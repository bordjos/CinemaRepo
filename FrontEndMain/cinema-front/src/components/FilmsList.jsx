import { Link, NavLink } from "react-router-dom";
import classes from "./FilmsList.module.css";

function FilmsList({ films }) {
  return (
    <div className={classes.films}>
      <h1>Now Showing</h1>
      <ul className={classes.list}>
        {films.map((film) => (
          <li key={film.id} className={classes.item}>
            {/* TO DO: check why it doesn't work without the backtick symbol */}
            <Link to={`${film.id}`}>
              <img src={film.posterUrl} alt={film.name} />
              <div className={classes.content}>
                <h2>{film.name}</h2>
                <p>{film.director}</p>
                <p>{film.cast}</p>
                <p>{film.genre}</p>
                <p>{film.distributor}</p>
                <p>{film.country}</p>
                <p>{film.year}</p>
              </div>
              <div className={classes.projections}>
                <h4>Choose the time and make a reservation</h4>
                <ul>
                  {Object.values(film.projectionsDTO).map((projection) => (
                    <button
                      className={classes.projectionButton}
                      key={projection.id}
                      disabled
                    >
                      {projection.dateTime.replace("T", " ")}
                    </button>
                  ))}
                </ul>
              </div>
            </Link>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default FilmsList;
