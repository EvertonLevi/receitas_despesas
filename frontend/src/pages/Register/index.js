import React, { useState } from 'react'
import './styles.css'
import { Link, useHistory } from 'react-router-dom'
import { FiArrowLeft } from 'react-icons/fi'
import axios from 'axios'
import ImgBG from '../../assets/image.svg'



export default function Register() {
  const history = useHistory()
  const [nome, setNome] = useState("")
  const [email, setEmail] = useState("")
  const [senha, setSenha] = useState("")

  async function createUser(e) {
    e.preventDefault()
    const data = {
      nome, email, senha
    }
    alert(data.nome)

    try {
      await axios.post("http://localhost:8080/createUser", {
        nome: nome,
        email: email,
        senha: senha,
      })
      alert(data.nome + " | " + data.email)
      history.push("/")//de volta p home
    } catch (error) {
      alert(error)
    }
  }

  return (
    <div className="register-container">
      <div className='content'>
        <section>
          <img src={ImgBG} style={{ width: 460 }} alt='MSI'></img>
          <Link className="back-link" to="/" >
            <FiArrowLeft size={16} color="#6C63FF" />
      Já tenho cadastro
      </Link>
        </section>

        <form
          onSubmit={createUser}
        >
          <h1>Faça seu cadastro</h1>
          <p>Faça seu cadastro, entre na plataforma e gerencie de forma fácil suas despesas e receitas!</p>

          <input placeholder="Seu nome..." name="nome"
            value={nome}
            onChange={e => setNome(e.target.value)}
          />

          <input type="email" placeholder="Seu e-mail..." name="email"
            value={email}
            onChange={e => setEmail(e.target.value)}
          />

          <input type="password" placeholder="Sua senha..." name="senha"
            value={senha}
            onChange={e => setSenha(e.target.value)}
          />
          <button className="button"
            type="submit">Cadastrar</button>
        </form>

      </div>
    </div>
  )
}