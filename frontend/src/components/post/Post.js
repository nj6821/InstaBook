import React, { useState } from 'react'
import './post.css'
import { MoreVert } from "@material-ui/icons";
import {Users} from "../../dummyData"

export default function Post(props) {
    
    const [like,setLike]=useState(props.post.like)
    const [isLike,setIsLike]=useState(false)

    const likeHandler=()=>{
        setLike(like+1)
        setIsLike(!isLike)
    }
    
   
  return (
    <div className='post'>
        <div className='postWrapper'>
            <div className='postTop'>
                <div className='postTopLeft'>
                    <img className='postProfileImg' src={Users.filter((u)=> u.id===props.post?.userId)[0].profilePicture} alt=''/>
                    <span className='postUserName'>{Users.filter((u)=> u.id===props.post?.userId)[0].username}</span>
                    <span className='postDate'>{props.post.date}</span>
                </div>
                <div className='postTopRight'>
                    <MoreVert/>
                </div>
            </div>
            <div className='postCenter'>
                <span className='postText'>{props.post?.desc}</span>
                <img className='postImg' src={props.post.photo}/>
            </div>
            <div className='postBottom'>
                <div className='postBottomLeft'>
                    <img className='likeIcon' src='assets/like.png' alt='' onClick={likeHandler}/>
                    <img className='likeIcon' src='assets/heart.png' alt='' onClick={likeHandler}/>
                    <span className='postLikeCounter'>{like} people like it</span>
                </div>
                <div className='postBottomRight'>
                    <span className='postCommentText'>{props.post.comment} comment</span>
                </div>
            </div>

        </div>
        
      
    </div>
  )
}
