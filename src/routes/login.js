const express = require("express");
const router = express.Router();
const passport = require("passport");

const Cities = require("../models/sucursales");

//Routes
router.get("/",(req,res,next)=>{
    res.render("login",{title:"Login"});
});

router.post("/",passport.authenticate("local-signin",{
    successRedirect:"/dashboard",
    failureRedirect:"/login",
    failureFlash:true,
    passReqToCallback:true
}));

router.get("/signup",async (req,res,next)=>{
    cities = await Cities.find();
    res.render("signup",{title:"Signup",cities});
});

router.post("/signup",passport.authenticate("local-signup",{
    successRedirect:"/login",
    failureRedirect:"/login/signup",
    passReqToCallback:true
}));

module.exports=router;