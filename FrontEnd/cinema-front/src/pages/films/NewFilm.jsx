import { json, redirect } from "react-router-dom";

import FilmForm from "../../components/FilmForm";
import CinemaAxios from "../../apis/CinemaAxios";

export default function NewFilm() {
  return <FilmForm method="post"/>;
}

// export async function action({ request, params }) {
//   const data = await request.formData(); // extracting the submitted form data

//   // must match the name props on the form elements
//   const filmData = {
//     name: data.get("name"),
//     director: data.get("director"),
//     cast: data.get("cast"),
//     length: data.get("length"),
//     distributor: data.get("distributor"),
//     country: data.get("country"),
//     year: data.get("year"),
//     about: data.get("about"),
//     posterUrl: data.get("posterUrl"),
//   };

//   console.log("filmData: " + filmData);

//   const response = await CinemaAxios.post("/films", filmData)
//     .then((res) => {
//       console.log(res.data);
//       return redirect("/films");
//     })
//     .catch((error) => {
//       // throw json(
//       //   { message: error.response?.data?.errors?.[0]?.defaultMessage },
//       //   { status: 500 }
//       // );
//       console.log("TJKLDFS" + error.response.data);
//       return error.response.data;
//     });

//   // return redirect("/films");
//   return response;
// }

// export async function action({ request, params }) {
//   try {
//     const data = await request.formData(); // Extracting the submitted form data

//     const filmData = {
//       name: data.get("name"),
//       director: data.get("director"),
//       cast: data.get("cast"),
//       length: data.get("length"),
//       distributor: data.get("distributor"),
//       country: data.get("country"),
//       year: data.get("year"),
//       about: data.get("about"),
//       posterUrl: data.get("posterUrl"),
//     };

//     console.log("filmData: ", filmData);

//     const response = await CinemaAxios.post("/films", filmData);
//     console.log(response.data);
//     return response.data;
//   } catch (error) {
//     console.error("Error saving film:", error);
//     throw json({ message: "Could not save the film." }, { status: 500 });
//   }
// }
