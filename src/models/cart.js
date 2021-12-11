const { ObjectId } = require("bson");
const mongoose = require("mongoose");
const schema = mongoose.Schema;

const cartSchema = new schema({
    user_id:ObjectId,
    nombre_producto:{
        type:String,
        unique:true
    },
    cantidad_producto:Number,
    precio_total:Number
});
module.exports=mongoose.model("Cart",cartSchema);