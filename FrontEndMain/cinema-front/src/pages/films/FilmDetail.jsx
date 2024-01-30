import { json, redirect, useRouteLoaderData } from "react-router-dom";
import FilmItem from "../../components/FilmItem";
import CinemaAxios from "../../apis/CinemaAxios";

export default function FilmDetail() {
  // const film = useRouteLoaderData("film-detail"); //we need to pass the id defined on the Route Component
  

  // console.log("FILM" + film);
  // return <FilmItem film={film} />;

  return <div>FilmDetail</div>
}

// export async function loader({ request, params }) {
//   const id = params.id; // similar to useParams()
//   console.log("Id: " + id);

//   const response = await CinemaAxios.get("/films/" + id)
//     .then((res) => {
//       console.log(res.data);
//       return res.data;
//     })
//     .catch((error) => {
//       throw json(
//         { message: "Could not fetch the details for the selected film." },
//         { status: 500 }
//       );
//     });
//   console.log(response);
//   return response;
// }

// export async function action({ params }) {
//   const id = params.id;

//   const response = await CinemaAxios.delete("/films/" + id)
//     .then((res) => {
//       console.log(res.data);
//       return res.data;
//     })
//     .catch((error) => {
//       throw json({ message: "Could not delete the film" }, { status: 500 });
//     });

//   return redirect("/films");
// }
