const DUMMY_FILMS = [
  {
    id: 1,
    name: "Film 1",
    director: "Director 1",
    cast: "Mike Sam Eve",
    length: 120,
    distributor: "Distributor 1",
    country: "Country 1",
    year: "1998",
    about: "fsdf sdfasdfa sfasfasdfas asdf",
  },
  {
    id: 2,
    name: "Film 2",
    director: "Director 2",
    cast: "Mike Sam Eve",
    length: 120,
    distributor: "Distributor 2",
    country: "Country 2",
    year: "1998",
    about: "fsdf sdfasdfa sfasfasdfas asdf",
  },
  {
    id: 3,
    name: "Film 3",
    director: "Director 3",
    cast: "Mike Sam Eve",
    length: 120,
    distributor: "Distributor 3",
    country: "Country 3",
    year: "1998",
    about: "fsdf sdfasdfa sfasfasdfas asdf",
    posterUrl: "",
  },
];

export default function Films() {
  return (
    <>
      <h1>Films Page</h1>
      <ul>
        {DUMMY_FILMS.map(film => <li key={film.id}></li>)}
      </ul>
    </>
  );
}
