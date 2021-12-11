const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const generalSchema = new Schema({
    nombre_sucursal:String,
    cantidad_productos:Number,
    ganancias:[{type:Schema.Types.ObjectId,ref:'Sucursal'}],
    cantidad_clientes:[{type:Schema.Types.ObjectId,ref:'Sucursal'}],
});
module.exports=mongoose.model("General",generalSchema);