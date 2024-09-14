import { ObjectId } from 'mongodb';
import { connectToDatabase } from '@/lib/mongodb';

export default async function handler(req, res) {
  if (req.method === 'POST') {
    const { comentario } = req.body;
    const { id } = req.query;
    const { db } = await connectToDatabase();

    const filme = await db.collection('filmes').findOne({ _id: new ObjectId(id) });
    
    if (!filme) {
      return res.status(404).json({ message: 'Filme não encontrado' });
    }

    const newComentario = {
      filmeId: id,
      texto: comentario,
      createdAt: new Date(),
    };

    await db.collection('comentarios').insertOne(newComentario);

    return res.status(201).json({ comentario: newComentario });
  }

  return res.status(405).json({ message: 'Método não permitido' });
}
