import React, { Component } from 'react';
import {
    Platform,
    StyleSheet,
    Text,
    View,
    Image,
    TouchableOpacity
} from 'react-native';
import Icon from 'react-native-vector-icons/MaterialIcons';


export default class VideoItem extends Component {
    constructor(props){
        super(props);
       
    }
   
  
    render() {
        let video = this.props.video;
        return (
            <View style={styles.container}>
               <TouchableOpacity  onPress={() => this.props.navigation.navigate('Envio')}>
                <Image source={{ uri: "http:/192.168.1.8:3210/images/"+video.placa+".png" }} style={{ height: 200 }} />
                <View style={styles.descContainer}>
                <Image source={ require('../images/car.png')} style={{ width: 50, height: 50, borderRadius: 25 }} />
                    <View style={styles.videoDetails}>
                        <Text numberOfLines={2} style={styles.videoTitle}>Placa: {video.marca}</Text>
                        <Text style={styles.detalle}>{video.placa}</Text>
                        <Text style={styles.detalle}>{video.modelo}</Text>
                        <Text style={styles.detalle}>{video.anio}</Text>
                        <Text style={styles.detalle}>{video.costo}</Text>
                    </View>
                    <TouchableOpacity>
                        <Icon name="more-vert" size={20} color="#999999"/>
                    </TouchableOpacity>
                </View>
                </TouchableOpacity>
            </View>
        )
    }
}


const styles = StyleSheet.create({
    costo:{
        fontSize:20
    },
    container: {
        padding: 15
    },
    detalle:{
        color: '#34495e',
        fontSize:13
    },
    descContainer: {
        flexDirection: 'row',
        paddingTop: 15,
        backgroundColor: '#ecf0f1'
    },
    videoTitle: {
        fontSize: 16,
        color: '#3c3c3c'
    },
    videoDetails: {
        paddingHorizontal: 15,
        flex: 1
    },
    videoStats: {
        fontSize: 15,
        paddingTop: 3
    }

});