const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const sucursalSchema = new Schema({
    nombre_sucursal: {
        type: String,
        unique: true
    },
    cantidad_productos: { type: Number, default: 0 },
    ganancias: { type: Number, default: 0 },
    cantidad_clientes: { type: Number, default: 0 },
})
module.exports = mongoose.model("branchOffice", sucursalSchema);