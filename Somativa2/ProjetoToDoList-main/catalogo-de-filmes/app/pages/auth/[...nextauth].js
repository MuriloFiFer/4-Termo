import NextAuth from 'next-auth';
import Providers from 'next-auth/providers';

export default NextAuth({
  providers: [
    Providers.Credentials({
      async authorize(credentials) {
        // Lógica de autenticação
      },
    }),
  ],
  session: { jwt: true },
  database: process.env.MONGODB_URI,
});
