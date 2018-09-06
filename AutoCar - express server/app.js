const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const cors = require('cors');

const Sequelize = require('sequelize');
const sequelize = new Sequelize('postgres://postgres:12345@localhost:5432/AutoCar');

app.use(bodyParser.json());
app.use(cors());
app.use(express.static('public'));

sequelize
.authenticate()
.then(() => {
  console.log('Sukses terhubung ke PostgreSQL');
})
.catch(err => {
  console.error('Gagal terhubung ke PostgreSQL:', err);
});

const Ninja = sequelize.define('autos', {
    placa: {type: Sequelize.STRING},
    marca: {type: Sequelize.STRING},
    modelo: {type: Sequelize.STRING},
    anio: {type: Sequelize.INTEGER},
    motor: {type: Sequelize.STRING},
    transmision:{type: Sequelize.STRING},
    costo: {type: Sequelize.DOUBLE}

  },{timestamps:false});
const Solicitud = sequelize.define('solicitudes', {
    cedula: {type: Sequelize.STRING},
    nombre: {type: Sequelize.STRING},
    direccion: {type: Sequelize.STRING},
    correo: {type: Sequelize.STRING},
    ciudad: {type: Sequelize.STRING},
    placa:{type: Sequelize.STRING},
    fecha: {type: Sequelize.STRING},
    token:{type: Sequelize.INTEGER},

  },{timestamps:false});

Ninja.sync({force: false}).then(() => {
    console.log('Tabel dibuat!')
  });
  Solicitud.sync({force: false}).then(() => {
    console.log('Tabel dibuat2!')
  });

app.get('/data', function(req,res){
  Ninja.findAll().then(data => {
    res.send(data);
  })
})
app.get('/solicitudes', function(req,res){
  Solicitud.findAll().then(data => {
    res.send(data);
  })
})
app.post('/solicitudes', function(req,res){
  Solicitud.create({
      cedula: req.body.cedula,
      nombre: req.body.nombre,
      direccion: req.body.direccion,
      correo: req.body.correo,
      ciudad: req.body.ciudad,
      placa: req.body.placa,
      fecha: req.body.fecha,
      token: req.body.token,
  }).then(solicitudes => {
    console.log('Data masuk!');
    res.send({
      status: 'Data sukses diinput!',
      cedula: req.body.cedula,
      nombre: req.body.nombre,
      direccion: req.body.direccion,
      correo: req.body.correo,
      ciudad: req.body.ciudad,
      placa: req.body.placa,
      fecha: req.body.fecha,
      token: req.body.token,
    })
  });
  })
app.post('/data', function(req,res){
Ninja.create({
    nama: req.body.nama,
    usia: req.body.usia
}).then(data => {
  console.log('Data masuk!');
  res.send({
		status: 'Data sukses diinput!',
		nama: req.body.nama,
		usia: req.body.usia
  })
});
})

app.listen(3210, ()=>{
  console.log('Server @port 3210 gan!')
})