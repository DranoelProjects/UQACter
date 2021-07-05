import '../App.css';
import React, {
  useState,
} from 'react';
import logo from '../ressources/UQACter.png';
import { saveUser } from '../API';
import {
    Redirect
  } from "react-router-dom";

function App() {
  const [username, setUsername] = useState("");
  const [hasUsername, setHasUsername] = useState(false);
  const [hasError, setHasError] = useState(false);

  const handleSubmit = () => {
    if(username === ''){
        setHasError(true);
    } else {
        window.localStorage.setItem('username', username);
        saveUser(username);
        setHasUsername(true);
    }
  }

  return (
    <div className="App">
      {hasUsername ? (
          <Redirect to="/conversations" />
      ) : (
        <div className="App-body">
          <img src={logo} alt="Logo" />
          <h1>Veuillez saisir votre identifiant</h1>
          <form className="inputUsernameForm" onSubmit={handleSubmit}>
            <input className="inputFieldUsername" type="text" name="username" onChange={e => setUsername(e.target.value)} />
            <input className="btnSubmit" type="button" value="Connexion" onClick={handleSubmit}/>
          </form>
          {hasError && (<p className="error">Vous devez saisir un identifiant valide</p>)}
        </div>
      )}
    </div>
  );
}

export default App;
