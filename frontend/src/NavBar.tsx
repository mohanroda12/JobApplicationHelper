function NavBar() {
    return (
        <header className="nav-bar">
            <nav className="nav-left">
                <a className="nav-button home-button" href="/">Application Helper</a>
                <a className="nav-button" href="/applications">Applications</a>
                <a className="nav-button plus-button" href="/applications/addNew">
                    <span className="material-symbols-rounded">add</span>
                </a>
            </nav>

            <nav className="nav-right">
                <a href="/login" className="login-button">Login</a>
                <a href="/signup" className="login-button">Sign-up</a>
            </nav>

        </header>
    )
}

export default NavBar