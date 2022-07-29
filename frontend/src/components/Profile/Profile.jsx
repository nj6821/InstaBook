import React from 'react';
import "./Profile.css"
// import logo from '/Users/abhishek.mishra4/my-frontend-social/src/Images/10.jpeg';
// import logo1 from '/Users/abhishek.mishra4/my-frontend-social/src/Images/3.jpeg';
// import logo2 from '/Users/abhishek.mishra4/my-frontend-social/src/Images/5.jpeg';
// import logo3 from '/Users/abhishek.mishra4/my-frontend-social/src/Images/6.jpeg';
// import logo4 from '/Users/abhishek.mishra4/my-frontend-social/src/Images/3.jpeg';
// import logo5 from '/Users/abhishek.mishra4/my-frontend-social/src/Images/3.jpeg';
// import logo6 from '/Users/abhishek.mishra4/my-frontend-social/src/Images/3.jpeg';
import { Link, useNavigate } from 'react-router-dom';


function Profile(props) {
    return (
        
        <div className='maindiv'>
            <div className='nddiv'>
                <div className='imagediv'>
                    <img className='Image' src="assets/person/3.jpeg" />
                </div>
                <div className='nddiv3'>
                    <h4>Abhishek</h4>
                    <div className='nddiv2'>
                        <h5>40 Posts</h5>
                        <h5>40 Friends</h5>
                        <h5>40 Followers</h5>
                        <Link to="/Home1"><button > Home</button></Link>
                    </div>
                </div>
                
            </div>
            <br></br>
            <br></br>
            <div className="gallery">
                <img className='Image1' src="assets/person/1.jpeg" />
                
                <img className='Image1' src="assets/person/1.jpeg" />
            
                <img className='Image1' src="assets/person/3.jpeg" />
                
                <img className='Image1' src="assets/person/1.jpeg" />

                <img className='Image1' src="assets/person/5.jpeg" />

                <img className='Image1' src="assets/person/6.jpeg" />
                <img className='Image1' src="assets/person/5.jpeg" />
                <img className='Image1' src="assets/person/3.jpeg" />
                
                
            </div>
            

            
        </div>
        
    );
}

export default Profile;