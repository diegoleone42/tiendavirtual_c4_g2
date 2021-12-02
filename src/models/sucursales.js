const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const Sucursal = new Schema({
    nombre_sucursal:String,
    cantidad_productos:Number,
    ganancias:Number,
    cantidad_clientes:Number,
    status:{
        type:Boolean,
        default:false
    }
})
module.exports=mongoose.model("sucursales",Sucursal)