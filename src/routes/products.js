const express = require('express');
const router = express.Router();

const TableProduct = require('../models/productoTabla')

router.get("/", async (req, res) => {
    title = 'Products';
    const products = await TableProduct.find();
    res.render("products", { products, title });
});
router.post("/add", async (req, res) => {
    const tabProduct = new TableProduct(req.body);
    const tabProductName = tabProduct.nombre_producto;
    const reqProductName = await TableProduct.find({ "nombre_producto": tabProductName }, { "_id": 0, "nombre_producto": 1 });
    if (reqProductName.length === 0) {
        await tabProduct.save();
        res.send("recieved");
    }
    else { res.send(`${reqProductName[0].nombre_producto} already exists`) }

});
router.post('/filter', (req, res) => {

});

module.exports = router;