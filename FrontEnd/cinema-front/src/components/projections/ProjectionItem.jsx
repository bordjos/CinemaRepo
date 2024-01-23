import { useEffect, useState } from "react";

import CinemaAxios from "../../apis/CinemaAxios";
import classes from "./ProjectionItem.module.css";

export default function ProjectionItem({ projection }) {
  const [seats, setSeats] = useState([]);
  const [selectedSeats, setSelectedSeats] = useState([]);

  useEffect(() => {
    const auditoriumId = projection.auditoriumId;
    console.log(auditoriumId);

    CinemaAxios.get("/auditoriums/" + auditoriumId + "/seats")
      .then((res) => {
        console.log(res.data);
        setSeats(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);

  const handleSeatClick = (seatId) => {
    const isSelected = selectedSeats.includes(seatId);

    setSelectedSeats((prevSelectedSeats) =>
      isSelected
        ? prevSelectedSeats.filter((id) => id !== seatId)
        : [...prevSelectedSeats, seatId]
    );
  };

  const checkout = () => {

  }

  return (
    <div className={classes.container}>
      <h1>Projection Details Page</h1>
      <p>{projection.filmName}</p>
      <p>Date and time: {projection.dateTime.replace("T", " ")}</p>
      <p>Ticket price: {projection.price} RSD</p>
      <p>Reserve your seat: </p>

      <div className={classes.grid}>
        {seats.map((seat) => (
          <button
            key={seat.id}
            onClick={() => handleSeatClick(seat.id)}
            className={
              selectedSeats.includes(seat.id)
                ? classes.selected
                : classes.notSelected
            }
          >
            {seat.number}
          </button>
        ))}
      </div>
      <div>
        <button onClick={checkout}>Checkout</button>
      </div>
    </div>
  );
}

// export async function loader({ request, params }) {
//   const id = params.projectionId; // similar to useParams()
//   console.log("projectionId: " + id);

//   const response = await CinemaAxios.get("/projections/" + id)
//     .then((res) => {
//       console.log(res.data);
//       return res.data;
//     })
//     .catch((error) => {
//       throw json(
//         { message: "Could not fetch the projections for the selected film." },
//         { status: 500 }
//       );
//     });

//   console.log(response);

//   return response;
// }
