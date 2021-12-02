const express = require("express");
const morgan = require("morgan");
const app = express();
const path = require("path");
const mongoose = require("mongoose");

// Importing routes
const dashboardRoutes=require("./routes/dashboard");
const productsRoutes=require('./routes/products');
const loginRoutes=require("./routes/login")

// Connection to DB
mongoose.connect("mongodb://localhost/tienda")
.then(db=> console.log("Connected to database"))
.catch(err=>console.log("Couldn't connect to DB"));
// Settings
app.set("appName", "Tienda");
app.set("port", 4242);
app.set("views", path.join(__dirname,"views"));
app.set("view engine", "ejs");

// Middlewares
app.use(express.json());
app.use(morgan("dev"));
app.use(express.urlencoded({extended:false}));

function logger(req, res, next) {
    console.log("request recieved");
    next();
}

// Routes
app.get("/", (req, res) => {
    data = [{ name: "Dan" }, { name: "Hal" }, { name: "Roy" }]
    title="Index";
    res.render("index.ejs", { users: data, title:title });
});

app.use(logger);

app.use("/dashboard",dashboardRoutes);
app.use("/products",productsRoutes);
app.use("/login",loginRoutes);


app.listen(app.get("port"), () => {
    console.log(`App listening at port ${app.get("port")}`)
});
