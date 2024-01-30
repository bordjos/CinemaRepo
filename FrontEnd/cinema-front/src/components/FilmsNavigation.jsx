import { NavLink, useRouteLoaderData } from "react-router-dom";

import classes from "./FilmsNavigation.module.css";

export default function FilmsNavigation() {
  const authObject = useRouteLoaderData("root");

  const isAdmin = () => {
    return authObject && authObject.role === "ADMIN";
  };

  return (
    <>
      {isAdmin() && (
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
      )}
    </>
  );
}
