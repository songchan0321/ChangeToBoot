import React from 'react';
import {Background, LoadingText} from './Styles';
import Spinner from './assets/spinner.gif';

export default () => {
    return (
        <Background>
            <LoadingText>기다려!!!!!!!!!</LoadingText>
            <img src={Spinner} alt="기다려!!!!!!!!!" width="5%" />
        </Background>
    );
};