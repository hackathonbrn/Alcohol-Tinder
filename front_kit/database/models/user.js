const sequelize = require('../lib/pgbaseConnector');
const Sequelize = require('sequelize');
const  user = sequelize.define('user', {
    firstname: {
        type: Sequelize.TEXT,
    },
    secondname: {
        type: Sequelize.TEXT,
    },
    phonenumber: {
        type: Sequelize.TEXT,
    },
    photo: {
        type: Sequelize.TEXT,
    },
    age: {
        type: Sequelize.INTEGER,
    },
    password: {
        type: Sequelize.TEXT,
    },
});

module.exports = user;
