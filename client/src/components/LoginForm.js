import React, { useState } from 'react';
import { login } from '../utils/userAuth';

const initialFormVals = {
  username: '',
  password: '',
};

export default function LoginForm() {
  const [getFormVals, setFormVals] = useState(initialFormVals);

  const handleSubmit = (e) => {
    login(getFormVals.username, getFormVals.password);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormVals({ ...getFormVals, [name]: value });
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <label htmlFor="username">Username: </label>
        <input
          type="text"
          name="username"
          onChange={handleChange}
          value={getFormVals.username}
        />
        <label htmlFor="password">Password: </label>
        <input
          type="password"
          name="password"
          onChange={handleChange}
          value={getFormVals.password}
        />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}
