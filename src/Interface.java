import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interface extends JFrame {
    private JPanel MainPainel;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton a1Button;
    private JButton a4Button;
    private JButton a6Button;
    private JButton a3Button;
    private JButton a2Button;
    private JButton a5Button;
    private JPanel Numeros;
    private JButton divisao;
    private JButton xButton;
    private JButton mais;
    private JButton menos;
    private JButton Igual;
    private JButton cButton;
    private JButton DELButton;
    private JLabel Label;
    private JButton a0Button;
    private JButton buttonpoint;
    private JPanel SinaisLeft;
    private JPanel Sinais2;
    private JPanel SinaisBottom;
    private JPanel LabelConteiner;
    private JPanel Conteiner;
    private String Expressao="";
    public Interface(String Titulo){
        super(Titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(MainPainel);
        ImageIcon icone = new ImageIcon("./Calculadora_ico.png");
        this.setIconImage(icone.getImage());
        this.pack();
        Label.setText(" ");
        a9Button.addActionListener(new ActionListener() //botão 9
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                concatenar('9');
            }
        });
        a8Button.addActionListener(new ActionListener()//botão 8
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                concatenar('8');
            }
        });
        a7Button.addActionListener(new ActionListener()//botão 7
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                concatenar('7');
            }
        });
        a6Button.addActionListener(new ActionListener()//botão 6
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                concatenar('6');
            }
        });
        a5Button.addActionListener(new ActionListener()//botão 5
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                concatenar('5');
            }
        });
        a4Button.addActionListener(new ActionListener()//botão 4
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                concatenar('4');
            }
        });
        a3Button.addActionListener(new ActionListener()//botão 3
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                concatenar('3');
            }
        });
        a2Button.addActionListener(new ActionListener()//botão 2
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                concatenar('2');
            }
        });
        a1Button.addActionListener(new ActionListener()//botão 1
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                concatenar('1');
            }
        });
        a0Button.addActionListener(new ActionListener()//botão 0
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                concatenar('0');
            }
        });
        buttonpoint.addActionListener(new ActionListener()//botão .
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                concatenar('.');
            }
        });
        divisao.addActionListener(new ActionListener()//botão /
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                concatenar('/');
                estadobotão(false);
            }
        });
        xButton.addActionListener(new ActionListener()//botão *
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                concatenar('*');
                estadobotão(false);
            }
        });
        mais.addActionListener(new ActionListener()//botão +
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                concatenar('+');
                estadobotão(false);
            }
        });
        menos.addActionListener(new ActionListener() // botão -
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                concatenar('-');
                estadobotão(false);
            }
        });
        Igual.addActionListener(new ActionListener() //botão =
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado();
            }
        });
        cButton.addActionListener(new ActionListener()//botão Clear
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                Expressao="";
                mostrarlabel();
            }
        });
        DELButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removercaractere();
            }
        });
    }
    public static void main(String[] args)
    {
        JFrame frame = new Interface("Calculadora");
        frame.setVisible(true);
        frame.setSize(300,400);
        Scanner scan = new Scanner(System.in);
        Character chara = scan.next().charAt(1);
    }
    private void concatenar(Character caractere)//concatena todos os numeros e sinais enviados para a expressão
    {
        Calculos calc= new Calculos();
        List<Double> listaNumeros = new ArrayList<Double>();
        listaNumeros=calc.obterNumeros(Expressao);
        if(calc.isOperador(caractere)){
            if(listaNumeros.size()>2)
            {
                System.out.println("ERROR");
            }else if(listaNumeros.size()<2){
                Expressao +=caractere;
            }
        }else{
            Expressao +=caractere;
        }
        mostrarlabel();
    }
    private void resultado()//Envia a Expressão para a classe Calculos e mostra o resultado
    {
        Calculos calc = new Calculos();
        double result=calc.calculadora(Expressao);
        if(result%1==0){
            int resultado = (int) Math.round(result);
            Expressao=""+resultado;
        }else{
        Expressao=""+result;
        }

        mostrarlabel();
        estadobotão(true);
    }
    private void mostrarlabel()//envia pro Display os textos
    {
        Label.setText(Expressao);
    }
    private void removercaractere()//remove o ultimo caractere da Expressão, seja número ou sinal
    {
        Calculos calc = new Calculos();
        if(calc.isOperador(Expressao.charAt(Expressao.length()-1))){
            estadobotão(true);
        }
        if(Expressao.length()>0)
        {
            Expressao = Expressao.substring(0, Expressao.length() - 1);
        }
        mostrarlabel();
    }
    private void estadobotão(boolean estado){
        mais.setEnabled(estado);
        menos.setEnabled(estado);
        divisao.setEnabled(estado);
        xButton.setEnabled(estado);
    }
}