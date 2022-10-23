import React from 'react';
import styles from './Help.module.scss';
import arrow2 from '../../assets/images/arrow2.svg';

const QuestCard = () => {
    return (
        <div className={styles.questCard}>
            <p>Что такое newStudy?</p>
            <img src={arrow2} alt="arrow2"/>
        </div>
    );
};

export default QuestCard;