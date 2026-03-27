# 📱 Cadastro de Usuários - Android

Aplicativo Android desenvolvido para cadastro simples de usuários, com exibição em lista utilizando RecyclerView.

---

## 🚀 Funcionalidades

* ➕ Cadastro de usuário (nome e e-mail)
* 📋 Exibição dos usuários em lista
* 🔄 Atualização automática da lista ao retornar para a tela principal
* 🧠 Armazenamento em memória utilizando `ArrayList`
* 📱 Interface simples e funcional

---

## 🛠️ Tecnologias utilizadas

* Java
* Android Studio
* RecyclerView
* ConstraintLayout
* Material Design (TextInputEditText)

---

## 📱 Telas do aplicativo

### 🏠 Tela Principal (MainActivity)

* Exibe a lista de usuários utilizando **RecyclerView**
* Botão **Cadastrar** para adicionar novo usuário
* Atualização automática da lista no método `onResume()`

### ➕ Tela de Cadastro (CreateUser)

* Campo para nome
* Campo para e-mail
* Botão salvar
* Retorno automático para tela principal após cadastro

---

## ⚙️ Funcionamento interno

### 📌 Lista de usuários

* Os dados são armazenados em uma lista estática:

```java
public static List<String> listaNomes = new ArrayList<>();
```

* Isso permite que os dados sejam compartilhados entre Activities enquanto o app estiver aberto

---

### 📌 RecyclerView + Adapter

O projeto utiliza um Adapter personalizado:

* Classe: `UserAdapter`
* Responsável por:

  * Criar os itens da lista (`onCreateViewHolder`)
  * Vincular dados (`onBindViewHolder`)
  * Controlar quantidade de itens (`getItemCount`)

Exemplo:

```java
holder.tvNome.setText(nome);
```

---

### 📌 Atualização dinâmica da lista

Quando o usuário volta da tela de cadastro:

```java
@Override
protected void onResume(){
    super.onResume();
    adapter.notifyDataSetChanged();
}
```

➡️ Isso garante que novos usuários apareçam automaticamente na lista.

---

## 📂 Estrutura do projeto

```
com.jhonatan.cadastrousuario
│
├── MainActivity.java        # Tela principal com lista de usuários
├── CreateUser.java         # Tela de cadastro
├── UserAdapter.java        # Adapter do RecyclerView
│
├── res/
│   ├── layout/
│   │   ├── activity_main.xml
│   │   ├── activity_create_user.xml
│   │
│   ├── values/
│
└── AndroidManifest.xml
```

---

## 📌 Melhorias futuras

* 💾 Persistência com banco de dados (SQLite ou Firebase)
* ✏️ Edição de usuários
* ❌ Remoção de usuários
* 🔍 Busca de usuários
* 🎨 Melhorias na interface (UI/UX)

---

## 👨‍💻 Autor SrJhol

Desenvolvido por **Jhonatan Mendes**
