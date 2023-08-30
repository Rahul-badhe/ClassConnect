import React from "react";
import {
  MDBFooter,
  MDBContainer,
  MDBIcon,
  MDBInput,
  MDBCol,
  MDBRow,
  MDBBtn,
} from "mdb-react-ui-kit";
import { MDBFormInline } from "mdbreact";
import mainlogo from "./Logos/ClassConnect.jpg";
import "bootstrap/dist/css/bootstrap.min.css";
import { Navbar, Container, Nav, NavDropdown } from "react-bootstrap";
import logocss from "./CSS/logo.css";
import navbarcss from "./CSS/navbar.css";
import "./CSS/landing.css";
import GNavbar from "./GNavbar";

const Landing = () => {
  return (
    <div>
      <div className="landing">
        <GNavbar />
        {/* <img src={bgimage} style={{height:"80%",width:"100%"}}></img> */}
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <form
          class="example"
          action="/action_page.php"
          style={{ margin: "auto", maxWidth: "60%" }}
        >
          <input
            type="text"
            placeholder="Enter any subject, stream, level"
            name="search2"
          ></input>
          <button type="submit">
            <i class="fa fa-search"></i>
          </button>
        </form>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
      </div>
      <MDBFooter
        color="white-50"
        bgColor="dark"
        className="text-center text-lg-start text-muted"
      >
        <section className="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
          <div className="me-5 d-none d-lg-block">
            <span>Get connected with us on social networks:</span>
          </div>

          <div>
            <a href="" className="me-4 text-reset">
              <MDBIcon fab icon="facebook-f" />
            </a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="" className="me-4 text-reset">
              <MDBIcon fab icon="twitter" />
            </a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="" className="me-4 text-reset">
              <MDBIcon fab icon="google" />
            </a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="" className="me-4 text-reset">
              <MDBIcon fab icon="instagram" />
            </a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="" className="me-4 text-reset">
              <MDBIcon fab icon="linkedin" />
            </a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="" className="me-4 text-reset">
              <MDBIcon fab icon="github" />
            </a>
          </div>
        </section>

        <section className="">
          <MDBContainer className="text-center text-md-start mt-5">
            <MDBRow className="mt-3">
              <MDBCol md="3" lg="4" xl="3" className="mx-auto mb-4">
                <h6 className="text-uppercase fw-bold mb-4">
                  <MDBIcon icon="gem" className="me-3" />
                  &nbsp;&nbsp;&nbsp;&nbsp; ClassConnect
                </h6>
                <p>
                Technology will never replace great teachers, but in the hands of great teachers, it’s transformational.
                ClassConnect is here to support you on every step of your educational journey.
                </p>
              </MDBCol>

              <MDBCol md="2" lg="2" xl="2" className="mx-auto mb-4">
                <h6 className="text-uppercase fw-bold mb-4">Popular Courses</h6>
                <p>
                  <a href="#!" className="text-reset">
                    Angular
                  </a>
                </p>
                <p>
                  <a href="#!" className="text-reset">
                    React
                  </a>
                </p>
                <p>
                  <a href="#!" className="text-reset">
                    Vue
                  </a>
                </p>
                <p>
                  <a href="#!" className="text-reset">
                    Laravel
                  </a>
                </p>
              </MDBCol>

              <MDBCol md="3" lg="2" xl="2" className="mx-auto mb-4">
                <h6 className="text-uppercase fw-bold mb-4">Useful links</h6>
                {/* <p>
                <a href='#!' className='text-reset'>
                  Login
                </a>
              </p> */}
                <p>
                  <a href="#!" className="text-reset">
                    Privacy Policy
                  </a>
                </p>
                <p>
                  <a href="#!" className="text-reset">
                    Contact us
                  </a>
                </p>
                {/* <p>
                <a href='#!' className='text-reset'>
                  
                </a>
              </p> */}
              </MDBCol>

              <MDBCol md="4" lg="3" xl="3" className="mx-auto mb-md-0 mb-4">
                <h6 className="text-uppercase fw-bold mb-4">Contact</h6>
                <p>
                  <MDBIcon icon="home" className="me-2" />
                  &nbsp;&nbsp;&nbsp;&nbsp; Pune, MH 411044, IN
                </p>
                <p>
                  <MDBIcon icon="envelope" className="me-3" />
                  &nbsp;&nbsp;&nbsp;&nbsp; admin@gmail.com
                </p>
                <p>
                  <MDBIcon icon="phone" className="me-3" />
                  &nbsp;&nbsp;&nbsp;&nbsp; +91 9834688441
                </p>
                <p>
                  <MDBIcon icon="print" className="me-3" />
                  &nbsp;&nbsp;&nbsp;&nbsp; +91 8623946832
                </p>
              </MDBCol>
            </MDBRow>
          </MDBContainer>
        </section>

        <div
          className="text-center p-4"
          style={{ backgroundColor: "rgba(0, 0, 0, 0.05)" }}
        >
          © 2023 Copyright:
          <a className="text-reset fw-bold" href="">
            www.ClassConnect.com
          </a>
        </div>
      </MDBFooter>
    </div>
  );
};

export default Landing;
