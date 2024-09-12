import mongoose from "mongoose";

const TodoSchema = new mongoose.Schema({
    title:{
        type:String,
        required:true
    },

    description:{
        type:String
    },
    completed:{
        type:String,
        enum:('A Fazer','Fazendo', 'Concluido'),
        default:'Pendente'
    }
});


const Todo = mongoose.models.Todo || mongoose.model('Todo',TodoSchema);

export default Todo;