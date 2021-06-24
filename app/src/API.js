const baseUrl = 'http://localhost:9001/users'

const postSettings = {
    method: 'POST',
    headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
    }
};

export const saveUser = async (username) =>{
    try {
        postSettings.body = JSON.stringify({username});
        const response = await fetch(`${baseUrl}/`, postSettings);
        //const data = await response.json();
        console.log(response);
    } catch (error) {
        console.error(error);
    }
}

// findUserById