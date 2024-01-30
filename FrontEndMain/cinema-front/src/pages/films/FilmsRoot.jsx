import { Outlet } from "react-router-dom";

import FilmsNavigation from "../../components/FilmsNavigation";

export default function FilmsRoot() {
  return (
    <>
      <FilmsNavigation />
      <Outlet />
    </>
  );
}
