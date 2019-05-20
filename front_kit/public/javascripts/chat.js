
var curRoom
var curUserId
const user = document.getElementById('user');
curUserId=user.value
// chatkit.createUser({
//     id: 'kit',
//     name: 'Kirill',
// })
//     .then(() => {
//         console.log('User created successfully');
//     }).catch((err) => {
//     console.log(err);
// });
// chatkit.getUser({
//     id: 'kit',
// })
//     .then(user => console.log('got a user', user))
//     .catch(err => console.error(err))

function getMessages(id) {
    // checkCL.innerHTML = ' ... ';
    const msgs = document.getElementById('msgs');

    curRoom=id
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'chat/getMess?id='+id, true);

    xhr.onreadystatechange = function() {
        if (xhr.readyState != 4) return;

        if (xhr.status != 200) {
            // обработать ошибку
            alert('Ошибка ' + xhr.status + ': ' + xhr.statusText);
            return;
        }
        if(xhr.response)
        // обработать результат
        //     let inner = ' ';
            msgs.innerHTML = ''
            var resp = JSON.parse(xhr.response)
            for (let i = 0; i < resp.length; i++)
                if(resp[i].user_id!==curUserId)
                    msgs.innerHTML +='<div class="incoming_msg">\n' +
                        '              <div class="incoming_msg_img"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>\n' +
                        '              <div class="received_msg">\n' +
                        '                <div class="received_withd_msg">\n' +
                        '                  <p>'+resp[i].user_id+': '+ resp[i].parts[0].content+'</p>\n' +
                        // '                  <span class="time_date"> 11:01 AM    |    June 9</span></div>\n' +
                        '              </div>\n' +
                        '            </div>'
                else
                    msgs.innerHTML +='<div class="outgoing_msg">\n' +
                        '              <div class="sent_msg">\n' +
                        '                  <p>'+ resp[i].parts[0].content+'</p>\n' +
                        // '                  <span class="time_date"> 11:01 AM    |    June 9</span></div>\n' +
                        '              </div>\n'


                // console.log(xhr.response)

    }

    xhr.send(null);

}
function sendMsg() {
    const msg = document.getElementById('inputMsg');
    const msgs = document.getElementById('msgs');

    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'chat/sendMess?msg='+msg.value+'&chat='+curRoom, true);

    xhr.onreadystatechange = function() {
        if (xhr.readyState != 4) return;


        if (xhr.status != 200) {
            // обработать ошибку
            alert('Ошибка ' + xhr.status + ': ' + xhr.statusText);
            return;
        }
        if(xhr.response)
        // обработать результат

        //     let inner = ' ';
        msgs.innerHTML +='<div class="outgoing_msg">\n' +
                '              <div class="sent_msg">\n' +
                '                  <p>'+ msg.value+'</p>\n' +
                // '                  <span class="time_date"> 11:01 AM    |    June 9</span></div>\n' +
                '              </div>\n'
        msg.clear()

        console.log(xhr.response)

    }

    xhr.send(null);
}