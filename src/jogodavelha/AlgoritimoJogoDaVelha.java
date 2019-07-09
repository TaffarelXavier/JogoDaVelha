package jogodavelha;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * <p style="font-weight:900;">Classe responsável pela lógia do jogo</p>
 */
public class AlgoritimoJogoDaVelha {

    //O nome do Jogador 1
    static private String NomeJogador1 = "1";
    //O nome do Jogador 2
    static private String NomeJogador2 = "2";
    //Jogador Ativo 1
    static boolean Jogador1Ativo = true;
    //Jogador Ativo 2
    static boolean Jogador2Ativo = false;
    //Número de Vitórias do jogador 1
    static private int VitoriasDoJogador1 = 0;
    //Número de Vitórias do jogador 2
    static private int VitoriasDoJogador2 = 0;
    //Número de partidas empatadas
    static private int PartidasEmpatadas = 0;
    //Altere aqui o nome do desenvolvedor.
    static final String NOME_DO_DESENVOLVEDOR = "Elton";  

    //Altere, aqui, os detalhes do jogo
    static final String DETALHES_SOBRE_JOGO = "O jogo da velha ou jogo do galo ou três em linha é um jogo e passatempo popular. É um jogo de regras extremamente simples, que não traz grandes dificuldades para seus jogadores e é facilmente aprendido.";

    //------------OS BOTÕES DO JOGO-------------
    static private JButton B1;
    static private JButton B2;
    static private JButton B3;
    static private JButton B4;
    static private JButton B5;
    static private JButton B6;
    static private JButton B7;
    static private JButton B8;
    static private JButton B9;

    static private JLabel LabelVitoriasDoJogador1;
    static private JLabel LabelVitoriasDoJogador2;
    private static JLabel LabelPartidasEmpatadas;

    /**
     * <P style="font-weight:900;">Este método serve para iniciar os objetos do formulário da classe JogoDaVelha.</P>
     * <p style="font-weight:900;">Este médoto é chamado dentro da classe JogoDaVelha</p>
     *
     * @param b1
     * @param b2
     * @param b3
     * @param b4
     * @param b5
     * @param b6
     * @param b7
     * @param b8
     * @param b9
     * @param Label1 <p style="font-weight:900;">Label1: VitoriasDoJogador1</p>
     * @param Label2 <p style="font-weight:900;">Label2: VitoriasDoJogador2</p>
     * @param Label3 <p style="font-weight:900;">Label3: PartidasEmpatadas</p>
     */
    public static void configuracoesIniciais(JButton b1, JButton b2, JButton b3, JButton b4, JButton b5,
            JButton b6, JButton b7, JButton b8, JButton b9, JLabel Label1, JLabel Label2, JLabel Label3) {
        B1 = b1;
        B2 = b2;
        B3 = b3;
        B4 = b4;
        B5 = b5;
        B6 = b6;
        B7 = b7;
        B8 = b8;
        B9 = b9;
        LabelVitoriasDoJogador1 = Label1;
        LabelVitoriasDoJogador2 = Label2;
        LabelPartidasEmpatadas = Label3;
    }

    /**
     *
     * @return
     */
    public static String getNomeJogador1() {
        return NomeJogador1;
    }

    /**
     *
     * @param NomeJogador1
     */
    public static void setNomeJogador1(String NomeJogador1) {
        AlgoritimoJogoDaVelha.NomeJogador1 = NomeJogador1;
    }

    /**
     *
     * @return
     */
    public static String getNomeJogador2() {
        return NomeJogador2;
    }

    /**
     *
     * @param NomeJogador2
     */
    public static void setNomeJogador2(String NomeJogador2) {
        AlgoritimoJogoDaVelha.NomeJogador2 = NomeJogador2;
    }

    /**
     * Alterar para quando um ou outro jogador estiver ativo.
     */
    private static void JogadorAtivo() {
        if (Jogador1Ativo == true) {
            Jogador1Ativo = false;
            Jogador2Ativo = true;
        } else {
            Jogador2Ativo = false;
            Jogador1Ativo = true;
        }
        jogadorVencedor("X");
        jogadorVencedor("O");
    }

    /**
     *
     * @param jogadorAtivo
     * @param botao
     */
    public static void iniciarJogo(boolean jogadorAtivo, JButton botao) {
        if (jogadorAtivo == true) {
            if (botao.getText().equals("")) {
                botao.setText("X");
                JogadorAtivo();
            }
        } else {
            if (botao.getText().equals("")) {
                botao.setText("O");
                JogadorAtivo();
            }
        }
    }

    /**
     *
     * @param Jogador
     * @param b1
     * @param b2
     * @param b3
     */
    private static void jogar(String Jogador, JButton b1, JButton b2, JButton b3) {
        if (b1.getText().equals(Jogador)
                && b2.getText().equals(Jogador)
                && b3.getText().equals(Jogador)) {
            b1.setBackground(Color.yellow); //Define a cor amarela
            b2.setBackground(Color.yellow); //Define a cor amarela
            b3.setBackground(Color.yellow); //Define a cor amarela
            if (b1.getText().equals("X")) { //Se for igual a X
                vencedor("Jogador 1");
            } else { //Se for igual a Zero
                vencedor("Jogador 2");
            }
        }
    }

    /**
     * <p style="font-weight:900;">Verifica o empate.</p>
     */
    private static void verificarEmpate() {

        if (!B1.getText().equals("")
                && !B2.getText().equals("")
                && !B3.getText().equals("")
                && !B4.getText().equals("")
                && !B5.getText().equals("")
                && !B6.getText().equals("")
                && !B7.getText().equals("")
                && !B8.getText().equals("")
                && !B9.getText().equals("")) {
            vencedor("Empate");
        }
    }

    /**
     *
     * @param Jogador
     */
    private static void jogadorVencedor(String Jogador) {

        //---------------VERIFICANDO AS LINHAS---------------
        jogar(Jogador, B1, B2, B3);
        jogar(Jogador, B4, B5, B6);
        jogar(Jogador, B7, B8, B9);

        //---------------VERIFICANDO AS COLUNAS---------------
        jogar(Jogador, B1, B4, B7);
        jogar(Jogador, B2, B5, B8);
        jogar(Jogador, B3, B6, B9);

        //---------------VERIFICANDO AS DIAGONAIS-------------
        jogar(Jogador, B1, B5, B9);
        jogar(Jogador, B3, B5, B7);

        //---------------VERIFICANDO EMPATE-------------
        verificarEmpate();
    }
    
    /**
     * <p style="font-weight:900;">No final do jogo, alguém ganhando 
     * ou dando empate, o background dos botões devem ser inicializados, isto é, voltar à cor inicial.</p>
     */
    public static void limparBackgroundButtons() {
       B1.setBackground(Color.WHITE);
       B2.setBackground(Color.WHITE);
       B3.setBackground(Color.WHITE);
       B4.setBackground(Color.WHITE);
       B5.setBackground(Color.WHITE);
       B6.setBackground(Color.WHITE);
       B7.setBackground(Color.WHITE);
       B8.setBackground(Color.WHITE);
       B9.setBackground(Color.WHITE);
    }
    
    /**
     * <p style="font-weight:900;">Mostra a mensagem final ao vencedor</p>
     * @param jogVencedor
     */
    private static void vencedor(String jogVencedor) {
        if (jogVencedor.equals("Jogador 1")) {
            JOptionPane.showMessageDialog(null, "Parabéns, " + NomeJogador1 + "! Você venceu o jogo.", "Congratulations!", 1);
            VitoriasDoJogador1++;
            LabelVitoriasDoJogador1.setText("Número de Vitórias: " + VitoriasDoJogador1);
            resetarCampos();
        }
        if (jogVencedor.equals("Jogador 2")) {
            JOptionPane.showMessageDialog(null, "Parabéns, " + NomeJogador2 + "! Você venceu o jogo.", "Congratulations!", 1);
            VitoriasDoJogador2++;
            LabelVitoriasDoJogador2.setText("Número de Vitórias: " + VitoriasDoJogador2);
            resetarCampos();
        }
        if (jogVencedor.equals("Empate")) {
            JOptionPane.showMessageDialog(null, "Deu velha! Jogo Empatado!", "Atenção!", 2);
            PartidasEmpatadas++;
            LabelPartidasEmpatadas.setText("Número de empates: " + PartidasEmpatadas);
            resetarCampos();
        }
        limparBackgroundButtons();
    }

    /**
     * <p style="font-weight:900;">Limpa os campo e define a jogada inicial para o jogador 1</p>
     */
    public static void resetarCampos() {
        B1.setText("");
        B2.setText("");
        B3.setText("");
        B4.setText("");
        B5.setText("");
        B6.setText("");
        B7.setText("");
        B8.setText("");
        B9.setText("");
        Jogador1Ativo = true;
        Jogador2Ativo = false;

    }

    /**
     * <p style="font-weight:900;">Reseta os campos e inicia um novo jogo</p>
     */
    public static void novoJogo() {
        resetarCampos();
        LabelVitoriasDoJogador1.setText("Número de Vitórias: 0");
        LabelVitoriasDoJogador2.setText("Número de Vitórias: 0");
        LabelPartidasEmpatadas.setText("Número de empates: 0");
        VitoriasDoJogador1 = 0;
        VitoriasDoJogador2 = 0;
        PartidasEmpatadas = 0;
    }

}
