const helpers = {};

helpers.isAuthenticated = (req,res,next)=>{
    if(req.isAuthenticated()){
        return next();
    }
    else{
        req.flash("flashErrorMessage","Not signed in");
        res.redirect("/login");
    }
};

module.exports = helpers;