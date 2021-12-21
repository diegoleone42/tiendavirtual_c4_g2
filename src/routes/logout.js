const express = require("express");
const router = express.Router();

// Routes

router.get("/", (req,res)=>{
    req.logout();
    res.redirect("/login");
});

router.get("/confirmation",(req,res)=>{
    res.render("logout",{title:"Logout"});
});

module.exports = router;