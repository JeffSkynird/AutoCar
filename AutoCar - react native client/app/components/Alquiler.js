import React, {Component} from 'react'
import {
    Text,
    View,TextInput,Alert,
    FlatList,  Image, StyleSheet,TouchableHighlight,Dimensions
} from 'react-native';

import axios from 'axios';
const {width, height} = Dimensions.get('window')

class Alquiler extends Component {

    constructor(){
        super();
        this.state = {
            dataku: [],
            dataku2:[],
            cedula: '',
            nombre: '',
            direccion:'',
            ciudad:'',
            correo:'',
            soli:0


          };
          this.klikGet();
          this.klikGet2();
    }
    static navigationOptions = {
        title: 'Welcome',
        header: null,
        headerVisible: false
      };
    klikGet(){
        var url = 'http://192.168.1.8:3210/data';
        axios.get(url)
        .then((ambilData) => {
        this.setState({
            dataku: ambilData.data,
        }) 
        })
    };
    klikGet2(){
        var url = 'http://192.168.1.8:3210/solicitudes';
        axios.get(url)
        .then((ambilData) => {
        this.setState({
            dataku2: ambilData.data,
        }) 
        })
    };
    fechaActual(){
      
            var date = new Date().getDate();
            var month = new Date().getMonth() + 1;
            var year = new Date().getFullYear();
       
           return  year+ '/' + month + '/' + date;
    
    }
    validarSolicitud(cedula){
        let val = JSON.stringify( this.state.dataku2)
        let t = JSON.parse(val, (key, value) => {
            if (typeof value === 'string') {
               
                if(cedula==value){
                    Alert.alert(
                        'Aviso',
                        'Usted posee una solicitud pendiente!',
                        [
                          {text: 'OK', onPress: () => this.setState({soli:1})},
                        ],
                        { cancelable: false }
                      )                   
                }

            }
      
          });
      
    }
    klikPost(placa){
        var url = 'http://192.168.1.8:3210/solicitudes';
        axios.post(url, {
            cedula: this.state.cedula,
            nombre: this.state.nombre,
            direccion: this.state.direccion,
            correo: this.state.correo,
            ciudad: this.state.ciudad,
            placa: placa,
            fecha: this.fechaActual(),
            token: 0,

        })
        .then(function (response) {
          console.log(response);
        })
        .catch(function (error) {
          console.log(error);
        });
       
      };

    changeCedula(cedula){
        this.setState({cedula})
    }
    changeNombre(nombre){
        this.setState({nombre})
    }
    changeDireccion(direccion){
        this.setState({direccion})
    }
    changeCiudad(ciudad){
        this.setState({ciudad})
    }
    changeCorreo(correo){
        this.setState({correo})
    }
    buttonPressed(placa){
        if(this.state.cedula&&this.state.nombre&&this.state.direccion&&this.state.ciudad&&this.state.correo){
            if(this.validarEmail(this.state.correo)==true){
                if(this.validarCedula(this.state.cedula)==true){
                    this.validarSolicitud(this.state.cedula)
                    this.klikPost(placa);
                    Alert.alert(
                        'Procesando.',
                        'Si no tiene solicitudes pendientes acerquese a Auto Car en los proximos 3 días laborales',
                        [
                          {text: 'OK', onPress: () => console.log('OK Pressed')},
                        ],
                        { cancelable: false }
                      )
                      
                }else{
                    Alert.alert(
                        'Error',
                        'Ingrese una cedula válida',
                        [
                          {text: 'OK', onPress: () => console.log('OK Pressed')},
                        ],
                        { cancelable: false }
                      )
                }
              
            }else if(this.validarEmail(this.state.correo)==false){
                Alert.alert(
                    'Error',
                    'Ingrese un email valido',
                    [
                      {text: 'OK', onPress: () => console.log('OK Pressed')},
                    ],
                    { cancelable: false }
                  )
            }
            
        }else{
            Alert.alert(
                'Error',
                'No debe dejar campos vacíos',
                [
                  {text: 'OK', onPress: () => console.log('OK Pressed')},
                ],
                { cancelable: false }
              )
        }
    }
    validarCedula(cedula){
        var cad = cedula
        var total = 0;
        var longitud = cad.length;
        var longcheck = longitud - 1;

        if (cad !== "" && longitud === 10){
          for(i = 0; i < longcheck; i++){
            if (i%2 === 0) {
              var aux = cad.charAt(i) * 2;
              if (aux > 9) aux -= 9;
              total += aux;
            } else {
              total += parseInt(cad.charAt(i)); // parseInt o concatenará en lugar de sumar
            }
          }

          total = total % 10 ? 10 - total % 10 : 0;

          if (cad.charAt(longitud-1) == total) {
            return true;
          }else{
            return false;
        }
        }

    }
    validarEmail(email){
        let reg = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/ ;
        if(reg.test(email) === false)
        {
        return false;
          }
        else {
          return true;
        }
        }

    
    render(){
        const { navigation } = this.props;
        const placa = navigation.getParam('placa');
        const fecha = this.fechaActual();
        const imag ='http:/192.168.1.8:3210/images/'+placa+'.png';
        return (
            <View style={styles.container}>
                <View style={styles.container}>
                <Image style={styles.thumbnail} source={{uri:imag}}/>

                    <Text style={[styles.infoText]}>Placa: {placa}              Fecha de alquiler: {fecha}</Text>
  
                </View>
                <View>
                    <TextInput
                        style={styles.input}
                        placeholder='Cédula'
                        value={this.state.cedula}
                        onChangeText={(cedula)=>this.changeCedula(cedula)}
                        maxLength = {10}
                        keyboardType='numeric'
                    />
                    <TextInput
                        style={styles.input}
                        placeholder='Nombre'
                        value={this.state.nombre}
                        onChangeText={(nombre)=>this.changeNombre(nombre)}
                    />
                    <TextInput
                        style={styles.input}
                        placeholder='Direccion'
                        value={this.state.direccion}
                        onChangeText={(direccion)=>this.changeDireccion(direccion)}
                    />
                    <TextInput
                        style={styles.input}
                        placeholder='Ciudad'
                        value={this.state.ciudad}
                        onChangeText={(ciudad)=>this.changeCiudad(ciudad)}
                    />
                    <TextInput
                        style={styles.input}
                        placeholder='Correo'
                        value={this.state.correo}
                        onChangeText={(correo)=>this.changeCorreo(correo)}
                        keyboardType='email-address'
                    />
                    <Text style={{color:'white'}}>{this.state.soli}</Text>
                    <TouchableHighlight style={styles.button} onPress={()=>this.buttonPressed(placa)}>
                        <Text style={styles.textButton}>Alquilar</Text>
                    </TouchableHighlight>
                </View>

            </View>
        )
    }

    
}

const styles = StyleSheet.create({
    infoText:{
        color: 'white'
    },
    
    container:{
        flex:1,
        backgroundColor:'black',
      
    },thumbnail: {
        width: width,
        height: 240
    },
    button:{
        backgroundColor:'#c0392b',
        paddingTop: 15,
        paddingBottom:15
    },
    title: {
        textAlign: 'center',
        fontSize:18,
        marginBottom:5
    },
    textButton:{
        textAlign: 'center',
        color: 'white'
    },
    input:{
        height:40,
        borderBottomColor :'#ccc',
        borderWidth:2,
        marginBottom:20,
        color:'white'
    }

})
export default Alquiler