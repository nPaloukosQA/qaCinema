export default axios.create({
    headers: { 'content-Type': 'application/json'},
    baseURL: "http://www.omdbapi.com/",
    responseType: "json"
});