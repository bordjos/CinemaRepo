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

  return (
    <>
      <article className={classes.film}>
        <img src={film.posterUrl} alt={film.name} />
        <h1>{film.name}</h1>
        {/* <time>{film.date}</time> */}
        <p>{film.about}</p>
        <div>Ok</div>
        {authObject && authObject.role === "ADMIN" && (
          <menu className={classes.actions}>
            <Link to="edit">Edit</Link>
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
