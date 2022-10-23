import React from 'react';
import styles from './SmallNewsCard.module.scss';

const SmallNewsCard = ({title, description}) => (
    <div className={styles.SmallNewsCard}>
        <h3>{title}</h3>
        <p>{description}</p>
    </div>
);

export default SmallNewsCard;
