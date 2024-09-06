import User from "@/models/User";
import connectMongo from "@/utils/dbConnectMongo";

//CRUD
export const getTask = async () => {
    await connectMongo;
    return await Task.find();       
};

export const addTask = async (data) => {
    await connectMongo;
    return await Task.create(task);
};

export const updateTask = async (id, data) => {
    await connectMongo;
    return await Task.findByIdAndUpdate(id, data, { 
        new: true,
        runValidatorns: true
})
};

export const deleteTask = async (id) => {
    await connectMongo;
    return await Task.deleteOne({_id:id});
};

