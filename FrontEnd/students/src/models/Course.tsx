export class Course {

    id: number
    code: String
    title: String
    description: String

    constructor(id:number, code: String, title: String, description:String) {
        this.id = id
        this.code = code
        this.title = title
        this.description = description
    }
}