import "./CSS/TutorRegisterComponent.css";
import bgimage from "../Images/dakota-corbin-a-AWnRtwlWM-unsplash.jpg";
import GNavbar from "./GNavbar";
import { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate } from 'react-router-dom';
import Address from "./TutorAddress";


const TutorRegisterComponent = () => {

  var [newTutor, setNewTutor] = useState({
    email: "",
    password: "",
    firstName: "",
    lastName: "",
    mobileNo: "",
    gender: "",
    dob: "",
    experience: "",
    tagline: "",
    summary: "",
  });
  
  const handleChange = (event) => {
    console.log("in handle change");
    const {name,value} = event.target
    setNewTutor({...newTutor,[name]:value})
  };
  
  const navigate = useNavigate();

  const submitdata = () => {
    const obj = {"firstName" : newTutor.firstName,"lastName" : newTutor.lastName, 
    "mobileNo" : newTutor.mobileNo, "emailId" : newTutor.email, "password" : newTutor.password,
    "gender" : newTutor.gender ,"dob" : newTutor.dob, "totalExperience": newTutor.experience,
    "tagline": newTutor.tagline, "summary": newTutor.summary};
    console.log(obj);
    axios.post("http://localhost:8080/register/tutor",obj).then((res)=>{
      console.log(res.data);
      const jwt =  res.data.token;
      window.alert("Basic Details Added");
      const options = {
        method: 'GET',
        url: "http://localhost:8080/tutor/detailsbyemail/"+newTutor.email,
        headers: { Authorization: `Bearer ${jwt}` } 
      };
      axios.request(options).then((res)=>{
        console.log(res.data)
        sessionStorage.setItem("tutorjwtToken",jwt);
        sessionStorage.setItem("tutorId",res.data.tutorId);
      });
    });
    navigate("/tutor/address");
  }



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
                      <h3 className="mb-5 text-uppercase">
                        Tutor basic Details
                      </h3>
                      <div className="row">
                        <div className="col-md-6 mb-4">
                          <div className="form-outline">
                            <input
                              type="text"
                              id="firstName"
                              name="firstName"
                              className="form-control form-control-lg"
                              value={newTutor.firstName}
                              onChange={handleChange}
                            />
                            <label
                              className="form-label"
                              htmlFor="form3Example1m"
                            >
                              First name
                            </label>
                          </div>
                        </div>
                        <div className="col-md-6 mb-4">
                          <div className="form-outline">
                            <input
                              type="text"
                              id="lastName"
                              name="lastName"
                              className="form-control form-control-lg"
                              value={newTutor.lastName}
                              onChange={handleChange}
                            />
                            <label
                              className="form-label"
                              htmlFor="form3Example1n"
                            >
                              Last name
                            </label>
                          </div>
                        </div>
                      </div>

                      <div className="form-outline mb-4">
                        <input
                          type="email"
                          id="email"
                          name="email"
                          className="form-control form-control-lg"
                          value={newTutor.email}
                          onChange={handleChange}
                        />
                        <label className="form-label" htmlFor="form3Example8">
                          Email
                        </label>
                      </div>

                      <div className="form-outline mb-4">
                        <input
                          type="password"
                          id="password"
                          name="password"
                          className="form-control form-control-lg"
                          value={newTutor.password}
                          onChange={handleChange}
                        />
                        <label className="form-label" htmlFor="form3Example8">
                          Password
                        </label>
                      </div>

                      <div className="form-outline mb-4">
                        <input
                          type="text"
                          id="mobileNo"
                          name="mobileNo"
                          className="form-control form-control-lg"
                          value={newTutor.mobileNo}
                          onChange={handleChange}
                        />
                        <label className="form-label" htmlFor="form3Example8">
                          Mobile No.
                        </label>
                      </div>
                      <div
                        className="d-md-flex justify-content-start align-items-center mb-4 py-2"
                        onChange={handleChange}
                      >
                        <h6 className="mb-0 me-4">Gender: </h6>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <div className="form-check form-check-inline mb-0 me-4">
                          <input
                            className="form-check-input"
                            type="radio"
                            name="gender"
                            id="gender"
                            value="Female"
                          />
                          <label
                            className="form-check-label"
                            htmlFor="femaleGender"
                          >
                            Female
                          </label>
                        </div>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <div className="form-check form-check-inline mb-0 me-4">
                          <input
                            className="form-check-input"
                            type="radio"
                            name="gender"
                            id="gender"
                            value="Male"
                          />
                          <label
                            className="form-check-label"
                            htmlFor="maleGender"
                          >
                            Male
                          </label>
                        </div>
                      </div>

                      <div className="form-outline mb-4">
                        <input
                          type="text"
                          id="dob"
                          name="dob"
                          className="form-control form-control-lg"
                          value={newTutor.dob}
                          onChange={handleChange}
                        />
                        <label className="form-label" htmlFor="form3Example9">
                          DOB
                        </label>
                      </div>

                      <div className="form-outline mb-4">
                        <input
                          type="text"
                          id="tagline"
                          name="tagline"
                          className="form-control form-control-lg"
                          value={newTutor.tagline}
                          onChange={handleChange}
                        />
                        <label className="form-label" htmlFor="form3Example8">
                          Tagline
                        </label>
                      </div>

                      <div className="form-outline mb-4">
                        <input
                          type="text-area"
                          id="summary"
                          name="summary"
                          className="form-control form-control-lg"
                          value={newTutor.summary}
                          onChange={handleChange}
                        />
                        <label className="form-label" htmlFor="form3Example8">
                          Summary
                        </label>
                      </div>

                      <div className="form-outline mb-4">
                        <input
                          type="text"
                          id="experience"
                          name="experience"
                          className="form-control form-control-lg"
                          value={newTutor.experience}
                          onChange={handleChange}
                        />
                        <label className="form-label" htmlFor="form3Example8">
                          Experience
                        </label>
                      </div>
                      <div className="d-flex justify-content-center pt-3">
                        <button
                          type="button"
                          class="btn btn-warning btn-lg ms-2"
                          style={{ justifyContent: "center" }}
                          onClick={submitdata}
                        >
                          Next
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

export default TutorRegisterComponent;