const mongoose = require("mongoose");
const bcrypt = require("bcrypt-nodejs");
const schema = mongoose.Schema;

const userSchema = new schema({
    nombre_usuario:String,
    password:String,
    role:String,
    ciudad:{
       type:mongoose.Types.ObjectId,
       ref:'branchOffice'
      }
    
});

userSchema.methods.encryptPassword = (password) =>{
   return bcrypt.hashSync(password,bcrypt.genSaltSync(10));
};

userSchema.methods.comparePassword= function(password){
   return bcrypt.compareSync(password,this.password)
}
module.exports=mongoose.model("User",userSchema);