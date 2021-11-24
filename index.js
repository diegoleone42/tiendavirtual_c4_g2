const express = require("express");
const app = express();

// Settings
app.set("appName", "Tienda")
app.set("port", 4242)
app.set("view engine", "ejs")

// Middlewares
app.use(express.json());

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

app.get("/dashboard", (req, res) => {
    data=[{id:1,cityName:"Bogotá",stats:{profits:20000000,clients:1654,stock:589}},{id:2,cityName:"Cali",stats:{profits:35000000,clients:1343,stock:349}}]
    res.render("dashboard.ejs",{cities:data});
});

app.get("/products", (req, res) => {
    data = [{ id: 1, productName: "Pollo", quantity: 30, store: "Bogotá" }, { id: 2, productName: "Papa", quantity: 1200, store: "Cali" }, { id: 3, productName: "Coco", quantity: 25, store: "Medellin" }]
    res.render("products.ejs", { products: data });
});
app.post("/products", (req, res) => {

})

app.listen(app.get("port"), () => {
    console.log(`App listening at port ${app.get("port")}`)
});
