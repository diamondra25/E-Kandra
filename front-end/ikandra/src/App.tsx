import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Authentification from './Components/Authentification';
import { AuthProvider } from './Contexts/AuthContext';
import Home from './Components/Home';

function App() {
  const API_URL = "http://localhost:8080";

  return (
    <BrowserRouter>
      <AuthProvider>
        <Routes>
          <Route path="authentification" element={<Authentification api_url={API_URL} log={false} />} />
          <Route path="/home" element={<Home />} />
        </Routes>
      </AuthProvider>
    </BrowserRouter>
  );
}

export default App;
