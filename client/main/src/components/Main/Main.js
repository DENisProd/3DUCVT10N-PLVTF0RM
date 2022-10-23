import React, {useContext} from 'react';
import styles from './Main.module.scss';
import News from "../News/News";
import Registration from "../Registration/Registration";
import Login from "../Login/Login";
import {
    BrowserRouter,
    Routes,
    Route,
} from "react-router-dom";
import Header2 from "../Header/Header2";
import Prepods from "../Prepods/Prepods";
import Facults from "../Facults/Facults";
import Rasp from "../Rasp/Rasp";
import Help from "../Help/Help";
import Profile from "../Profile/Profile";
import {Context} from "../../App";

const Main = () => {
    const {isAuth, setIsAuth} = useContext(Context);

    return (
        <main className={styles.main}>
            <div className={styles.main__container}>
                <div className={styles.main__inner}>
                    <Routes>
                        <Route path="/" element={<News/>}/>
                        <Route path="/registration" element={<Registration/>}/>
                        <Route path="/login" element={<Login/>}/>
                        <Route path="/prepods" element={<Prepods/>}/>
                        <Route path="/facults" element={<Facults/>}/>
                        <Route path="/rasp" element={<Rasp/>}/>
                        <Route path="/help" element={<Help/>}/>
                        <Route path="/profile" element={<Profile/>}/>
                    </Routes>
                </div>
            </div>
        </main>
    )
};

export default Main;
