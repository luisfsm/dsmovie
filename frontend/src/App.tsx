import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import Listing from 'pages/Listing/Listing';
import Form from 'pages/Form/Form';
import Navbar from "./Components/navbar/";

function App() {
  return (
    <>
      <BrowserRouter>
        <Navbar />
        <Routes>
            <Route path="/" element={<Listing />}></Route>
            <Route path="/form">
              <Route path=":movieId" element={<Form />}></Route>
            </Route>
        </Routes>

      </BrowserRouter>

    </>
  );
}

export default App;
