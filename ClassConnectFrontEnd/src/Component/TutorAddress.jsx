import { useState } from "react";
import bgimage from "../Images/timothy-eberly-1mPBkYvbu3w-unsplash.jpg";
import GNavbar from "./GNavbar";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const TutorAddress = () => {
  var [address, setAddress] = useState({
    addressLine1: "",
    addressLine2: "",
    city: "",
    district: "",
    state: "",
    pincode: "",
  });

  const handleChange = (event) => {
    console.log("in handle change");
    const { name, value } = event.target;
    setAddress({ ...address, [name]: value });
  };

  const navigate = useNavigate();

  const addAddress = () => {
    const obj = {
      "addressLine1": address.addressLine1,
      "addressLine2": address.addressLine2,
      "city": address.city,
      "district": address.district,
      "state": address.state,
      "pincode": address.pincode,
    };
  
    console.log(obj);
    const jwtToken = sessionStorage.getItem("tutorjwtToken");
    const tutorId = sessionStorage.getItem("tutorId");
    const options = {
      method: "POST",
      url: "http://localhost:8080/tutor/address/" + tutorId,
      data: address,
      headers: {
        Authorization: `Bearer ${jwtToken}`,
        "Content-Type": "application/json",
      },
    };
    axios.request(options).then((res) => {
      console.log(res.data);
      window.alert("Address Details Added");
      navigate("/tutor/qualificationdetails");
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
                      <h3 className="mb-5 text-uppercase">Address Details</h3>
                        <div className="form-outline mb-4">
                          <div className="form-outline">
                            <input
                              type="text-area"
                              id="addressLine1"
                              name="addressLine1"
                              className="form-control form-control-lg"
                              value={address.addressLine1}
                              onChange={handleChange}
                            />
                            <label
                              className="form-label"
                              htmlFor="form3Example1m"
                            >
                              Address Line1
                            </label>
                          </div>
                        </div>
                        <div className="form-outline mb-4">
                          <div className="form-outline">
                            <input
                              type="text-area"
                              id="addressLine2"
                              name="addressLine2"
                              className="form-control form-control-lg"
                              value={address.addressLine2}
                              onChange={handleChange}
                            />
                            <label
                              className="form-label"
                              htmlFor="form3Example1n"
                            >
                              Address Line2
                            </label>
                          </div>
                        </div>
                      
                      <div className="row">
                        <div className="col-md-6 mb-4">
                          <input
                            type="text"
                            id="city"
                            name="city"
                            className="form-control form-control-lg"
                            value={address.city}
                            onChange={handleChange}
                          />
                          <label className="form-label" htmlFor="form3Example8">
                            City
                          </label>
                        </div>

                        <div className="col-md-6 mb-4">
                          <input
                            type="text"
                            id="district"
                            name="district"
                            className="form-control form-control-lg"
                            value={address.district}
                            onChange={handleChange}
                          />
                          <label className="form-label" htmlFor="form3Example8">
                            District
                          </label>
                        </div>
                      </div>

                      <div className="form-outline mb-4">
                        <input
                          type="text"
                          id="state"
                          name="state"
                          className="form-control form-control-lg"
                          value={address.state}
                          onChange={handleChange}
                        />
                        <label className="form-label" htmlFor="form3Example8">
                          State
                        </label>
                      </div>

                      <div className="form-outline mb-4">
                        <input
                          type="text"
                          id="pincode"
                          name="pincode"
                          className="form-control form-control-lg"
                          value={address.pincode}
                          onChange={handleChange}
                        />
                        <label className="form-label" htmlFor="form3Example8">
                          Pin Code
                        </label>
                      </div>

                      <div className="d-flex justify-content-center pt-3">
                        <button
                          type="button"
                          class="btn btn-warning btn-lg ms-2"
                          style={{ justifyContent: "center" }}
                          onClick={addAddress}
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

export default TutorAddress;