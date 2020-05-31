import React, { useState } from 'react'
import { Link, useHistory } from 'react-router-dom'
import { FiLogIn } from 'react-icons/fi'
import axios from 'axios'
import './styles.css'
import img from "../assets/image.png"
import Auth from '../../auth'


export default function Header(props) {

 return (
  <div className="header-container navbar">
   <img src={img} style={{ width: 20 }} alt='marca'></img>
   <div>
    <ul>
     <li>
      <a href="#">Home</a>
     </li>
     <li>
      <a href="#">Features</a>
     </li>
     <li>
      <a href="#">Pricing</a>
     </li>
    </ul>
   </div>
   <h1>HEADER CONTAINER</h1>
   <div>
    {/* criar componente Avatar com opções de settings e logout */}
    <img src={img} style={{ width: 20 }} alt='marca'></img>
   </div>
  </div>
 )
}