import './App.css';
import Header from "./components/Header/Header";
import Main from "./components/Main/Main";
import {Route, Routes} from "react-router-dom";
import News from "./components/News/News";
import Registration from "./components/Registration/Registration";
import Login from "./components/Login/Login";
import React, {useEffect, useState} from "react";
import Header2 from "./components/Header/Header2";
import axios from "axios";

export const Context = React.createContext();

function App() {

    const [isLoading, setIsLoading] = useState(false);

    const URL_check = "https://hack.mysecrets.site/api/user/profile/";


    const [isAuth, setIsAuth] = useState(false);
    const [data, setData] = useState(null);
    const [token, setToken] = useState(null);



    useEffect(() => {
        setIsLoading(true);
        let config = {
            headers: {
                'Authorization': 'Bearer ' + localStorage.getItem('token')
            }
        }
        axios.get(URL_check, config).then(res => {
            setIsAuth(true);
            setData(res.data);
            // console.log(res.data)
            setIsLoading(false);
        }).catch(res => {
            if (res.response.status === "401") {
                localStorage.removeItem('token');
            }
            setIsLoading(false);
        });
    }, [isAuth]);

    return (
       <Context.Provider value={{isAuth, setIsAuth, data, setData, token, setToken}}>
           {isLoading ? <div className="loader">
               <h1>Загрузка...</h1>
           </div>: <div className="app">
               <Routes>
                   <Route path="/" element={<Header/>}/>
                   <Route path="/registration" element={<Header2/>}/>
                   <Route path="/login" element={<Header2/>}/>
                   <Route path="/prepods" element={<Header2/>}/>
                   <Route path="/facults" element={<Header2/>}/>
                   <Route path="/rasp" element={<Header2/>}/>
                   <Route path="/help" element={<Header2/>}/>
                   <Route path="/profile" element={<Header2/>}/>
               </Routes>
               <Main/>
           </div>}
       </Context.Provider>
    );
}

export default App;
