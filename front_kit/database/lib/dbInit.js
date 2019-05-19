const User = require('../models/user')


// User.hasMany(UserInGroup, { foreignKey: 'id_us', sourceKey: 'id' })
// UserInGroup.belongsTo(Group, { foreignKey: 'id_gr', targetKey: 'id' })
// UserInGroup.belongsTo(User, { foreignKey: 'id_us', targetKey: 'id' })
async function init () {
    // await Position.sync({force:true})
    // await SignedStatus.sync({force:true})
    // await DocType.sync({force:true})
    // await User.sync({force:true})
    // await Document.sync({force:true})
    // await DocSigners.sync({force:true})
    //await UserLogin.sync({force:true})

    await User.sync()


}

(async function f () {
  await init()
})()



// module.exports.init = init()
