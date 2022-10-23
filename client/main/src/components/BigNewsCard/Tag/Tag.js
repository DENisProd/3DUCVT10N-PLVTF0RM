import React from 'react';
import styles from './Tag.module.scss';



const Tag = ({title, img}) => {
    return (
        <div className={styles.tag}>
            { !img ? '' : <img src={img} alt="tag"/>}
            <p>{title}</p>
        </div>
    );
};

export default Tag;