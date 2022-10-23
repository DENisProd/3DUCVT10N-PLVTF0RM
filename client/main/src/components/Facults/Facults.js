import React, {useContext, useEffect, useState} from 'react';
import styles from './Facults.module.scss';
import Navigation2 from "../Navigation2/Navigation2";
import FacultCard from "./FacultCard/FacultCard";
import search from "../../assets/images/search.svg";
import {Context} from "../../App";
import axios from "axios";

const Facults = () => {

    const [isLoading, setIsLoading] = useState(false);

    const URL_getfac = "https://hack.mysecrets.site/api/dean/faculty/";
    const [facults, setFacults] = useState([]);


    useEffect(() => {
        setIsLoading(true);
        axios.get(URL_getfac).then(res => {
            console.log(res.data);
            setFacults(res.data);
            setIsLoading(false);
        }).catch(() => {
            setIsLoading(false);
        });
    }, [])

    return (
        <div className={styles.facults}>
            <Navigation2/>
            <div className={styles.facults__myfacults}>
                <h2>Мой факультет</h2>
                <FacultCard/>
                <div className={styles.facults__allFacults}>
                    <h2>Все факультеты</h2>
                    <div className={styles.facults__search}>
                        <img src={search} alt="search"/>
                        <input type="text" placeholder="Введите название факультета..."/>
                    </div>

                </div>

                {isLoading ? <h4>Загрузка...</h4> : <div className={styles.facults__list}>
                    {facults.map(facult => <FacultCard key={facult.id} name={facult.name} description={facult.description}
                                                       location={facult.location} contacts={facult.contacts} cathedraList={facult.cathedraList}/>)
                    }
                </div>}
            </div>
        </div>
    )
};

export default Facults;
