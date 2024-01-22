import { Outlet, useLoaderData, useSubmit } from "react-router-dom";
import MainNavigation from "../components/MainNavigation";
import { useEffect } from "react";
import { getTokenDuration } from "../util/auth";
import Footer from "../components/Footer";

export default function Root() {
  // const navigation = useNavigation();

  useLoaderData();
  const data = useLoaderData();
  const submit = useSubmit(); //used so we can programatically submit a form (the Log Out Form in this case)

  useEffect(() => {
    // if (!data.jwt) {
    //   return;
    // }

    if (!data) {
      return;
    }

    if (data === "EXPIRED") {
      submit(null, { action: "/logout", method: "POST" });
      return;
    }

    const tokenDuration = getTokenDuration();
    console.log("tokenDuration: " + tokenDuration);

    setTimeout(() => {
      submit(null, { action: "/logout", method: "POST" }); //the first argument is the data, we don't need to send any in this case
    }, tokenDuration); //automatically log out after 1 hour
  }, [data, submit]);

  return (
    <>
      <MainNavigation />
      <main>
        {/* idle, loading or submitting */}
        {/* {navigation.state === "loading" && <p>Loading...</p>} */}
        {/* defines where the contect of the child routes in rendered */}
        <Outlet />
      </main>
      <Footer />
    </>
  );
}
