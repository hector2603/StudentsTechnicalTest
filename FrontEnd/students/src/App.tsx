import { useState } from 'react'
import './App.css'
import Button from 'react-bootstrap/Button';
import ButtonGroup from 'react-bootstrap/ButtonGroup';
import Student from './student/Student';
import Course from './course/Course';

function App() {
  const STUDENTS : String = "STUDENT"
  const COURSES : String= "COURSES"
  const [active, setActive] = useState(STUDENTS);

  const SetView = (active : String) => {
    setActive(active);
  }; 

  const ActiveView = () => {
    switch (active) {
      case STUDENTS:
        return <Student />;
      case COURSES:
        return <Course />;
    }
  };

  return (
    <div className='container'>
      <div className='header'>
        <ButtonGroup aria-label="NavBar">
          <Button variant="primary" className='button-nav-bar' onClick={() => SetView(STUDENTS)} >Students</Button>
          <Button variant="primary" className='button-nav-bar' onClick={() => SetView(COURSES)}>Courses</Button>
        </ButtonGroup>
      </div>
      <div className='body'>
        {ActiveView()}
      </div>
    </div>

  )
}

export default App
