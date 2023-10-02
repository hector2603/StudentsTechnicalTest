import { Button } from "react-bootstrap";
import { Student } from "../../../models/Student";
import StudentService from "../../../shared/service/StudentService";

type PropsStudent = {
  student: Student;
  setStudents: any;
  setStudentSelected: any;
};

const TableRow = ({ student, setStudents, setStudentSelected }: PropsStudent) => {

  const handleClickDelete = (id: number) => {
    setStudents((current: Student[]) =>
      current.filter(
        (student) =>
          student.id != id
      )
    );
    StudentService.deleteByID(id)
  };


  return (
    <tr>
      <td>{student.id}</td>
      <td>{student.firstName}</td>
      <td>{student.lastName}</td>
      <td>
        <Button 
        variant="primary"
        onClick={() => setStudentSelected(student.id)}

        >
          Show
        </Button>
      </td>
      <td>
        <Button
          variant="primary"
          onClick={() => handleClickDelete(student.id)}
        >
          Delete
        </Button></td>
    </tr>
  );
};

export default TableRow;