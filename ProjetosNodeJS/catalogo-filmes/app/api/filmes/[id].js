import { ObjectId } from 'mongodb';
import { connectToDatabase } from '@/lib/mongodb';

export default async function handler(req, res) {
  if (req.method === 'GET') {
    const { id } = req.query;
    const { db } = await connectToDatabase();

    const filme = await db.collection('filmes').findOne({ _id: new ObjectId(id) });
    const comentarios = await db.collection('comentarios').find({ filmeId: id }).toArray();

    if (!filme) {
      return res.status(404).json({ message: 'Filme não encontrado' });
    }

    return res.status(200).json({ filme, comentarios });
  }

  return res.status(405).json({ message: 'Método não permitido' });
}
