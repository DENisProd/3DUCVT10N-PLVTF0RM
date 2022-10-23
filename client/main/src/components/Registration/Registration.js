import React, {useEffect, useState} from 'react';
import styles from './Registration.module.scss';
import bigLogo from '../../assets/images/BigLogo.svg';
import close from '../../assets/images/close.svg';
import Input from "../Input/Input";
import gosuslugi from '../../assets/images/gosuslugi.png';
import sber from '../../assets/images/sber.png';
import {Link, useNavigate} from "react-router-dom";
import useInput from "../TextField/UseInput";
import axios from "axios";

const Registration = () => {

    const URL_registration = "https://hack.mysecrets.site/api/auth/signup";

    const [message, setMessage] = useState('');
    const navigate = useNavigate();

    const email = useInput('', {isEmpty: true, minLength: 3, isEmail: true});
    const username = useInput('', {isEmpty: true, minLength: 3});
    const lastName = useInput('', {isEmpty: true, minLength: 1});
    const firstName = useInput('', {isEmpty: true, minLength: 1});
    const patronomic = useInput('', {isEmpty: true, minLength: 1});
    const password = useInput('', {isEmpty: true, minLength: 3, maxLength: 12});
    const password1 = useInput('', {isEmpty: true, minLength: 3, maxLength: 12, isEquals: password.value});


    const registration = () => {
        const user = {
            email: email.value,
            username: username.value,
            lastName: lastName.value,
            firstName: firstName.value,
            patronomic: patronomic.value,
            password: password.value,
            role: ["user"]
        }

        axios.post(URL_registration, user).then(res => {
            setMessage(res.data.message);
            navigate('/login')
        }).catch(res => {
            setMessage(res.response.data.message);
        });
    }

    return (
        <div className={styles.registration}>
            <div>
                <img src={bigLogo} alt="bigLogo"/>
            </div>
            <div className={styles.registration__form}>
                <div className={styles.registration__title}>
                    <h3>Выберите свою роль</h3>
                    <Link to="/"><img src={close} alt="close"/></Link>
                </div>
                <div className={styles.registration__type}>

                </div>
                <p className={styles.registration__info}>Контактная информация</p>
                <Input useInput={email} name="email" type="email" placeholder={"Ваш адрес электроной почты"}/>
                <Input useInput={username} name="username" type="text" placeholder={"Ваш логин"}/>
                <Input useInput={firstName} name="firstName" type="text" placeholder={"Ваше имя"}/>
                <Input useInput={lastName} name="lastName" type="text" placeholder={"Ваша фамилия"}/>
                <Input useInput={patronomic} name="patronomic" type="text" placeholder={"Ваше очество"}/>
                <Input useInput={password} name="password" type="password" placeholder={"Ваш пароль"}/>
                <Input useInput={password1} name="password1" type="password" placeholder={"Повторите пароль"}/>
                <p className={styles.registration__enter}>Войти с помощью</p>
                <div className={styles.registration__enterhelp}>
                    <div><img src={gosuslugi} alt="gosuslugi"/></div>
                    <div><img src={sber} alt="sberid"/></div>
                </div>
                <div className={styles.registration__btns}>
                    <button onClick={registration} className={styles.registration__btn1}>зарегестрироваться</button>
                    <button className={styles.registration__btn2}>у вас уже есть аккаунт?</button>
                </div>
                <h5>{message}</h5>
            </div>
        </div>
    )
};

export default Registration;
