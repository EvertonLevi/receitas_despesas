import React from 'react'
import {
 BrowserRouter,
 Route,
 Switch,
 Redirect
} from 'react-router-dom'

import Auth from './auth'

import Logon from './pages/Logon'
import Register from './pages/Register'
import NovoLancamento from './pages/NovoLancamento'

// import PrivateRoute from '../src/PrivateRoute'


export default function Routes() {

 const PrivateRoute = ({ component: Component, ...rest }) => (
  <Route {...rest} render={props => (
   Auth.isAuthenticated() ? (
    <Component {...props} />
   ) : (
     <Redirect to={{ pathname: "/", state: { from: props.location } }} />
    )
  )} />
 )

 return (
  <BrowserRouter>
   <Switch>
    <Route path="/" exact component={Logon} />
    <Route path="/register" component={Register} />
    <PrivateRoute path="/novoLancamento" component={NovoLancamento} />
    <Redirect to="/404" />
   </Switch>
  </BrowserRouter>
 )
}