import {useNavigate} from "react-router-dom";
import {useState} from "react";

const URL = "http://localhost:8080/api/v1/auth"


function LoginForm() {


    const navigate = useNavigate()
    const[error, setError] = useState("")

    async function login(email: string, password: string) {

        try {
            const result = await fetch(
                `${URL}/login`, {
                    method: "POST",
                    headers: {"Content-type": "application/JSON"},
                    body: JSON.stringify({
                        email: email,
                        password: password
                    })
                }
            )
            if(!result.ok) {
                const error_data = await result.json()
                setError(error_data.error)
                return
            }
            navigate("/applications")
        }
        catch(err) {
            console.error(err)
        }
    }

    const handleLoginInput = async (e: React.SubmitEvent) => {
        e.preventDefault()
        const data = new FormData(e.target)
        await login(
            data.get("email") as string,
            data.get("password") as string,
        )
    }

    return(
    <div className="login-box">
        <form className="login-form" method="post" onSubmit={handleLoginInput}>
            <h1>Login</h1>

            <label htmlFor="email">Email</label>
            <input type="text" id="email" name="email"/>

            <label htmlFor="password">Password</label>
            <input type="password" id="password" name="password"/>

            <p className="login-alert">{error}</p>
            <input type="submit" value="Login" className="login-button"/>
            <a href="">Forgot password</a>
        </form>
    </div>
    )
}

export default LoginForm