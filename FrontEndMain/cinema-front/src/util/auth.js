import { redirect } from "react-router-dom";

// for automatic Log Out after one hour
export function getTokenDuration() {
  const storedExpirationDate = localStorage.getItem("expiration");
  const expirationDate = new Date(storedExpirationDate);
  const currentDate = new Date();
  // get time gives us the time in milliseconds
  const remainingDuration = expirationDate.getTime() - currentDate.getTime();

  return remainingDuration;
}

// for authentication and authorisation
export function loader() {
  const role = localStorage.getItem("role");
  const jwt = localStorage.getItem("jwt");

  if (!jwt) {
    return null;
  }

  const tokenDuration = getTokenDuration();

  if (tokenDuration < 0) {
    return "EXPIRED";
  }

  const authObject = {
    role,
    jwt,
  };

  return authObject;
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
