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

  const endpoint = "http://localhost:8080/authenticate"
  const endpointTest = "http://localhost:8080/testAuth"
  const proxyurl = "http://localhost:8080/";

  async function login(e) {
    e.preventDefault()

    const dataAuth = {
      password: setSenha(senha),
      userEmail: setEmail(email)
    }

    const token = Buffer.from(`${email}:${senha}`, 'utf-8').toString('base64')
    try {
      await axios.post(endpoint, dataAuth, {
        headers: {
          'Authorization': 'Basic ' + btoa(email + ':' + senha),
          // 'Authorization': `Basic ${token}`
        }
      })
        .then(res => {
          localStorage.setItem("authorization", res.data.token)
          history.push("/")
          return loginOK
        })
    } catch (error) {
      alert(error)
    }
  }

  async function loginOK() {
    axios.get(endpoint).then(res => {
      if (res.data === "success") {
        alert("Autenticação OOOOOOOOOOKKKKKKKKK")
        // this.props.history.push("/dashboard");
      } else {
        alert("Autenticação falhou!!!!!!!!!!!");
      }
    });
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
            type="password"
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