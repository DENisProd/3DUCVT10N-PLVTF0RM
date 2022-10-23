import {useEffect, useState} from "react";

const useValidation = (value, validations) => {
    const [isEmpty, setEmpty] = useState(true)
    const [minLengthError, setMinLengthError] = useState(false)
    const [maxLengthError, setMaxLengthError] = useState(false)
    const [emailError, setEmailError] = useState(false)
    const [equalsError, setEqualsError] = useState(false)
    const [message, setMessage] = useState('')

    useEffect(() => {
        for (const validation in validations) {
            switch (validation) {
                case 'minLength':
                    if(value.length < validations[validation]) {
                        setMinLengthError(true)
                        setMessage('Некорректная длина')
                    } else {
                        setMinLengthError(false)
                        //setMessage('')
                    }
                    break
                case 'isEmpty':
                    if (value) {
                        setEmpty(false)
                        setMessage('Поле не должно быть пустым')

                    } else {
                        setEmpty(true)
                        //setMessage('')
                    }
                    break
                case 'maxLength':
                    if (value.length > validations[validation]) {
                        setMaxLengthError(true)
                        setMessage('Некорректная длина')
                    } else {
                        setMaxLengthError(false)
                    }
                    break
                case 'isEmail':
                    const re = /^(([^<>()[\].,;:\s@"]+(\.[^<>()[\].,;:\s@"]+)*)|(".+"))@(([^<>()[\].,;:\s@"]+\.)+[^<>()[\].,;:\s@"]{2,})$/i;
                    if (re.test(String(value).toLowerCase())) {

                        setEmailError(false)
                    } else {
                        setEmailError(true);
                        setMessage("Некорректный email")
                    }
                    break
                case 'isEquals':
                    if (value === validations[validation]) {
                        setEqualsError(false)
                    } else {
                        setEqualsError(true)
                        setMessage('Пароли не совпадают')
                    }
                    break
            }
        }
    }, [value])

    return {
        isEmpty,
        minLengthError,
        maxLengthError,
        emailError,
        equalsError,
        message
    }
}

export default function useInput (initialValue, validations) {
    const [value, setValue] = useState(initialValue)
    const [isDirty, setDirty] = useState(false)
    const valid = useValidation(value, validations)

    const onChange = (e) => {
        setValue(e.target.value)
    }

    const onBlur = (e) => {
        setDirty(true)
    }

    return {
        value,
        onChange,
        onBlur,
        isDirty,
        ...valid
    }

}
