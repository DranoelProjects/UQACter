import '../App.css';
import React, {
    useState, 
    useEffect
} from 'react';
import { getConversation } from '../API';
import Moment from 'react-moment';
import { SendMessage } from '../components'
import {
    useHistory
  } from "react-router-dom";

const Conversation = () => {
    const username = window.localStorage.getItem('username');
    const receiver = window.localStorage.getItem('receiver');
    const [messages, setMessages] = useState([]);
    let isLoading = true;

    useEffect(() => { 
        getConversation(username, receiver).then((data) => {
            setMessages(data);
        });
    }, [username, receiver]);

    if(messages){
        isLoading = false;
    }

    const history = useHistory();
    const handleGoBack = () => {
        history.push("/conversations")
    }

    return (
        <div className="App">
            <div className="App-body">
                <div className="titleDiv">
                    <button className="btnBack" onClick={handleGoBack}>BACK</button>
                    <h2>Discussion avec {receiver}</h2>
                </div>
                {isLoading ? (
                    <div>
                        <p>Chargement de la conversation en cours</p>
                    </div>
                ):(
                    <div className="allMessages">
                        {messages.map(item => (
                            <div className="message" key={item.id}>
                                {item.emitter === username ? (
                                    <div className="emitter">
                                        <div className="messageInfo">
                                            <Moment date={item.date} format="YYYY/MM/DD hh:mm:ss"/>
                                            <p>De {item.emitter}</p>
                                        </div>
                                        <p className="messageContent">{item.text}</p>
                                    </div>
                                ) : (
                                    <div className="receiver">
                                        <div className="messageInfo">
                                            <Moment date={item.date} format="YYYY/MM/DD hh:mm:ss"/>
                                            <p>De {item.emitter}</p>
                                        </div>
                                        <p className="messageContent">{item.text}</p>
                                    </div>
                                )}
                            </div>
                        ))}
                        <SendMessage username={username} receiver={receiver} />
                    </div>
                )}
            </div>
        </div>
    );
};

export default Conversation;