
public class Tabuleiro {

	int [][] matriz = new int [10][10];
	int [] palpites = new int[2];
	
	
	public void SortearValores(){
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				matriz[i][j] = (int) (Math.random() * 100);
			}
		}
	}
	
	
	public void ListarTabuleiro() {
	
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(matriz[i][j] + "  ");
			}
			System.out.println();
		}
		
		
		
	}
	
	public double VerificarPremio() {
		
	int premiacao = 0;
	int encontrou1 = 0;
	int encontrou2 = 0;
	
	for(int i = 0; i < 10; i++) {
		for(int j = 0; j < 10; j++) {
		
			if(matriz[i][j] == palpites[0]){
				encontrou1++;
			}
			if(matriz[i][j] == palpites[1]){
				encontrou2++;
			}
		}
	}
	
	if(encontrou1 >= 3) {
		premiacao+= encontrou1 * 1000;
	}
	
	if(encontrou2 >= 3) {
		premiacao+= encontrou2 * 1000;
	}	
		
		return premiacao;
	}
	
	public Tabuleiro(int palpite1, int palpeite2) {
		
		palpites[0] = palpite1;
		palpites[1] = palpeite2;
		
		SortearValores();
		ListarTabuleiro();
	}
	
	@Override
	public String toString() {
		System.out.println("Você ganhou " + VerificarPremio() + "reais. ");
		return super.toString();
	}
	
}
