import { RouterProvider, createBrowserRouter } from "react-router-dom";

import Home from "./pages/Home";
import Films, { loader as filmsLoader } from "./pages/films/Films.jsx";
import FilmDetail from "./pages/films/FilmDetail.jsx";
import NewFilm from "./pages/films/NewFilm.jsx";
import EditFilm from "./pages/films/EditFilm.jsx";
import PriceList from "./pages/PriceList.jsx";
import AboutUs from "./pages/AboutUs.jsx";
import Contact from "./pages/Contact.jsx";
import Root from "./pages/Root.jsx";
import Login from "./pages/Login.jsx";
import FilmsRoot from "./pages/films/FilmsRoot.jsx";
import ErrorPage from "./pages/Error.jsx";

// the paths are set as relative
const router = createBrowserRouter([
  {
    path: "/",
    element: <Root />,
    errorElement: <ErrorPage />, //will be triggered if there was an error generated in any route related code (including loaders)
    children: [
      { index: true, element: <Home /> },
      {
        path: "films",
        element: <FilmsRoot />,
        children: [
          {
            index: true,
            element: <Films />,
            loader: filmsLoader,
          }, //loader - takes a function as a value, this function will be executed whenever we are about to visit this route and before the Component loads
          { path: ":id", element: <FilmDetail /> },
          { path: "new", element: <NewFilm /> },
          { path: ":id/edit", element: <EditFilm /> },
        ],
      },
      { path: "price-list", element: <PriceList /> },
      { path: "about-us", element: <AboutUs /> },
      { path: "contact", element: <Contact /> },
      { path: "login", element: <Login /> },
    ],
  },
]);

function App() {
  return <RouterProvider router={router}></RouterProvider>;
}

export default App;
