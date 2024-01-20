import { Link, useSubmit } from "react-router-dom";
import classes from "./FilmItem.module.css";

export default function FilmItem({ film }) {
  const submit = useSubmit();

  function startDeleteHandler() {
    const proceed = window.confirm("Are you sure?"); //return a boolean value

    if (proceed) {
      submit(null, { method: "DELETE" }); //first argument is the data, we don't need it in this case //method //action(if it is defined on a different path)
    }
  }

  return (
    <article className={classes.film}>
      <img src={film.posterUrl} alt={film.name} />
      <h1>{film.name}</h1>
      {/* <time>{film.date}</time> */}
      <p>{film.about}</p>
      <menu className={classes.actions}>
        <Link to="edit">Edit</Link>
        <button onClick={startDeleteHandler}>Delete</button>
      </menu>
    </article>
  );
}