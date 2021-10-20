const requestURL = 'http://localhost:8080/draft/gamer'


function sendRequest(method, url){
return new Promise((resolve, reject) => {

    const xhr = new XMLHttpRequest()

xhr.open(method, url)

xhr.responseType = 'json'

xhr.onload = () =>{
    if(xhr.status >= 400){
        console.error(xhr.response)
    }else{
        console.log(xhr.response)
    }
}
xhr.onerror = () => {
    reject(xhr.response)
}
xhr.send()
})
}
sendRequest('Get', requestURL)
.then(data => console.log(data))
.catch(err => console.log(err))