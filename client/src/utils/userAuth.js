import axios from 'axios';
import { BASEURL } from '../constants';
import axiosWithAuth from './axiosWithAuth';

const baseAxios = () => {
  return axios.create({
    baseURL: BASEURL,
  });
};

export const register = (username, password) => {
  return baseAxios()
    .post('/register', { username, password })
    .then((res) => {
      if (res.data.access_token) {
        localStorage.setItem('token', res.data.access_token);
      }
    })
    .catch((err) => {
      console.log(`Register failed ==>> ${err.message}`);
    });
};

export const login = (username, password) => {
  return baseAxios()
    .post('/login', { username, password })
    .then((res) => {
      if (res.data.access_token) {
        localStorage.setItem('token', res.data.access_token);
      }
    })
    .catch((err) => {
      console.log(`Login failed ==>> ${err.message}`);
    });
};

export const logout = () => {
  localStorage.removeItem('token');
};
