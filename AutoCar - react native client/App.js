import React from 'react';
import { View, Text } from 'react-native';
import { createStackNavigator } from 'react-navigation';

import Main from './app/Main'
import Search from './app/components/Search'
import Details from './app/components/Details'
import List from './app/components/List'
import Alquiler from './app/components/Alquiler'

const RootStack = createStackNavigator(
  {
    Home: Main,
    Search: Search,
    Details: Details,
    List: List,
    Alquiler:Alquiler
  },
  {
    initialRouteName: 'Home',
  }
);
export default class App extends React.Component {
  render() {
    return <RootStack />;
  }
}