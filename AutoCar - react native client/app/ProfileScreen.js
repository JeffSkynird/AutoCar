import React from 'react';
import { Button, Text, View } from 'react-native';

export default class DetailsScreen extends React.Component {
    static navigationOptions = {
      title: 'Welcome',
      header: null
    };
    render() {
      const { navigate } = this.props.navigation;
      return (
          <View>
        <Button
          title="Go to Jane's profile"
          onPress={() =>
            navigate('Home', { name: 'Jane' })
          }
        />
        </View>
      );
    }
  }