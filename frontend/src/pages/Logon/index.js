import React, { useState } from 'react'
import { Link } from 'react-router-dom'
import { FiLogIn } from 'react-icons/fi'
import styles from "./styles.css"

import ImgBG from '../../assets/image.svg'

export default function Logon() {
  const [id, setId] = useState("")
  const [email, setEmail] = useState("")
  const [senha, setSenha] = useState("")

  return (
    <div className={styles.logon_container}>
      <section className={styles.form}>
        {/* <img src={ImgBG} style={{ width: 50}} alt="Receitas e Despesas" /> */}

        <form
        // onSubmit={}
        >
          <h1>Faça seu login</h1>
          <input placeholder='Seu email...'
          // value={email}
          // onChange={e => setId(e.target.value)} 
          />
          <input placeholder='Sua senha...'
          // value={senha}
          // onChange={e => setId(e.target.value)} 
          />
          <button className="button" type="submit">Entrar</button>

          <Link className="back-link" to="/registrar" >
            <FiLogIn size={16} color="#6C63FF" />
      Não tenho cadastro
      </Link>
        </form>
      </section>
      <img src={ImgBG} style={{width: 560}} alt='Vector'></img>
    </div>
  )
}