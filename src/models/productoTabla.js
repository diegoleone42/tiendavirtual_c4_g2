const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const ProductoTabla= new Schema({
    nombre_producto:String,
    precio_producto:Number,
    tienda_producto:String,
    cantidad_producto:Number,
    status:{
        type:Boolean,
        default:false
    }
})
module.exports=mongoose.model('tablaProductos',ProductoTabla);
