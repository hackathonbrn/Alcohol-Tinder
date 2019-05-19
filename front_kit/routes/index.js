var express = require('express');
var router = express.Router();
const fetch = require("node-fetch");

/* GET home page. */
router.get('/',async function(req, res, next) {

  const getData = async url => {
    try {
      const response = await fetch(url,{ method: 'POST', body: '{id:1}' });
      const json = await response.json();
      return json;
      console.log(json);
    } catch (error) {
      console.log(error);
    }
  };
  let resu = await getData("http://192.168.1.140:8080/api/getQueue");
  let alco = await getData("http://192.168.1.140:8080/api/getAlcoList")
  const getInfo = async url => {
    try {
      const response = await fetch(url,{ method: 'GET' });
      const json = await response.json();
      return json;
      console.log(json);
    } catch (error) {
      console.log(error);
    }
  };
  let info = await getInfo("http://192.168.1.140:8080/api/getUser/2")

  res.render('index', {
    result:resu,
    alco: alco  });
});

module.exports = router;
