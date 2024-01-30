import { useMutation } from "@tanstack/react-query";
import { Link, useLocation, useNavigate } from "react-router-dom";

import Modal from "../../components/UI/Modal";
import { createNewProjection, queryClient } from "../../util/http";
import ProjectionForm from "../../components/projections/ProjectionForm";
import ErrorBlock from "../../components/UI/ErrorBlock";

export default function NewProjection() {
  const navigate = useNavigate();
  const location = useLocation();
  

  //useMutation() hook is used for data changing queries, useQuery() is used for fetch queries
  const { mutate, isPending, isError, error } = useMutation({
    // mutationKey: , //isn't needed here because we don't need to cache the query
    mutationFn: createNewProjection,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ["projections"] }); // tells React query that the data fetched by a specific query is stale and the immediate refetch should be triggered //queryKey should match the query key of that specific query (it is enough to include for example "events" in the key, so both the search query and the regular fetch events query will be triggered, add exact: true to the Object to avoid this behaviour) //I added this here just in case I make the whole App use tanstack
    //   navigate("../");
    }, //will trigger if the mutation is successful
  });

  const handleSubmit = (formData) => {
    mutate({ projection: formData });
    // navigate("/events"); //we can use this here but it is better for the mutation to be finished first!
  };

  return (
    <Modal onClose={() => navigate("../")}>
      <ProjectionForm onSubmit={handleSubmit}>
        {isPending && "Submitting..."}
        {!isPending && (
          <>
            <Link to="../" className="button-text">
              Cancel
            </Link>
            <button type="submit" className="button">
              Create
            </button>
          </>
        )}
      </ProjectionForm>
      {isError && (
        //implement error block to the Cinema project
        <ErrorBlock
          title="Failed to create projection"
          message={
            error.info?.message ||
            "Failed to create projection. Please check your inputs and try again later."
          }
        />
      )}
    </Modal>
  );
}
