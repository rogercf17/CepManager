# 📮 CepManager

Sistema de gerenciamento de endereços via CEP desenvolvido em Java. Permite buscar, cadastrar, listar, remover e consultar endereços utilizando a API pública [ViaCEP](https://viacep.com.br/).

---

## 🚀 Funcionalidades

- **Listar** todos os endereços cadastrados
- **Cadastrar** um novo endereço a partir de um CEP (sem duplicatas)
- **Remover** um endereço pelo CEP
- **Buscar** um endereço pelo CEP na lista local
- **Persistência** em arquivo JSON local (`enderecos.json`)

---

## 🛠️ Tecnologias

| Tecnologia | Versão |
|---|---|
| Java | 23 |
| Maven | 3.x |
| Gson | 2.10.1 |
| ViaCEP API | — |

---

## 📁 Estrutura do Projeto

```
CepManager/
├── src/
│   └── main/
│       └── java/
│           └── org/example/
│               ├── Main.java                        # Ponto de entrada e menu interativo
│               ├── client/
│               │   └── BuscadorDeCep.java           # Requisições HTTP para a ViaCEP
│               ├── models/
│               │   ├── Endereco.java                # Modelo principal de endereço
│               │   └── EnderecoR.java               # Record DTO da resposta da API
│               ├── repository/
│               │   └── EnderecoRepository.java      # Leitura e escrita no arquivo JSON
│               ├── service/
│               │   └── EnderecoService.java         # Regras de negócio
│               └── exception/
│                   └── EnderecoNaoEncontrado.java   # Exceção customizada
├── pom.xml
└── enderecos.json                                   # Gerado automaticamente na primeira execução
```

---

## ⚙️ Como executar

### Pré-requisitos

- Java 23+
- Maven 3.x

### Passos

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/CepManager.git

# Entre na pasta
cd CepManager

# Compile o projeto
mvn compile

# Execute
mvn exec:java -Dexec.mainClass="org.example.Main"
```

---

## 📖 Como usar

Ao iniciar, o sistema exibe um menu interativo:

```
Digite (1) para ver todos os endereços
Digite (2) para cadastrar um novo endereço
Digite (3) para remover um endereço cadastrado
Digite (4) para buscar um endereço
Digite (0) para fechar o programa
```

Os CEPs podem ser digitados com ou sem hífen (ex: `01310-100` ou `01310100`).

Os endereços são salvos automaticamente no arquivo `enderecos.json` na raiz do projeto.

---

## 🧱 Arquitetura

O projeto segue o princípio de **Responsabilidade Única (SRP)** do SOLID:

| Camada | Responsabilidade |
|---|---|
| `Main` | Interação com o usuário (menu, Scanner) |
| `EnderecoService` | Regras de negócio (duplicata, validação) |
| `EnderecoRepository` | Leitura e escrita no arquivo JSON |
| `BuscadorDeCep` | Requisições HTTP para a ViaCEP |
