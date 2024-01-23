import { useLoaderData } from "react-router-dom";
import ProjectionItem from "../../components/projections/ProjectionItem";
import CinemaAxios from "../../apis/CinemaAxios";

export default function ProjectionDetail() {
  const projection = useLoaderData(); //we need to pass the id defined on the Route Component
  

  // console.log("FILM" + film);
  return <ProjectionItem projection={projection} />;
}

export async function loader({ request, params }) {
  const id = params.projectionId; // similar to useParams()
  console.log("projectionId: " + id);

  const response = await CinemaAxios.get("/projections/" + id)
    .then((res) => {
      console.log(res.data);
      return res.data;
    })
    .catch((error) => {
      throw json(
        { message: "Could not fetch the projections for the selected film." },
        { status: 500 }
      );
    });

  console.log(response);

  return response;
}
