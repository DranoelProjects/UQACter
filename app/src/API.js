const baseUrl = 'http://localhost:9001/users'

const putSettings = {
    method: 'PUT',
    headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
    }
};

export const saveUser = async (username) =>{
    try {
        putSettings.body = JSON.stringify({username});
        await fetch(`${baseUrl}/`, putSettings);
    } catch (error) {
        console.error(error);
    }
}
