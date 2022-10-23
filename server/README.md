https://hack.mysecrets.site/api/

POST Регистрация 
http://localhost:9000/api/auth/signup
{
	"email": "student1@gmail.com",
	"username":"student1",
	"lastName":"Иванов",
	"firstName":"Иван",
	"patronomic":"Иванович",
	"password":"zavc",
	"role": ["user"]
}

POST Авторизация
http://localhost:9000/api/auth/signin
{
	"username":"admin",
	"password":"admin"
}

POST создание события
http://localhost:9000/api/event/
{
	"title":"Хакатон 2019",
	"shortText":"eiciencieicei cuecueicuecne ceuneucneucneuc ecuneucneucneuc ",
	"fullText":"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuri Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. ",
	"tagList": ["studsovet", "it", "хакатон"]
}

Получение всех событий
GET http://localhost:9000/api/event/

Получить одно по id
GET http://localhost:9000/api/event/14

Получить топ 10 для правого блока
GET http://localhost:9000/api/event/top/

------ADMIN--------
Создание факультета
POST http://localhost:9000/api/admin/faculty/
{
	"name":"Энергетика и Нефтегазопромышленность",
	"shortName":"ЭиНГП",
	"description":"самый замечательный факульт ет мира азмащмащмаьмщаьмашмаьль rgfrtgrgr grtg rtg tr grtgrма",
	"location":"10-223, пл.Страны Советов 1, корпус 1, этаж 3",
	"contacts":"88005553535 fac1@mysecrets.site",
	"deanId": 20
}

Создать кафедру
POST http://localhost:9000/api/admin/cathedra/
{
	"name": "Вычислительные системы и информационная безопасность",
	"shortName":"ВСиИБ",
	"description":"mcimeiocc wciwcwmciwmc wciwmcwc wc wiciwciwmciwmciwcwicm wcwcmiwcmw icwim imcw",
	"teachers":[],
	"zavCathedra": 23,
	"faculty":19
}

Создать специальность
POST http://localhost:9000/api/admin/speciality/
{
	"name":"Информационная безопасность телекоммуникационных систем",
	"academGroup":"ВИБТ",
	"description": "iojodfiviodfmviodvddfdfvdfvdfvdfvl,dfp,vdf,vpodpodfmdf dfmvdfiovm dfovdfi viodfv dvdfvndvi dfivndfvdf",
	"cathedraId": 26
}

Создать группу
POST http://localhost:9000/api/study_department/group/
{
	"name": "ВИБ31",
	"cathedra": 26,
	"kurs": 3
}

Создать студента
POST http://localhost:9000/api/admin/student/
{
	"userId": 31,
	"recordNumber": 2022027,
	"academicGroup": 32
}

Создать учителя
POST http://localhost:9000/api/admin/teacher/
{
	"userId": 36,
	"education": "МГТУ им.Баумана",
	"degree": "кандидат технических наук"
}

Получить всех пользователей для админ-панели
GET http://localhost:9000/api/admin/users/

Получить все факультеты
GET http://localhost:9000/api/dean/faculty/

Получить кафедры по id факультета
GET http://localhost:9000/api/dean/cathedra/19

Получить специальности по id кафедры
GET http://localhost:9000/api/dean/speciality/26


Получить профиль пользователя
GET http://localhost:9000/api/user/profile/


Изменить модерацию новости
POST http://localhost:9000/api/admin/event/11
{
	"state": 0
}
Включить –
{
	"state": 1
}


Изменение пользователя
POST http://localhost:9000/api/admin/user/
{
		"id": 3,
		"firstName": "Userov",
		"lastName": "User",
		"patronomic": "Userovich",
		"email": "user@gmail.com",
		"balance": 0,
		"roles": ["ROLE_USER","ROLE_MODERATOR"]
	}
	
	
	Создать вопрос
POST http://localhost:9000/api/user/question/
{
"question":"enjciuecneicinecinencencecnececdencjecndjcdnjdnc"
}

Получить все вопросы
GET http://localhost:9000/api/admin/questions/

