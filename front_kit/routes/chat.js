const Chatkit = require('@pusher/chatkit-server');
const chatkit = new Chatkit.default({
    instanceLocator: 'v1:us1:454204a2-1b10-4f33-8b8e-6d1cd3ea8730',
    key: '89c89008-1656-4a6b-be21-ef03a9190178:TIk7cndTIwnppSHQfUZO7aPGL+b+SBYllEv/CY+JOIE=',
})

var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/',async function(req, res, next) {
    let groups = await chatkit.getUserRooms({
        userId: 'Vasya',
    })
      .catch((err) => {
        console.log(err);
    });
// console.log(groups)
    res.render('chat', {
        title: 'Express' ,
        groups: groups,
        chatkit:chatkit,
        user:'Vasya'
    });
});

router.get('/getMess',async function(req, res, next) {
    let result = await chatkit.fetchMultipartMessages({
        roomId: req.query.id,
        limit: 20,
        direction:'newer'
    })
        // .then(moreMessages => {
        //     console.log('got the next 20 messages before them')
        //     for (let m of moreMessages) {
        //         renderMessage(m)
        //     }
        // })
        .catch(err => console.error(err))

    res.end(JSON.stringify(result))
});
router.get('/sendMess',async function(req, res, next) {
    let result = await chatkit.sendSimpleMessage({
        userId: 'Vasya',
        roomId: req.query.chat,
        text: req.query.msg,
    })
        .catch(err => console.error(err))
    res.end('ok')

});

module.exports = router;
