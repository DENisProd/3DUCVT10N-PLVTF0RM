import React, {useContext, useState} from 'react';
import styles from './Header.module.scss';
import letter from '../../assets/images/letter.svg';
import logo from '../../assets/images/logo.svg';
import search from '../../assets/images/search.svg';
import newStudy from '../../assets/images/newStudy.svg';
import {Link} from "react-router-dom";
import {Context} from "../../App";
import profilePhoto from "../../assets/images/profilePhoto.png";
import close from "../../assets/images/close.svg";
import Modal from "../Modal/Modal";

const Header = () => {
    const {isAuth, setIsAuth} = useContext(Context);

    const [modalActive, setModalActive] = useState(false);

    const logout = () => {
        localStorage.removeItem('token');
        window.location.reload();
    }

    return (
        <header className={styles.header}>
            <div className={styles.header__container}>
                <div className={styles.header__inner}>
                    <div className={styles.header__leftside}>
                        <Link to="/">
                            <div>
                                <img className={styles.header__logo} src={logo} alt="logo"/>
                                <img className={styles.header__newStudy} src={newStudy} alt="newStudy"/>
                            </div>
                        </Link>
                    </div>

                    <nav className={styles.header__nav}>
                        <div onClick={() => setModalActive(true)} className={styles.header__connection}>
                            <img src={letter} alt="связь"/>
                            <p>Связаться с ректором</p>
                        </div>
                        {isAuth ? <>
                            <Link to="/profile">
                                <div className={styles.header__profile}>
                                    <p>мой профиль</p>
                                    <img src={profilePhoto} alt="profilePhoto"/>
                                </div>

                            </Link>
                            <div onClick={() => logout()} className={styles.header__enter}>
                                <p>выход</p>
                            </div>
                        </> : <>
                            <Link to="/login">
                                <div className={styles.header__enter}>
                                    <p>вход</p>
                                </div>
                            </Link>
                            <Link to="/registration">
                                <div className={styles.header__registration}>
                                    регистрация
                                </div>
                            </Link>
                        </>
                        }
                    </nav>
                </div>
            </div>
            <Modal acitve={modalActive} setActive={setModalActive}>
                <div className={styles.modal__content}>
                    <h3>связь с ректором</h3>
                    <img onClick={() => setModalActive(false)} src={close} alt="close"/>
                </div>
                <div className={styles.modal__contact}>
                    <h4>Контактная информация</h4>
                    <div>
                        <input type="text" placeholder={"Фамилия, имя и отчество"}/>
                    </div>
                    <div>
                        <input type="text" placeholder={"Номер вашей группы"}/>
                    </div>
                    <div>
                        <input type="text" placeholder={"Введите ваш Email"}/>
                    </div>
                </div>
                <div className={styles.modal__reason}>
                    <h4>
                        Причина обращения
                    </h4>
                    <textarea></textarea>
                    <button>Отправить</button>
                </div>
            </Modal>
        </header>
    )
};


export default Header;
