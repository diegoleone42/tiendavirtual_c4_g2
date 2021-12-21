const passport = require("passport");
const LocalStrategy = require("passport-local").Strategy;

const User = require("../models/users");

passport.serializeUser((user, done) => {
    done(null, user.id);
});

passport.deserializeUser(async (id, done) => {
    const user = await User.findById(id);
    done(null, user);
});

passport.use("local-signup", new LocalStrategy({
    usernameField: 'username',
    passwordField: 'password',
    passReqToCallback: true
}, async (req, username, password, done) => {
    const checkUser = await User.findOne({ "nombre_usuario": username });
    if (checkUser) {
        return done(null, false, req.flash("flashErrorMessage", "User already exists"));
    } else {
        const newUser = new User();
        newUser.nombre_usuario = username;
        newUser.password = newUser.encryptPassword(password);
        newUser.ciudad=req.body.ciudad;
        newUser.role=req.body.role;
        await newUser.save();
        done(null, newUser, req.flash("flashSuccessMessage", "User successfully created"));
    }
}));

passport.use("local-signin", new LocalStrategy({
    usernameField: 'username',
    passwordField: 'password',
    passReqToCallback: true
}, async (req, username, password, done) => {
    const loginUser = await User.findOne({ "nombre_usuario": username });
    if (loginUser) {
        if(loginUser.comparePassword(password)){
            return done(null,loginUser, req.flash("flashUserData", loginUser));
        }else{
            return done(null,false, req.flash("flashErrorMessage","Incorrect password"));
        }
    }else{
        return done(null,false, req.flash("flashErrorMessage", "User not found"));
    }
}));