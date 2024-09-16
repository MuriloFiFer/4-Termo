import { hash } from 'bcryptjs';
import connectMongo from '@/lib/dbconnect'; // Certifique-se de que o caminho está correto
import mongoose from 'mongoose';

const UserSchema = new mongoose.Schema({
  username: { type: String, required: true },
  password: { type: String, required: true }
});

const User = mongoose.models.User || mongoose.model('User', UserSchema);

export default async function handler(req, res) {
  if (req.method === 'POST') {
    const { username, password } = req.body;

    if (!username || !password) {
      return res.status(400).json({ message: 'Preencha todos os campos' });
    }

    try {
      await connectMongo(); // Conectando ao MongoDB

      const hashedPassword = await hash(password, 10);

      const newUser = new User({
        username,
        password: hashedPassword
      });

      await newUser.save();

      return res.status(201).json({ message: 'Usuário registrado com sucesso' });
    } catch (error) {
      console.error('Erro ao registrar o usuário:', error);
      return res.status(500).json({ message: 'Erro no servidor. Tente novamente mais tarde.' });
    }
  } else {
    return res.status(405).json({ message: 'Método não permitido' });
  }
}
