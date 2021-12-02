const express = require("express");
const router = express.Router();

router.get("/",(req,res)=>{
    title="Login";
    res.render("login",{title:title});
});

router.post("/signin",(req,res)=>{
    console.log(req.body)
    res.send("Signed in!!!")
})

module.exports=router;