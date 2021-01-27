package alura.com.br.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import alura.com.br.R;
import alura.com.br.dao.AlunoDao;
import alura.com.br.ui.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {
    public static final String TITULO_DA_APPBAR = "Novo  aluno";
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    private final AlunoDao dao = new AlunoDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(TITULO_DA_APPBAR);
        inicializaçaoDosCampos();
        configuraBotaoSalvar();
    }
    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_formulario_botao_aluno_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aluno alunoCriado = criaAluno();
                Salvar(alunoCriado);
            }
        });
    }
    private void inicializaçaoDosCampos() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

    private void Salvar(Aluno aluno) {
        dao.salva(aluno);
        finish();
    }
    private Aluno criaAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();
        return new Aluno(nome, telefone, email);
    }
}