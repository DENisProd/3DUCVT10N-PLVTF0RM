import React from 'react';
import styles from './Rasp.module.scss';
import Navigation2 from "../Navigation2/Navigation2";
import NavigationMain from "../Navigation/NavigationMain";

const Rasp = () => {
    return (
        <div className={styles.rasp}>
            <Navigation2/>
            <div className={styles.rasp__content}>
                <h2>Расписание</h2>
                <iframe
                    src="https://docs.google.com/spreadsheets/d/e/2PACX-1vTVzlrk6nLJqF35cobgiPPQXgBDg3OSWdWOPiB0somElac2-ZmOXQZlFOwn9TyHCQdlKH9WMdQn_v-9/pubhtml?widget=true&amp;headers=false"></iframe>
            </div>
        </div>
    )
};

export default Rasp;
