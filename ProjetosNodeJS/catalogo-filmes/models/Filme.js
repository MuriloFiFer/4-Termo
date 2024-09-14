import mongoose from "mongoose";

const FilmeSchema = new mongoose.Schema({
    usuarioId: { type: mongoose.Schema.Types.ObjectId, ref: 'Usuario', required: true },
    titulo: { type: String, required: true },
    descricao: { type: String },
    comentarios: [{ type: String }]
});

const Filme = mongoose.models.Filme || mongoose.model('Filme', FilmeSchema);
export default Filme;
