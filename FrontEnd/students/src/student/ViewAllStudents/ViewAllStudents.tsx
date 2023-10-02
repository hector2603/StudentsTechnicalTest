import './ViewAllStudents.css'
import StudentService from '../../shared/service/StudentService';
import { useEffect } from "react";
import TableRow from './TableStudent/RowTable';
import { Student } from '../../models/Student';

type PropsStudent = {
  students: Student[];
  setStudents : any;
  setStudentSelected: any;
};

function ViewAllStudent({students,setStudents,setStudentSelected}:PropsStudent) {

  useEffect(() => {
    const fetchStudents = async () => {
      try {
        const student = await StudentService.getAll();
        setStudents(student);
      } catch (error) {
        console.log(error);
      }
    };

    fetchStudents();
  }, []);

  return (
    <>
      <table className='tableStudents'>
        <thead>
          <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Show</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          {students.map((student: Student, i) => (
            <TableRow
              key={i}
              {... ({student,setStudents,setStudentSelected})}
            />
          ))}
        </tbody>
      </table>
    </>
  )
}

export default ViewAllStudent