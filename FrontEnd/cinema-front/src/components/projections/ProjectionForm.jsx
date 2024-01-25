import { Form, useNavigate, useNavigation } from "react-router-dom";

import classes from "./ProjectionForm.module.css";

export default function ProjectionForm({ method }) {
  const navigate = useNavigate();
  const navigation = useNavigation(); // provides the state of the currently active route transition (for example, submitting a form)

  const isSubmitting = navigation.state === "submitting";

  function cancelHandler() {
    navigate("..");
  }

  return (
    <Form method={method} className={classes.form}>
      <p>
        <label htmlFor="dateTime">Date and time:</label>
        <input id="dateTime" type="datetime-local" name="dateTime" required />
      </p>
      <p>
        <label for="projectionTypeId">Auditorium:</label>
        <select name="auditoriumId" id="auditoriumId">
          <option value="1">A1</option>
          <option value="2">A2</option>
          <option value="3">B1</option>
          <option value="4">B2</option>
        </select>
      </p>
      <p>
        <label for="projectionTypeId">Projection Type:</label>
        <select name="projectionTypeId" id="projectionTypeId">
          <option value="1">2D</option>
          <option value="2">3D</option>
          <option value="3">4D</option>
        </select>
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
