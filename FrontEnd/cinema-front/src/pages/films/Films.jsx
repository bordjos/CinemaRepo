import { useLoaderData } from "react-router-dom";

import FilmsList from "../../components/FilmsList";
import CinemaAxios from "../../apis/CinemaAxios";

export default function Films() {
  // const getFilms = useCallback(() => {
  //   setIsLoading(true);

  //   setIsLoading(false);
  // }, []);

  // useEffect(() => {
  //   getFilms();
  // }, []);

  const films = useLoaderData(); //will store the return value of the loader function

  console.log(films);

  return <FilmsList films={films} />;

  // return (
  //   <>
  //     <div style={{ textAlign: "center" }}>
  //       {isLoading && <p>Loading...</p>}
  //       {error && <p>{error}</p>}
  //     </div>
  //     {!isLoading && films && <FilmsList films={films} />}
  //   </>
  // );
}

export async function loader() {
  const response = await CinemaAxios.get("/films")
    .then((res) => {
      console.log(res.data);
      return res.data;
    })
    .catch((error) => {
      //...
      return null;
    });

  return response;
}
