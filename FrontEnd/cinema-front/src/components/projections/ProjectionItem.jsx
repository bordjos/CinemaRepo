import { useEffect, useState } from "react";
import { useNavigate, useRouteLoaderData } from "react-router-dom";
import { useMutation } from "@tanstack/react-query";

import CinemaAxios from "../../apis/CinemaAxios";
import classes from "./ProjectionItem.module.css";
import { queryClient } from "../../util/http";

export default function ProjectionItem({ projection }) {
  const navigate = useNavigate();
  
  const [seats, setSeats] = useState([]);
  const [selectedSeats, setSelectedSeats] = useState([]);
  const [totalPrice, setTotalPrice] = useState(0);


  const authObject = useRouteLoaderData("root");

  const isAdmin = () => {
    return authObject && authObject.role === "ADMIN";
  };

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

  const { mutate, isPending, isError, error } = useMutation({
    // mutationKey: , //isn't needed here because we don't need to cache the query
    mutationFn: () =>
      CinemaAxios.delete("/projections/" + projection.id)
        .then((res) => res.data)
        .catch((err) => console.log(err)),
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ["events"] }); // tells React query that the data fetched by a specific query is stale and the immediate refetch should be triggered //queryKey should match the query key of that specific query (it is enough to include for example "events" in the key, so both the search query and the regular fetch events query will be triggered, add exact: true to the Object to avoid this behaviour)
      console.log("SUCCESS?")
      navigate("../");
    }, //will trigger if the mutation is successful
  });

  const deleteProjection = () => {
    mutate();
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
            disabled={
              projection.reservedSeatIds.includes(seat.id) ||
              !authObject ||
              isAdmin()
            }
          >
            {seat.number}
          </button>
        ))}
      </div>
      <p>
        <span className={classes.redSquare}></span>Seats marked as red are
        reserved!
      </p>
      {authObject && (
        <>
          <p style={{ color: "green" }}>Total price: {totalPrice} RSD</p>

          <div>
            {isAdmin() ? (
              <button
                className={classes.deleteProjectionButton}
                onClick={deleteProjection}
              >
                Delete
              </button>
            ) : (
              <button className={classes.checkoutButton} onClick={checkout}>
                Checkout
              </button>
            )}
          </div>
        </>
      )}
    </div>
  );
}
