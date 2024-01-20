import { useState } from 'react';
import { useNavigate } from "react-router-dom";

import classes from '../components/FilmForm.module.css';
import { login } from '../services/auth';


export default function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();
  function cancelHandler() {
    navigate("..");
  }

  return (
    <form className={classes.form}>
      <p>
        <label htmlFor="username">Username</label>
        <input id="username" type="text" name="username" required onChange={e => setUsername(e.target.value)} />
      </p>
      <p>
        <label htmlFor="password">Password</label>
        <input id="password" type="password" name="password" required onChange={e => setPassword(e.target.value)} />
      </p>
      <div className={classes.actions}>
        <button type="button" onClick={cancelHandler}>
          Cancel
        </button>
        <button type='button' onClick={() => login(username, password)}>Log In</button>
      </div>
    </form>
  );
}
