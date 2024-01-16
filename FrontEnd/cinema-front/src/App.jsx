import { RouterProvider, createBrowserRouter } from "react-router-dom";

import Home from "./pages/Home";
import Films from "./pages/films/Films.jsx";
import FilmDetails from "./pages/films/FilmDetails.jsx";
import NewFilm from "./pages/films/NewFilm.jsx";
import EditFilm from "./pages/films/EditFilm.jsx";
import PriceList from "./pages/PriceList.jsx";
import AboutUs from "./pages/AboutUs.jsx";
import Contact from "./pages/Contact.jsx";
import Root from "./pages/Root.jsx";

// the paths are set as relative
const router = createBrowserRouter([
  {
    path: "/",
    element: <Root />,
    children: [
      { index: true, element: <Home /> },
      { path: "films", element: <Films /> },
      { path: "films/:id", element: <FilmDetails /> },
      { path: "films/new", element: <NewFilm /> },
      { path: "films/:id/edit", element: <EditFilm /> },
      { path: "price-list", element: <PriceList /> },
      { path: "about-us", element: <AboutUs /> },
      { path: "contact", element: <Contact /> },
    ],
  },
]);

function App() {
  return <RouterProvider router={router}></RouterProvider>;
}

export default App;
