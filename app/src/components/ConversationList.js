import React from 'react';
import PropTypes from 'prop-types';

const ConversationList = (props) => {
    const { username } = props;
    return (
        <div>
            <h1>Connecté en tant que {username}</h1>
        </div>
    );
};

ConversationList.propTypes = {
    username: PropTypes.string.isRequired,
};

export default ConversationList;