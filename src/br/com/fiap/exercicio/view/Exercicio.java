package br.com.fiap.exercicio.view;

import br.com.fiap.exercicio.model.Aluno;

import java.util.*;

public class Exercicio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Criar um mapa de aluno
        Map<Integer, Aluno> alunoMap = new HashMap<Integer, Aluno>();

        //Ler os dados dos alunos
        int opcao = -1;
        String menu = """
                ===========MENU===========
                
                1- Adicionar Aluno
                2- Remover Aluno
                3- Mostrar Dados
                0- Sair
                
                """;

        while (opcao != 0) {

            System.out.println(menu);
            opcao = scanner.nextInt();

            if (opcao == 1) {
                do {
                    System.out.println("Digite o RM do aluno: ");
                    int rm = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o nome do aluno: ");
                    String nome = scanner.nextLine();

                    System.out.println("Digite a idade do aluno: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite a nota 1: ");
                    double nota1 = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Digite a nota 2: ");
                    double nota2 = scanner.nextDouble();
                    scanner.nextLine();

                    //Instanciando classe aluno
                    Aluno aluno = new Aluno(rm, nome, idade, nota1, nota2);

                    //Colocando os valores no mapa
                    alunoMap.put(rm, aluno);

                    //Perguntar se deseja adicionar mais alunos no mapa
                    System.out.println("Deseja cadastrar mais alunos? S-Sim N-Não: ");
                } while (!scanner.nextLine().equalsIgnoreCase("n"));
            }
            if (opcao == 2) {
                System.out.println("Digite o RM do aluno a ser removido: ");
                int rm = scanner.nextInt();
                scanner.nextLine();

                alunoMap.remove(rm);
            }
            if (opcao == 3) {
                //Recuperar todos os alunos (valores no mapa)
                Collection<Aluno> alunos = alunoMap.values();

                for (Aluno a : alunos ) {
                    System.out.println(a);
                }
                //Exibir total de alunos
                System.out.println("TOTAL: " + alunos.size());

                int somaIdades = 0;
                for (Aluno a : alunos) {
                    somaIdades += a.getIdade();
                }
                //Exibir a média das idades
                System.out.println("Média das idades: " + somaIdades/alunos.size());

                double mediaNotas = 0;
                for (Aluno a : alunos) {
                    mediaNotas += a.getNota1() + a.getNota2();
                }
                //Exibir a média das notas
                System.out.println("Média das notas: " + mediaNotas/alunos.size()/2);
            }
        }
    }
}