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
        userId: 'admin',
    })
      .catch((err) => {
        console.log(err);
    });
// console.log(groups)
    res.render('chat', {
        title: 'Express' ,
        groups: groups,
        chatkit:chatkit
    });
});

router.get('/getMess',async function(req, res, next) {
    let result = await chatkit.fetchMultipartMessages({
        roomId: req.query.id,
        limit: 20,
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
        userId: 'admin',
        roomId: req.query.chat,
        text: req.query.msg,
    })
        .catch(err => console.error(err))
    res.end(true)

});

module.exports = router;
