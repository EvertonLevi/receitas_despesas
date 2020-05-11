import React, { useState } from 'react'
import { Link, useHistory } from 'react-router-dom'
import { FiLogIn } from 'react-icons/fi'
import axios from 'axios'
import './styles.css'



import ImgBG from '../../assets/image.svg'

export default function Logon() {
  const [nome, setNome] = useState("")
  const [email, setEmail] = useState("")
  const [senha, setSenha] = useState("")
  const history = useHistory()

  async function login(e) {
    e.preventDefault()
    const data = {
      nome, email, senha
    }

    const token = Buffer.from(`${email}:${senha}`, 'utf-8').toString('base64')

    try {
      let response = await axios.post("http://localhost:8080/getUser",
        {
          headers: {
            // 'Authorization': 'Basic ' + btoa(email + ':' + senha),
            'Authorization': `Basic ${token}`
          }
        }, {
        auth: {
          email: email,
          senha: senha
        }
      })
      console.log(response)
      // history.push("/")
    } catch (error) {
      alert(error)
    }
  }

  return (
    <div className="logon_container">
      <section className="form">
        {/* TODO ta errado, isso é no Cadastro o createUser */}
        <form
          onSubmit={login}
        >
          <h1>Faça seu login</h1>
          <input placeholder='Seu email...'
            value={email}
            onChange={e => setEmail(e.target.value)}
          />
          <input placeholder='Sua senha...'
            value={senha}
            onChange={e => setSenha(e.target.value)}
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