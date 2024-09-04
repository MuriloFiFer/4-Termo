import Todo from "@/models/Todo";
import connectMongo from "@/utils/dbConnect";

//criar o CRUD

//Create
export const getTodos = async() => {
    connectMongo;
    try {
        return await Todo.find();        
    } catch (error){
    console.error(error); 
    }
}

//Create
export const createTodo = async(data) => {
    connectMongo;
    try {
        return await Todo.create(data);       
    } catch (error){
        console.error(error);
    }
}

//Update
export const updateTodo = async (id, data) => {
    await connectMongo();
    try {
    return await Todo.findByIdAndUpdate(id, data, {
      new: true,
      runValidators: true,
    });
} catch (error){
    console.error(error);
  };
};
  
  //Delete
  export const deleteTodo = async (id) => {
    await connectMongo();
    try {
    return await Todo.deleteOne({ _id: id });
  } catch (error){
    console.error(error);
  };
};
  