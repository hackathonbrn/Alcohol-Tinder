var express = require('express');
var router = express.Router();
const fetch = require("node-fetch");

/* GET home page. */
router.get('/',async function(req, res, next) {
  // response = await fetch("http://192.168.1.140:8080/api/",{ method: 'POST' })
  // let inter = await response.json()

  res.render('user', { title: 'Пользователи', user: {firstName: 'Вася', age:24, photo: 'https://pp.userapi.com/c850720/v850720060/114157/zmJhCH4JBbc.jpg', alcohol: ['Пиво'], interests: ['Музыка', 'Котики', 'Искусство', 'Политика', 'Кальян', 'Самолеты', 'Спорт', 'Игры']} });
});

module.exports = router;
