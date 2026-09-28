import './style/nav.css'
import './style/style.css'
import NavBar from './NavBar.tsx'
import LoginForm from "./LoginForm.tsx";
import SignUpForm from "./SignUpForm.tsx";
import { BrowserRouter, Routes, Route } from "react-router-dom"

function App() {

  return(
      <BrowserRouter>
          <NavBar/>
          <Routes>
              <Route path="/login" element={<LoginForm/>}/>
              <Route path="/signup" element={<SignUpForm/>}/>
          </Routes>
      </BrowserRouter>
  )
}

export default App
