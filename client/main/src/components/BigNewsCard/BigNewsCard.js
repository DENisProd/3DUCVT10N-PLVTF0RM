import React from 'react';
import styles from './BigNewsCard.module.scss';
import Tag from "./Tag/Tag";
import heart from '../../assets/images/heart.png';
import health from '../../assets/images/health.png';
import musle from '../../assets/images/musle.png';
import runners from '../../assets/images/runners.jpg';
import eye from '../../assets/images/eye.svg';
import like from '../../assets/images/like.svg';
import comment from '../../assets/images/comment.svg';
import fire from '../../assets/images/fire.png';




const BigNewsCard = () => (
    <div className={styles.BigNewsCard}>
        <div className={styles.BigNewsCard__tags}>
            <div className={styles.BigNewsCard__fire}>
                <img src={fire} alt="fire"/>
            </div>
            <Tag img={musle} title={"Спорт"}/>
            <Tag img={heart} title={"Жизнь ВУЗа"}/>
            <Tag img={health} title={"Здоровье"}/>
        </div>
        <h2 className={styles.BigNewsCard__title}>В newStudy прошёл марафон по бегу!</h2>
        <p className={styles.BigNewsCard__data}>5 дней назад</p>

        <p className={styles.BigNewsCard__description}>
            XXXVI Донской марафон проводит Федерация легкой атлетики г. Ростова-на-Дону. Мероприятие получает статус
            Открытого Чемпионата г. Ростова-на-Дону по марафону. Старт предполагает возможность участия в данном
            спортивном мероприятии от молодых спортсменов (юношей и девушек) до ветеранов легкой атлетики. При
            выполнении соответствующих спортивных нормативов участникам соревнования будут присвоены спортивные
            разряды.</p>
        <img className={styles.BigNewsCard__photo} src={runners} alt="main_photo"/>
        <div className={styles.BigNewsCard__buttons}>
            <div className={styles.BigNewsCard__btns}>
                <div className={styles.BigNewsCard__btn}>
                    <svg width="24" height="25" viewBox="0 0 24 25" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M20.4134 5.83319C19.3781 4.7103 17.9575 4.09186 16.413 4.09186C15.2585 4.09186 14.2012 4.45685 13.2704 5.17661C12.8008 5.53992 12.3752 5.98441 12 6.5032C11.6249 5.98456 11.1992 5.53992 10.7294 5.17661C9.79877 4.45685 8.74149 4.09186 7.58701 4.09186C6.04251 4.09186 4.62177 4.7103 3.58646 5.83319C2.56351 6.94296 2 8.45908 2 10.1024C2 11.7939 2.63034 13.3422 3.98364 14.9752C5.19427 16.4359 6.93423 17.9188 8.94916 19.6358C9.63718 20.2222 10.4171 20.8869 11.2268 21.5949C11.4408 21.7823 11.7153 21.8854 12 21.8854C12.2846 21.8854 12.5592 21.7823 12.7729 21.5952C13.5826 20.8871 14.363 20.2221 15.0513 19.6354C17.0659 17.9186 18.8059 16.4359 20.0165 14.975C21.3698 13.3422 22 11.7939 22 10.1023C22 8.45908 21.4365 6.94296 20.4134 5.83319Z" fill="white"/>
                    </svg>
                    <p>1.56K</p>
                </div>
                <div className={styles.BigNewsCard__btn}>
                    <svg width="18" height="19" viewBox="0 0 18 19" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M5.12012 17.5H9.00012H5.12012Z" fill="white"/>
                        <path d="M5.12012 17.5H9.00012" stroke="#141414" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M5.26401 17.5H1.92501C1.10201 17.5 0.690007 16.505 1.27201 15.924L2.36201 14.834" stroke="#141414" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M1 9.5C1 5.082 4.582 1.5 9 1.5C13.418 1.5 17 5.082 17 9.5C17 13.918 13.418 17.5 9 17.5" stroke="#141414" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M2.73011 14.46L2.36011 14.83" stroke="#141414" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M2.733 14.463C1.651 13.099 1 11.377 1 9.5" stroke="#141414" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                    <p>281</p>
                </div>
            </div>
            <div className={styles.BigNewsCard__views}>
                <img src={eye} alt="eye"/>
                <p>5K</p>
            </div>
        </div>
    </div>
);

export default BigNewsCard;
