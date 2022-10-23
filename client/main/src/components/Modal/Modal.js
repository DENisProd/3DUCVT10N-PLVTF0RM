import React from 'react';
import './Modal.css';

const Modal = ({acitve, setActive, children}) => {
    return (
        <div className={acitve ? "modal active" : "modal"} onClick={() => setActive(false)}>
            <div className={acitve ? "modal__content active" : "modal__content"} onClick={e => e.stopPropagation()}>
                {children}
            </div>
        </div>
    );
};

export default Modal;