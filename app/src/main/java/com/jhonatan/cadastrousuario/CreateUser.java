package com.jhonatan.cadastrousuario;
//BLOCO DE IMPORTAÇÃO
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class CreateUser extends AppCompatActivity {
    TextInputEditText editNome, editEmail;
    Button btnSalvar;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);

        editNome = findViewById(R.id.nome_completo);
        editEmail = findViewById(R.id.email);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener( v -> {
            String nome = editNome.getText().toString();
            String email = editEmail.getText().toString();

            if (!nome.isEmpty()){
                MainActivity.listaNomes.add(nome + "(" + email +")");
                finish();;
            }
        });

    }


}
