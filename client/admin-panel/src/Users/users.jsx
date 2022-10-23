import Table from 'react-bootstrap/Table';
import classes from "./users.module.scss"
import { GetUsers, UpdateUser } from "../../config"
import { useState, useEffect, useRef } from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';

const NamesCode = {
    username: "Имя пользователя",
    id: "ID",
    firstName: "Имя",
    lastName: "Фамилия",
    patronomic: "Отчество",
    email: "E-mail",
    password: "Пароль",
    balance: "Баланс",
    createdAt: "Дата регистрации",
    roles: "Роли"
}

const ignoreArr = ["id", "password", "balance", "createdAt"]
const roles = {
    ROLE_USER: "Пользователь", ROLE_MODERATOR: "Модератор", ROLE_ADMIN: "Администратор", ROLE_DEAN: 'Декан', ROLE_CATHEDRA_MAN: "Зав. кафедрой", ROLE_TEACHER: 'Преподаватель', ROLE_EMPLOYEE: 'Сотрудник', ROLE_STUDENT: "Студент", ROLE_UCHEB_OTDEL: "Учебный отдел"
}



const ModalData = ({ dataObj, user, setEdit }) => {
    const [user_, setUser] = useState(user)
    console.log(user_)
    return <Modal show={true} onHide={() => {
        setEdit(null)

    }}>
        <Modal.Header closeButton>
            <Modal.Title>Редактирование</Modal.Title>
        </Modal.Header>
        <Modal.Body>

            {Object.keys(user).map((e, i) => <Form.Group key={i} className="mb-3" controlId="formBasicEmail">
                <Form.Label>{NamesCode[e] || e}</Form.Label>
                {e != "roles" ? <Form.Control onChange={ee => {
                    user_[e] = ee.target.value
                    setUser({ ...user_ })
                }} disabled={ignoreArr.includes(e)} type="text" value={user_[e] || ""} placeholder={`Введите ${NamesCode[e] || e}`} />
                    :
                    Object.keys(roles).map(r => <Form.Check
                        key={r}
                        type="switch"
                        label={roles[r]}
                        onChange={() => {
                            if (user_[e].map(ee => ee.name).includes(r)) {
                                user_[e].splice(user_[e].findIndex(ee => ee.name == r), 1)

                            } else {
                                user_[e].push({ name: r })

                            }
                            setUser({ ...user_ })
                        }}
                        checked={user_[e].map(ee => ee.name).includes(r)}
                    />)
                }

            </Form.Group>)}

        </Modal.Body>
        <Modal.Footer>
            <Button variant="secondary" onClick={() => {
                setEdit(null)

            }}>
                Закрыть
            </Button>
            <Button variant="danger" onClick={() => {
                dataObj.users.splice(dataObj.users.findIndex(e => e.id == user.id), 1)
                dataObj.setUsers([...dataObj.users])
                setEdit(null)
            }}>

                Удалить
            </Button>
            <Button variant="primary" onClick={() => {
                UpdateUser(user).then(r => {
                    if (r.error) {
                        return
                    }
                    dataObj.users[dataObj.users.findIndex(e => e.id == user.id)] = user_
                    dataObj.setUsers([...dataObj.users])
                    setEdit(null)

                })

            }}>
                Сохранить
            </Button>
        </Modal.Footer>
    </Modal>
}

const Users = () => {
    const [users, setUsers] = useState([])
    const [search, setSearch] = useState("")
    const [edit, setEdit] = useState(null)
    useEffect(() => {
        GetUsers().then(e => {

            if (e.error) return
            setUsers(e)
        })
    }, [])
    useEffect(() => {

    }, [search])
    console.log(edit)

    return <div className={`${classes.Users} content`}>
        {edit && <ModalData dataObj={{
            setUsers,
            users
        }} user={edit} setEdit={setEdit} />}
        <h2>Пользователи</h2>
        <div style={{
            display: "flex",
            marginBottom: 20
        }}>
            <Form.Control
                onChange={(e) => setSearch(e.target.value)}
                type="search"
                placeholder="Поиск"
                className="me-2"
                value={search}
                aria-label="Search"
            />
        </div>
        <div className={classes.Table}>

            <Table striped bordered hover >
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Имя пользователя</th>
                        <th>ФИО</th>
                        <th>E-mail</th>
                        <th>Создание аккаунта</th>
                        <th>Роли</th>
                        <th>Функции</th>
                    </tr>
                </thead>
                <tbody>
                    {users.filter(e => JSON.stringify(e).toLocaleLowerCase().includes(search.toLocaleLowerCase())).map(({ id, email, createdAt, lastName, firstName, username, patronomic, roles }) => <tr key={id}>
                        <td>{id}</td>
                        <td>{username}</td>
                        <td>{lastName} {firstName} {patronomic}</td>
                        <td>{email}</td>
                        <td>{createdAt ? new Date(createdAt).toLocaleDateString() : ""} {createdAt ? new Date(createdAt).toLocaleTimeString() : ""}</td>
                        <td>{roles.map(e => e.name).join(", ")}</td>
                        <td onClick={() => {
                            setEdit(users.find(e => e.id == id))
                        }} style={{
                            color: "rgb(13,110,253)",
                            fontSize: 12,
                            cursor: "pointer"
                        }}>Редактировать</td>
                    </tr>)}


                </tbody>
            </Table>
        </div>

    </div>
}
export default Users