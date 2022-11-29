import './App.css';
import { ChakraProvider } from '@chakra-ui/react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { StartPage } from './pages/StartPage';
import { AdminPage } from './pages/AdminPage';




function App() {
  return (
    <div className="App">
     
   
    <ChakraProvider>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<AdminPage />}></Route>
      </Routes>
    </BrowserRouter>
  </ChakraProvider>
    </div>
  );
}

export default App;
