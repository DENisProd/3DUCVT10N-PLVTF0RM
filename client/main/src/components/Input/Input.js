import React from 'react';
import styles from './Input.module.scss';

const Input = (props) => {

    const input = props?.useInput
    return (
        <>
            <input
                className={styles.inputForm}
                onChange={e => input?.onChange(e)}
                onBlur={e => input?.onBlur(e)}
                name={props.name}
                type={props?.type || "text"}
                placeholder={props.placeholder}
                value={input?.value}
                style={props.styles}
                min={props?.min}
                max={props?.max}/>
            {(input?.isDirty && (input?.isEmpty || input?.emailError || input?.minLengthError || input?.maxLengthError || input?.equalsError)) &&
                <div className="error_field">{input?.message}</div>}
        </>
    )
};


export default Input;
