import logo from './logo.svg';
import './App.css';
import './Component/Landing';
import Landing from './Component/Landing';
import {BrowserRouter, Routes } from 'react-router-dom';
import {Route} from 'react-router';
import Login from './Component/Login';
import StudentRegister from './Component/StudentRegister';
import TutorRegister from './Component/TutorRegister';
import CourseList from './Component/CourseList';
import TutorQualification from './Component/TutorQualification';
import TutorExperience from './Component/TutorExperience';
import TutorAddress from './Component/TutorAddress';
import StudentEducationalDetails from './Component/StudentEducationalDetails';
import StudentAddress from './Component/StudentAddress';
import Tutor from './Component/Tutor';
import Student from './Component/Student';
import Admin from './Component/Admin';
import AboutUs from './Component/AboutUs';
import PrivacyPolicy from './Component/PrivacyPolicy';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Routes>
        <Route path="/" element={<Landing/>}></Route>
        <Route path="/login" element={<Login/>}></Route>
        <Route path="/register/student" element={<StudentRegister/>}></Route>
        <Route path="/register/tutor" element={<TutorRegister/>}></Route>
        <Route path="/courses" element={<CourseList/>}></Route>
        <Route path="/tutor/address" element={<TutorAddress/>}></Route>
        <Route path="/tutor/qualificationdetails" element={<TutorQualification/>}></Route>
        <Route path="/tutor/experiences" element={<TutorExperience/>}></Route>
        <Route path="/student/educationaldetails" element={<StudentEducationalDetails/>}></Route>
        <Route path="/student/address" element={<StudentAddress/>}></Route>
        <Route path="/tutor" element={<Tutor/>}></Route>
        <Route path="/student" element={<Student/>}></Route>
        <Route path="/admin" element={<Admin/>}></Route>
        <Route path="/course/add" element={<Admin/>}></Route>
        <Route path="/aboutus" element={<AboutUs/>}></Route>
        <Route path="/privacyPolicy" element={<PrivacyPolicy/>}></Route>
      </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;