import React, { Component } from 'react';
import { StyleSheet, View, Button } from 'react-native';
import t from 'tcomb-form-native'; // 0.6.11

const Form = t.form.Form;
const Age = t.refinement(t.Number, function(n) {
  return n >= 18;
});
Age.getValidationErrorMessage = function() {
  return 'bad age';
};
t.Number.getValidationErrorMessage = function(value) {
  if (!value) return 'empty number';
  else if (!Number.isInteger(value)) return 'bad number';
};

const User = t.struct({
    cedula: t.String,
    nombre: t.String,
    direccion: t.String,
    correo: t.String,
    ciudad: t.String,
    placa: t.String,
    fecha: t.String,
    token: t.Number,
});

const formStyles = {
  ...Form.stylesheet,
  formGroup: {
    normal: {
      marginBottom: 10,
    },
  },
  controlLabel: {
    normal: {
      color: 'blue',
      fontSize: 18,
      marginBottom: 7,
      fontWeight: '600',
    },
    // the style applied when a validation error occours
    error: {
      color: 'red',
      fontSize: 18,
      marginBottom: 7,
      fontWeight: '600',
    },
  },
};

const options = {
  order: ['cedula', 'nombre', 'direccion','correo','ciudad','placa','fecha','token'],
  fields: {
    cedula: {
        placeholder: 'Ingrese su cedula',
      error: 'cedula está vacia?',
    },
    nombre: {
      placeholder: 'Ingrese su nombre',
    },
    direccion: {
        placeholder: 'Ingrese su direccion',

    },
    correo: {
        placeholder: 'Ingrese su correo',

    },
    ciudad: {
        placeholder: 'Ingrese su ciudad',

    },
    placa: {
        placeholder: 'Ingrese su placa',

    },
    fecha: {
        placeholder: 'Ingrese su fecha',

    },
    token: {
        placeholder: 'Ingrese su token',

    },
    


  },
  stylesheet: formStyles,
};

export default class App extends Component {
    showCurrentDate=()=>{
 
        var date = new Date().getDate();
        var month = new Date().getMonth() + 1;
        var year = new Date().getFullYear();
   
        Alert.alert(year + '/' + month + '/' +date );
   
       }
       handleSubmit(){
        var value = this.refs.form.getValue();

        var url = 'http://192.168.1.8:3210/solicitudes';
        axios.post(url, {
        cedula: value.cedula,
        nombre: value.nombre,
        direccion: value.direccion,
        correo: value.correo,
        ciudad: value.ciudad,
        placa: value.placa,
        fecha: this.showCurrentDate(),
        token: 1
      
        })
        .then(function (response) {
        console.log(response);
        })
        .catch(function (error) {
        console.log(error);
        });
        this.state.input1 = '';
        this.state.input2 = '';
    };
    

  render() {
    return (
      <View style={styles.container}>
        <Form ref={c => (this._form = c)} type={User} options={options} />
        <Button title="Sign Up!" onPress={this.handleSubmit} />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    justifyContent: 'center',
    marginTop: 50,
    padding: 20,
    backgroundColor: '#ffffff',
  },
});