import './App.css';
import { ChakraProvider } from '@chakra-ui/react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { AdminPage } from './pages/AdminPage';
import { GameData } from './models/GameData';
import { createContext } from 'react';


interface GameDataContext {
  gameData: GameData;
  gameDataModifier: (value: GameData) => void;
}

export const GameDataContext = createContext<GameDataContext>({
  gameData: {
    name: "",
    isNameValid: false,
    genre: "",
    isGenreValid: false,
    platform: "",
    isPlatformValid: false,
    description: "",
    isDescriptionValid: false,
  },
  gameDataModifier: () => {},

});

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
