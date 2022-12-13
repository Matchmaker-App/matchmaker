import "./Wrapper.css"
import { FaGamepad } from 'react-icons/fa';
import {HiInformationCircle} from 'react-icons/hi'
import {GiHamburgerMenu} from 'react-icons/gi'
import {RiGameFill} from 'react-icons/ri'
import { Link, Outlet } from "react-router-dom";
import logo from "./logo.svg"

export const Wrapper = () => {
    return (
     <>   
     <div className="wrapper-container">
    <nav className="wrapper-navbar-items">
        
        <h1 className="wrapper-title"><img src={logo} className="smaller-logo" alt="logo"/> Matchmaker</h1>
        <ul className="nav-menu">
            <li>
                <Link to="/" className="nav-menu-link">Home  <FaGamepad className="wrapper-icons"/></Link>
            </li>
            <li>
            <Link to="/AboutPage" className="nav-menu-link">About  <HiInformationCircle className="wrapper-icons"/></Link>
            </li>
            <li>
            <Link to="/AdminPage" className="nav-menu-link">AdminPanel  <HiInformationCircle className="wrapper-icons"/></Link>
            </li>
            <li>
            <Link to="/ErrorPage" className="nav-menu-link">User <GiHamburgerMenu className="wrapper-icons"/></Link>
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