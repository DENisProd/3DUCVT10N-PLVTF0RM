import React from 'react';
import styles from "./FacultCard.module.scss";
import Tag2 from "../../Prepods/PrepodCard/Tag2/Tag2";
import phone from '../../../assets/images/phone.svg';
import letter2 from '../../../assets/images/letter2.svg';

const FacultCard = ({name, description, location, contacts, cathedraList}) => {
    return (
        <div className={styles.facultCard}>
            <div className={styles.facultCard__big}>
                <h3 className={styles.facultCard__big_title1}>{name ? name : "Авиастроение"}</h3>
                <p className={styles.facultCard__big_desc}>{description ? description : "Факультет «Авиастроение» создан в 2013 году с целью обеспечения реального сектора экономики кадрами в области разработки технологических процессов производства воздушных судов, ремонта и обслуживания авиационной техники, обеспечения работоспособности холодильных и криогенных систем, систем кондиционирования и вентиляции, в том числе на транспорте, а также разработки конструкторско-технологической документации новых и модернизируемых наземных транспортно-технологических машин для аэродромов."}</p>
                <h3 className={styles.facultCard__big_title2}>Кафедры</h3>
                <div className={styles.facultCard__tags}>
                    {cathedraList?.map(cathedra => <Tag2 key={cathedra?.id} title={cathedra?.name}/>)}
                </div>
            </div>
            <div className={styles.facultCard__small}>
                <h3>Деканат</h3>
                <div className={styles.facultCard__contacts}>
                    <p className={styles.facultCard__contacts_title}>Контакты</p>
                    <div className={styles.facultCard__contacts_phones}>
                        <div>
                            <img src={phone} alt="phone1"/>
                            <p>258-53-32</p>
                        </div>
                    </div>
                    <div className={styles.facultCard__contacts_email}>
                        <img src={letter2} alt="letter"/>
                        <p>{contacts ? contacts : "будние дни с 8:30 до 16:00, суббота с 8:30 до 13:30"}</p>
                    </div>
                </div>
                <div className={styles.facultCard__address}>
                    <p className={styles.facultCard__address_title}>
                        Адресс
                    </p>
                    <p className={styles.facultCard__address_pos}>
                        {location ? location : "ул. Страна Советов, 1. ауд. 10-227, 10-228, 10-222"}
                    </p>
                </div>
                <div className={styles.facultCard__dop}>
                    <p className={styles.facultCard__dop_title1}>
                        Дополнительное образование
                    </p>
                    <p className={styles.facultCard__dop_title2}>
                        Авиационный учебный центр факультета Авиастроение
                    </p>
                </div>
            </div>
        </div>
    );
};

export default FacultCard;