import './App.css';
import React, {
  useState,
} from 'react';
import { ConversationList } from './components'
import { saveUser } from './API';

function App() {
  const [username, setUsername] = useState("");
  const [hasUsername, setHasUsername] = useState(false);

  const handleSubmit = () => {
    setHasUsername(true);
    saveUser(username);
  }

  return (
    <div className="App">
      {hasUsername ? (
        <ConversationList username={username} />
      ) : (
        <header className="App-header">
          <form className="inputUsernameForm" onSubmit={handleSubmit}>
            <label>Identifiant :</label>
            <input type="text" name="username" onChange={e => setUsername(e.target.value)} />
            <input type="submit" value="Envoyer" />
          </form>
        </header>
      )}
    </div>
  );
}

export default App;
