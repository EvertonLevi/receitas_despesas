
// retornando true liberar as rotas
// false só login e register
import axios from 'axios'

const API_URL = 'http://localhost:8080'

export const USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'

class Auth {




  executeBasicAuthenticationService(email, senha) {
    // return axios.get(`${API_URL}/authenticate`,
    return axios.get(`${API_URL}`,
      {
        headers: {
          authorization: this.createBasicAuthToken(email, senha)
          .match().map((res) => {
            this.registerSuccessfulLogin(email, senha)
          })
        }
      })
  }

  createBasicAuthToken(email, senha) {
    return 'Basic ' + window.btoa(email + ":" + senha)
  }

  registerSuccessfulLogin(email, senha) {
    //let basicAuthHeader = 'Basic ' +  window.btoa(email + ":" + senha)
    //console.log('registerSuccessfulLogin')
    sessionStorage.setItem(USER_NAME_SESSION_ATTRIBUTE_NAME, email)
    this.setupAxiosInterceptors(this.createBasicAuthToken(email, senha))
  }

  executeJwtAuthenticationService(email, senha) {
    console.log(email);
    return axios.post(`${API_URL}`, {
      email,
      senha
    })
  }

  registerSuccessfulLoginForJwt(email, token) {
    sessionStorage.setItem(USER_NAME_SESSION_ATTRIBUTE_NAME, email)
    this.setupAxiosInterceptors(this.createJWTToken(token))
  }

  createJWTToken(token) {
    return 'Bearer ' + token
  }


  logout() {
    sessionStorage.removeItem(USER_NAME_SESSION_ATTRIBUTE_NAME);
  }

  isAuthenticated() {
    let user = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return false
    return true
  }
  // isAuthenticated = () => true

  isUserLoggedIn() {
    let user = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return false
    return true
  }

  getLoggedInemail() {
    let user = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return ''
    return user
  }

  setupAxiosInterceptors(token) {
    axios.interceptors.request.use(
      (config) => {
        if (this.isAuthenticated()) {
          config.headers.authorization = token
        }
        return config
      }
    )
  }

}

export default new Auth()