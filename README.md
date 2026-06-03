# 🛍️ Produto API DummyJSON

Aplicativo Android desenvolvido como atividade do **BootCamp 2026** do Professor **Jamilton Damasceno**.

O app consome a API pública [DummyJSON](https://dummyjson.com/) para listar, pesquisar e exibir detalhes de produtos.

---

## 📱 Funcionalidades

- **Listagem de produtos** consumidos da API DummyJSON
- **Pesquisa em tempo real** de produtos por nome via SearchView
- **Tela de detalhes** com informações completas do produto selecionado
- Navegação entre telas com passagem de dados via `Intent`

---

## 🏗️ Arquitetura e Organização do Projeto

```
app/src/main/java/com/caiquesenna/produtoapidummyjson/
├── data/
│   ├── Product.kt             # Model do produto
│   ├── ProductResponse.kt     # Wrapper da resposta da API
│   ├── Dimensions.kt          # Model de dimensões
│   ├── Meta.kt                # Model de metadados
│   ├── Review.kt              # Model de avaliações
│   ├── DummyApiService.kt     # Interface Retrofit (endpoints)
│   └── RetrofitClient.kt      # Configuração do cliente Retrofit
└── ui/
    ├── MainActivity.kt        # Tela principal com lista e busca
    ├── DetalhesActivity.kt    # Tela de detalhes do produto
    └── ProductAdapter.kt      # Adapter do RecyclerView
```

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Versão | Finalidade |
|---|---|---|
| **Kotlin** | — | Linguagem principal |
| **Retrofit** | 2.11.0 | Consumo da API REST |
| **Gson Converter** | 2.11.0 | Serialização/Desserialização JSON |
| **Glide** | 4.16.0 | Carregamento de imagens |
| **ViewBinding** | — | Vinculação de views |
| **Coroutines** | — | Chamadas assíncronas à API |
| **RecyclerView** | — | Listagem de produtos |

---

## 🌐 API Utilizada

**Base URL:** `https://dummyjson.com/`

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/products` | Retorna todos os produtos |
| `GET` | `/products/search?q={query}` | Pesquisa produtos por termo |


## 📚 Aprendizados

Este projeto foi desenvolvido como parte do BootCamp 2026 do Prof. Jamilton Damasceno e aborda os seguintes conceitos:

- Consumo de APIs REST com **Retrofit**
- Uso de **Coroutines** para operações assíncronas
- Padrão de camadas **data / ui**
- **RecyclerView** com Adapter customizado
- **ViewBinding** para acesso seguro às views
- Navegação entre Activities com passagem de objetos via `Serializable`

---

## 📱 Telas do App

<img width="397" height="845" alt="image" src="https://github.com/user-attachments/assets/d613bae4-ad92-414f-b29d-8f664e3040de" />

<img width="398" height="846" alt="image" src="https://github.com/user-attachments/assets/8347a644-5370-4d11-8886-0d7af927e3ac" />


