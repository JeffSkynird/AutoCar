import React, { Component } from 'react';
import {View,Text,Dimensions,Platform} from 'react-native';
import {SceneMap,TabView, TabBar,PagerPan,PagerScroll } from 'react-native-tab-view';
import RelacionMarcas from './RelacionMarcas';
import RelacionOtros from './RelacionOtros';


export default class TabsEpisodes extends Component {
    constructor(props){
        super(props)
    }
    state = {
        index: 0,
    routes: [
        { key: 'first', title: 'Más de la marca' },
        { key: 'second', title: 'Relacionados' },
    ],
    };

     _handleIndexChange = index => this.setState({ index });

    _renderTabBar = props => <TabBar {...props} style={{backgroundColor:'transparent'}} indicatorStyle={{ backgroundColor: 'red' }}
    />;

   _renderScene = SceneMap({
     first:  () => <RelacionMarcas data={this.props.data } navigation={this.props.navigation} />,
     second:() => <RelacionOtros data={this.props.data2 }  navigation={this.props.navigation} />
   });

   _renderPager(props){
     return (Platform.OS === 'ios') ? <PagerScroll {...props} /> : <PagerPan {...props} />
   }

  render() {
     return (
 
            <TabView
            navigationState={this.state}
            renderScene={this._renderScene}
            renderTabBar={this._renderTabBar}
            onIndexChange={this._handleIndexChange}
            initialLayout={{
                width: Dimensions.get('window').width,
                height: Dimensions.get('window').height
            }}
            renderPager={this._renderPager}
            />
           
    
    );
  }
}
