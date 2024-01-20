import { RouterProvider, createBrowserRouter } from "react-router-dom";

import Home from "./pages/Home";
import Films, { loader as filmsLoader } from "./pages/films/Films.jsx";
import FilmDetail, {
  loader as filmDetailLoader,
  action as deleteFilmAction,
} from "./pages/films/FilmDetail.jsx";
import NewFilm from "./pages/films/NewFilm.jsx";
import EditFilm from "./pages/films/EditFilm.jsx";
import PriceList from "./pages/PriceList.jsx";
import AboutUs from "./pages/AboutUs.jsx";
import Contact from "./pages/Contact.jsx";
import Root from "./pages/Root.jsx";
import Login from "./pages/Login.jsx";
import FilmsRoot from "./pages/films/FilmsRoot.jsx";
import ErrorPage from "./pages/Error.jsx";
import { action as manageFilmAction } from "./components/FilmForm.jsx";

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
            index: true, //same as path: ""
            element: <Films />,
            loader: filmsLoader,
          }, //loader - takes a function as a value, this function will be executed whenever we are about to visit this route and before the Component loads
          {
            path: ":id",
            id: "film-detail", //we add the id prop here so the loader will be available here and we need to use the useRouteLoaderData() hook instead
            loader: filmDetailLoader, //added nested routes so both pages can you the loader
            children: [
              {
                index: true,
                element: <FilmDetail />,
                action: deleteFilmAction,
              },
              { path: "edit", element: <EditFilm />, action: manageFilmAction },
            ],
          },
          { path: "new", element: <NewFilm />, action: manageFilmAction },
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
