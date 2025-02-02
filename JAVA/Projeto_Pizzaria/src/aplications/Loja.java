
package aplications;

import java.util.*;

import entidades.Pizza;
import entidades.Produto;
import entidades.Salgado;
import entidades.Aparencia;

public class Loja {

	public static void main(String[] args) {

		// Atributos
		Scanner leia = new Scanner(System.in);
		char op = 'S';
		char op1;
		char op2;
		char op3;
		String auxCod = " ";
		int pos, quantidade;

		// Listas: armazenam os cat�logos de pizzas e salgados e criam carrinho
		List<Produto> carrinho = new ArrayList<>();
		List<Produto> cardapioPizza = new ArrayList<>();
		List<Produto> cardapioSalgado = new ArrayList<>();
		List<Produto> comidas = new ArrayList<>();

		// Card�pio de Pizzas
		comidas.add(new Produto("G5-1", "Mussarela ", 43.00, 10));
		comidas.add(new Produto("G5-2", "Calabresa ", 39.00, 10));
		comidas.add(new Produto("G5-3", "Portuguesa", 45.00, 10));
		comidas.add(new Produto("G5-4", "Frango    ", 39.00, 10));
		comidas.add(new Produto("G5-5", "Milana    ", 46.00, 10));

		// Card�pio de Salgados
		comidas.add(new Produto("G5-6", "Coxinha   ", 5.00, 10));
		comidas.add(new Produto("G5-7", "P�o Pizza ", 5.00, 10));
		comidas.add(new Produto("G5-8", "Pastel    ", 5.00, 10));
		comidas.add(new Produto("G5-9", "Presunto/Q", 5.00, 10));
		comidas.add(new Produto("G5-10", "Salsicha ", 5.00, 10));

		cardapioPizza.add(new Produto("G5-1", "Mussarela ", 43.00, 10));
		cardapioPizza.add(new Produto("G5-2", "Calabresa ", 39.00, 10));
		cardapioPizza.add(new Produto("G5-3", "Portuguesa", 45.00, 10));
		cardapioPizza.add(new Produto("G5-4", "Frango    ", 39.00, 10));
		cardapioPizza.add(new Produto("G5-5", "Milana    ", 46.00, 10));

		cardapioSalgado.add(new Produto("G5-6", "Coxinha   ", 5.00, 10));
		cardapioSalgado.add(new Produto("G5-7", "P�o Pizza ", 5.00, 10));
		cardapioSalgado.add(new Produto("G5-8", "Pastel    ", 5.00, 10));
		cardapioSalgado.add(new Produto("G5-9", "Presunto/Q", 5.00, 10));
		cardapioSalgado.add(new Produto("G5-10", "Salsicha ", 5.00, 10));

		// A fazer: Mostrar todo o cat�logo de produtos

		// In�cio do Programa

		System.out.println("Voc� deseja comprar? [S/N]");
		op3 = leia.next().toUpperCase().charAt(0);
		int i = 0;
		// Processamentos
		do {
			pos = -1;
			// Escolha: Pizza ou Salgado
			classes.Aparencia.pizzaSalgado();
			op2 = leia.next().toUpperCase().charAt(0);

			// Caso a escolha seja Pizza
			if (op2 == 'P') {

				// Imprime cat�logo de Pizzas
				classes.Aparencia.mostraTLoja();
				for (classes.Produto menu : cardapioPizza) {
					System.out.println(menu.getCodigo() + "\t\t" + menu.getSabor() + "\t\t" + menu.getPreco() + "\t\t"
							+ menu.getEstoque());
				}
				// Caso a escolha seja Salgado
			} else if (op2 == 'S') {

				// Imprime cat�logo de Salgados
				classes.Aparencia.mostraTLoja();
				for (classes.Produto menu : cardapioSalgado) {
					System.out.println(menu.getCodigo() + "\t\t" + menu.getSabor() + "\t\t" + menu.getPreco() + "\t\t"
							+ menu.getEstoque());
				}
			}
//---------------------------------------------------------------------------------------------
			// ^^CODIGO BOM

			System.out.println("SELECIONE O CODIGO DO PRODUTO: ");
			auxCod = leia.next().toUpperCase();

			for (int x = 0; x < comidas.size(); x++) {

				if (comidas.get(x).getCodigo().equals(auxCod)) {
					pos = x;
					break;
				}

			}

			if (pos >= 0) {
				classes.Aparencia.mostraTLoja();
				System.out.printf("%s\t\t%s\t\t%.2f\t\t%d\n", comidas.get(pos).getCodigo(), comidas.get(pos).getSabor(),
						comidas.get(pos).getPreco(), comidas.get(pos).getEstoque());
				System.out.println("Informe quantos tu vai querer :");
				int auxQtde = leia.nextInt();

				if (auxQtde < 0) {
					System.out.println("Impossivel realizar, valor negativo!!! Ae n�o n�!!!");
				} else if (auxQtde == 0) {
					System.out.println("Impossivel realizar, quantidade zero. T� dificil!");
				} else if (comidas.get(pos).getEstoque() == 0) {
					System.out.println("Impossivel realizar, produto sem estoque!!!");
				} else if (comidas.get(pos).getEstoque() < auxQtde) {
					System.out.print("Impossivel realizar, quantidade maior que estoque!!");
				} else {
					comidas.add(new classes.Produto(comidas.get(pos).getCodigo(), comidas.get(pos).getSabor(),
							comidas.get(pos).getPreco(), auxQtde));
				}
			} else {
				System.out.println("Codigo informado n�o existe!!!");
			}
			System.out.println("Continua S-sim ou N-nao :");
			op = leia.next().toUpperCase().charAt(0);
			// int auxQtde = 0;
			// fechamento do carrinho - n�o ta pronto
			// System.out.println("vc vai pagar : R$"+(auxQtde*lista.get(pos).getValor()));
			// carrinho.get(pos).retiraEstoque(auxQtde);
		} while (op == 'S');

		

		double auxTotal = 0;
		for (classes.Produto escolhido : carrinho) {
			for (int x = 0; x < carrinho.size(); x++) {
				if (comidas.get(x).getCodigo().equals(escolhido.getCodigo())) {
					pos = x;
					break;
				}

			}

			System.out.println(escolhido.getCodigo() + "\t" + escolhido.getPreco() + "\t" + escolhido.getEstoque()
					+ "\t" + escolhido.getSabor());
			auxTotal = auxTotal + (escolhido.getPreco() * escolhido.getEstoque());
			carrinho.get(pos).retiraEstoque(escolhido.getEstoque());
		}
	
		System.out.println("FECHAMENTO DA COMPRA");
		System.out.println("COD\tVALOR\tQUANTIDADE\tPRODUTO");
		
		for (classes.Produto escolhido : carrinho) {
			for (int x=0; x<comidas.size(); x++ ) {
				
				if (comidas.get(x).getCodigo().equals(escolhido.getCodigo())) {
					pos = x;
					break;
				}
				
			}
		
		System.out.println(escolhido.getCodigo()+"\t"+escolhido.getPreco()+"\t"+escolhido.getEstoque()+"\t"+escolhido.getSabor());
		auxTotal = auxTotal + (escolhido.getPreco()*escolhido.getEstoque());
		comidas.get(pos).retiraEstoque(escolhido.getEstoque());
	}
		
		for (classes.Produto item : carrinho) {
			System.out.println(item.getCodigo() + "\t" + item.getPreco() + "\t" + item.getEstoque() + "\t" + item.getSabor());
		}
		System.out.println("FECHAMENTO R$: " + auxTotal);

		System.out.println("AT� BREVE!!!");
	}

}