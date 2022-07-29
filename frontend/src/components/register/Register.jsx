import React,{useState} from 'react'
import axios from 'axios'

import './Register.css'
import { Link, useNavigate } from 'react-router-dom';

export default function Register() {
    const [details, setDetails] = useState({ firstName: "", lastName: "", email: "", password: "" });

    
    const uploadHandler=(e)=> {
        
        e.preventDefault();
        axios.post('https://insta-booking.herokuapp.com/api/userService/signup',details)
        .then(res =>{
        
            console.log(res);
           //redirect to login page
        })

        alert("Signup-Successfully")
        
        
        
    }

    const changeHandler=(e)=> {
        const name = e.target.name;
      const value = e.target.value;
      setDetails({ ...details, [name] : value });
    }

   

  return (
    <div className="login">
      <div className="loginWrapper">
        {/* <div className="loginLeft">
          <h3 className="loginLogo">Oolala</h3>
          <span className="loginDesc">
            Oolala helps you connect with your friends and family
          </span>
        </div> */}
        <div className="loginRight">
          <div className="loginBox">
            <div style={{display: 'flex', flexDirection:'row'}}>
            <input onChange={changeHandler} name="firstName"  placeholder="First Name" className="loginInput" id="regfirstName" />
            <input  onChange={changeHandler} name="lastName"  placeholder="Last Name" className="loginInput" id="reglastName"/>
            </div>
            <input onChange={changeHandler} name="email"  placeholder="Email" className="loginInput" />
            <input onChange={changeHandler} name="password" placeholder="Password" className="loginInput" />
            {/* <input placeholder="Password Again" className="loginInput" /> */}
            <button onClick={uploadHandler} className="loginButton">Sign Up</button>
            <Link to="/Login" ><button className="loginRegisterButton">
              Log into Account
            </button></Link>
          </div>
        </div>
      </div>
    </div>
  )
}
