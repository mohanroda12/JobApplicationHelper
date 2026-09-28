function SignUpForm() {
    return(
    <div className="login-box">
        <form className="login-form" method="post">
            <h1>Login</h1>

            <label htmlFor="email">Email</label>
            <input type="text" id="email" name="username"/>

            <label htmlFor="password">Password</label>
            <input type="password" id="password" name="password"/>

            <input type="submit" value="Login" className="login-button"/>
            <a href="">Forgot password</a>
        </form>
    </div>
    )
}

export default SignUpForm