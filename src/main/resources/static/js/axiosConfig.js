import axios from 'axios';

const instance = axios.create({
    headers: {"Access-Control-Allow-Origin": "*"},
    headers: {'content-Type': 'application/json'},
    baseURL: 'http://localhost:8181/',
    responseType: "json"
})