import { useState, useEffect } from "react";
import Auth from "./Auth/auth";
import Dashboard from "./Dashboard/dashboard"
import { CheckAuth } from "../config"

const App = () => {
  const [fetch, setFetch] = useState(false)
  const [isAuth, setIsAuth] = useState(null)
  useEffect(() => {
    CheckAuth().then(e => {
      setFetch(true)
      if (e.error) return
      setIsAuth(e)
    })
  }, [])
  if (!fetch) {
    return <div></div>
  }
  if (!isAuth) {
    return <Auth setIsAuth={setIsAuth} />
  }
  return <Dashboard setIsAuth={setIsAuth} />
}

export default App;