import { NavLink } from "react-router-dom";

import classes from "./MainNavigation.module.css";

// using NavLink here instead of Link so we can get an is active props
function MainNavigation() {
  return (
    <header className={classes.header}>
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
        </ul>
      </nav>
    </header>
  );
}

export default MainNavigation;
