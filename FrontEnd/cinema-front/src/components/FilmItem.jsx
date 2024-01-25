import { Link, NavLink, useRouteLoaderData, useSubmit } from "react-router-dom";
import classes from "./FilmItem.module.css";

export default function FilmItem({ film }) {
  const submit = useSubmit();
  // const {jwt, role} = useRouteLoaderData("root");
  const authObject = useRouteLoaderData("root");

  function startDeleteHandler() {
    const proceed = window.confirm("Are you sure?"); //returns a boolean value

    if (proceed) {
      submit(null, { method: "DELETE" }); //first argument is the data, we don't need it in this case //method //action(if it is defined on a different path)
    }
  }

  const isAdmin = () => {
    return authObject && authObject.role === "ADMIN";
  }

  return (
    <>
      <article className={classes.film}>
        <img src={film.posterUrl} alt={film.name} />
        <h1>{film.name}</h1>
        {/* <time>{film.date}</time> */}
        <p>{film.about}</p>
        {isAdmin() && (
          <menu className={classes.actions}>
            <Link to="edit">Edit</Link>
            <Link to="new-projection">Add a projection</Link>
            <button onClick={startDeleteHandler}>Delete</button>
          </menu>
        )}
      </article>
      <div className={classes.containerDiv}>
        <div className={classes.infoDiv}>
          <p>Director: {film.director}</p>
          <p>Cast: {film.cast}</p>
          <p>
            Genre:{" "}
            {Object.values(film.genres).map((genre, index, array) => (
              <span key={index}>
                {genre}
                {index < array.length - 1 && ", "}
              </span>
            ))}
          </p>
          <p>Length: {film.length} min</p>
          <p>Country of origin: {film.country}</p>
          <p>Release year: {film.year}</p>
        </div>
        <div className={classes.projectionsDiv}>
          <p>Projections: </p>
          <ul>
            {Object.values(film.projectionsDTO).map((projection) => (
              <NavLink
                to={`${projection.id}`}
                className={classes.projectionButton}
                key={projection.id}
                disabled
              >
                {projection.dateTime.replace("T", " ")}
              </NavLink>
            ))}
          </ul>
        </div>
      </div>
    </>
  );
}
