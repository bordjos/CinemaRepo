import classes from "./PriceInfo.module.css";

export default function PriceInfo() {
  return (
    <div className={classes.containerDiv}>
      <h1>Ticket prices</h1>
      <div className={classes.tableDiv}>
        <table className={classes.pricesTable}>
          <thead>
            <tr>
              <th>TYPES</th>
              <th>WEEKDAYS</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>2D projections up until 14:59h</td>
              <td>500 RSD</td>
            </tr>
            <tr>
              <td>2D projections between 15:00h and 17:59h</td>
              <td>550 RSD</td>
            </tr>
            <tr>
              <td>2D projections from 18:00h</td>
              <td>600 RSD</td>
            </tr>
            <tr>
              <td>3D projections up until 14:59h</td>
              <td>700 RSD</td>
            </tr>
            <tr>
              <td>3D projections between 15:00h and 17:59h</td>
              <td>750 RSD</td>
            </tr>
            <tr>
              <td>3D projections from 18:00h</td>
              <td>800 RSD</td>
            </tr>
            <tr>
              <td>4D projections up until 14:59h</td>
              <td>900 RSD</td>
            </tr>
            <tr>
              <td>4D projections between 15:00h and 17:59h</td>
              <td>950 RSD</td>
            </tr>
            <tr>
              <td>4D projections from 18:00h</td>
              <td>1.000 RSD</td>
            </tr>
          </tbody>
        </table>
        <div style={{height: "6rem"}}></div>
        <table className={classes.pricesTable}>
          <thead>
            <tr>
              <th>TYPES</th>
              <th>WEEKENDS</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>2D projections up until 14:59h</td>
              <td>550 RSD</td>
            </tr>
            <tr>
              <td>2D projections between 15:00h and 17:59h</td>
              <td>600 RSD</td>
            </tr>
            <tr>
              <td>2D projections from 18:00h</td>
              <td>650 RSD</td>
            </tr>
            <tr>
              <td>3D projections up until 14:59h</td>
              <td>750 RSD</td>
            </tr>
            <tr>
              <td>3D projections between 15:00h and 17:59h</td>
              <td>800 RSD</td>
            </tr>
            <tr>
              <td>3D projections from 18:00h</td>
              <td>850 RSD</td>
            </tr>
            <tr>
              <td>4D projections up until 14:59h</td>
              <td>950 RSD</td>
            </tr>
            <tr>
              <td>4D projections between 15:00h and 17:59h</td>
              <td>1.000 RSD</td>
            </tr>
            <tr>
              <td>4D projections from 18:00h</td>
              <td>1.050 RSD</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div></div>
    </div>
  );
}
