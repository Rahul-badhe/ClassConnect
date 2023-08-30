import bgimage from "../Images/artem-maltsev-0CvHQ62gwY8-unsplash.jpg";
import { ReactDOM } from "react";
import GNavbar from "./GNavbar";
import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import {
  loadCaptchaEnginge,
  validateCaptcha,
  LoadCanvasTemplate,
} from "react-simple-captcha";
import swal from "sweetalert";
import jwtDecode from "jwt-decode";

const LoginComponent = () => {
  const [data, setData] = useState({
    email: "",
    password: "",
  });
  const [passType, setPassType] = useState("text");
  const [isChecked, setIsChecked] = useState(false);

  useEffect(() => {
    loadCaptchaEnginge(6, "grey", "black", "upper");
  }, []);
  const handleShowPassword = () => {
    setIsChecked(!isChecked);
  };
  useEffect(() => {
    if (isChecked == true) {
      setPassType("text");
      return;
    }
    setPassType("password");
  }, [isChecked]);

  const changeHandler = (e) => {
    setData((data) => ({
      ...data,
      [e.target.name]: e.target.value,
    }));
  };

  const navigate = useNavigate();

  const submitData = (e) => {
    if (data.email == "") {
      alert("Username cannot be null");
      return;
    }
    if (data.password == "") {
      alert("Password cannot be null");
      return;
    }
    e.preventDefault();

    let user_captcha = document.getElementById("user_captcha_input").value;

    if (validateCaptcha(user_captcha) === true) {
      // if(true){
      //    alert('Captcha Matched');
      //    loadCaptchaEnginge(6);
      const obj = { emailId: data.email, password: data.password };
      axios
        .post("http://localhost:8080/authenticate", obj)
        .then((response) => {
          console.log(response.data);
          const jwt = response.data.token;
          const user = jwtDecode(jwt);
          console.log(user);
          const options = {
            method: 'GET',
            url: "http://localhost:8080/authenticate/getlogin/"+user.sub,
            headers: { Authorization: `Bearer ${jwt}` } 
          };
          axios.request(options).then((res)=>{
            const role = res.data.userRole;
            console.log(role)
            if (role.includes("ROLE_STUDENT")) {
              sessionStorage.setItem("student", jwt);
              navigate(`/student`);
            }
            if (role.includes("ROLE_TUTOR")) {
              sessionStorage.setItem("tutor", jwt);
              navigate(`/tutor`);
            }
            if (role.includes("ROLE_ADMIN")) {
              sessionStorage.setItem("admin", jwt);
              navigate(`/admin`);
            }
          })
        })
        .catch((err) => {
          swal(
            "Wrong Details",
            "Enter Correct Details again, Make Sure you are register before Login",
            "error"
          );
        });
    } else {
      swal("Captcha Does Not Match !", "Enter Correct Captcha", "error");
      // document.getElementById('user_captcha_input').value = "";
    }
  };

  return (
    <div>
      <GNavbar />
      <section className="h-100 bg-dark">
        <div className="container py-5 h-100">
          <div className="row d-flex justify-content-center align-items-center h-100">
            <div className="col">
              <div className="card card-registration my-4">
                <div className="row g-0">
                  <div className="col-xl-6 d-none d-xl-block">
                    <img
                      src={bgimage}
                      alt="Sample photo"
                      className="img-fluid"
                      style={{
                        borderTopLeftRadius: ".25rem",
                        borderTopLeftRadius: ".25rem",
                      }}
                    />
                  </div>
                  <div className="col-xl-6">
                    <div className="card-body p-md-5 text-black">
                      <h3 className="mb-5 text-uppercase">Login</h3>

                      <div className="form-outline mb-4">
                        <input
                          type="email"
                          id="email"
                          name="email"
                          className="form-control form-control-lg"
                          value={data.email}
                          onChange={changeHandler}
                        />
                        <label className="form-label" htmlFor="form3Example8">
                          Email
                        </label>
                      </div>

                      <div className="form-outline mb-4">
                        <input
                          type={passType}
                          id="password"
                          name="password"
                          className="form-control form-control-lg"
                          value={data.password}
                          onChange={changeHandler}
                        />

                        <label className="form-label" htmlFor="form3Example8">
                          Password
                        </label>
                        <br></br>
                        <span>
                          <input
                            type="checkbox"
                            checked={isChecked}
                            onChange={handleShowPassword}
                            id="show"
                          ></input>
                          &emsp;
                        </span>
                        <label htmlFor="show">Show Password</label>
                      </div>
                      <div className="form-outline mb-4">
                        <LoadCanvasTemplate />
                      </div>
                      <div className="form-outline mb-4">
                        <label> Enter Captcha </label>
                        <input
                          type="text"
                          id="user_captcha_input"
                          name="user_captcha_input"
                          className="form-control form-control-lg"
                        />
                      </div>
                      <div className="d-flex justify-content-center pt-3">
                        <button
                          type="button"
                          className="btn btn-warning btn-lg ms-2"
                          onClick={submitData}
                        >
                          Submit
                        </button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
};

export default LoginComponent;
