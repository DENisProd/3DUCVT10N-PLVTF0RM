import React, {useContext} from 'react';
import styles from './Profile.module.scss';
import Navigation2 from "../Navigation2/Navigation2";
import person from '../../assets/images/st.png';
import bigPerson from '../../assets/images/st1.png';
import edit from '../../assets/images/edit.svg';
import delete2 from '../../assets/images/delete.svg';
import {Context} from "../../App";

const Profile = () => {

    const {isAuth, setIsAuth} = useContext(Context);
    const {token, setToken} = useContext(Context);
    const {data, setData} = useContext(Context);

    return (
        <div className={styles.profile}>
            <Navigation2/>
            <div className={styles.profile__content}>
                <div className={styles.profile__photo}>
                    <div className={styles.profile__photo_person}>
                        <img src={person} alt="person"/>
                        <p>студент</p>
                    </div>
                    <img className={styles.profile__photo_bigPerson} src={bigPerson} alt="bigPerson"/>
                    <p className={styles.profile__photo_title}>Фото профиля</p>
                    <div className={styles.profile__photo_btns}>
                        <button className={styles.profile__photo_btn1}>
                            <img src={edit} alt="edit"/>
                            Изменить
                        </button>
                        <button className={styles.profile__photo_btn2}>
                            <img src={delete2} alt="delete"/>
                            Удалить
                        </button>
                    </div>
                </div>
                <div className={styles.profile__info}>
                    <div className={styles.profile__inp}>
                        <p className={styles.profile__inp_first}>Ваше ФИО</p>
                        <div>{data?.firstName + " " + data?.lastName + " " + data?.patronomic}</div>
                    </div>
                    <div className={styles.profile__inp}>
                        <p>Факультет</p>
                        <div>Информатика и вычислительная техника</div>
                    </div>
                    <div className={styles.profile__inp}>
                        <p>Кафедра</p>
                        <div>пмавыымиаувитритвпитвапт</div>
                    </div>
                    <div className={styles.profile__inp}>
                        <p>Адрес вашей электроной почты</p>
                        <div>{data?.email}</div>
                    </div>
                </div>
                <div className={styles.profile__ball}>
                    <div className={styles.profile__ballinfo}>
                        <p>Средний балл</p>
                        <div>
                            4.2
                        </div>
                    </div>
                    <div className={styles.profile__ballinfo}>
                        <p>Баллы за портфолио</p>
                        <div>
                            52
                        </div>
                    </div>
                    <div className={styles.profile__ballinfo}>
                        <p>Номер вашей группы</p>
                        <div>
                            ЭА11
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
};

export default Profile;
