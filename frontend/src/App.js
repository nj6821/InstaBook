import logo from './logo.svg';
import './App.css';
import {Person} from "@material-ui/icons"
import Login from './components/Login/Login'
import Register from './components/register/Register';
import Home from './components/pages/home/Home';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Profile from './components/Profile/Profile';
import Add_post_page from './components/Add_post_page/Add_post_page';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route exact path="/" element={<Login/>}/>
        <Route exact path="/register" element={<Register/>}/>
        <Route exact path="/Login" element={<Login/>}/>
        <Route exact path="/Home1" element={<Home/>}/> 
        <Route exact path="/Add_post_page" element={<Add_post_page/>}/> 
        <Route exact path="/Profile" element={<Profile/>}/>
      </Routes>
      
    </BrowserRouter>
  );
}

export default App;
