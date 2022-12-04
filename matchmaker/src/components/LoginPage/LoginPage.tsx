import { useNavigate } from 'react-router-dom';
import './LoginPage.css'
import SignIn from './SignIn.png'


export const LoginPage = () => {
//declare use of navigate
const navigate = useNavigate();
    function  handleClick(){
        navigate("/StartPage")
    }


    return (
       
        <div className="loginpage-container">
            <div className="loginpage-container-second">
            <img src={SignIn} alt="Logo" className="signin" onClick={handleClick}/>
            </div>
    
   </div>
   

    );
}