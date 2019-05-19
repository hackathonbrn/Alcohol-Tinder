var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('user', { title: 'Пользователи', user: {firstName: 'Ап', age:1, photo: 'h', alcohol: ['Ром', 'Мартини'], interests: ['Ром', 'Мартини']} });
});

module.exports = router;
