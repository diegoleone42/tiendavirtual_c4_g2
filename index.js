const express=require("express");
const app= express();
const port = 5000;
app.use(express.json());

app.get("/",(req,res)=>{
    res.send("Hello world! (Pathetic...)")
})

app.listen(port,()=>{
    console.log(`App listening at port ${port}`)
})
