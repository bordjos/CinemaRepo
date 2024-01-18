import { useParams } from "react-router-dom";

export default function FilmDetail() {
  const params = useParams();

  return (
    <>
      <h1>Film Detail Page</h1>
      <p>Event ID: {params.id}</p>
    </>
  );
}
