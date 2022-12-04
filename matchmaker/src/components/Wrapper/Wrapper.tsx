import "./Wrapper.css"
import { FaGamepad } from 'react-icons/fa';
import {HiInformationCircle} from 'react-icons/hi'
import {GiHamburgerMenu} from 'react-icons/gi'
import {RiGameFill} from 'react-icons/ri'
import { Link, Outlet } from "react-router-dom";

export const Wrapper = () => {
    return (
     <>   
     <div className="wrapper-container">
    <nav className="wrapper-navbar-items">
        
        <h1 className="wrapper-title"><RiGameFill/> Matchmaker</h1>
        <ul className="nav-menu">
            <li>
                <Link to="/" className="nav-menu-link">Home <FaGamepad className="wrapper-icons"/></Link>
            </li>
            <li>
            <Link to="/AboutPage" className="nav-menu-link">About <HiInformationCircle className="wrapper-icons"/></Link>
            </li>
            <li>
            <Link to="/ErrorPage" className="nav-menu-link">AdminPanel <HiInformationCircle className="wrapper-icons"/></Link>
            </li>
            <li>
            <h2 className="nav-menu-item">User <GiHamburgerMenu className="wrapper-icons"/></h2>
            </li>
            
        </ul>
        
    </nav>
    <div className="wrapper-mainarea">
    
</div>
    </div>
    
    <Outlet />
   </>
   
   
    );
};