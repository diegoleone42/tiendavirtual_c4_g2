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
        return done(null, false, req.flash("signupMessage", "User already exists"));
    } else {
        const newUser = new User();
        newUser.nombre_usuario = username;
        newUser.password = newUser.encryptPassword(password);
        await newUser.save();
        done(null, newUser);
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
            return done(null,loginUser);
        }else{
            return done(null,false, req.flash("signinMessage","Incorrect password"));
        }
    }else{
        return done(null,false, req.flash("signinMessage", "User not found"));
    }
}));