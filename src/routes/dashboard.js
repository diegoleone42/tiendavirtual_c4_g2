const express = require("express");
const router=express.Router();

// Models
const User = require("../models/users");
const Store=require("../models/sucursales");

// Routes
router.get("/",async (req, res) => {
    const title="Dashboard";
    const user = req.user;
    const data = await User.findOne({"_id":user._id}).populate("ciudad");
    console.log(data.role);
    let cities;
    if(data.role == "administrator"){
        cities = await Store.find();
    }else{
        cities = [data.ciudad];
    }

    res.render("dashboard",{cities:cities,title:title});
});

router.post("/addStore", async (req,res)=>{
    const newStore = new Store(req.body);
    await newStore.save();
    res.send("recieved")
});

module.exports=router;