import { useState } from "react";
import bgimage from "../Images/himal-rana-HdVeYMcIzfw-unsplash.jpg";
import GNavbar from "./GNavbar";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const TutorQualification = () => {
  var [qualification, setQualification] = useState({
    stream: "",
    level: "",
    board: "",
    passingYear: "",
  });

  const handleChange = (event) => {
    console.log("in handle change");
    const { name, value } = event.target;
    setQualification({ ...qualification, [name]: value });
  };

  const navigate = useNavigate();

  const addQualification = () => {
    const obj = {
      "stream": qualification.stream,
      "level": qualification.level,
      "board": qualification.board,
      "passingYear": qualification.passingYear
    };
    console.log(obj);
    const jwtToken = sessionStorage.getItem("tutorjwtToken");
    const tutorId = sessionStorage.getItem("tutorId");
    const options = {
      method: "POST",
      url: "http://localhost:8080/tutor/qualificationdetails/" + tutorId,
      data: qualification,
      headers: {
        Authorization: `Bearer ${jwtToken}`,
        "Content-Type": "application/json",
      },
    };
    axios.request(options).then((res) => {
      console.log(res.data);
      window.alert("Qualification Details Added");
      navigate("/tutor/experiences");
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
                        Tutor Qualification Details
                      </h3>
                      <div className="row">
                        <div className="form-outline mb-4">
                          <div className="form-outline">
                            <input
                              type="text"
                              id="stream"
                              name="stream"
                              className="form-control form-control-lg"
                              value={qualification.stream}
                              onChange={handleChange}
                            />
                            <label
                              className="form-label"
                              htmlFor="form3Example1m"
                            >
                              Stream
                            </label>
                          </div>
                        </div>
                        <div className="form-outline mb-4">
                          <div className="form-outline">
                            <input
                              type="text"
                              id="level"
                              name="level"
                              className="form-control form-control-lg"
                              value={qualification.level}
                              onChange={handleChange}
                            />
                            <label
                              className="form-label"
                              htmlFor="form3Example1n"
                            >
                              Level
                            </label>
                          </div>
                        </div>
                      </div>

                      <div className="form-outline mb-4">
                        <input
                          type="text"
                          id="board"
                          name="board"
                          className="form-control form-control-lg"
                          value={qualification.board}
                          onChange={handleChange}
                        />
                        <label className="form-label" htmlFor="form3Example8">
                          Board
                        </label>
                      </div>

                      <div className="form-outline mb-4">
                        <input
                          type="number"
                          id="passingYear"
                          name="passingYear"
                          className="form-control form-control-lg"
                          value={qualification.passingYear}
                          onChange={handleChange}
                        />
                        <label className="form-label" htmlFor="form3Example8">
                          Passing Year
                        </label>
                      </div>

                      <div className="d-flex justify-content-center pt-3">
                        <button
                          type="button"
                          className="btn btn-warning btn-lg ms-2"
                          style={{ justifyContent: "center" }}
                          onClick={addQualification}
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
export default TutorQualification;