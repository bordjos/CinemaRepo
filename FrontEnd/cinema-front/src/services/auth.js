import CinemaAxios from "../apis/CinemaAxios";
import { jwtDecode } from "jwt-decode";

export const login = async (username, password) => {
  const body = {
    username: username,
    password: password,
  };

  try {
    const response = await CinemaAxios.post("/users/auth", body);
    console.log(response);
    console.log("Not decoded: " + response.data);

    window.localStorage.setItem("jwt", response.data);

    const decoded = jwtDecode(response.data);
    console.log("Decoded:" + decoded);

    window.localStorage.setItem("role", decoded.role.authority);
    window.location.replace("http://localhost:5173");
  } catch (e) {
    alert("Login FAILED");
    window.location.replace("http://localhost:5173");
  }
};

export const logout = () => {
  window.localStorage.removeItem("jwt");
  window.localStorage.removeItem("role");
  window.location.replace("http://localhost:5173");
};
