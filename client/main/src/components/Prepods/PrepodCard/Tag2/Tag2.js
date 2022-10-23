import React from 'react';
import styles from './Tag2.module.scss';

const Tag2 = ({title, img}) => {
    return (
        <div className={styles.tag}>
            { !img ? '' : <img src={img} alt="tag"/>}
            <p>{title}</p>
        </div>
    );
};

export default Tag2;