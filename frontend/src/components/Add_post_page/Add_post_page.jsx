import { responsiveFontSizes } from '@material-ui/core';
import React from 'react';
import { useState } from "react";
import './Add_post_page.css'
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';


function Add_post_page(props) {

    const [data, setData] = useState({ postTitle: "", postContent: "" });
    const Navigate = useNavigate()
    function OnChange_Handler(e)
    {
        e.preventDefault();
        const name = e.target.name
        const value = e.target.value
        setData({...data,[name]:value})
        
    }

    function onClickhandler(e){
        e.preventDefault();
        console.log(data)
        
        axios.post('https://quiet-shore-71950.herokuapp.com/api/postService/addpost',data)
        .then(res =>{
        
            console.log(res)
           //redirect to login page
        })

        alert("Post Submitted Successfully")
        Navigate("/Home1")

    }


    return (
        <div className='divb'>
               <div className='entire-post'>
        <h3>Your post</h3>
        <div className='title-div'>
            <input placeholder='Enter your post title' className='title' onChange={OnChange_Handler}/>
        </div>
        <div className='description-div'>
            <textarea className='description' rows='15' cols='50' placeholder='Your post Description' onChange={OnChange_Handler}/>
        </div>
        <div className='post-button-div'>
            <button className='post-button' onClick={onClickhandler}>Post</button>
        </div>
        </div>
        </div>
    );
}

export default Add_post_page;