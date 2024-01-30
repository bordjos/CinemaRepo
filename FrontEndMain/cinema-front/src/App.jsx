import { RouterProvider, createBrowserRouter } from "react-router-dom";
import { QueryClientProvider } from "@tanstack/react-query";

import Home from "./pages/Home";
import FilmDetail from "./pages/films/FilmDetail.jsx";
import PriceList from "./pages/PriceList.jsx";
import AboutUs from "./pages/AboutUs.jsx";
import Contact from "./pages/Contact.jsx";
import Root from "./pages/Root.jsx";
import Authentication, {
  action as authAction,
} from "./pages/Authentication.jsx";
import { action as logoutAction } from "./util/logout.js";
// import { checkAuthLoader, loader as tokenLoader } from "./util/auth.js";
import { queryClient } from "./util/http.js";
import {loader as tokenLoader} from "./util/auth.js"
import Films from "./pages/films/Films.jsx";

// the paths are set as relative
const router = createBrowserRouter([
  {
    path: "/",
    element: <Root />,
    // errorElement: <ErrorPage />, //will be triggered if there was an error generated in any route related code (including loaders)
    id: "root",
    loader: tokenLoader, // added so the UI updates after we Log In or Create an Account
    children: [
      { index: true, element: <Home /> },
      {
        path: "/films",
        element: <Films />,
        children: [
          {
            path: "/films/:id",
            element: <FilmDetail />,
            // loader: filmDetailLoader, //added nested routes so both pages can use the loader
            children: [
              // {
              //   index: true, //same as path: ""
              //   element: <FilmDetail />,
              //   action: deleteFilmAction,
              // },
              // {
              //   path: "edit",
              //   element: <EditFilm />,
              //   action: manageFilmAction,
              //   loader: checkAuthLoader,
              // },
              // {
              //   path: ":projectionId",
              //   element: <ProjectionDetail />,
              //   loader: projectionDetailLoader,
              // },
              // {
              //   path: "new-projection",
              //   element: <NewProjection />,
              // },
            ],
          },
          // {
          //   path: "new",
          //   element: <NewFilm />,
          //   action: manageFilmAction,
          //   loader: checkAuthLoader,
          // },
        ],
      },
      { path: "price-list", element: <PriceList /> },
      { path: "about-us", element: <AboutUs /> },
      { path: "contact", element: <Contact /> },
      { path: "auth", element: <Authentication />, action: authAction },
      { path: "logout", action: logoutAction },
    ],
  },
]);

function App() {
  return (
    <QueryClientProvider client={queryClient}>
      <RouterProvider router={router}></RouterProvider>
    </QueryClientProvider>
  );
}

export default App;
