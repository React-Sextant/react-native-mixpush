import { NativeModules } from 'react-native';

export const getToken = function(app_id){
    return Promise.resolve(NativeModules.RNMixPush.getToken(app_id))
};
