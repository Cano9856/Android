const express = require("express");
const cors = require ('cors');
const {Pool} = require ('pg')

const app = express();
const PORT = 3000;

app.use(cors());
app.use(express.json());

const myPool = new Pool({
    user:"postgres",
    host:"localhost",
    database:"bbddExamen",
    password:"postgres",
    port:5432
});

app.listen(PORT,()=>{
    console.log("Servidor corriendo en "+`http://localhost:${PORT}`);
});

app.get("/libros", async (req,res)=>{
    const result = await myPool.query('SELECT * FROM libros');
    res.json({message:"Libros obtenidos", libros:result.rows});
});
app.get("/categorias", async (req,res)=>{
    const result = await myPool.query('SELECT * FROM categorias');
    res.json({message:"categorias obtenidas", categorias:result.rows});
});
app.get("/libros/categoria/:id", async (req,res)=>{
    const id = req.params.id;
    const result = await myPool.query('SELECT * FROM libros WHERE categoria_id=$1',[id]);
    res.json({message:"Libros obtenidos", libros:result.rows});
});