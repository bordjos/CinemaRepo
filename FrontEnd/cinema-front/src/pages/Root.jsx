import { Outlet, useNavigation } from "react-router-dom";
import MainNavigation from "../components/MainNavigation";

export default function Root() {
  // const navigation = useNavigation();

  return (
    <>
      <MainNavigation />
      <main>
        {/* idle, loading or submitting */}
        {/* {navigation.state === "loading" && <p>Loading...</p>} */}
        {/* defines where the contect of the child routes in rendered */}
        <Outlet />
      </main>
    </>
  );
}
