import React from 'react';
import styles from './Prepods.module.scss';
import PrepodCard from "./PrepodCard/PrepodCard";
import search from "../../assets/images/search.svg";
import Navigation2 from "../Navigation2/Navigation2";

const Prepods = () => {
    return (
        <div className={styles.prepods}>
            <Navigation2/>
            <div className={styles.prepods__myprepods}>
                <h2>Мои преподаватели</h2>
                <div className={styles.prepods__list}>
                    <PrepodCard/>
                    <PrepodCard/>
                    <PrepodCard/>
                </div>
                <div className={styles.prepods__allprepods}>
                    <div className={styles.prepods__allprepods__title}>
                        <h2>Все преподаватели</h2>
                        <div className={styles.prepods__search}>
                            <img src={search} alt="search"/>
                            <input type="text" placeholder="Введите имя / предмет..."/>
                        </div>
                    </div>
                    <div className={styles.prepods__list}>
                        <PrepodCard/>
                        <PrepodCard/>
                        <PrepodCard/>
                    </div>
                </div>
            </div>
        </div>
    )
};

export default Prepods;
