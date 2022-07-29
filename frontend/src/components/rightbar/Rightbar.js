import React from 'react'
import './rightbar.css'
import { Users } from '../../dummyData'
export default function Rightbar() {
  return (
    <>
    <div className='ac-friend'>
      <h3>All Active Friends</h3>
    </div>
        
        <div className='fr-list'>
        {/* <h4 className="rightbarTitle">Friends</h4> */}
        </div>
        <div className='fr-profile'>
        <ul className="rightbarFriendList">
          {Users.map((u) => (
            <div key={u.id} className="friends">
              <img src={u.profilePicture} className="friendPic"/>
              <span className="friendnames">{u.username}</span>
            </div>
          ))}
        </ul>
        </div>
      </>
  )
}
