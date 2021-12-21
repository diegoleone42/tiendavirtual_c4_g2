const express = require('express');
const router = express.Router();

// Models
const TableProduct = require('../models/productos');
const Cities = require('../models/sucursales');

// Functions
async function saveProduct(newProd, stores) {
    await newProd.save();
    let store = await stores.findOne({ _id: `${newProd.ciudad_producto}` });
    await store.updateOne({ cantidad_productos: store.cantidad_productos + 1 });
}

async function getData(database,city){
    console.log(city);
    var products;
    if (city!=""){
        products = await database.find({"ciudad_producto":city}).populate("ciudad_producto");
        return products;
    }
    else{
       products = await database.find().populate("ciudad_producto");
       return products;
    }
    
}

// Routes

router.get("/", async (req, res) => {
    title = 'Products';
    idFilter = req.query.filter;
    var products;
    if (idFilter != undefined){
        products = await getData(TableProduct,idFilter);
    }
    else {
        products = await getData(TableProduct,"");
    }
    const cities = await Cities.find();
    res.render("products", { products, title, cities });
});


router.post("/add", async (req, res) => {
    const newProduct = new TableProduct(req.body);
    const newProductName = newProduct.nombre_producto;
    const reqProduct = await TableProduct.findOne({ "nombre_producto": newProductName }, { "_id": 0, "nombre_producto": 1, "ciudad_producto": 1 });
    if (!reqProduct) {
        saveProduct(newProduct,Cities);
        res.send("recieved");
    }
    else if (newProduct.ciudad_producto.toString() === reqProduct[0].ciudad_producto.toString()) {
        res.send(`${reqProduct[0].nombre_producto} already exists into that city `);
    }
    else {
        saveProduct(newProduct);
        res.send("Added");
    }

});


module.exports = router;