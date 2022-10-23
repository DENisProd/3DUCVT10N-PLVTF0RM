const url = "https://hack.mysecrets.site/api/"

const methodReq = (path, method = "POST", body = null) => fetch(url + path, {
    method,
    body: body ? JSON.stringify(body) : null,
    headers: {
        'Content-Type': 'application/json;charset=utf-8',
        'Authorization': 'Bearer ' + localStorage.getItem("token") || ""
    },
}).then(e => e.json()).catch(e => {
    return {
        error: true
    }
})

export const AuthAdmin = (username, password) => methodReq("auth/signin", "POST", { username, password })
export const CheckAuth = () => methodReq("user/profile/", "GET")
export const GetUsers = () => methodReq("admin/users/", "GET")
export const UpdateUser = (user) => methodReq("admin/user/", "POST", user)
export const GetNews = () => methodReq("event/", "GET")
export const UpdateNew = (event) => methodReq("admin/event/", "POST", event)