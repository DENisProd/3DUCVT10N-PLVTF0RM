import classes from "./dashboard.module.scss"
import Nav from "../Nav/nav"
import { useState, lazy, Suspense } from "react"

const Default = lazy(() => import("../Default/default"))
const Users = lazy(() => import("../Users/users"))
const News = lazy(() => import("../News/news"))

const Dashboard = ({ setIsAuth }) => {
    const [page, setPage] = useState(null)
    return <div className={classes.Dashboard}>
        <Nav setPage={setPage} setIsAuth={setIsAuth} />
        {!page && <Suspense fallback=""><Default /></Suspense>}
        {page == "users" && <Suspense fallback=""><Users /></Suspense>}
        {page == "news" && <Suspense fallback=""><News /></Suspense>}
    </div>
}

export default Dashboard