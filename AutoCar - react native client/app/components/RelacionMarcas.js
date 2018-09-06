import React, {Component} from 'react'
import {View,Text, StyleSheet, TouchableWithoutFeedback, Image} from 'react-native'
import axios from 'axios';

class RelacionMarcas extends Component{
    constructor(props){
        super(props)
        this.state = {
            dataku: [],
          };
          this.klikGet();
    }
    klikGet(){
        var url = 'http://192.168.1.8:3210/data';
        axios.get(url)
        .then((ambilData) => {
        this.setState({
            dataku: ambilData.data,
        }) 
        })
       
    };
  
    
    render(){
        const { navigate } = this.props.navigation;
        const space = this.state.dataku.filter(x => x.marca === this.props.data);
        return (
            <View styles={styles.container}>
            {
                space.map((data,i) => {
                    return (
                      <View style={styles.video} key={i}>
                          <View style={styles.videoEpisode}>
                          <TouchableWithoutFeedback onPress={()=>this.props.navigation.navigate('Details',{
                            placa:data.placa,
                            marca: data.marca,
                            modelo: data.modelo,
                            anio: data.anio,
                            chasis: data.chasis,
                            motor: data.motor,
                            kilometraje: data.kilometraje,
                            costo: data.costo,
                            transmision: data.transmision
                        })}>
                              <Image style={styles.image} source={{uri: "http:/192.168.1.8:3210/images/"+data.placa+".png" }}/>
                          </TouchableWithoutFeedback> 
                              <View style={styles.episodeName}>
                                  <Text style={styles.text}>Modelo: {data.modelo}-{data.anio}</Text>
                                  <Text  style={styles.text}>Costo: ${data.costo}</Text>
                                  <Text style={styles.text}>Motor: {data.motor}</Text>
                              </View>
                          </View>
                          <Text style={styles.summary}></Text>
          
                      </View> 
                    )
                  })
            }
              
            </View>
        )
    }

}
const styles= StyleSheet.create({
    container:{
        marginHorizontal:10
    },
image:{
    width:150,
    height:80,
    marginRight:10,
    marginTop:10
},
text:{
    color:'white'
},
videoEpisode:{
    flexDirection: 'row'
},
episodeName:{
    justifyContent: 'center'
}
})
export default RelacionMarcas