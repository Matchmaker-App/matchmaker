
import { Button, FormLabel, Input, MenuItem, Select, SelectChangeEvent } from '@mui/material';
import axios from 'axios';
import { ReactNode, useCallback, useContext, useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { MeetApi } from '../../api/MeetApi';

import { DataContext } from '../../App';
import {GameResponse} from "../../models/GameResponse"
import { Meet } from '../../models/Meet';
import './MeetFormPage.css'

//game data
interface RequestGame<T>{
  data: T;
}

export const MeetFormPage = () => {

//use state game
  const[requestGame,setRequestGame]=useState<RequestGame<GameResponse[]>
  >({
    data: [],
    });

const [meet,setMeet]=useState<Meet>({
  aviability:true,
  date:"",
  numberOfPlayers:0,
  time:"",
  gameId:0,
  userId:1,
})    

//declare context use 
const context = useContext(DataContext);

//declare use of navigate
const navigate = useNavigate();

//submitting form
function  handleSubmit(){
    axios.post(
     "http://localhost:9000/meet/",
     { 
       date:meet.date,
       time:meet.time,
       aviability:true,
       numberOfPlayers: meet.numberOfPlayers,
       
     },{
       params:{
       gameId:meet.gameId,
       userId:1
       }
    })
    context.basicData.date = "";
    context.basicData.time = "";
    context.gameResponseData.name ="";
    navigate("/")
 }

//date from input to meet
const onMeetDateChanged = (
    event: React.ChangeEvent<HTMLInputElement>
  ) => {
    setMeet({
      ...meet,
      date: event.currentTarget.value,
    });
  };

//time from input to meet
  const onMeetTimeChanged = (
    event: React.ChangeEvent<HTMLInputElement>
  ) => {
    setMeet({
      ...meet,
      time: event.currentTarget.value,
    });
  };
//number of players to meet
  const onChangeNumberOfPlayers =(
  
    event: React.ChangeEvent<HTMLInputElement>
  ) =>{
    setMeet({
      ...meet,
      numberOfPlayers: Number(event.target.value),
    });
  };

//game from select to meet
const onSelectGame =(
  
  event: SelectChangeEvent<number>,
) =>{
  setMeet({
    ...meet,
    gameId: Number(event.target.value),
  });
};

//fetching games data
  const fetchGames = useCallback(async () => {
    try {
      setRequestGame({ data: [] });
      const games = await MeetApi.getGameForMeets();
      console.log(games);
      setRequestGame({ data: games.data });
    } catch (error) {
      setRequestGame({ data: [] });
    }
  }, []);

//hook
  useEffect(() => {
    fetchGames();
  }, []);

//view  
    return (  
<div className="meetformpage-container">
 <form id="meet-form" color='#586ae6' >
        <FormLabel><h3 className="meetformpage-title">Meet</h3></FormLabel>
        <ul className="meet-form-list">
          <li>
            <label>Date</label>
            <Input
            className="date-input"
            
            id="meet-date"
            type="text"
            placeholder="01.20.2022"
            value={meet.date}
            onChange={onMeetDateChanged}
             />  
          </li>
          <li>
            <label>Time</label>
            <Input
            id="meet-time"
            type="text"
            placeholder="20:00"
            value={meet.time}
            onChange={onMeetTimeChanged}
          />  
          </li>
          <li>
            <label>Game</label>
            <Select
    value={meet.gameId}
    onChange={onSelectGame}
  >
    {requestGame.data.map((game) => (
              <MenuItem value={game.id}>{game.name}</MenuItem>
            ))}
  
  </Select>
            {/* <Select
            placeholder="Choose game"
            className="selectGame"
            onChange={onSelectGame}
            value={meet.gameId.toString()}
            >
            {requestGame.data.map((game) => (
              <option value={meet.gameId.toString()}>{game.name}</option>
            ))}
            </Select>  */}
          </li>
          <li>
            <label>Players</label>
            <Input
            id="meet-time"
            type="text"
            placeholder='0'
            value={meet.numberOfPlayers}
            onChange={onChangeNumberOfPlayers}
            />  
          </li>
          <li>
            <Button onClick={handleSubmit}
            >
            <p className="meet-form-button">Add Meet</p>
            </Button>
          </li>
        </ul>
  </form>
</div>

    );
}