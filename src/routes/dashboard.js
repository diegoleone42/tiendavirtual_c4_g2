const express = require("express");
const router=express.Router();


router.get("/",(req, res) => {
    data=[{id:1,cityName:"Bogotá",stats:{profits:20000000,clients:1654,stock:589}},{id:2,cityName:"Cali",stats:{profits:35000000,clients:1343,stock:349}},{id:3,cityName:"Medellin",stats:{profits:35000000,clients:1343,stock:349}}]
    res.render("dashboard",{cities:data});
});

module.exports=router;