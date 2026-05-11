## 👥 Equipe
*   [Kauã Silva Gomes](https://github.com)
*   [Cauã Silva Rodrigues](https://github.com)
*   [Larissa Queiroz Coqueiro Silva](https://github.com)
*   [Thalita Moraes Ferreira](https://github.com)


# 📋 Sistema de Cadastro de Clientes e Contatos

Sistema console desenvolvido em **Java** como Projeto Integrador, com foco em estruturas de dados usando matrizes bidimensionais (`String[][]`) e manipulação manual de dados — sem uso de coleções, banco de dados ou arquivos externos.

---

## 📌 Sobre o projeto

O sistema simula um cadastro empresarial onde cada cliente pode ter múltiplos contatos (telefone, e-mail, WhatsApp, Instagram, LinkedIn, entre outros). Toda a persistência é feita em memória, por meio de matrizes que crescem dinamicamente conforme novos registros são incluídos.

A relação entre clientes e contatos é do tipo **1 para N**: um cliente pode ter vários contatos, e ao excluir um cliente, todos os seus contatos são automaticamente removidos.

---

## ⚙️ Funcionalidades

### Clientes
- Incluir cliente com código gerado automaticamente (sequencial)
- Listar todos os clientes em formato de tabela
- Consultar cliente por código
- Alterar dados do cliente
- Excluir cliente (com remoção em cascata dos contatos)
- Ordenar clientes por nome (algoritmo manual, char por char)

### Contatos
- Incluir contato vinculado a um cliente existente
- Listar todos os contatos (com nome do cliente via JOIN manual)
- Listar contatos de um cliente específico
- Alterar tipo e valor do contato
- Excluir contato (recria a matriz sem o item removido)

### Relatórios
- Clientes com total de contatos por cliente
- Sumarização geral: total de clientes, total de contatos, média de contatos por cliente e clientes sem contato

---

## 🏗️ Estrutura dos dados

As matrizes seguem o seguinte layout de colunas:

**Clientes** — `String[n][8]`

| Índice | Campo |
|--------|-------|
| [0] | Código |
| [1] | Nome |
| [2] | CPF/CNPJ |
| [3] | Data de nascimento |
| [4] | Sexo |
| [5] | Cidade |
| [6] | Estado |
| [7] | Status |

**Contatos** — `String[n][5]`

| Índice | Campo |
|--------|-------|
| [0] | Código do contato |
| [1] | Código do cliente |
| [2] | Tipo |
| [3] | Valor |
| [4] | Status |

---

## 🧩 Funções implementadas

**Clientes**
- `aumentarMatrizClientes` — expande a matriz quando necessário
- `incluirCliente` — adiciona novo cliente com código automático
- `listarClientesTabela` — exibe clientes em tabela formatada
- `buscarClientePorCodigo` — localiza cliente pelo código
- `alterarCliente` — atualiza dados de um cliente existente
- `apagarCliente` — remove cliente e seus contatos
- `ordenarClientesPorNome` — ordenação manual por nome

**Contatos**
- `aumentarMatrizContatos` — expande a matriz quando necessário
- `incluirContato` — adiciona contato validando a existência do cliente
- `listarContatosTabela` — exibe contatos com nome do cliente (JOIN manual)
- `listarContatosPorCliente` — filtra contatos de um cliente específico
- `alterarContato` — atualiza tipo e valor do contato
- `apagarContato` — remove contato recriando a matriz

**Auxiliares**
- `compararNomeCharPorChar` — comparação de strings sem `compareTo()`
- `copiarLinha` — copia uma linha da matriz para outra posição
- `limparLinha` — limpa os dados de uma linha
- `trocarLinhas` — troca duas linhas de posição (usado na ordenação)

---

## 🚫 Restrições técnicas

Por requisito do projeto, **não é permitido** utilizar:

- `ArrayList`, `List`, `Map`, `HashMap`
- `Arrays.sort()`, `Collections.sort()`, `compareTo()`
- Classes de entidade ou objetos (`Cliente`, `Contato`)
- Banco de dados ou arquivos
- Bibliotecas externas
- Variáveis globais

---

## ▶️ Como executar

**Pré-requisitos:** Java JDK 8 ou superior instalado.

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/seu-repositorio.git

# Acesse a pasta do projeto
cd seu-repositorio

# Compile
javac Main.java

# Execute
java Main
```

---

## 📁 Estrutura do projeto

```
/
├── Main.java          # Ponto de entrada e menus
├── Clientes.java      # Funções de CRUD de clientes
├── Contatos.java      # Funções de CRUD de contatos
├── Relatorios.java    # Funções de relatórios
└── README.md
```

> A estrutura de arquivos pode variar conforme a organização do grupo.

---

## 👥 Autores

Desenvolvido como Projeto Integrador — curso de **Análise e Desenvolvimento de Sistemas**.

---

## 📄 Licença

Este projeto é de uso acadêmico.
