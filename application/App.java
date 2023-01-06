package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class App {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    List<Pessoa> pessoas = new ArrayList<>();
    System.out.print("Digite o número de pessoas: ");
    int number = sc.nextInt();

    for (int i = 1; i <= number; i++) {
      System.out.println("Pessoa #" + i + ":");

      System.out.print("Física ou Jurídica (f/j)? ");
      char pessoaTipo = sc.next().charAt(0);

      System.out.print("Nome: ");
      sc.nextLine();
      String nome = sc.nextLine();

      System.out.print("Renda anual: ");
      double rendaAnual = sc.nextDouble();

      if (pessoaTipo == 'F' || pessoaTipo == 'f') {
        System.out.print("Gastos com saúde: ");
        double saude = sc.nextDouble();
        pessoas.add(new PessoaFisica(nome, rendaAnual, saude));
      } else if (pessoaTipo == 'J' || pessoaTipo == 'j') {
        System.out.print("Quantidade de funcionários: ");
        int funcionários = sc.nextInt();
        pessoas.add(new PessoaJuridica(nome, rendaAnual, funcionários));
      }
    }

    System.out.println();

    System.out.println("IMPOSTOS PAGOS:");

    double totalTaxes = 0.0;

    for (Pessoa pessoa : pessoas) {
      totalTaxes += pessoa.imposto();
      System.out.printf(pessoa.getNome() + ": $ " + String.format("%.2f", pessoa.imposto()) + "\n");
    }

    System.out.printf("TOTAL TAXES: %.2f", totalTaxes);

    sc.close();
  }
}