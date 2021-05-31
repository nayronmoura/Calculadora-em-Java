/*
* calculo responsável por realizar todos os elementos de calculo
* Separar números e Operadores
* Realizar o calculo
* */

import java.util.ArrayList;
import java.util.List;
public class Calculos
{
    //método reposável por acionar todo o código
    public double calculadora(String expressao)
    {
        List<Double> listaNumeros = new ArrayList<Double>();
        List<Character> listaOperadores = new ArrayList<Character>();
        listaNumeros = obterNumeros(expressao);
        listaOperadores = obterOperadores(expressao);
        return calcularValor(listaNumeros, listaOperadores);
    }
    //método para calcular todos os valores
    private double calcularValor(List<Double> listaNumeros, List<Character> listaOperadores) {
        double total = 0.0;
        int j=0;
        for (int i = 0; i < listaNumeros.size()-1; i++) {
            if ( total==0.0) {
                double numero1 = listaNumeros.get(i);
                double numero2 = listaNumeros.get(i + 1);
                char operador = listaOperadores.get(i);
                total = executarOperacao(numero1, operador, numero2);
            }
            else if (total>0.0) {
                j++;
                double numero2 = listaNumeros.get(i + 1);
                char operador = listaOperadores.get(j);
                total = executarOperacao(total, operador, numero2);
            }
        }
        double a= total%1;
        System.out.println(a);
        return total;
    }
    //método responsável por executar as operações
    private double executarOperacao(double numero1, char operador, double numero2) {
        double resultado = 0.0;
        if (operador == '+') {
            resultado = numero1 + numero2;
        } else if (operador == '-') {
            resultado = numero1 - numero2;
        } else if (operador == '/') {
            resultado = numero1 / numero2;
        } else if (operador == '*') {
            resultado = numero1 * numero2;
        }
        return resultado;
    }
    //método que retira os números da expressão
    public List<Double> obterNumeros(String expressao) {
        List<Double> listaNumeros = new ArrayList<Double>();
        String numeroEmString = "";
        for (int i = 0; i < expressao.length(); i++) {
            if (isOperador(expressao.charAt(i))) {
                Double numero = Double.valueOf(numeroEmString);
                listaNumeros.add(numero);
                numeroEmString = "";
            } else {
                numeroEmString = numeroEmString.concat("" + expressao.charAt(i));
            }
        }
        if(!numeroEmString.isEmpty())
        {
            Double numero = Double.valueOf(numeroEmString);
            listaNumeros.add(numero);
        }
        return listaNumeros;
    }
    //método que retira os operadores da expressão
    private List<Character> obterOperadores(String expressao) {
        List<Character> listaOperadores = new ArrayList<Character>();
        for (int i = 0; i < expressao.length(); i++) {
            if (isOperador(expressao.charAt(i))) {
                listaOperadores.add(expressao.charAt(i));
            }
        }
        return listaOperadores;
    }
    public boolean isOperador(char caracter) {
        return caracter == '-' || caracter == '+' || caracter == '/' || caracter == '*' || caracter == '(' || caracter == ')';
    }
}
