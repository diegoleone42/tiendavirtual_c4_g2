const express = require("express");
const router = express.Router();

// Models
const Cart = require("../models/cart");

// Routes
router.get("/", async(req,res)=>{
    const title="Cart";
    const sCart = await Cart.find();
    res.render("cart",{title:title, scProducts:sCart});
});

module.exports=router;