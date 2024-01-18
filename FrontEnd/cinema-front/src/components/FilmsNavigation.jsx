import { NavLink } from "react-router-dom";

import classes from "./FilmsNavigation.module.css";

function FilmsNavigation() {
  return (
    <header className={classes.header}>
      <nav>
        <ul className={classes.list}>
          <li>
            <NavLink
              to="/films"
              className={({ isActive }) =>
                isActive ? classes.active : undefined
              }
              end
            >
              All Films
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/films/new"
              className={({ isActive }) =>
                isActive ? classes.active : undefined
              }
            >
              New Film
            </NavLink>
          </li>
        </ul>
      </nav>
    </header>
  );
}

export default FilmsNavigation;
