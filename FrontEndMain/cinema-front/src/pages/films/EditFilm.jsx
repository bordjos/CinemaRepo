import { useRouteLoaderData } from "react-router-dom";
import FilmForm from "../../components/FilmForm";

export default function EditFilm() {
  const film = useRouteLoaderData("film-detail");

  return <FilmForm film={film} method="put" />;
}
