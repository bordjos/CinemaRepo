import { Form, useNavigate, useNavigation } from "react-router-dom";

import classes from "./ProjectionForm.module.css";
import { useState } from "react";
import CinemaAxios from "../../apis/CinemaAxios";

export default function ProjectionForm({ method }) {
  const navigate = useNavigate();
  const navigation = useNavigation(); // provides the state of the currently active route transition (for example, submitting a form)
  const [selectedAuditorium, setSelectedAuditorium] = useState("0");
  const [selectedProjectionType, setSelectedProjectionType] = useState("0");

  const isSubmitting = navigation.state === "submitting";

  function cancelHandler() {
    navigate("..");
  }

  let currDate = new Date();

  currDate.setHours(currDate.getHours() + 24);

  const validateDate = (event) => {
    // event.preventDefault();

    const dateTime = document.getElementById("dateTime");
    const selectedDateTime = new Date(dateTime.value);

    const minTime = new Date(currDate);
    minTime.setHours(12, 0, 0, 0);

    const maxTime = new Date(currDate);
    maxTime.setHours(22, 0, 0, 0);

    console.log("minTime: " + minTime, "maxTime: " + maxTime);
    console.log("selectedDate: " + selectedDateTime);

    if (
      selectedDateTime.getHours() < minTime.getHours() ||
      selectedDateTime.getHours() > maxTime.getHours()
    ) {
      alert("Please select a time between 12:00 and 22:00");
      return false;
    }

    const auditoriumId = document.getElementById("auditoriumId");

    // event.target.submit();
  };

  const isSubmitDisabled =
    selectedAuditorium === "0" || selectedProjectionType === "0";

  return (
    <Form
      method={method}
      className={classes.form}
      onSubmit={(e) => validateDate(e)}
    >
      <p>
        <label htmlFor="dateTime">Date and time:</label>
        <input
          id="dateTime"
          type="datetime-local"
          name="dateTime"
          min={currDate.toISOString().slice(0, -8)}
          required
        />
      </p>
      <p>
        <label htmlFor="projectionTypeId">Auditorium:</label>
        <select
          name="auditoriumId"
          id="auditoriumId"
          onChange={(e) => setSelectedAuditorium(e.target.value)}
          required
        >
          <option value="0">---</option>
          <option value="1">A1</option>
          <option value="2">A2</option>
          <option value="3">B1</option>
          <option value="4">B2</option>
        </select>
      </p>
      <p>
        <label htmlFor="projectionTypeId">Projection Type:</label>
        <select
          name="projectionTypeId"
          id="projectionTypeId"
          onChange={(e) => setSelectedProjectionType(e.target.value)}
          required
        >
          <option value="0">---</option>
          <option value="1">2D</option>
          <option value="2">3D</option>
          <option value="3">4D</option>
        </select>
      </p>
      <div className={classes.actions}>
        <button type="button" onClick={cancelHandler} disabled={isSubmitting}>
          Cancel
        </button>
        <button
          disabled={isSubmitting || isSubmitDisabled}
          className={isSubmitDisabled ? classes.buttonDisabled : ""}
        >
          {isSubmitting ? "Submitting..." : "Save"}
        </button>
      </div>
    </Form>
  );
}

export async function action({ request, params }) {
  // const method = request.method.toLowerCase();
  alert("IM HERE!");

  const data = await request.formData(); // extracting the submitted form data

  const filmId = params.id;

  // must match the name props on the form elements
  const projectionData = {
    dateTime: data.get("dateTime").replace("T", " "),
    auditoriumId: data.get("auditoriumId"),
    projectionTypeId: data.get("projectionTypeId"),
    filmId,
    price: 500,
  };

  const response = await CinemaAxios.post("/projections", projectionData)
    .then((res) => {
      console.log("SUCCESS");
      return redirect("/films/" + filmId);
    })
    .catch((err) => {
      console.log(err);
      return null;
    });

  return response;

  // console.log("method: " + method);

  // let url = "/films";

  // if (method === "put") {
  //   const id = params.id;
  //   filmData.id = id;
  //   console.log("ID: " + id);
  //   url += "/" + id;
  // }
  // console.log("filmData: " + filmData);

  // const response = await CinemaAxios[method](url, filmData)
  //   .then((res) => {
  //     console.log(res.data);
  //     return redirect("/films");
  //   })
  //   .catch((error) => {
  //     // throw json(
  //     //   { message: error.response?.data?.errors?.[0]?.defaultMessage },
  //     //   { status: 500 }
  //     // );
  //     console.log("TJKLDFS" + error.response.data);
  //     return error.response.data;
  //   });

  // // return redirect("/films");
  // return response;
}
