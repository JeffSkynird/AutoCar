import React from 'react';
import { Button, Text } from 'react-native';
export default class HomeScreen extends React.Component {
    static navigationOptions = {
      title: 'Welcome',
      header: null
    };
    render() {
      const { navigate } = this.props.navigation;
      return (
        <Button
          title="Go to Jane's profile"
          onPress={() =>
            navigate('Details', { name: 'Jane' })
          }
        />
      );
    }
}