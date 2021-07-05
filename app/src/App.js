import React from 'react';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";
import { Conversation, ConversationList, Login } from "./pages";

function App() {
  return (
      <Router>
        <Switch>
          <Route exact path="/" component={Login} />
          <Route exact path="/conversations" component={ConversationList} />
          <Route path="/conversations/:receiver" component={Conversation} />
        </Switch>
      </Router>
  );
}

export default App;
