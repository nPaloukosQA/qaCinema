export default axios.create({
    headers: {"Access-Control-Allow-Origin": "*", 'content-Type': 'application/json'},
    baseURL: "http://localhost:8181/",
    responseType: "json"
});