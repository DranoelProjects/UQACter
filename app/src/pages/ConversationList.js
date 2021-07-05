import '../App.css';
import React, {
    useState, 
    useEffect
} from 'react';
import { getUserInterlocutors } from '../API';
import {
    Redirect,
    useHistory
  } from "react-router-dom";

const ConversationList = () => {
    const username = window.localStorage.getItem('username');
    const [interlocutors, setInterlocutors] = useState([]);
    const [receiver, setReceiver] = useState('');
    let isLoading = true;

    useEffect(() => {
        getUserInterlocutors(username).then((data) => {
            setInterlocutors(data);
        });
    }, [username]);

    if(interlocutors){
        isLoading = false;
    }

    const handleChangingReceiver = (e) => {
        window.localStorage.setItem('receiver', e.target.innerText);
        setReceiver(e.target.innerText);
    }

    const history = useHistory();
    const handleGoBack = () => {
        history.push("/")
    }

    return (
        <div className="App">
            <div className="App-body">
                <div className="titleDiv">
                    <button className="btnBack" onClick={handleGoBack}>BACK</button>
                    <h2>Connecté en tant que {username}</h2>
                </div>
                {isLoading ? (
                    <div>
                        <p>Chargement des conversations en cours</p>
                    </div>
                ):(
                    <div className="allConversations">
                        {receiver === '' ? (
                            <div>
                                {interlocutors.map(item => (
                                    <button className="btnConversation" onClick={handleChangingReceiver} key={item}>
                                        {item}
                                    </button>
                                ))}                      
                            </div> 
                        ) : (
                            <Redirect to={`/conversations/${receiver}`} />
                        )}

                    </div>
                )}
            </div>
        </div>
    );
};

export default ConversationList;