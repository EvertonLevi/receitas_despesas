import React, { useState } from 'react'
import { Link } from 'react-router-dom'
import { FiLogIn } from 'react-icons/fi'
import axios from 'axios'
import './styles.css'


import ImgBG from '../../assets/image.svg'

export default function Logon() {
  const [nome, setNome] = useState("")
  const [email, setEmail] = useState("")
  const [senha, setSenha] = useState("")
 
  return (
    <div className="logon_container">
      <section className="form">
        {/* TODO ta errado, isso é no Cadastro o createUser */}
        <form onSubmit={createUser}        >
          <h1>Faça seu login</h1>
          <input placeholder='Seu email...'
          // value={email}
          // onChange={e => setId(e.target.value)} 
          />
          <input placeholder='Sua senha...'
          // value={senha}
          // onChange={e => setId(e.target.value)} 
          />
          <button className="button"
            type="submit">Entrar</button>

          <Link className="back-link" to="/register" >
            <FiLogIn size={16} color="#6C63FF" />
      Não tenho cadastro
      </Link>
        </form>
      </section>

      <img src={ImgBG} style={{ width: 560 }} alt='MSI'></img>
    </div>
  )
}