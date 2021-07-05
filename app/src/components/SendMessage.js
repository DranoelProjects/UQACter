import React, {
    useState,
    useEffect
} from 'react';
import PropTypes from 'prop-types';
import { listMessages, sendMessage } from '../API';

const SendMessage = (props) => {
    const { username, receiver } = props;
    const [message, setMessage] = useState("");
    const [isLoading, setIsLoading] = useState(true);
    const [currentId, setCurrentId] = useState(0);

    useEffect(() => { 
        let messages = [];
        listMessages().then((data) => {
            messages = data;
            setCurrentId(messages[messages.length-1].id+1);
            setIsLoading(false);
        });
    }, [username, receiver]);

    const handleSubmit = () => {
        console.log(currentId);
        sendMessage(currentId, new Date(), message, username, receiver);
        setCurrentId(currentId+1);
    }

    return (
        <div>
            {isLoading ? (
                <p>Chargement en cours</p>
            ):(
                <form onSubmit={handleSubmit}>
                    <input className="inputFieldMessage" type="text" name="message" onChange={e => setMessage(e.target.value)} />
                    <input className="btnSendMessage" type="submit" value="Envoyer" />
                </form>
            )}

        </div>
    );
};

SendMessage.propTypes = {
    username: PropTypes.string.isRequired,
    receiver: PropTypes.string.isRequired,
};

export default SendMessage;