import {
  Form,
  useNavigate,
  useNavigation,
  useActionData,
  redirect,
} from "react-router-dom";

import classes from "./FilmForm.module.css";
import CinemaAxios from "../apis/CinemaAxios";

export default function FilmForm({ method, film }) {
  const data = useActionData(); //gives us access to the data returned by the action() method
  console.log("DATA: " + JSON.stringify(data));
  const navigate = useNavigate();
  const navigation = useNavigation(); // provides the state of the currently active route transition (for example, submitting a form)

  const isSubmitting = navigation.state === "submitting";

  function cancelHandler() {
    navigate("..");
  }

  return (
    //using Form Component here so that the browser default of sending the form will not happen automatically, instead, it will pass the data to the action method()
    <Form method={method} className={classes.form}>
      {data && data.errors && (
        <ul>
          {/* mapping through the error messages defined on the BackEnd */}
          {Object.values(data.errors).map((err) => (
            <li key={err.defaultMessage} style={{ color: "red" }}>
              {err.defaultMessage}
            </li>
          ))}
        </ul>
      )}
      <p>
        <label htmlFor="name">Name</label>
        <input
          id="name"
          type="text"
          name="name"
          required
          defaultValue={film ? film.name : ""}
        />
      </p>
      <p>
        <label htmlFor="director">Director</label>
        <input
          id="director"
          type="text"
          name="director"
          required
          defaultValue={film ? film.director : ""}
        />
      </p>
      <p>
        <label htmlFor="cast">Cast</label>
        <input
          id="cast"
          type="text"
          name="cast"
          required
          defaultValue={film ? film.cast : ""}
        />
      </p>
      <p>
        <label htmlFor="length">Length</label>
        <input
          id="length"
          type="number"
          name="length"
          required
          min="1"
          max="400"
          defaultValue={film ? film.length : 1}
        />
      </p>
      <p>
        <label htmlFor="distributor">Distributor</label>
        <input
          id="distributor"
          type="text"
          name="distributor"
          required
          defaultValue={film ? film.distributor : ""}
        />
      </p>
      <p>
        <label htmlFor="country">Country</label>
        <input
          id="country"
          type="text"
          name="country"
          required
          defaultValue={film ? film.country : ""}
        />
      </p>

      <p>
        <label htmlFor="year">Year</label>
        <input
          id="year"
          type="number"
          name="year"
          required
          min="1900"
          max={new Date().getFullYear()}
          defaultValue={film ? film.year : 2024}
        />
      </p>
      <p>
        <label htmlFor="about">Description</label>
        <textarea
          id="about"
          name="about"
          rows="5"
          required
          defaultValue={film ? film.about : ""}
        />
      </p>
      <p>
        <label htmlFor="posterUrl">Poster</label>
        <input
          id="posterUrl"
          type="url"
          name="posterUrl"
          required
          defaultValue={film ? film.posterUrl : ""}
        />
      </p>
      <div className={classes.actions}>
        <button type="button" onClick={cancelHandler} disabled={isSubmitting}>
          Cancel
        </button>
        <button disabled={isSubmitting}>
          {isSubmitting ? "Submitting..." : "Save"}
        </button>
      </div>
    </Form>
  );
}

export async function action({ request, params }) {
  const method = request.method.toLowerCase();

  const data = await request.formData(); // extracting the submitted form data

  // must match the name props on the form elements
  const filmData = {
    name: data.get("name"),
    director: data.get("director"),
    cast: data.get("cast"),
    length: data.get("length"),
    distributor: data.get("distributor"),
    country: data.get("country"),
    year: data.get("year"),
    about: data.get("about"),
    posterUrl: data.get("posterUrl"),
  };

  console.log("method: " + method);

  let url = "/films";

  if (method === "put") {
    const id = params.id;
    filmData.id = id;
    console.log("ID: " + id);
    url += "/" + id;
  }
  console.log("filmData: " + filmData);

  const response = await CinemaAxios[method](url, filmData)
    .then((res) => {
      console.log(res.data);
      return redirect("/films");
    })
    .catch((error) => {
      // throw json(
      //   { message: error.response?.data?.errors?.[0]?.defaultMessage },
      //   { status: 500 }
      // );
      console.log("TJKLDFS" + error.response.data);
      return error.response.data;
    });

  // return redirect("/films");
  return response;
}
