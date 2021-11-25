const express = require('express');
const router=express.Router();

router.get("/products", (req, res) => {
    data = [{ id: 1, productName: "Pollo", quantity: 30, store: "Bogotá" }, { id: 2, productName: "Papa", quantity: 1200, store: "Cali" }, { id: 3, productName: "Coco", quantity: 25, store: "Medellin" }]
    res.render("products", { products: data });
});
router.post("/products", (req, res) => {

})