import { compare } from 'bcryptjs';
import jwt from 'jsonwebtoken';
import { connectToDatabase } from '@/lib/mongodb';

export default async function handler(req, res) {
  if (req.method === 'POST') {
    const { username, password } = req.body;
    const { db } = await connectToDatabase();

    const user = await db.collection('usuarios').findOne({ username });

    if (!user || !(await compare(password, user.password))) {
      return res.status(401).json({ message: 'Credenciais inválidas' });
    }

    const token = jwt.sign({ username: user.username }, 'your_secret_key', { expiresIn: '1h' });

    return res.status(200).json({ token });
  }

  return res.status(405).json({ message: 'Método não permitido' });
}
