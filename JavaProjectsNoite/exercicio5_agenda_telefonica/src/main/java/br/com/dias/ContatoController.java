package br.com.dias;

public class ContatoController {
    private Contato[] contatos;
    private int contadorDeContatos;

    public ContatoController(int maxContato) {

        maxContato = 100;

        contatos = new Contato[maxContato];
        contadorDeContatos = 0;

    }

    public void addContato(Contato contato) throws AgendaCheiaException {

        if (contadorDeContatos >= contatos.length) {
            throw new AgendaCheiaException("Agenda Cheia");
        }
        try {
            contatos[contadorDeContatos] = contato;
            contadorDeContatos++;
            System.out.println("Contato adicionado com sucesso");
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public void listarContato() {

        if (contadorDeContatos == 0) {
            System.out.println("Agenda Vazia");
        } else {
            for (int i = 0; i < contadorDeContatos; i++) {
                System.out.println(contatos[i].toString());
            }
        }
    }
    // public void buscarNome(String nome) throws ContatoNaoEncontrado{
    //     for (int i = 0; i < contatos.length; i++) {
    //         if (contadorDeContatos==0) {
    //             System.out.println("Agenda Vazia");
    //         }else{
    //             if (contatos[i].getNome().equalsIgnoreCase(nome)) {
    //                 System.out.println(contatos[i].toString());
    //             }
    //         }
    //     }
    //     throw new ContatoNaoEncontrado("Contato não encontrado");
    // }
    public Contato buscarContato(String nome) throws ContatoNaoEncontrado{
        for (int i = 0; i < contadorDeContatos; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                return contatos[i];
            }
        }
         ContatoNaoEncontrado(("Contato não encontrado"));
        return null;
        
    }
 
    private void ContatoNaoEncontrado(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ContatoNaoEncontrado'");
    }

    //remover contato
    public void removerContato(String nome) throws ContatoNaoEncontrado{
        boolean encontrado = false;
        for (int i = 0; i < contadorDeContatos; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                encontrado = true;
                contatos[i]=contatos[contadorDeContatos-1];
                contatos[contadorDeContatos-1]=null;
                contadorDeContatos--;
            }    
    }
    if (!encontrado) {
        throw new ContatoNaoEncontrado("Contato não Encontrado");
}
    }

};