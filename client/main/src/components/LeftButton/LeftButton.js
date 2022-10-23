import React from 'react';
import styles from './LeftButton.module.scss';

const LeftButton = ({title, img, here}) => {
    return (
        <div className={here ? styles.leftButtonHere : styles.leftButton}>
            {img}
            <p>{title}</p>
        </div>
    )
};

export default LeftButton;
