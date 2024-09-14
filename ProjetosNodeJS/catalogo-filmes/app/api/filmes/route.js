import { jwtMiddleware } from "@/utils/middleware";
import { listarFilmes, adicionarFilme, comentarFilme } from "@/controllers/FilmeController";

export async function GET(req, res) {
    return jwtMiddleware(async (req, res) => {
        await listarFilmes(req, res);
    })(req, res);
}

export async function POST(req, res) {
    return jwtMiddleware(async (req, res) => {
        await adicionarFilme(req, res);
    })(req, res);
}

export async function PUT(req, res) {
    return jwtMiddleware(async (req, res) => {
        await comentarFilme(req, res);
    })(req, res);
}
