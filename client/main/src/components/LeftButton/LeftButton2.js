import React from 'react';
import styles from './LeftButton.module.scss';

const LeftButton2 = ({title, img}) => (
    <div className={styles.leftButton2}>
        {img}
        <p>{title}</p>
    </div>
);

export default LeftButton2;
