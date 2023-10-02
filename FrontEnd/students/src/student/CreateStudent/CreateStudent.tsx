import './CreateStudent.css'
import { useForm, SubmitHandler } from "react-hook-form";
import Button from 'react-bootstrap/Button';
import { Student } from '../../models/Student';
import StudentService from '../../shared/service/StudentService';


type Inputs = {
  studentFirstName: string,
  studentLastName: string,
};

type PropsStudent = {
  setStudents : any;
};

function CreateStudent({setStudents}:PropsStudent) {



  const { register, handleSubmit, formState: { errors } } = useForm<Inputs>();
  const onSubmit: SubmitHandler<Inputs> = async data => {
    const student : Student = ({
      id: 2,
      firstName : data.studentFirstName,
      lastName : data.studentLastName
    });
    const studentCreated : Student = await StudentService.create(student);
    setStudents((prevArray: Student[]) => [...prevArray, studentCreated]);
  };

  return (
    <>
      <h1>Create Student</h1>
      <form onSubmit={handleSubmit(onSubmit)}>
        <div className='formStudent'>
          <div className='labelForm'>
            <label>First Name</label>
            <input {...register("studentFirstName", { required: true })} />
          </div>
          <div className='labelForm'>
            <label>Last Name</label>
            <input {...register("studentLastName", { required: true })} />
          </div>
          <Button variant="primary" type="submit" className='buttonCreateStudent'>
            Create
          </Button>
        </div>
        {errors.studentFirstName && errors.studentLastName &&
          <span>All fields are required</span>
        }
      </form>
    </>
  )
}

export default CreateStudent