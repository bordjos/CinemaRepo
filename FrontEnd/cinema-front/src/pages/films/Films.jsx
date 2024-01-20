import { useLoaderData, json } from "react-router-dom";

import FilmsList from "../../components/FilmsList";
import CinemaAxios from "../../apis/CinemaAxios";

export default function Films() {
  const data = useLoaderData(); //will store the return value of the loader function

  if (data.isError) {
    return <p>{data.message}</p>;
  }

  console.log(data);

  return <FilmsList films={data} />;
}

//TO DO: implement adding movies to the state in reverse order (shallow copy?)
//TO DO: implement search
export async function loader() {
  const response = await CinemaAxios.get("/films")
    .then((res) => {
      console.log(res.data);
      return res.data;
    })
    .catch((error) => {
      // return { isError: true, message: "Could not fetch films." };

      //OR
      // throw { message: "Could not fetch events." };

      //OR throw a Response to help differentiate between Error messages, we can catch it in the Component that renders an Error using useRouteError hook
      // throw new Response(
      //   JSON.stringify({ message: "Could not fetch events." }),
      //   { status: 500 }
      // );

      //OR (automatically converts it to json format)
      throw json({ message: "Could not fetch films." }, { status: 500 });
    });

  return response;
}
