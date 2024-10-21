const express = require("express");
const cors = require("cors");
const bodyParser = require('body-parser');
const {Pool} = require("pg");
const req = require("express/lib/request");//quitar la barra podría ocasionar errores?
const res = require("express/lib/response");


const app = express();
const PUERTO = 3000;
const PUERTO2 = 5432;

app.use(cors());
app.use(bodyParser.json());

const myPool = new Pool({
    //usaré una bbdd ya existente
    user:"postgres",
    host:"database-1.c4ps7rsoggws.us-east-1.rds.amazonaws.com",
    database:"postgres",
    password:"#gUaBD$C3ICI",
    port:PUERTO2,
    ssl: {
        rejectUnauthorized: false,
    }
})
//comprobaré si la bbdd se comunica correctamente
app.listen(PUERTO, ()=>{
    console.log(`Servidor corriendo en  http://localhost:${PUERTO}`)
});


//HASTA AQUI LA CONEXION A BBDD

//INICIO FUNCIONALIDAD LOGIN, ES DECIR, ENDPOINT AL QUE ATACAR

//USUARIO DE PRUEBA QUE UTILIZARÉ
/*
prueba@example.com
passsword1
*/
app.post('/login', async(req, res)=>{
    const {email, password} = req.body;//NECESITO QUE AL ATACAR AL ENDPOINT LE MANDES LOS PARAMETROS POR BODY

    try {
        const user = await myPool.query('SELECT id, password FROM usuario WHERE email=$1', [email]);//Insertamos la select para recuperar datos del usuario

        if (user.rows.length===1) {
            if (user.rows[0].password ===password) {
                res.status(200).json({message: "Inicio de sesión exitoso ", user: user.rows[0]});
                console.log(user.rows[0]);
                
            } else {
                res.status(401).json({message: "Credenciales incorrectas ", });
            } 
        } else {
            res.status(401).json({message: "No se encontro al usuario ", });
        }

    } catch (error) {
        res.status(500).json({ error: 'Error interno del servidor' });
    }
});

//COMPROBAREMOS SI FUNCIONA EL ENDPOINT EN THUNDERCLIENT, FUNCIONA, VAMOS AL ANDROID