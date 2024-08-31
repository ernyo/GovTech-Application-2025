import { lazy, Suspense } from "react";
import { Route, Routes } from "react-router-dom";

const Home = lazy(() => import("../pages/Home"));

const Router = () => {
  return (
    <Suspense fallback={null}>
      <Routes>
        <Route key="root" path="/" Component={Home} />
      </Routes>
    </Suspense>
  );
};

export default Router;
