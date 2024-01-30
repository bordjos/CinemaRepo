import { redirect } from "react-router-dom";

export function action() {
  localStorage.removeItem("jwt");
  localStorage.removeItem("role");
  localStorage.removeItem("expiration");
  return redirect("/");
}
