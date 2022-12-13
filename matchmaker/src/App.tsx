import { createContext, useState } from 'react';

import './App.css';
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import { Wrapper } from './components/Wrapper/Wrapper';
import { StartPage } from './components/StartPage/StartPage';
import { LoginPage } from './components/LoginPage/LoginPage';
import { AboutPage } from './components/AboutPage/AboutPage';
import { Meet } from './models/Meet';
import { MeetFormPage } from './components/MeetFormPage/MeetFormPage';
import { GameResponse } from './models/GameResponse';
import { MeetsPage } from './components/MainPage/MeetsPage';
import { Game } from './models/game/Game';
import { AdminPage } from './components/AdminPage/AdminPage';

import error from './404.png'
import { UserPage } from './components/UserPage/UserPage';


//define context
interface DataContext {
  basicData: Meet;
  basicDataModifier: (value: Meet) => void;

  gameResponseData: GameResponse;
  gameResponseDataModifier: (value: GameResponse) => void;

  game: Game;
  gameModifier: (value: Game) => void;
  
}

//context fields and modifier
export const DataContext = createContext<DataContext>({
  basicData: {
    date:"",
    time:"",
    numberOfPlayers:0,
    aviability:true,
    gameId:0,
    userId:0,
  },
  basicDataModifier: (value: Meet) => {},
gameResponseData:{
  id:0,
  name:"",
},
gameResponseDataModifier:(value:GameResponse)=>{},
//gamecontext
game: {
  name: "",
  genre: "",
  platform: "",
},
gameModifier: (value: Game) => {},


});


function App() {
  
  //use of context fields
  const [basicData, setBasicData] = useState<Meet>({
    date:"",
    time:"",
    numberOfPlayers:0,
    aviability:true,
    gameId:0,
    userId:0,
  });

  const[gameResponseData,setGameResponeData] = useState<GameResponse>({
    id:0,
    name:"",
  })

  function PageNotFound() {
    return (
      <div>
        <img src={error} alt="Logo" className="logo" />
      </div>
    );

  }

  const [game, setGame] = useState<Game>({
   
    name: "",
    genre: "",
    platform: "",
  });
  //use of context modifier
  const basicDataModifier = (value: Meet) => {
    setBasicData(value);
  };
  const gameResponseDataModifier = (value:GameResponse)=>{
    setGameResponeData(value);
  }

  //use of game context
  
  const gameModifier = (value: Game) => {
    setGame(value);
  };

  return (


    
    <DataContext.Provider
      value={{
        game: game,
        gameModifier: gameModifier,
        basicData: basicData,
        basicDataModifier: basicDataModifier,
        gameResponseData:gameResponseData,
        gameResponseDataModifier: gameResponseDataModifier,
      }}
    >
      
      <BrowserRouter>
   <Routes>
    <Route path ="/" element={<Wrapper />}>
    <Route index element={<LoginPage/>}></Route>
    <Route path="/StartPage" element={<StartPage/>}></Route>
    <Route path="/LoginPage" element={<LoginPage/>}></Route>
    <Route path="/AdminPage" element={<AdminPage/>}></Route>
    <Route path="/AboutPage" element={<AboutPage/>}></Route>
    <Route path="/UserPage" element={<UserPage/>}></Route>
    <Route path="/MeetFormPage" element={<MeetFormPage/>}></Route>  
    <Route path="/MeetsPage" element={<MeetsPage/>}></Route>  

    <Route path="*" element={<PageNotFound />} />
      </Route>
   </Routes>

   </BrowserRouter>
   
   </DataContext.Provider>
   
  );

    

}

export default App;
