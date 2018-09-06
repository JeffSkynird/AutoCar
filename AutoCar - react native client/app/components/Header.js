import React, {Component} from 'react'
import {
    Text,
    View,
    StyleSheet,
    TouchableWithoutFeedback,
    Image
} from 'react-native'

import Icon from 'react-native-vector-icons/FontAwesome'

export default  class Header  extends Component{
    constructor(props){
        super(props);
    }
    static navigationOptions = {
        title: 'Welcome',
        header: null
      };
      static navigationOptions = {
        headerVisible: false
    }
    render(){
        const { navigate } = this.props.navigation;
       
        return(
           
            <View style={styles.container}>
                <TouchableWithoutFeedback >
                    <Icon 
                        name="bars"
                        color="black"
                        size={25}
                    />
                </TouchableWithoutFeedback>
                <Text style={{color:'white',fontSize:25}}>AUTO CAR</Text>
                <TouchableWithoutFeedback onPress={() => navigate('Search')}>
                <Icon 
                    name="search"
                    color="white"
                    size={25}
                />
                </TouchableWithoutFeedback>
             </View>
        )
        
  
    }
        
}

const styles = StyleSheet.create({
    container: {
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
