import bgimage from "../Images/annie-spratt-vGgn0xLdy8s-unsplash.jpg";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import GNavbar from "./GNavbar";

const TutorExperience = () => {
  var [experience, setExperience] = useState({
    numberOfYears: "",
    organisationName: "",
    field: "",
  });

  const handleChange = (event) => {
    console.log("in handle change");
    const { name, value } = event.target;
    setExperience({ ...experience, [name]: value });
  };

  const navigate = useNavigate();

  const addExperiences = () => {
    const obj = {
      "numberOfYears": experience.numberOfYears,
      "organisationName": experience.organisationName,
      "field": experience.field,
    };
    console.log(obj);
    const jwtToken = sessionStorage.getItem("tutorjwtToken");
    const tutorId = sessionStorage.getItem("tutorId");
    console.log(jwtToken+"\n"+tutorId);
    const options = {
      method: "POST",
      url: "http://localhost:8080/tutor/experience/" + tutorId,
      data: experience,
      headers: {
        Authorization: `Bearer ${jwtToken}`,
        "Content-Type": "application/json",
      },
    };
    axios.request(options).then((res) => {
      console.log(res.data);
      window.alert("Experiences Details Added \n Registration Successful \n Your Profile is Complete");
      navigate("/login");
    });
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
                      <h3 className="mb-5 text-uppercase">
                        Teaching Experience Details
                      </h3>
                      <div className="row">
                        <div className="col-md-6 mb-4">
                          <div className="form-outline">
                            <input
                              type="text"
                              id="numberOfYears"
                              name="numberOfYears"
                              className="form-control form-control-lg"
                              value={experience.numberOfYears}
                              onChange={handleChange}
                            />
                            <label
                              className="form-label"
                              htmlFor="form3Example1m"
                            >
                              Number of years
                            </label>
                          </div>
                        </div>
                        <div className="col-md-6 mb-4">
                          <div className="form-outline">
                            <input
                              type="text"
                              id="organisationName"
                              name="organisationName"
                              className="form-control form-control-lg"
                              value={experience.organisationName}
                              onChange={handleChange}
                            />
                            <label
                              className="form-label"
                              htmlFor="form3Example1n"
                            >
                              Organization name
                            </label>
                          </div>
                        </div>
                      </div>

                      <div className="form-outline mb-4">
                        <input
                          type="text"
                          id="field"
                          name="field"
                          className="form-control form-control-lg"
                          value={experience.field}
                          onChange={handleChange}
                        />
                        <label className="form-label" htmlFor="form3Example8">
                          Field
                        </label>
                      </div>
                      <div className="d-flex justify-content-center pt-3">
                        <button
                          type="button"
                          className="btn btn-warning btn-lg ms-2"
                          style={{ justifyContent: "center" }}
                          onClick={addExperiences}
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

export default TutorExperience;
