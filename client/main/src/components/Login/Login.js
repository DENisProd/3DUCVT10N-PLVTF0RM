import React, {useContext, useEffect, useState} from 'react';
import styles from './Login.module.scss';
import bigLogo from "../../assets/images/BigLogo.svg";
import close from "../../assets/images/close.svg";
import Input from "../Input/Input";
import gosuslugi from "../../assets/images/gosuslugi.png";
import sber from "../../assets/images/sber.png";
import {Link, useNavigate} from "react-router-dom";
import useInput from "../TextField/UseInput";
import axios from "axios";
import { Context } from "../../App";


const Login = () => {
    const URL_login = "https://hack.mysecrets.site/api/auth/signin";

    const {isAuth, setIsAuth} = useContext(Context);
    const {token, setToken} = useContext(Context);

    const [message, setMessage] = useState('');
    const navigate = useNavigate();

    const username = useInput('', {isEmpty: true, minLength: 3});
    const password = useInput('', {isEmpty: true, minLength: 3, maxLength: 12});

    const logIn = () => {
        const user = {
            username: username.value,
            password: password.value
        }

        axios.post(URL_login, user).then(res => {
            console.log(res);
            setMessage(res.data.message);
            setIsAuth(true);
            localStorage.setItem('token', res.data.token);
            navigate('/')
        }).catch(res => {
            setMessage("Неверный логин или пароль");
        });
    }

    return (
        <div className={styles.login}>
            <div>
                <img src={bigLogo} alt="bigLogo"/>
            </div>
            <div className={styles.login__form}>
                <div className={styles.login__title}>
                    <h3>Авторизация</h3>
                    <Link to="/"><img src={close} alt="close"/></Link>
                </div>
                <div className={styles.login__type}>

                </div>
                <p className={styles.login__info}>Контактная информация</p>
                <Input useInput={username} name="username" type="text" placeholder={"Ваш логин"}/>
                <Input useInput={password} name="password" type="password" placeholder={"Ваш пароль"}/>
                <p className={styles.login__enter}>Войти с помощью</p>
                <div className={styles.login__enterhelp}>
                    <div><img src={gosuslugi} alt="gosuslugi"/></div>
                    <div><img src={sber} alt="sberid"/></div>
                </div>
                <div className={styles.login__btns}>
                    <button onClick={logIn} className={styles.login__btn1}>авторизоваться</button>
                    <button className={styles.login__btn2}>забыли пароль?</button>
                    <button className={styles.login__btn2}>у вас нет аккаунта?</button>
                </div>
                <h5>{message}</h5>
            </div>
        </div>
    )
};

export default Login;
