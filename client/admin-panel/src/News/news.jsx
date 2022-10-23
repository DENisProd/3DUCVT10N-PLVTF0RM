import classes from "./news.module.scss"
import Table from 'react-bootstrap/Table';
import { GetNews, UpdateNew } from "../../config"
import { useState, useEffect, useRef } from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';

const NamesCode = {
    id: "ID",
    title: "Название",
    shortText: "Короткий текст",
    fullText: "Полный текст",
    tagList: "Теги",
    authorId: "ID автора",
    likesList: "Лайки",
    createdDate: "Дата создание",
    isModerated: "Доступность"

}

const ignoreArr = ["id", "authorId", "views", "createdDate", "likesList"]


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
                {e != "isModerated" ? <Form.Control onChange={ee => {
                    user_[e] = ee.target.value
                    setUser({ ...user_ })
                }} disabled={ignoreArr.includes(e)} type="text" value={user_[e] || ""} placeholder={`Введите ${NamesCode[e] || e}`} />
                    :
                    <Form.Check
                        type="switch"
                        label={"Опубликовать"}
                        onChange={() => {
                            user_[e] = !user_[e]
                            setUser({ ...user_ })
                        }}
                        checked={user_[e]}
                    />
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
                dataObj.news.splice(dataObj.news.findIndex(e => e.id == user.id), 1)
                dataObj.setNews([...dataObj.news])
                setEdit(null)
            }}>

                Удалить
            </Button>
            <Button variant="primary" onClick={() => {
                UpdateUser(user).then(r => {
                    if (r.error) {
                        return
                    }
                    dataObj.news[dataObj.news.findIndex(e => e.id == user.id)] = user_
                    dataObj.setNews([...dataObj.news])
                    setEdit(null)

                })

            }}>
                Сохранить
            </Button>
        </Modal.Footer>
    </Modal>
}


const News = () => {
    const [news, setNews] = useState([])
    const [search, setSearch] = useState("")
    const [edit, setEdit] = useState(null)
    useEffect(() => {
        GetNews().then(e => {

            if (e.error) return
            setNews(e)
        })
    }, [])
    useEffect(() => {

    }, [search])

    return <div className={`${classes.News} content`}>
        {edit && <ModalData dataObj={{
            setNews,
            news
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
                        <th>Название</th>
                        <th>Короткий текст</th>
                        <th>Теги</th>
                        <th>Автор ID</th>
                        <th>Создание новости</th>
                        <th>Просмотры</th>
                        <th>Функции</th>
                    </tr>
                </thead>
                <tbody>
                    {news.filter(e => JSON.stringify(e).toLocaleLowerCase().includes(search.toLocaleLowerCase())).map(({ id, authorId, title, createdDate, fullText, isModerated, shortText, tagList, views }) => <tr key={id}>
                        <td>{id}</td>
                        <td>{title}</td>
                        <td>{shortText}</td>

                        <td>{tagList.join(", ")}</td>
                        <td>{authorId}</td>
                        <td>{createdDate}</td>
                        <td>{views}</td>

                        <td onClick={() => {
                            setEdit(news.find(e => e.id == id))
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
export default News