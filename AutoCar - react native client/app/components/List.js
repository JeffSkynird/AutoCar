import React, {Component} from 'react'
import {
    Text,
    View,
    FlatList,  Image, StyleSheet,TouchableWithoutFeedback
} from 'react-native';

import axios from 'axios';

class List extends Component {
    constructor(){
        super();
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

    _renderItem(item){
        return (
            <TouchableWithoutFeedback onPress={()=>this.props.navigation.navigate('Details',{
                placa:item.placa,
                marca: item.marca,
                modelo: item.modelo,
                anio: item.anio,
                motor: item.motor,
                costo: item.costo,
                transmision: item.transmision
            })}>
            <Image style={{width: 120, height: 180}} source={{uri: "http:/192.168.1.8:3210/images/"+item.placa+".png" }}/>
            </TouchableWithoutFeedback>
        )
    }

    render(){
        const { navigate } = this.props.navigation;
        const space = this.state.dataku.filter(x => x.anio === 2018);
        const transmision = this.state.dataku.filter(x => x.transmision === 'Manual');
        return (
            <View style={{flex: 1}}>
                <View>
                <Text style={styles.text}>Adiciones más recientes</Text>
                    <FlatList
                        horizontal
                        ItemSeparatorComponent={() => <View style={{width: 5}} />}
                        renderItem={({item}) => this._renderItem(item)} 
                        data={this.state.dataku}
                        keyExtractor={(item)=>item.id.toString()}/>
                </View>
                <View>
                    <Text style={styles.text}>De este año</Text>
                    <FlatList
                        horizontal
                        ItemSeparatorComponent={() => <View style={{width: 5}} />}
                        renderItem={({item}) => this._renderItem(item)} 
                        data={space}
                        keyExtractor={(item)=>item.id.toString()}
                    />
                </View>
                <View>
                    <Text style={styles.text}>Mayormente en existencia</Text>
                    <FlatList
                        horizontal
                        ItemSeparatorComponent={() => <View style={{width: 5}} />}
                        renderItem={({item}) => this._renderItem(item)} 
                        data={space}
                        keyExtractor={(item)=>item.id.toString()}
                    />
                </View>
            </View>
            
        )
    }
}

const styles = StyleSheet.create({
    text: {
        color: 'white'
    }
})
export default List