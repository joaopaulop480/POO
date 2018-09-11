
public class Jogadores extends Object {

	private int numCamiseta;
	private String nome;
	private String posicao;
	
	public int getNumCamiseta() {
		return numCamiseta;
	}
	public void setNumCamiseta(int numCamiseta) {
		this.numCamiseta = numCamiseta;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	
	@Override
	public String toString() {
		
		StringBuilder str = new StringBuilder();
		
		str.append("Nome do Jogador: ").append(getNome()).append(" ");
		str.append("Numero da Camida: ").append(getNumCamiseta()).append("\n");
		str.append("Posição: ").append(getPosicao()).append("\n");
		
		return str.toString();
	}
	
	
	
}
