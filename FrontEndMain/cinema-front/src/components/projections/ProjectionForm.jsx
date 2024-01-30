import { useState } from "react";
import { useQuery } from "@tanstack/react-query";

import ErrorBlock from "../UI/ErrorBlock.jsx";
import { useNavigate, useNavigation } from "react-router-dom";
import classes from "./ProjectionForm.module.css";

export default function ProjectionForm({ inputData, onSubmit, children }) {
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

  // const { data, isPending, isError } = useQuery({
  //   queryKey: ["events-images"],
  //   queryFn: fetchSelectableImages,
  // });

  function handleSubmit(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const data = Object.fromEntries(formData);

    onSubmit({ ...data });
  }

  return (
    <form id={classes["event-form"]} onSubmit={handleSubmit}>
      <p className={classes.control}>
        <label htmlFor="dateTime">Date and time:</label>
        <input
          id="dateTime"
          type="datetime-local"
          name="dateTime"
          min={currDate.toISOString().slice(0, -8)}
          required
        />
      </p>
      <p className={classes.control}>
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
      <p className={classes.control}>
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
      <p className={classes["form-actions"]}>{children}</p>
    </form>
  );

  // return (
  //   <form id="event-form" onSubmit={handleSubmit}>
  //     <p className="control">
  //       <label htmlFor="title">Title</label>
  //       <input
  //         type="text"
  //         id="title"
  //         name="title"
  //         defaultValue={inputData?.title ?? ""}
  //       />
  //     </p>

  //     {isPending && <p>Loading selectable images...</p>}
  //     {isError && (
  //       <ErrorBlock
  //         title="Failed to load selectable images"
  //         message="Please try again later."
  //       />
  //     )}
  //     {data && (
  //       <div className="control">
  //         <ImagePicker
  //           images={data}
  //           onSelect={handleSelectImage}
  //           selectedImage={selectedImage}
  //         />
  //       </div>
  //     )}

  //     <p className="control">
  //       <label htmlFor="description">Description</label>
  //       <textarea
  //         id="description"
  //         name="description"
  //         defaultValue={inputData?.description ?? ""}
  //       />
  //     </p>

  //     <div className="controls-row">
  //       <p className="control">
  //         <label htmlFor="date">Date</label>
  //         <input
  //           type="date"
  //           id="date"
  //           name="date"
  //           defaultValue={inputData?.date ?? ""}
  //         />
  //       </p>

  //       <p className="control">
  //         <label htmlFor="time">Time</label>
  //         <input
  //           type="time"
  //           id="time"
  //           name="time"
  //           defaultValue={inputData?.time ?? ""}
  //         />
  //       </p>
  //     </div>

  //     <p className="control">
  //       <label htmlFor="location">Location</label>
  //       <input
  //         type="text"
  //         id="location"
  //         name="location"
  //         defaultValue={inputData?.location ?? ""}
  //       />
  //     </p>

  //     <p className="form-actions">{children}</p>
  //   </form>
  // );
}
