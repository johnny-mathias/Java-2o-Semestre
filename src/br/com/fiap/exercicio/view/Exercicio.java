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
            //Perguntar se deseja adicionar mais alunos no mapa
            System.out.println(menu);
            opcao = scanner.nextInt();

            if (opcao == 1) {
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
            }
            if (opcao == 2) {
                System.out.println("Digite o RM do aluno a ser removido: ");
                int rm = scanner.nextInt();
                scanner.nextLine();

                alunoMap.remove(rm);
            }
            if (opcao == 3) {
                for ().out.println(alunoMap.);
            }
        }

    }
}
