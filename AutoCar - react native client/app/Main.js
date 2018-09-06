import React, { Component } from 'react';
import {
  Platform,
  StyleSheet,
  Text,
  View,
  Image,
  TouchableOpacity,
  FlatList,ScrollView,TouchableWithoutFeedback
} from 'react-native';
import List from './components/List'
import Slider from './components/Slider'
import Header  from './components/Header'
import Icon from 'react-native-vector-icons/FontAwesome'
export default class App extends Component {
  static navigationOptions = {
    title: 'Welcome',
    header: null
  };
  constructor(){
        super();
      }
  render() {
    const { navigate } = this.props.navigation;
    return (
      <View style={[{flex:1}, styles.container]}>
       <ScrollView style={[{flex: 1}, styles.container]}>
          <Header navigation={this.props.navigation}/>
          <Slider/>
          <List navigation={this.props.navigation}/> 
          </ScrollView>
      </View>
     
   
    )
  }
}

const styles = StyleSheet.create({
  container: {
      backgroundColor: 'black'
  },
  container2: {
    flexDirection: 'row',
    height: 60,
    alignItems: 'center',
    justifyContent:'space-between',
    backgroundColor: 'black',
    paddingHorizontal: 15,
    paddingTop: 10,
},
logo: {
    width: 120,
    height: 40
}
})