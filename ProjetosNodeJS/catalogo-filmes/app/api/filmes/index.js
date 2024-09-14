import { connectToDatabase } from '@/lib/mongodb';

export default async function handler(req, res) {
  if (req.method === 'GET') {
    const { db } = await connectToDatabase();
    const filmes = await db.collection('filmes').find({}).toArray();

    return res.status(200).json({ filmes });
  }

  return res.status(405).json({ message: 'Método não permitido' });
}
