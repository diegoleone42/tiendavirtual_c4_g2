const express = require("express");
const engine = require("ejs-mate");
const morgan = require("morgan");
const path = require("path");
const mongoose = require("mongoose");
const passport = require("passport");
const session = require("express-session");
const flash = require("connect-flash");
const { isAuthenticated } = require("./helpers/auth")

const app = express();
require("./passport/local-auth");

// Importing routes
const dashboardRoutes = require("./routes/dashboard");
const productsRoutes = require('./routes/products');
const loginRoutes = require("./routes/login");
const cartRoutes = require("./routes/cart");
const logoutRoutes = require("./routes/logout");

// Connection to DB
mongoose.connect("mongodb://localhost/tienda")
    .then(db => console.log("Connected to database"))
    .catch(err => console.log("Couldn't connect to DB"));

// Settings
app.set("appName", "Tienda");
app.set("port", 4242);
app.set("views", path.join(__dirname, "views"));
app.engine('ejs', engine);
app.set("view engine", "ejs");

// Middlewares
app.use(express.static(path.join(__dirname, "/public")));
app.use(express.json());
app.use(morgan("dev"));
app.use(express.urlencoded({ extended: false }));
app.use(session({
    secret: "1i{BgGl5uirPX*@WbPb9",
    resave: false,
    saveUninitialized: false
}));
app.use(flash());
app.use(passport.initialize());
app.use(passport.session());
// Globar variables
app.use((req, res, next) => {
    app.locals.flashErrorMessage = req.flash("flashErrorMessage");
    app.locals.flashSuccessMessage = req.flash("flashSuccessMessage");
    app.locals.flashUserData = req.flash("flashUserData");
    app.locals.user = req.user || null;
    next();
});


// Routes
app.get("/", (req, res) => {
    data = [{ name: "Dan" }, { name: "Hal" }, { name: "Roy" }]
    title = "Index";
    res.render("index.ejs", { users: data, title: title });
});
app.use("/login", loginRoutes);
app.use((req, res, next) => {
    isAuthenticated(req, res, next);
});
app.use("/dashboard", dashboardRoutes);
app.use("/products", productsRoutes);
app.use("/cart", cartRoutes);
app.use("/logout", logoutRoutes);

// Starting server
app.listen(app.get("port"), () => {
    console.log(`App listening at port ${app.get("port")}`)
});
