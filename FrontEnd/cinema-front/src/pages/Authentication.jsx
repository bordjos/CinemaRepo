import { json, redirect } from "react-router-dom";

import AuthForm from "../components/AuthForm";
import CinemaAxios from "../apis/CinemaAxios";
import { jwtDecode } from "jwt-decode";

export default function Authentication() {
  return <AuthForm />;
}

export async function action({ request }) {
  const searchParams = new URL(request.url).searchParams; // URL Object is provided by the browser
  const mode = searchParams.get("mode") || "login"; // set login if searchParams is undefined

  // protect the use from manually setting the mode through the URL
  if (mode !== "login" && mode !== "sign-up") {
    throw json({ message: "Unsupported mode." }, { status: 422 });
  }
  const data = await request.formData();

  let authData;
  let url = "/users";

  if (mode === "login") {
    authData = {
      username: data.get("username"),
      password: data.get("password"),
    };
    url += "/auth";
  } else {
    authData = {
      username: data.get("username"),
      eMail: data.get("eMail"),
      password: data.get("password"),
      repeatedPassword: data.get("repeatedPassword"),
      firstName: data.get("firstName"),
      lastName: data.get("lastName"),
    };
  }

  console.log(authData);
  console.log(mode);
  console.log(url);

  try {
    const response = await CinemaAxios.post(url, authData);
    console.log("RESPONSE: " + response);
    console.log("NOT DECODED: " + response.data);

    window.localStorage.setItem("jwt", response.data);

    const decoded = jwtDecode(response.data);
    console.log("DECODED:" + decoded);

    window.localStorage.setItem("role", decoded.role.authority);
    // window.location.replace("http://localhost:5173");
    //this throws an error?
    return redirect("/");
  } catch (e) {
    console.log("ERROR: " + e.response.status);

    mode === "login" ? alert("Login FAILED") : alert("Registration FAILED");

    // window.location.replace("http://localhost:5173");

    if (e.response.status === 400 || e.response.status === 403) {
      return e.response;
    }
  }

  // return null; //must return null so the Error Component doesn't get triggered

  //when using redirect the jwt state change is not picked up (implement ContextProvider maybe?)
  return redirect("/");
}
