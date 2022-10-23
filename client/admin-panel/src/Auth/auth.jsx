import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import classes from "./auth.module.scss"
import { useRef, useState } from 'react';
import { AuthAdmin } from '../../config';

const Auth = ({ setIsAuth }) => {
    const [load, setLoad] = useState(false)
    const [error, setError] = useState("")
    const login = useRef()
    const password = useRef()
    return <div className={classes.Auth}>
        <Form onSubmit={(ev) => {
            setError("")
            setLoad(true)
            ev.preventDefault()
            AuthAdmin(login.current.value, password.current.value).then(e => {
                setLoad(false)
                if (e.error) {
                    setError("Неверный логин или пароль")
                    return
                }
                localStorage.setItem("token", e.token)
                setIsAuth(e)
            })
            return false
        }}>
            <h3>Авторизация</h3>
            <Form.Group className="mb-3" controlId="formBasicEmail">
                <Form.Label>Логин</Form.Label>
                <Form.Control ref={login} type="text" placeholder="Введите логин" />
            </Form.Group>
            <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>Пароль</Form.Label>
                <Form.Control ref={password} type="password" placeholder="Введите пароль" />
            </Form.Group>
            <div style={{
                display:'flex',
                alignItems:'center',
                justifyContent: "space-between"
            }}>
                <Button disabled={load} variant="primary" type="submit">
                    Войти
                </Button>
                <p style={{
                    color: "red",
                    fontSize: 12
                }}>{error}</p>
            </div>

        </Form>
    </div>
}
export default Auth