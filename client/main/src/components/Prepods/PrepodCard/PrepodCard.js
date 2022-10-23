import React from 'react';
import styles from './PrepodCard.module.scss';
import teacher from '../../../assets/images/teacher.png';
import letter2 from '../../../assets/images/letter2.svg';
import phone from '../../../assets/images/phone.svg';
import Tag2 from "./Tag2/Tag2";

const PrepodCard = () => {
    return (
        <div className={styles.prepodCard}>
            <div className={styles.prepodCard__title}>
                <img src={teacher} alt="photoPrepod"/>
                <p>Новикова Людмила Александровна</p>
            </div>
            <p className={styles.prepodCard__desc}>
                Преподаватель математики. Большой
                стаж и отзывчивость к ученику, даёт возможность называть её отличным учителем математики.
            </p>
            <div className={styles.prepodCard__info}>
                <div>
                    <img src={letter2} alt="letter"/>
                    <p><span>ludmila@mail.ru</span></p>
                </div>
                <div>
                    <img src={phone} alt="phone"/>
                    <p>8(901)-353-12-12</p>
                </div>
            </div>
            <div className={styles.prepodCard__tags}>
                <Tag2 title={"Математика"}/>
                <Tag2 title={"1 курс"}/>
                <Tag2 title={"2 курс"}/>
                <Tag2 title={"ещё какой-то аспект"} />
            </div>
        </div>
    );
};

export default PrepodCard;