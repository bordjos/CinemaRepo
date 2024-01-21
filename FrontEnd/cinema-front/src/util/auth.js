import { redirect } from "react-router-dom";

export function loader() {
  const role = localStorage.getItem("role");
  const jwt = localStorage.getItem("jwt");

  const authObject = {
    role,
    jwt,
  };

  return authObject;

  // return localStorage.getItem("jwt");
}

// added for route protection
export function checkAuthLoader() {
  const authObject = loader();

  console.log("AUTH ROLE: " + authObject.role);

  if (!authObject.jwt) {
    return redirect("/auth");
  } else if (authObject.role !== "ADMIN") {
    return redirect("/");
  }

  return null;
}
