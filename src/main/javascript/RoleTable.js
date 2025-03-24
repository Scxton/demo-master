//根据用户ID查询单行信息，29为用户ID值
// const baseUrl = 'http://127.0.0.1:8000/roleTable/2';
// fetch(baseUrl)
//     .then(response => response.json())
//     .then(data => {
//         console.log(data);
//     })
//     .catch(error => {
//         console.error(error);
//     });

const baseUrl = 'http://127.0.0.1:8000/login';
fetch(baseUrl, {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({ username: 'ADMIN_1', password: 'ADMIN_1'})
})
    .then(response => {
        const token = response.headers.get('token');
        console.log('Token:', token);
        return response.json();
    })
    .then(data => {
        console.log('Response Data:', data);
    })
    .catch(error => {
        console.error('Error:', error);
    });