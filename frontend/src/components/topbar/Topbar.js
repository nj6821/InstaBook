import React from 'react'
import './topbar.css'
import { Search,Person,Chat,Notifications} from '@material-ui/icons'
import { Link, useNavigate } from 'react-router-dom';

export default function Topbar() {
  return (
    <div className='topbarContainer'>
        <div className='topbarLeft'>
        <span className="logo">INSTA BOOK</span>
        </div>
        <div className='topbarCenter'>
            <div className='searchbar'>
                <Search/>
                <input placeholder='search friends' className='searchInput'/>

            </div>

        </div>
        <div className='topbarRight'>
            <div className='topbarLinks'>
                <span className='topbarLink'>HomePage</span>
                <span className='topbarLink'>Timeline</span>
            </div>
            <div className='topbarIcons'>
                <div className='topbarIconItem'>
                    <Person/>
                    <span className='topbarIconBadge'>1</span>
                </div>
                <div className='topbarIconItem'>
                    <Chat/>
                    <span className='topbarIconBadge'>1</span>
                </div>
                <div className='topbarIconItem'>
                    <Notifications/>
                    <span className='topbarIconBadge'>1</span>
                </div>
            </div>
            <Link to="/Profile"><img src="/assets/person/1.jpeg "  alt="" className="topbarImg"/></Link>
        </div>
      
    </div>
  )
}
