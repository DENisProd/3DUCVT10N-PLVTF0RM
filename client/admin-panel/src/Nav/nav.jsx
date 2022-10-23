import classes from "./nav.module.scss"
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
const Nav_ = ({setPage,setIsAuth}) => {
    return <div className={classes.Nav}>
        <Navbar bg="primary" variant="dark">
            <Container>
                <Navbar.Brand onClick={() => {setPage(null) }}>Админ панель</Navbar.Brand>
                <Nav className="me-auto">
                    <Nav.Link onClick={() => {setPage("news") }}>Новости</Nav.Link>
                    <Nav.Link onClick={() => { setPage("users")}}>Пользователи</Nav.Link>
                </Nav>
                <Nav >
                    <Nav.Link onClick={() => { setIsAuth(false); localStorage.removeItem("token") }}>Выход</Nav.Link>
                </Nav>
            </Container>
        </Navbar>
    </div>
}
export default Nav_;