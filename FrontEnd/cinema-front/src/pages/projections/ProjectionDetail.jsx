import { useLoaderData } from "react-router-dom";
import CinemaAxios from "../../apis/CinemaAxios";

export default function ProjectionDetail() {
  const data = useLoaderData();
//   console.log(data);

  return <>
  <h1>Projection Details Page</h1>
    <p>{data.dateTime}</p>
    <p>{data.price}</p>
  </>;
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


  
