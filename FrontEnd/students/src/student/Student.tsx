import './Student.css'
import CreateStudent from './CreateStudent/CreateStudent';
import ViewAllStudent from './ViewAllStudents/ViewAllStudents';
import React, { useEffect, useState } from "react";
import ShowStudent from './ShowStudent/ShowStudent';


function Student() {
  const [students, setStudents] = useState([]);
  const [studentSelected, setStudentSelected] = useState(0);

  return (
    <div className='containerStudent'>
      <div className='blockStudent'>
        <CreateStudent {... ({setStudents})}/>
        <ViewAllStudent {... ({students,setStudents,setStudentSelected})} />
      </div>
      <div className='blockStudent'>
        <ShowStudent {... ({studentId:studentSelected})}/>
      </div>
    </div>
  )
}

export default Student