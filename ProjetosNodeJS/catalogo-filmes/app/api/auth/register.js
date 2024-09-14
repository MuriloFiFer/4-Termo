import { hash } from 'bcryptjs';
import { connectToDatabase } from '@/lib/mongodb';

export default async function handler(req, res) {
  if (req.method === 'POST') {
    const { username, password } = req.body;

    if (!username || !password) {
      return res.status(400).json({ message: 'Preencha todos os campos' });
    }

    const hashedPassword = await hash(password, 10);
    const { db } = await connectToDatabase();
    
    await db.collection('usuarios').insertOne({
      username,
      password: hashedPassword,
    });

    return res.status(201).json({ message: 'Usuário registrado com sucesso' });
  }

  return res.status(405).json({ message: 'Método não permitido' });
}
