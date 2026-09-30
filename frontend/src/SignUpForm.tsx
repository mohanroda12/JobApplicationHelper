import { useNavigate } from "react-router-dom";
const URL = "http://localhost:8080/api/v1/auth"

function SignUpForm() {

    const navigate = useNavigate()

    async function signUp( email: string, password: string, username: string) {
        try {
            const result = await fetch(
                `${URL}/signup`, {
                    method: "POST",
                    headers: {"Content-Type": "application/JSON"},
                    body: JSON.stringify({
                        email: email,
                        password: password,
                        username: username,
                    })
                }
            )
            if(!result.ok) {
                return
            }
            navigate("/login")
        }
        catch (err) {
            console.error(err)
        }
    }

    const handleSignupSubmit = (e: React.SubmitEvent) => {
        e.preventDefault()
        const data = new FormData(e.target)
        signUp(
            data.get("email") as string,
            data.get("password") as string,
            data.get("username") as string
        )
    }

    return(
    <div className="login-box">
        <form className="login-form" method="post" onSubmit={handleSignupSubmit}>
            <h1>Sign Up</h1>

            <label htmlFor="username">Name</label>
            <input type="text" id="username" name="username"/>

            <label htmlFor="email">Email</label>
            <input type="text" id="email" name="email"/>

            <label htmlFor="password">Password</label>
            <input type="password" id="password" name="password"/>

            <input type="submit" value="Sign Up" className="login-button"/>
            <a href="">Forgot password</a>
        </form>
    </div>
    )
}

export default SignUpForm