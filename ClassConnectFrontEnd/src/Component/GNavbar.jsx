import React from "react";
import { Navbar, Container, Nav, NavDropdown } from "react-bootstrap";
import { Link } from "react-router-dom"; // Import Link from React Router
import mainlogo from "./Logos/ClassConnect.jpg";
import logocss from "./CSS/logo.css";
import navbarcss from "./CSS/navbar.css";
import "./CSS/landing.css";

const GNavbar = () => {
  return (
    <div>
      <Navbar
        style={{ navbarcss }}
        collapseOnSelect
        expand="xl"
        bg="dark"
        variant="dark"
      >
        <Container className="content-justify-end">
          <img src={mainlogo} style={{ logocss }} className="logo" alt="Logo" />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <Nav>
            <Nav.Link as={Link} to="/">Home</Nav.Link>
          </Nav>
          <Navbar.Toggle aria-controls="responsive-navbar-nav" />
          <Navbar.Collapse id="responsive-navbar-nav">
            <Nav>
              &nbsp;&nbsp;&nbsp;&nbsp;
              <Nav.Link as={Link} to="/aboutUs">
                About Us
              </Nav.Link>
              &nbsp;&nbsp;&nbsp;&nbsp;
              <NavDropdown title="Register" id="collasible-nav-dropdown">
                <NavDropdown.Item as={Link} to="/register/student">
                  As a Student
                </NavDropdown.Item>
                <NavDropdown.Item as={Link} to="/register/tutor">
                  As a Tutor
                </NavDropdown.Item>
              </NavDropdown>
            </Nav>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <Nav>
              <Nav.Link as={Link} to="/login">Login</Nav.Link>
            </Nav>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <Nav>
              <Nav.Link as={Link} to="/privacyPolicy">Privacy Policy</Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </div>
  );
};

export default GNavbar;