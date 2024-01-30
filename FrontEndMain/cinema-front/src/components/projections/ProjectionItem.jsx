import { useEffect, useState } from "react";

import CinemaAxios from "../../apis/CinemaAxios";
import classes from "./ProjectionItem.module.css";

export default function ProjectionItem({ projection }) {
  const [seats, setSeats] = useState([]);
  const [selectedSeats, setSelectedSeats] = useState([]);
  const [totalPrice, setTotalPrice] = useState(0);

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

    setTotalPrice((prevPrice) =>
      isSelected
        ? parseInt(prevPrice) - parseInt(projection.price)
        : parseInt(prevPrice) + parseInt(projection.price)
    );

    console.log(selectedSeats);
  };

  const checkout = () => {
    const tickets = selectedSeats.map((seatId) => ({
      projectionId: projection.id,
      seatId: seatId,
    }));

    CinemaAxios.post("/tickets", tickets)
      .then((res) => {
        console.log("SUCCESS!!!");
        location.reload();
      })
      .catch((err) => {
        console.log("ERROR!");
      });

    console.log(tickets);
  };

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
            className={` ${
              selectedSeats.includes(seat.id)
                ? classes.selected
                : classes.notSelected
            } ${
              projection.reservedSeatIds.includes(seat.id)
                ? classes.disabled
                : ""
            }`}
            disabled={projection.reservedSeatIds.includes(seat.id)}
          >
            {seat.number}
          </button>
        ))}
      </div>
      <p>
        <span className={classes.redSquare}></span>Seats marked as red are
        reserved!
      </p>
      <p style={{color: "green"}}>Total price: {totalPrice} RSD</p>
      <div>
        <button className={classes.checkoutButton} onClick={checkout}>
          Checkout
        </button>
      </div>
    </div>
  );
}
