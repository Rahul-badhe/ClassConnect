import React from "react";
import GNavbar from "./GNavbar";
import bgimage from "../Images/shutterstock_download.jpg";
import "bootstrap";
import { MDBBtn } from "mdb-react-ui-kit";
import Button from "react-bootstrap/Button";
import './CSS/tutor.css'

const Tutor = () => {
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
                    <div className="col-xl-6">
                      <div className="card-body justify-content-center p-md-5 text-black">
                        <h3 className="mb-5 text-uppercase">Welcome</h3>
                        <div className="container-div">
                          <img
                            src={bgimage}
                          ></img>
                        </div>
                        <br></br>
                        <br></br>
                        <Button variant="dark" size="lg">Add courses </Button>
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

export default Tutor;
