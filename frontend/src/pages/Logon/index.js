import React, { useState } from 'react'
import { Link, useHistory } from 'react-router-dom'
import { FiLogIn } from 'react-icons/fi'
import axios from 'axios'
import './styles.css'

import Auth from '../../auth'



import ImgBG from '../../assets/image.svg'

export default function Logon() {
  const [email, setEmail] = useState("")
  const [senha, setSenha] = useState("")
  const [hasLoginFailed, setHasLoginFailed] = useState(false)
  const [showSuccessMessage, setShowSuccessMessage] = useState(false)

  const history = useHistory()

  const endpoint = "http://localhost:8080"
  const endpointTest = "http://localhost:8080/testAuth"
  const proxyurl = "http://localhost:8080/";

  function logout() {
    localStorage.removeItem("user")
  }

  async function login(e) {
    e.preventDefault()
    try {
      await axios("http://localhost:8080", {
        method: "POST",
        headers: {
          'Access-Control-Allow-Origin': '*',
          'Access-Control-Allow-Methods': 'GET, POST',
          'Access-Control-Allow-Headers': ' Origin, Content-Type, X-Auth-Token'
        },
        auth: {
          email: email,
          senha: senha
        }
      })
        .then((response) => {
          console.log(response)
          localStorage.setItem("user", JSON.stringify(response.data))
        })
      // await axios.post("http://localhost:8080", { email, senha }, {
      //   headers: {
      //     'Authorization': 'Basic ' + btoa(email + ':' + senha),
      //   }
      // })
      //   .then(res => {
      //     localStorage.setItem("authorization", res.data.token)
      //     history.push("/novoLancamento")
      //     alert("VOcê está logado!!" + window.localStorage.toString())
      //   })
    } catch (error) {
      alert(error)
    }
  }

  function logonSubmit() {
    Auth.executeBasicAuthenticationService(email, senha)
      .then(() => {
        Auth.registerSuccessfulLogin(email, senha)
        // history.push("/novoLancamento")
        alert("Você está logado")
        console.log(Auth.createBasicAuthToken)
      }).catch((error) => {
        setShowSuccessMessage(false)
        setHasLoginFailed(true)
        alert("Deu erro: " + error)
      })

    // Auth.executeJwtAuthenticationService(email, senha)
    //   .then((response) => {
    //     Auth.registerSuccessfulLoginForJwt(email, senha)
    //     history.push('/novoLancamento')
    //   }).catch(() => {
    //     setShowSuccessMessage(false)
    //     setHasLoginFailed(true)
    //   })
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
            type="email"
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