import React, {Component} from 'react'
import {
    View,
    Text,
    StyleSheet,
    Image,
    TouchableHighlight,
    TouchableWithoutFeedback,
    ScrollView,
    Dimensions,
    Share,
    Animated,ImageBackground
} from 'react-native'

import Icon from 'react-native-vector-icons/FontAwesome'
import IonIcons from 'react-native-vector-icons/Ionicons'
import { LinearGradient } from 'expo';
import TabsAutos from './TabsAutos';



const {width, height} = Dimensions.get('window')

class Details extends Component {
    constructor(props){
        super(props)
       
    }
    static navigationOptions = {
        title: 'Welcome',
        header: null
    }
    onShare(placa, marca, modelo){
      Share.share({
            title: marca+'-'+modelo,
            url: "http:/192.168.1.8:3210/images/"+placa+".png",
            message: 'Alquila tus autos en AUTO CAR! \n'+
            "Marca: "+marca+"\nModelo: "+modelo+"\nhttp:/192.168.1.8:3210/images/"+placa+".png"
        },{
            dialogTitle: 'Comparte desde tu app favorita :)'    
        })
    }
    render() {
        const { navigation } = this.props;
        const placa = navigation.getParam('placa');
        const marca = navigation.getParam('marca');
        const anio = navigation.getParam('anio');
        const chasis = navigation.getParam('chasis');
        const motor = navigation.getParam('motor');
        const modelo = navigation.getParam('modelo');
        const kilometraje = navigation.getParam('kilometraje');
        const costo = navigation.getParam('costo');
        const transmision = navigation.getParam('transmision');
      
        return (
            <ScrollView style={styles.container}>
                 <ImageBackground
                        style={styles.thumbnail}
                        source={{uri: "http:/192.168.1.8:3210/images/"+placa+".png" }}
                    >
                  
                      <Text style={[styles.text, styles.titleShow]}>{marca}-{modelo}</Text>
                   
                    </ImageBackground>
                    <View style={styles.descriptionContainer}>
                        <View style={styles.subtitle}>
                            <Text style={[styles.text, styles.subTitleText]}>Año: {anio}</Text>
                            <Text style={[styles.text, styles.subTitleText]}>Motor{motor}</Text>
                        </View>
                        <Text style={[styles.text]}>Placa: {placa}. </Text>
                        <Text style={[styles.text]}>Marca: {marca}. </Text>
                        <Text style={[styles.text]}>Modelo: {modelo}. </Text>
                        <Text style={[styles.text]}>Costo: ${costo}. </Text>
                        <Text style={[styles.text]}>Transmisión: {transmision} </Text>

                        <View style={styles.shareListIcons}>
                            <TouchableHighlight onPress={()=>navigation.navigate('Alquiler',{
                                placa: placa,
                                })}>
                            <View style={styles.myListIcon}>
                                <IonIcons
                                    style={styles.listIcon} 
                                    name="md-checkmark"
                                    color="grey"
                                    size={25}
                                />
                                <Text style={styles.text}>Alquilar</Text>
                            </View>
                            </TouchableHighlight>
                            <TouchableHighlight onPress={ () => this.onShare(placa,marca,modelo)}>
                                <View style={styles.myShareIcon}>
                                    <Icon 
                                        style={styles.shareIcon}
                                        name="share-alt"
                                        color="grey"
                                        size={25}
                                    />
                                    <Text style={styles.text}>Compartir</Text>
                                </View>
                            </TouchableHighlight>
                        </View>
                        </View>
                        <TabsAutos data={marca} data2={transmision} navigation={this.props.navigation}/>
            </ScrollView>
         
       
        )
    }
}

const styles = StyleSheet.create({
    nameContainer: {
        backgroundColor: 'transparent',
        bottom:400
    },
    titleShow:{
        fontSize:30,
        paddingLeft:10,
        marginBottom:5,
        marginTop:245,
        color:'black'
    },
    header: {
        backgroundColor: '#181818',
        paddingVertical: 10,
        alignItems: 'center',
        position: 'absolute',
        top: 0,
        left: 0,
        right: 0,
        zIndex: 1
    },
    closeButton: {
        position: 'absolute',
        top: 15,
        right: 10,
        zIndex: 2
    },
    headerText: {
        color: 'black',
        fontSize: 20
    },
    headerWithIcon: {
        flexDirection: 'row',
        alignItems: 'center'
    },
    iconDown: {
        marginLeft: 5
    },
    
    container: {
        flex: 1,
        backgroundColor: '#181818'
    },
    thumbnail: {
        width: width,
        height: 300
    },
    buttonPlay: {
        justifyContent: 'center',
        flex: 1,
        alignItems: 'center'
    },
    iconPlay: {
        opacity: 0.7,
        backgroundColor: 'transparent'
    },
    descriptionContainer: {
        paddingHorizontal: 20,
        paddingTop:10
    },
    subtitle: {
        flexDirection: 'row'
    },
    subTitleText: {
        marginRight: 20
    },
    text: {
        color: '#b3b3b3',
        fontSize: 16
    },
    shareListIcons: {
       flexDirection: 'row',
       marginVertical: 30 
    },
    listIcon: {
        height: 25
    },
    shareIcon: {
        height: 25
    },
    myListIcon: {
        flexDirection: 'column',
        justifyContent: 'center',
        alignItems: 'center',
        marginRight: 40
    },
    myShareIcon: {
        flexDirection: 'column',
        justifyContent: 'center',
        alignItems: 'center'
    },
    description: {
        marginVertical: 10
    },
    light: {
        fontWeight: '200'
    }
})

export default Details