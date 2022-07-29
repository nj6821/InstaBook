import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { useState } from "react";
import "./Login.css";
import Home from '../pages/home/Home';
import axios from 'axios';
import { ContactSupportOutlined } from '@material-ui/icons';
import { StylesProvider } from '@material-ui/core';

const Login = () => {
    const [data, setData] = useState({ email: "", password: "" });
    const Navigate = useNavigate()
    const[nam,setNam] = useState("")

    function OnChange_Handler(e)
    {
        e.preventDefault();
        const name = e.target.name
        const value = e.target.value
        setData({...data,[name]:value})
    }

    function OnClick_Handler(e)
    {
        e.preventDefault();
        
        axios.post('https://insta-booking.herokuapp.com/api/userService/login',data)
        .then(res =>{
            console.log(res)
            if(res.data.loginStatus==true)
            {
              Navigate("/Home1" )
            }
            else
            {
              alert('Please Enter Correct details')
            }
           //redirect to login page
        })
       
        // axios.get('https://jsonplaceholder.typicode.com/users').then((res)=>{
        //         console.log(res)
        //         setNam(res.data[0].name)
        //         var count = 1;
        //         while(count<500)
        //             count=count+1
        //         localStorage.setItem("token",nam)
        //         console.log(nam)
                
        // })

        
        
        
        
        
        
        
        
    }


    return (
        <div>
                <div className="login">
      <div className="loginWrapper">
        <div className="loginLeft">
          <h3 className="loginLogo">INSTABOOK</h3>
          <span className="loginDesc">
          Connect With Your Friends
          </span>
        </div>
        <br></br>
        <br></br>
        <div className="loginRight">
          <div className="loginBox">
            <input name="email"  onChange={OnChange_Handler} placeholder="Email" className="loginInput" id="loginEmail"/>
            <input  name="password"  onChange={OnChange_Handler} placeholder="Password" className="loginInput" id="loginPassword"/>
            <button  className="loginButton" onClick={OnClick_Handler}>Log In</button>
            <Link to="/register"><button className="loginRegisterButton">
              Create a New Account
            </button></Link>
          </div>
        </div>
      </div>
    </div>
        </div>
    );
};

export default Login;