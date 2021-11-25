const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const taskProducto= new Schema({
    codigo_producto:Number,
    nombre_producto:String,
    precio_venta:Number,
    status:{
        type:Boolean,
        default:false
    }
})
module.exports=mongoose.model('tasks',taskProducto);
