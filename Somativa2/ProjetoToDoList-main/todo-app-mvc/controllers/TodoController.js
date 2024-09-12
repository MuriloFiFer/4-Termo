import Todo from "@/models/todo";
import connectMongo from "@/utils/dbConnect";
import { Connection } from "mongoose";

//Criar o CRUD



export const getTodos = async() => {
    await connectMongo;
    try{
        return await Todo.find();
    }
    catch (error){
        console.error(error);
    }
}

//Create

export const createTodo = async(data)=>{
    connectMongo;
    try{
        return await Todo.create(data);
    }catch(error){
        console.error(err);
    }
}

export const deleteTodo = async (id) =>{
    await connectMongo();
    try {
        return await Todo.deleteTodo({_id: id});
    } catch (error) {
        console.error(err);
        
    }
}