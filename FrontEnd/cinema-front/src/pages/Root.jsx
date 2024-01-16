import { Outlet } from "react-router-dom";
import MainNavigation from "../components/MainNavigation";

export default function Root() {
  return (
    <>
      <MainNavigation />
      <main>
        {/* defines where the contect of the child routes in rendered */}
        <Outlet />
      </main>
    </>
  );
}
