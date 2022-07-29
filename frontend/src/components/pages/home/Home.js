import React from 'react'
import Feed from '../../feed/Feed'
import Rightbar from '../../rightbar/Rightbar'
import Sidebar from '../../sidebar/Sidebar'
import Topbar from '../../topbar/Topbar'
import './home.css'

export default function Home() {
  return (
    <div>
      <Topbar/>
      <div className='homeContainer'>
        <Sidebar/>
        <Feed/>
        <Rightbar/>
      </div>
    </div>
  )
}
