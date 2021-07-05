const baseUrl = 'http://localhost:9191'

const putSettings = {
    method: 'PUT',
    headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
    }
};
const getSettings = {
    method: 'GET',
    headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
    }
};

const postSettings = {
    method: 'POST',
    headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
    }
};

export const saveUser = async (username) =>{
    try {
        putSettings.body = JSON.stringify({username});
        await fetch(`${baseUrl}/users/`, putSettings);
    } catch (error) {
        console.error(error);
    }
}

export const sendMessage = async (id, date, message, emitter, receiver) =>{
    try {
        postSettings.body = JSON.stringify({
            id,
            date,
            text: message,
            emitter,
            receiver,
        });
        await fetch(`${baseUrl}/messages/`, postSettings);
    } catch (error) {
        console.error(error);
    }
}

export const getUserInterlocutors = async (username) =>{
    try {
        const resp = await fetch(`${baseUrl}/messages/conversations/`+username, getSettings);
        const json = await resp.json();
        return json;
    } catch (error) {
        console.error(error);
    }
}
export const getConversation = async (user1, user2) =>{
    try {
        const resp = await fetch(`${baseUrl}/messages/`+user1+"/"+user2, getSettings);
        const json = await resp.json();
        return json;
    } catch (error) {
        console.error(error);
    }
}
export const listMessages = async () =>{
    try {
        const resp = await fetch(`${baseUrl}/messages/`);
        const json = await resp.json();
        return json;
    } catch (error) {
        console.error(error);
    }
}