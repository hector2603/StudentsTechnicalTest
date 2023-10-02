import { Course } from "./Course";

export class Student {

    id: number
    lastName: String
    firstName: String
    courses?: Course[]


    constructor(id:number, lastName: String, firstName: String) {
        this.id = id
        this.lastName = lastName
        this.firstName = firstName
    }

}