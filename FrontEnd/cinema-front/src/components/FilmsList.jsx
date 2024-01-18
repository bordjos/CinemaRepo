import classes from "./FilmsList.module.css";

function FilmsList({ films }) {
  return (
    <div className={classes.films}>
      <h1>All Films</h1>
      <ul className={classes.list}>
        {films.map((film) => (
          <li key={film.id} className={classes.item}>
            <a href="...">
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
                <ul>
                  {Object.values(film.projectionsDTO).map((projection) => (
                    <button>{projection.dateTime}</button>
                  ))}
                </ul>
              </div>
            </a>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default FilmsList;
