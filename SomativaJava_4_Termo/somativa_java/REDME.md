# Sistema de Manutenção Preventiva e Corretiva

## 1. Definição do Tema
O Sistema de Manutenção Preventiva e Corretiva é um software destinado ao gerenciamento do ciclo de vida de máquinas e equipamentos industriais, com foco em minimizar o tempo de inatividade e otimizar a performance operacional. Ele permite o controle das manutenções preventivas (realizadas regularmente para evitar falhas) e corretivas (realizadas após uma falha). O sistema também inclui funcionalidades para registrar falhas, gerenciar técnicos, gerar relatórios e acompanhar indicadores de desempenho, como o MTTR (Mean Time to Repair - Tempo Médio de Reparo) e o MTBF (Mean Time Between Failures - Tempo Médio Entre Falhas).

## 2. Análise de Requisitos e Escopo

### Funcionalidades Principais:
#### Gerenciamento de Máquinas e Equipamentos:
- Cadastro de máquinas, incluindo especificações técnicas, data de aquisição e localização.
- Visualização e edição de informações de máquinas.

#### Registro e Controle de Manutenções:
- Registro de manutenções preventivas e corretivas.
- Histórico completo de manutenções para cada máquina.
- Registro de peças substituídas e tempo de inatividade.

#### Gerenciamento de Falhas:
- Registro de falhas ocorridas, classificando a severidade e identificando o operador.
- Controle de falhas por máquina.

#### Gerenciamento de Técnicos:
- Cadastro de técnicos, incluindo suas especialidades e disponibilidade.

#### Relatórios e Indicadores:
- Geração de relatórios de manutenção, tempo de inatividade, falhas e peças trocadas.
- Cálculo de indicadores como MTTR e MTBF.

#### Integração com API:
- Utilização de uma API REST (JSON-Server) para armazenar e recuperar dados.

## 3. Escopo do Projeto

### Objetivos:
- Desenvolvimento da interface gráfica (Swing) para o gerenciamento de máquinas, técnicos e manutenções.
- Implementação de funcionalidades CRUD para máquinas, manutenções, falhas e técnicos.
- Geração de relatórios com base nos dados registrados, incluindo indicadores de desempenho.
- Conexão com API para armazenar e manipular dados em tempo real.
- Validação e testes para garantir a robustez do sistema.

### Levantamento de Recursos:

#### Recursos Humanos:
- Um desenvolvedor responsável por todas as fases do projeto: análise, desenvolvimento, testes e implementação.

#### Tecnologias e Ferramentas:
- **Linguagem de Programação**: Java (para a interface gráfica Swing).
- **API REST**: JSON-Server para manipulação de dados.
- **Banco de Dados**: Pode ser um banco leve como SQLite, ou um banco que suporte integração rápida com a API.
- **Ferramentas de Desenvolvimento**: IDE (ex.: IntelliJ IDEA, Eclipse), Git para controle de versão.
- **Ferramentas de Relatórios**: JasperReports ou outra biblioteca para geração de relatórios em Java.
- **Biblioteca de Cálculos**: Para calcular os indicadores MTTR e MTBF, caso não seja feito manualmente.

#### Tempo e Cronograma:
- **Período Total**: 5 dias.

#### Recursos de Infraestrutura:
- **Computador**: Para desenvolvimento, com acesso à internet.
- **Ambiente de Teste**: Uma máquina local ou virtual onde o sistema será testado.

### Análise de Riscos:

#### Risco de Prazo:
- **Descrição**: O projeto tem um prazo muito curto (1 semana). Atrasos podem ocorrer se houver dificuldades no desenvolvimento, especialmente na integração com a API e na geração de relatórios.
- **Mitigação**: Definir prioridades claras e um cronograma detalhado, focando nas funcionalidades principais e deixando as secundárias para ajustes finais. Revisar diariamente o progresso.

#### Risco de Bug ou Erro de Código:
- **Descrição**: Bugs inesperados ou falhas no código podem surgir, principalmente ao lidar com cálculos complexos (MTTR, MTBF) ou com a manipulação de dados através da API.
- **Mitigação**: Realizar testes contínuos durante o desenvolvimento, utilizando boas práticas de versionamento (Git) para salvar versões estáveis. Reservar tempo para testes detalhados no final do desenvolvimento.

#### Risco de Integração com API:
- **Descrição**: A integração com a API REST (JSON-Server) pode apresentar dificuldades, como problemas de conectividade, resposta lenta ou falhas no armazenamento de dados.
- **Mitigação**: Realizar testes de integração o quanto antes. Se surgirem problemas, considerar um fallback (ex.: armazenar os dados localmente, caso necessário).

#### Risco de Sobrecarga do Desenvolvedor:
- **Descrição**: Como o projeto está sendo desenvolvido por uma única pessoa, há o risco de sobrecarga, o que pode levar a falhas, atrasos ou perda de qualidade.
- **Mitigação**: Manter uma boa organização de tarefas, usar ferramentas de gerenciamento pessoal (ex.: Trello) e fazer pausas regulares para garantir a produtividade. Evitar trabalhar até o último minuto, deixando um buffer de tempo para ajustes finais.

#### Risco de Escopo Mal Gerenciado:
- **Descrição**: Como o projeto é curto, há risco de que o escopo cresça durante o desenvolvimento, adicionando funcionalidades extras que não podem ser completadas a tempo.
- **Mitigação**: Definir bem o escopo desde o início e evitar mudanças de escopo. Funcionalidades adicionais devem ser tratadas como "nice to have", e apenas implementadas se houver tempo extra.

#### Risco de Erros na Geração de Relatórios:
- **Descrição**: A geração de relatórios e cálculos de indicadores (MTTR, MTBF) pode apresentar erros de lógica ou formatação incorreta.
- **Mitigação**: Validar os cálculos com dados de teste antes da implementação completa e manter uma documentação clara dos métodos usados.

#### Risco de Dependência de Ferramentas e Bibliotecas:
- **Descrição**: Problemas podem surgir devido a bugs ou incompatibilidades em bibliotecas de terceiros (ex.: Swing ou ferramentas de relatórios).
- **Mitigação**: Usar versões estáveis e bem documentadas das ferramentas. Ter um plano de contingência (ex.: mudar a forma de geração de relatórios, se houver falhas críticas).

## 4. Modelagem do Sistema

### Diagrama de Classe:

```json
{
    "maquinas": [
      {
        "id": 1,
        "codigo": "M001",
        "nome": "Torno CNC",
        "modelo": "CNC 3000",
        "fabricante": "Siemens",
        "dataAquisicao": "2020-01-10",
        "tempoVidaEstimado": 10,
        "localizacao": "Linha 1",
        "detalhes": "Operação em alta precisão",
        "manual": "URL do manual"
      }
    ],
    "historicoManutencao": [
      {
        "id": 1,
        "maquinaId": 1,
        "data": "2024-10-07",
        "tipo": "Preventiva",
        "pecasTrocadas": "Correia",
        "tempoDeParada": 4,
        "tecnicoId": "João Silva",
        "observacoes": "Substituição preventiva da correia."
      }
    ],
    "falhas": [
      {
        "id": 1,
        "maquinaId": 1,
        "data": "2024-09-28",
        "problema": "Falha no motor",
        "prioridade": "Alta",
        "operador": "Carlos Lima"
      }
    ],
    "tecnicos": [
      {
        "id": 1,
        "nome": "João Silva",
        "especialidade": "Mecânica",
        "disponibilidade":"Livre"
      }
    ],
}


### Daigrama de Sequencia:
    +-------------------+
    |    Técnico        |
    +-------------------+
            |
            | 1. Solicita manutenção
            v
    +-------------------+
    |  Sistema de       |
    |  Manutenção       |
    +-------------------+
            |
            | 2. Registra manutenção
            v
    +-------------------+
    |    Base de Dados  |
    +-------------------+
            |
            | 3. Confirma registro
            v
    +-------------------+
    |    Técnico        |
    +-------------------+
            |
            | 4. Recebe confirmação
            v


### Diagrama de Fluxo:

    Início
      |
      v
    Cadastro de Máquina?
      | 
     Sim
      |
      v
    Inserir Dados da Máquina
      |
      v
    Cadastro de Manutenção?
      |
     Sim
      |
      v
    Registrar Manutenção
      |
      v
    Geração de Relatório?
      |
     Sim
      |
      v
    Gerar Relatório
      |
      v
    Fim



## Diagrama de Caso de Uso:


    +-------------------+
    |   Sistema de      |
    | Manutenção        |
    +-------------------+
           /|\
          / | \
         /  |  \
        /   |   \
       /    |    \
      /     |     \
+---------+ +----------+ +---------+
| Técnico | | Operador  | | Gerente |
+---------+ +----------+ +---------+
      |         |           |
      |         |           |
   Cadastrar  Registrar     Consultar
   Máquina    Falhas      Relatórios




## Manual do Usuário – Sistema de Manutenção de Máquinas

## Introdução

Este manual tem como objetivo orientar o usuário no uso do sistema de **Manutenção de Máquinas**, que permite gerenciar máquinas, registrar falhas, monitorar o histórico de manutenção e gerenciar técnicos responsáveis pelas manutenções. Este sistema foi desenvolvido para facilitar a gestão de manutenção preventiva e corretiva, promovendo um melhor acompanhamento do ciclo de vida das máquinas e das ações corretivas em caso de falhas.

## Funcionalidades do Sistema

1. **Gerenciamento de Máquinas**
   - Adicionar novas máquinas.
   - Listar todas as máquinas cadastradas.
   - Atualizar informações de uma máquina.
   - Remover máquinas do sistema.

2. **Gerenciamento de Falhas**
   - Registrar falhas nas máquinas.
   - Listar falhas já registradas para acompanhamento.
   
3. **Gerenciamento do Histórico de Manutenção**
   - Cadastrar manutenções realizadas nas máquinas.
   - Visualizar o histórico completo de manutenções preventivas e corretivas.
   
4. **Gerenciamento de Técnicos**
   - Cadastrar técnicos responsáveis pelas manutenções.
   - Listar e remover técnicos do sistema.

## Navegação e Operações

### 1. **Gerenciamento de Máquinas**

- **Cadastrar uma Máquina**
  1. No menu principal, selecione a opção "Máquinas".
  2. Clique em "Adicionar Máquina".
  3. Preencha as informações requeridas:
     - Código
     - Nome
     - Modelo
     - Fabricante
     - Data de Aquisição
     - Tempo de Vida Estimado
     - Localização
     - Detalhes adicionais (como manual da máquina)
  4. Clique em "Salvar" para adicionar a máquina ao sistema.

- **Listar Máquinas**
  1. No menu principal, clique em "Máquinas".
  2. A lista completa de máquinas cadastradas será exibida com suas respectivas informações.

- **Editar Máquina**
  1. Na lista de máquinas, selecione a máquina que deseja atualizar.
  2. Altere as informações desejadas e clique em "Salvar".

- **Remover Máquina**
  1. Selecione a máquina que deseja remover.
  2. Clique no botão "Excluir". Confirme a remoção.

### 2. **Gerenciamento de Falhas**

- **Registrar Falha**
  1. No menu, selecione "Falhas".
  2. Clique em "Adicionar Falha".
  3. Preencha as informações:
     - Máquina relacionada
     - Data da falha
     - Descrição do problema
     - Prioridade
     - Operador responsável
  4. Clique em "Salvar".

- **Listar Falhas**
  1. Acesse "Falhas" no menu.
  2. Uma lista com as falhas registradas será exibida.

### 3. **Gerenciamento do Histórico de Manutenções**

- **Registrar Manutenção**
  1. No menu, clique em "Histórico de Manutenção".
  2. Selecione "Adicionar Manutenção".
  3. Informe os dados necessários:
     - Máquina relacionada
     - Data da manutenção
     - Tipo (Preventiva ou Corretiva)
     - Peças trocadas (se houver)
     - Tempo de parada
     - Técnico responsável
     - Observações
  4. Clique em "Salvar".

- **Visualizar Histórico**
  1. Acesse "Histórico de Manutenção" no menu.
  2. A lista completa de manutenções será exibida.

### 4. **Gerenciamento de Técnicos**

- **Cadastrar Técnico**
  1. No menu, selecione "Técnicos".
  2. Clique em "Adicionar Técnico".
  3. Preencha as informações:
     - Nome
     - Especialidade
     - Disponibilidade
  4. Clique em "Salvar".

- **Listar Técnicos**
  1. Acesse "Técnicos" no menu.
  2. Uma lista com os técnicos cadastrados será exibida.

- **Remover Técnico**
  1. Selecione o técnico que deseja remover.
  2. Clique no botão "Excluir" e confirme a ação.

## Considerações Finais

Este sistema foi projetado para ser intuitivo e eficiente, com o objetivo de facilitar o gerenciamento de máquinas e garantir que as manutenções preventivas e corretivas sejam executadas de forma adequada. Caso surjam dúvidas ou problemas durante o uso, contate o suporte técnico responsável.
