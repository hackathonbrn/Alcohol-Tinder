var express = require('express');
var router = express.Router();
const fetch = require("node-fetch");

/* GET home page. */
router.get('/',async function(req, res, next) {


  let response = await fetch("http://192.168.1.140:8080/api/getQueue",{ method: 'POST', body: '{id:1}' })
  let resu = await response.json()

  response = await fetch("http://192.168.1.140:8080/api/getAlcoList",{ method: 'POST' })
  let alco = await response.json()

  response = await fetch("http://192.168.1.140:8080/api/",{ method: 'POST' })
  let inter = await response.json()

  res.render('index', {
    result:resu,
    alco: alco,
    inter: inter});
});

module.exports = router;
