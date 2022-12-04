import { useNavigate } from 'react-router-dom';
import './StartPage.css'

export const StartPage = () => {

    
//declare use of navigate
const navigate = useNavigate();

function  handleClickRight(){
    navigate("/MeetFormPage")
}

function  handleClickLeft(){
    navigate("/MeetsPage")
}

    return (
       
        <div className="startpage-container">
                    <div className="startpage-left-side">


<button className="startpage-join-meet" onClick={handleClickLeft} >
<h1>I'm searching for a meet!</h1>
</button>
    </div>

    <div className="startpage-right-side">



<button className="startpage-create-meet" onClick={handleClickRight}>
<h1>I want to create a meet!</h1>

</button>
    </div>
   </div>
   

    );
}