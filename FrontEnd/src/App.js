import './App.css';
import { BrowserRouter, Routes, Route} from 'react-router-dom';
import Home from './Pages/Home';
import BasicDetails from './components/homeInsurance/BasicDetails';
import HomeInsuranceBase from './components/homeInsurance/HomeInsuranceBase';
import HealthInsuranceBase from './components/healthInsurance/HealthInsuranceBase';

function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home/>} />
          <Route path="/HomeInsurance" element={<HomeInsuranceBase/>} />
          <Route path="/HealthInsurance" element={<HealthInsuranceBase/>} />
        </Routes>
      </BrowserRouter>
  );
}

export default App;
