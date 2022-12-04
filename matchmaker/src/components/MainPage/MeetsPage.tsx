
import { useCallback, useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { MeetApi } from '../../api/MeetApi';
import { MeetGet } from '../../models/MeetGet';
import { ImPlus } from 'react-icons/im';
import './MeetsPage.css'

interface RequestMeet<T>{
    data: T;
  }


export const MeetsPage = () => {

//use state game
const[requestMeets,setRequestMeets]=useState<
RequestMeet<MeetGet[]>
>({
  data: [],
  });
  
//declare use of navigate
const navigate = useNavigate();
    
//fetching meets data
const fetchMeets = useCallback(async () => {
    try {
      setRequestMeets({ data: [] });
      const meets = await MeetApi.getMeets();
      console.log(meets);
      setRequestMeets({ data: meets.data });
    } catch (error) {
      setRequestMeets({ data: [] });
    }
  }, []);

  const listMeets = requestMeets.data.map((meet) =>
  
  <li key={meet.id}><div className="meet-container">
    <ul>
      <li>
      <label className="label">
    Date: {meet.date}
    </label>
      </li>
      <li>
      <label>
    Game: {meet.game}
    </label>
      </li>
      <li>
      <label>
    Time: {meet.time}
    </label> 
      </li>
      <li>
      <label>
    NumberOfPlayers: {meet.numberOfPlayers}
    </label> 
      </li>
      <li>
      <label className="meet-aviability">
     <button className="meet-button"><ImPlus className="meet-icon" /></button>
    </label> 
      </li>
    </ul>
    
    </div></li>
  );

  useEffect(() => {
    fetchMeets();
  }, []);

    return (
        <div className="meetspage-container">
            <div className="meetspage-meets">
          <ul>{listMeets}</ul>

        
            </div>
   </div>
   

    );
}