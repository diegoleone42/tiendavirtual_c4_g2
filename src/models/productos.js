const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const productoSchema = new Schema({
    nombre_producto:String,
    cantidad_producto:Number,
    precio_producto:Number,
    ciudad_producto:{
        type: mongoose.Types.ObjectId, 
        ref:'branchOffice'}
});
module.exports=mongoose.model("Producto",productoSchema);