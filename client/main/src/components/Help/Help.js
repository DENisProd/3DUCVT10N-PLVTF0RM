import React from 'react';
import styles from './Help.module.scss';
import Navigation2 from "../Navigation2/Navigation2";
import QuestCard from "./QuestCard";
import phone from "../../assets/images/phone.svg";
import letter2 from "../../assets/images/letter2.svg";

const Help = () => (
    <div className={styles.help}>
        <Navigation2/>
        <div className={styles.help__quest}>
            <h2>Помощь</h2>
            <div className={styles.help__list}>
                <div className={styles.help__big}>
                    <h3>Часто задаваемые вопросы</h3>
                    <QuestCard/>
                    <QuestCard/>
                    <QuestCard/>
                </div>
                <div className={styles.help__small}>
                    <h3>Контакты поддержки</h3>
                    <div className={styles.help__contacts_phones}>
                        <div>
                            <img src={phone} alt="phone1"/>
                            <p>258-53-32</p>
                        </div>
                        <div>
                            <img src={phone} alt="phone2"/>
                            <p>258-12-42</p>
                        </div>
                    </div>
                    <div className={styles.help__contacts_email}>
                        <img src={letter2} alt="letter"/>
                        <p>nte34r5-36@gmail.com  </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
);

export default Help;
