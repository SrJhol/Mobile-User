package com.jhonatan.cadastrousuario;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.List;
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
   //Atributo privado que armazena a referencia dos dados que serão exibidos
    private List<String> listaUsuarios;
    //Construtor que permite que a MainActivity "entregue" a lista de dados para este Adapter
    public UserAdapter(List<String>lista){
        this.listaUsuarios = lista;
    }
    //Metodo 1: Cria do zero o visual de uma linha da lista(+ViewHolder)
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        //LayoutInflater transforma o arquivo XML em um objeto View Java
        //Aqui usamos um layout padrão do android(simple_list_item_1) para facilitar
     View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);

     //Retorna uma nova instancia da nossa classe interna ViewHolder com a View criada
     return new ViewHolder(view);}

      //Metedo 2:Vincula os dados de um ojeto de lista a uma linha especifica da tela
 @Override
public void onBindViewHolder (@NonNull ViewHolder holder, int position) {
 //  Recupera os dados da lista de acordo com a posição que o Android está desenhando agora
  String nome = listaUsuarios.get(position);

  //define o texto no componente visual está guardado dentro de 'holder'
  holder.tvNome.setText(nome);
 }
//Metodo 3: Informa ao Android quantos itens a lista possui ao todo
@Override
public int getItemCount(){
 //Se a lista exister , retorna o tamanho , se não , retorna 0
 return listaUsuarios != null ? listaUsuarios.size():0;
}

//Classe interna ViewHolder: Servir para "segurar" as referencias dos componentes de cada linha
 //Evitar chamadas respectivas ao findViewById, melhorando a performance do RecycleView
 public class ViewHolder extends RecyclerView.ViewHolder{
     TextView tvNome;

     public ViewHolder(@NonNull View itemView){
      super(itemView);
      //Faz o mapeamento do ID do layout para o objeto java
      //android.R.id.text1 é o ID padrão do layout 'simple_list_item_1'
      tvNome = itemView.findViewById(android.R.id.text1);
     }
}

}

