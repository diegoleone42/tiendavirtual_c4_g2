const express = require("express");
const router=express.Router();

// Models
const Store=require("../models/sucursales");

// Routes
router.get("/",async (req, res) => {
    const title="Dashboard";
    const data = await Store.find();
    res.render("dashboard",{cities:data,title:title});
});

router.post("/addStore", async (req,res)=>{
    const newStore = new Store(req.body);
    await newStore.save();
    res.send("recieved")
});

module.exports=router;