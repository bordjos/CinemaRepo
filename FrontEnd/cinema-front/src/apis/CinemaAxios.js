import axios from 'axios';

var CinemaAxios = axios.create({
  baseURL: 'http://localhost:8080/api',
  /* other custom settings */
});

CinemaAxios.interceptors.request.use(
  function add_jwt(config) {
    if (window.localStorage.getItem('jwt')) {
      config.headers.Authorization = 'Bearer ' + 
        window.localStorage.getItem('jwt')  
    }
    return config
  }
)

export default CinemaAxios;