import * as Yup from 'yup';

export const loginSchema = Yup.object().shape({
  username: Yup.string().required('Username is required'),
  password: Yup.string().required('Password is required'),
});

export const registerSchema = Yup.object().shape({
  username: Yup.string().required('Username is required'),
  password: Yup.string()
    .min(8, 'Min length: 8 characters')
    .max(24, 'Max length: 24 characters')
    .required('Password is required'),
});
