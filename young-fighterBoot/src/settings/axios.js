import axios from 'axios'

axios.defaults.headers['content-type'] = 'application/json';
axios.defaults.withCredentials = true;

const NODE_ENV = process.env.NODE_ENV ? process.env.NODE_ENV : 'development';

switch (NODE_ENV) {
    case 'development':
        axios.defaults.baseURL =  'http://localhost:9000/';
        break;
    default:
        axios.defaults.baseURL =  'http://localhost:9000/';
}