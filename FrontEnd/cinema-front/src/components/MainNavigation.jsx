import { Form, NavLink, useRouteLoaderData } from "react-router-dom";

import classes from "./MainNavigation.module.css";
import logo from "../assets/cinema-logo.jpg";

// using NavLink here instead of Link so we can get an is active props
function MainNavigation() {
  const authObject = useRouteLoaderData("root");

  return (
    <header className={classes.header}>
      <img className={classes.logo} src={logo} alt="Cinema Logo Image" />
      <nav>
        <ul className={classes.list}>
          <li>
            {/* using absolute path so the link always leads to the starting page */}
            <NavLink
              to="/"
              className={({ isActive }) =>
                isActive ? classes.active : undefined
              }
            >
              Home
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/films"
              className={({ isActive }) =>
                isActive ? classes.active : undefined
              }
            >
              Films
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/price-list"
              className={({ isActive }) =>
                isActive ? classes.active : undefined
              }
            >
              Price List
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/about-us"
              className={({ isActive }) =>
                isActive ? classes.active : undefined
              }
            >
              About Us
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/contact"
              className={({ isActive }) =>
                isActive ? classes.active : undefined
              }
            >
              Contact
            </NavLink>
          </li>
          {authObject.jwt ? (
            <li>
              <Form action="/logout" method="POST" >
                <button style={{ marginRight: "6rem" }}>Log Out</button>
              </Form>
            </li>
          ) : (
            <li>
              <NavLink
                to="/auth?mode=login"
                className={({ isActive }) =>
                  isActive ? classes.active : undefined
                }
                style={{ marginRight: "6rem" }}
              >
                Log In
              </NavLink>
            </li>
          )}

          {/* <li>
            <NavLink onClick={logout}>Log Out</NavLink>
          </li> */}
        </ul>
      </nav>
    </header>
  );
}

export default MainNavigation;
