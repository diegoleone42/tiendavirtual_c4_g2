const express = require("express");
const router = express.Router();
const passport = require("passport");


//Routes
router.get("/",(req,res,next)=>{
    res.render("login",{title:"Login"});
});

router.post("/",passport.authenticate("local-signin",{
    successRedirect:"/dashboard",
    failureRedirect:"/login",
    passReqToCallback:true
}));

router.get("/signup",(req,res,next)=>{
    res.render("signup",{title:"Signup"});
})

router.post("/signup",passport.authenticate("local-signup",{
    successRedirect:"/login",
    failureRedirect:"/login/signup",
    passReqToCallback:true
}));

module.exports=router;