import {
  Form,
  Link,
  useSearchParams,
  useActionData,
  useNavigation,
} from "react-router-dom";

import classes from "./AuthForm.module.css";

function AuthForm() {
  const data = useActionData();
  const navigation = useNavigation(); // navigation has a property that hold the current submission state
  const isSubmitting = navigation.state === "submitting";

  const [searchParams, setSearchParams] = useSearchParams(); //get hold of query params
  const isLogin = searchParams.get("mode") === "login";

  return (
    <>
      <Form method="post" className={classes.form}>
        <h1>{isLogin ? "Log in" : "Create a new user"}</h1>
        {data &&
          data.status &&
          (data.status === 400 ? (
            <p className={classes.error}>
              The credentials you provided are already in use, try providing a
              different username or e-mail
            </p>
          ) : (
            <p className={classes.error}>
              The username and password your provided are invalid!
            </p>
          ))}
        <p>
          <label htmlFor="username">Username</label>
          <input id="username" type="text" name="username" required />
        </p>
        <p>
          <label htmlFor="password">Password</label>
          <input id="password" type="password" name="password" required />
        </p>
        {!isLogin && (
          <>
            <p>
              <label htmlFor="repeatedPassword">Repeat Password</label>
              <input
                id="repeatedPassword"
                type="password"
                name="repeatedPassword"
                required
              />
            </p>
            <p>
              <label htmlFor="eMail">Email</label>
              <input id="eMail" type="email" name="eMail" required />
            </p>
            <p>
              <label htmlFor="firstName">First Name</label>
              <input id="firstName" type="text" name="firstName" required />
            </p>
            <p>
              <label htmlFor="lastName">Last Name</label>
              <input id="lastName" type="text" name="lastName" required />
            </p>
          </>
        )}
        <div className={classes.actions}>
          <Link to={`?mode=${isLogin ? "sign-up" : "login"}`}>
            {isLogin ? "Create new user" : "Login"}
          </Link>
          <button disabled={isSubmitting}>
            {isSubmitting ? "Submitting..." : "Save"}
          </button>
        </div>
      </Form>
    </>
  );
}

export default AuthForm;
