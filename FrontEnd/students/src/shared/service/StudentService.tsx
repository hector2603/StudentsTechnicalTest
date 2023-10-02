import { Student } from "../../models/Student";
import API from "../environment/APIConfig";

const STUDENTS_ENDPOINTS = {
  ALL_STUDENTS: "student",
  STUDENT_DETAILS: "student/",
  CREATE_STUDENT: "student",
  DELETE_STUDENT: "student/",
  UPDATE_STUDENT: "student/",
};

const StudentService = {
  getAll: () => {
    return API.get(STUDENTS_ENDPOINTS.ALL_STUDENTS).then((res) => res.data);
  },

  findByid: (id: number) => {
    return API.get<Student>(STUDENTS_ENDPOINTS.STUDENT_DETAILS + id).then((res) => res.data);
  },

  deleteByID: (id : number ) =>
    API.delete(STUDENTS_ENDPOINTS.DELETE_STUDENT + id).then((res) => res),

  updateByID: (id : number, student : any) =>
    API.put(STUDENTS_ENDPOINTS.UPDATE_STUDENT + id, student).then(
      (res) => res.data
    ),
  create: (studentData : any) =>
    API.post<Student>(STUDENTS_ENDPOINTS.CREATE_STUDENT, studentData).then(
      (res) => {
        console.log(res.data);
        return res.data
      }
    )
};

export default StudentService;