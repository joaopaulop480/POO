
import java.util.LinkedList;
import java.util.Scanner;

public class Time {

	static Scanner sc;

	protected LinkedList<Jogadores> listaJogadores = new LinkedList<Jogadores>();

	protected static LinkedList<Jogadores> SaoPaulo = new LinkedList<Jogadores>();

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int opc = 0;
		Time time = new Time();

		int tamanho = 0;
		boolean primeiroCadastroFeito = false;
		do {
			System.out.println("-----Menu-----");
			System.out.println("1.. Cadastrar Jogador");
			System.out.println("2.. Incluir Jogador no Time");
			System.out.println("3.. Procurar Jogador");
			System.out.println("4.. Excluir Jogador");
			System.out.println("5.. Alterar Jogador");
			System.out.println("9.. Sair");

			System.out.println("Digite sua opção: ");

			opc = Integer.parseInt(sc.nextLine());

			switch (opc) {
			case 1:
				time.Cadastrar();
				primeiroCadastroFeito = true;

				break;
			case 2:

				if (primeiroCadastroFeito) {
					if (tamanho < 10) {

						Jogadores procurado = new Jogadores();
						procurado = time.ProcurarJogador();

						// Ja existe jogador no time?

						if (time.JaExisteTime(procurado.getNumCamiseta())) {
							break;
						} else {
							SaoPaulo.add(procurado);
							tamanho++;
							System.out.println("Jogador incluido no time com sucesso: ");
							break;
						}

					} else {
						System.out.println("Time Completo!!");
					}
				} else {
					System.out.println("Primeiro Cadastre um jogador!!");
				}
				break;
			case 3:
				Jogadores procurado = new Jogadores();
				procurado = time.ProcurarJogador();

				if (procurado == null) {
					System.out.println("Não existe Jogador");
				} else {
					System.out.println(procurado.toString());
				}
				break;
			case 4:

				System.out.println("Informe o numero da Camisa do " + "Jogador que deseja exluir do time: ");
				int numCamisa = Integer.parseInt(sc.nextLine());

				for (Jogadores jogadores : SaoPaulo) {
					if (jogadores.getNumCamiseta() == numCamisa) {
						SaoPaulo.remove(jogadores);
						tamanho--;
						System.out.println("Jogador excluido com Sucesso");
						break;
					}
				}
				break;
			case 5:
				time.alterarJogador();

			default:
				break;
			}

		} while (opc != 9);

	}

	public void Cadastrar() {

		Jogadores jogador = new Jogadores();

		System.out.println("Digite o numero da Camiseta: ");
		int numCamisa = Integer.parseInt(sc.nextLine());
		if (!JaExiste(numCamisa)) {

			jogador.setNumCamiseta(numCamisa);
			System.out.println("Digite o Nome do Jogador: ");
			jogador.setNome(sc.nextLine());

			System.out.println("Digite a Posição do Jogador ");
			jogador.setPosicao(sc.nextLine());

			listaJogadores.add(jogador);

		}

	}

	public Jogadores ProcurarJogador() {
		int opc;
		do {
			System.out.println("----Procurar Jogador-----");
			System.out.println("1 - Numero da Camisa");
			System.out.println("2 - Nome");
			System.out.println("Digite sua opção: ");

			opc = Integer.parseInt(sc.nextLine());

			switch (opc) {
			case 1:

				System.out.println("Informe o numero da Camisa: ");
				Integer camisa = new Integer(Integer.parseInt(sc.nextLine()));

				for (Jogadores jogadores : listaJogadores) {
					if (jogadores.getNumCamiseta() == camisa) {
						return jogadores;
					}
				}
				System.out.println("Numero de Camisa não existe");
				break;
			case 2:
				System.out.println("Informe o nome do Jogador: ");
				String nome = new String(sc.nextLine());

				for (Jogadores jogadores : listaJogadores) {
					if (jogadores.getNome().equals(nome)) {
						return jogadores;
					}
				}

				System.out.println("Nome do Jogador não existe");
				break;
			default:

				System.out.println("Opção Invalida!");
				break;
			}
		} while (opc != 1 || opc != 2);

		return null;
	}

	public void alterarJogador() {
		System.out.println("Informe o numero da Camisa do " + "Jogador que deseja alterar: ");
		for (Jogadores jogadores : listaJogadores) {
			if (jogadores.getNumCamiseta() == Integer.parseInt(sc.nextLine())) {
				System.out.println("Informe o nome do novo Jogador para essa camisa: ");
				jogadores.setNome(sc.nextLine());

			}
		}
	}

	public boolean JaExiste(int numCamisa) {
		for (Jogadores jogadores : listaJogadores) {
			if (jogadores.getNumCamiseta() == numCamisa) {
				System.out.println("Já existe Jogador com esse numero");
				return true;
			}
		}
		return false;
	}

	public boolean JaExisteTime(int numCamisa) {

		for (Jogadores jogadores : SaoPaulo) {
			if (jogadores != null) {
				if (jogadores.getNumCamiseta() == numCamisa) {
					System.out.println("Já existe Jogador no Time");
					return true;
				}
			}
		}
		return false;
	}

}
