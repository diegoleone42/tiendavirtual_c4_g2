const express = require("express");
const morgan = require("morgan");
const app = express();
const path = require("path");
const mongoose = require("mongoose");

// Importing routes
const dashboardRoutes=require("./routes/dashboard");

// Connection to DB
mongoose.connect("mongodb://localhost/tienda")
.then(db=> console.log("Connected to database"))
.catch(err=>console.log("Couldn't connect to DB"))
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
function productSubmit(req, res) {

}

// Routes
app.get("/", (req, res) => {
    data = [{ name: "Dan" }, { name: "Hal" }, { name: "Roy" }]
    res.render("index.ejs", { users: data });
});

app.use(logger);

app.use("/dashboard",dashboardRoutes);

app.get("/products", (req, res) => {
    data = [{ id: 1, productName: "Pollo", quantity: 30, store: "Bogotá" }, { id: 2, productName: "Papa", quantity: 1200, store: "Cali" }, { id: 3, productName: "Coco", quantity: 25, store: "Medellin" }]
    res.render("products.ejs", { products: data });
});
app.post("/products", (req, res) => {

})

app.listen(app.get("port"), () => {
    console.log(`App listening at port ${app.get("port")}`)
});
