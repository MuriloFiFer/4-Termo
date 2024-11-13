
# Documentação do Projeto: **Aplicativo de Controle de Acesso para Visitantes com QR Code**

## 1. Visão Geral do Projeto

O objetivo deste projeto é desenvolver um aplicativo móvel que permita o controle de acesso de visitantes em locais restritos. O aplicativo autenticará visitantes via QR code, gerenciará dados de autenticação e possibilitará que administradores liberem ou bloqueiem acessos de forma prática e segura.

## 2. Definição do Escopo

### 2.1 Funcionalidades Principais

- **Autenticação de Visitantes com Firebase Authentication**: 
    - O aplicativo utilizará o Firebase Authentication para gerenciar login e registro de usuários.
    - Autenticação é necessária para acessar as funcionalidades de geração e leitura de QR Codes.

- **Tela Inicial - Home**:
    - Exibe dois botões principais:
        - **Login**: Abre uma tela para login com campos para e-mail e senha, além de um botão para confirmar o login.
        - **Registrar**: Abre uma tela para cadastro, com campos para e-mail, senha e confirmação de senha.

### 2.2 Funcionalidades Pós-Login

1. **Gerar QR Code**:
    - Permite ao usuário gerar um QR Code para um visitante, inserindo nome e CPF.
    - O QR Code é salvo no Firebase, associado ao usuário logado.
    - O QR Code ficará acessível na "to-do list" do perfil do usuário.

2. **Ler QR Code**:
    - Abre uma janela que permite a leitura de QR Codes de visitantes.
    - Após a leitura, exibe os dados do visitante (nome e CPF).
    - O usuário pode escolher entre liberar ou bloquear a entrada do visitante.

3. **Gerenciamento de QR Codes**:
    - O perfil do usuário exibirá uma lista com todos os QR Codes gerados.
    - Cada QR Code terá uma opção de exclusão para que o usuário remova os QR Codes que não deseja mais armazenar.

### 2.3 Limitações do Escopo

- O projeto não integrará com sistemas físicos de controle de acesso (catracas).
- Não incluirá funcionalidades para gerenciamento de funcionários.
- Não será possível gerar relatórios avançados.

## 3. Objetivos SMART

- **Específicos**: Criar um aplicativo para controle de acesso de visitantes, com autenticação via QR code e Firebase.
- **Mensuráveis**: Registrar a entrada de visitantes em até 10 segundos com 95% de sucesso.
- **Atingíveis**: Utilizar Firebase para autenticação e armazenamento seguro.
- **Relevantes**: Atende à necessidade de segurança em locais restritos e facilita o gerenciamento de visitantes.
- **Temporais**: Lançar versão piloto em 2 meses.

## 4. Análise de Riscos

- **Falha na Leitura do QR Code**: Implementar melhorias de leitura em condições adversas.
- **Problemas de Segurança de Dados**: Aplicar criptografia e autenticação forte.
- **Erro na Verificação de Localização**: Utilizar geofencing para validação da localização (em versões futuras).

## 5. Recursos

- **Equipe de Desenvolvimento**: Desenvolvedores de mobile e backend.
- **Equipamentos**: Dispositivos para testes e câmeras para simular leitura de QR codes.
- **Ferramentas**: Firebase para banco de dados e autenticação; API de geolocalização (para versões futuras).

## 6. Diagrama de Casos de Uso

```plaintext
+--------------------+
|      Usuário       |
+--------------------+
        |
        | 1. Autenticar via Firebase
        v
+--------------------+     2. Gerar ou Ler QR Code
|    Sistema         |--------------------------->|
+--------------------+                             |
        | 3. Salvar QR Code                        |
        |----------------------------------------->|
        v                                          |
+--------------------+                             |
|  Firebase          |<----------------------------|
+--------------------+                             |
        |                                          |
        v                                          |
+--------------------+                             |
|  Administrador     |  4. Liberar/Bloquear Entrada|
+--------------------+----------------------------+
```

## 7. Diagrama de Classes

```plaintext
+---------------------------+        +----------------------------+
|         Usuario           |        |       QRCode               |
+---------------------------+        +----------------------------+
| - email: String           |        | - codigo: String           |
| - senha: String           |        | - nomeVisitante: String    |
|                           |        | - cpfVisitante: String     |
+---------------------------+        | - dataHoraGeracao: DateTime|
        |                               +--------------------------+
        | 1                              |
        v                                v
+----------------------------+        +-----------------------------+
|       Firebase             |        |         Notificacao         |
+----------------------------+        +-----------------------------+
| - autenticarUsuario()      |        | - dataHora: DateTime        |
| - armazenarQRCode()        |        | - dadosVisitante: QRCode    |
+----------------------------+        +-----------------------------+
```

## 8. Diagrama de Sequência

### Processo de Autenticação e Geração de QR Code

```plaintext
Usuário  -> Sistema   -> Firebase
    |          |             |
    | 1. Login via Firebase  |
    |----------------------->|
    |          |             |
    | 2. Acessar Geração QR  |
    |------------------------|
    |          |             |
    | 3. Inserir Dados       |
    |------------------------|
    |          |             |
    | 4. Gerar e Salvar QR   |
    |----------------------->|
    |          | 5. Confirmar e Notificar
    |<-----------------------|
    |          |             |
    | 6. Fim do processo     |
    |<-----------------------|
```

## 9. Tutorial de Utilização do Aplicativo

### 1. Tela Inicial - Home

   Na tela inicial, escolha entre:

   - **Login**: Para acessar sua conta com e-mail e senha.
   - **Registrar**: Para criar uma nova conta.

### 2. Registro de Usuário

   - Insira seu **e-mail** e crie uma **senha** (com confirmação).
   - Toque em **Registrar** para concluir.

### 3. Login

   - Insira seu **e-mail** e **senha**.
   - Toque em **Login** para acessar o aplicativo.

### 4. Funcionalidades Pós-Login

   #### 4.1. Gerar QR Code
   - Toque em **Gerar QR Code** para acessar a funcionalidade.
   - Uma nova janela abrirá com os campos para preencher os dados do visitante.
      - Insira o **nome** e o **CPF** do visitante.
      - Toque no botão **Gerar QR Code** para gerar o código.
      - O QR Code gerado será exibido como uma imagem logo abaixo.
   - Para enviar o QR Code por e-mail, insira um endereço de e-mail no campo **Digite o email para envio** e toque em **Enviar QR Code por e-mail**.

   #### 4.2. Ler QR Code
   - Toque em **Ler QR Code**.
   - Escaneie o QR Code usando a câmera do dispositivo.
   - As informações do visitante, como **nome** e **CPF**, serão exibidas após a leitura do código.
 

### 5. Gerenciamento de QR Codes

   - Acesse seu perfil e visualize a lista de QR Codes.
   - Para excluir um QR Code específico, toque na opção **Excluir** ao lado do código desejado.

### 6. Encerrar Sessão

   - No perfil, toque no botão de **Logout** para encerrar sua sessão.

---

Este guia fornece todas as instruções necessárias para utilizar o aplicativo de controle de acesso de visitantes com QR Code.


### 10. Testes e Validação

- **Testes de Autenticação**: Validar a criação de contas, login e logout.
- **Testes de Leitura de QR Code**: Simular a leitura de diferentes tipos de QR Codes e verificar se a validação ocorre corretamente.
- **Testes de Fluxo de Navegação**: Garantir que a navegação entre as telas (Login, Registro, QR Code, Histórico) funciona sem interrupções.
  
A implementação desses testes garante maior confiabilidade e segurança nas funcionalidades principais do aplicativo.


## 11. Conclusão

Este documento descreve o escopo, funcionalidades e cronograma do aplicativo de controle de acesso para visitantes. O sistema será implementado com Firebase Authentication e armazenamento seguro dos dados dos visitantes. Ele será lançado como uma versão piloto para testes em 2 meses, com foco em segurança e eficiência.
