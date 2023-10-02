import './ShowStudent.css'
import { Student } from '../../models/Student';
import { useEffect, useState } from "react";
import StudentService from '../../shared/service/StudentService';
import { Course } from '../../models/Course';

type PropsStudent = {
  studentId: number;
};

function ShowStudent({ studentId }: PropsStudent) {

  const [student, setStudent] = useState<Student | undefined>(undefined);

  useEffect(() => {
    const fetchStudent = async (id: number) => {
      try {
        const student = await StudentService.findByid(id);
        setStudent(student);
        console.log(student);
      } catch (error) {
        console.log(error);
      }
    };

    fetchStudent(studentId);
  }, [studentId]);

  return (student &&
    <>
      <h1>{studentId} - {student?.firstName} {student?.lastName}</h1>
      <h2>Courses </h2>
      {student?.courses && student?.courses.map((course: Course) => (
        <p>{course.code} {course.description} {course.title}</p>
          ))}
    </>
  )
}

export default ShowStudent