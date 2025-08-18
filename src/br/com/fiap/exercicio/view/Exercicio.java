package br.com.fiap.exercicio.view;

import br.com.fiap.exercicio.model.Aluno;

import java.util.*;

public class Exercicio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Criar um mapa de aluno
        Map<Integer, Aluno> alunoMap = new HashMap<Integer, Aluno>();

        //Recuperar todos os alunos (valores no mapa)
        Collection<Aluno> alunos = alunoMap.values();

        //Ler os dados dos alunos
        int opcao = -1;
        String menu = """
                ===========MENU===========
                
                1- Adicionar Aluno
                2- Remover Alunos com média < 3
                └  3- Mostrar Dados dos Alunos
                   4- Mostrar Médias
                   5- Mostrar Média > 6
                   6- Mostrar Idade > 30
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
                for (Aluno a : alunos) {
                    if ((a.getNota1()+ a.getNota2())/2 < 3) {
                        alunos.remove(a);
                    }
                }
            }
            if (opcao == 3) {
                for (Aluno a : alunos) {
                    System.out.println(a);
                }
                //Exibir total de alunos
                System.out.println("\nTOTAL: " + alunos.size());
            }
            if (opcao == 4) {

                //Exibir nomes e médias de todos os alunos
                int somaIdades = 0;
                double somaNotas = 0;
                int maiorIdade = 0;
                int menorIdade = 0;
                for (Aluno a : alunos) {
                    System.out.println("Aluno(a): " + a.getNome() + " Média: " + (a.getNota1()+a.getNota2())/2);

                    somaIdades += a.getIdade();
                    somaNotas += a.getNota1() + a.getNota2();
                    if (a.getIdade() > maiorIdade)
                        maiorIdade = a.getIdade();
                    if (a.getIdade() < menorIdade || menorIdade == 0)
                        menorIdade = a.getIdade();
                }

                //Exibir a média das idades
                System.out.println("\nMédia das idades: " + somaIdades / alunos.size());

                //Exibir a média das notas
                System.out.println("Média das notas: " + somaNotas / alunos.size() / 2);

                //Exibir o aluno com a maior e menor idade
                System.out.println("\nMaior idade: " + maiorIdade);
                System.out.println("Menor idade: " + menorIdade);

            }
            if (opcao == 5) {
                for (Aluno a : alunos) {
                    if ((a.getNota1() + a.getNota2()) / 2 >= 6) {
                        System.out.println(a);
                    }
                }
            }
            if (opcao == 6) {
                for (Aluno a : alunos) {
                    if (a.getIdade() > 30) {
                        System.out.println(a);
                    }
                }
            }
        }
    }
}