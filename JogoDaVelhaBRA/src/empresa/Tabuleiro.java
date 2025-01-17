package empresa;

public class Tabuleiro {
	private int mat[][] = new int[3][3];

	Tabuleiro() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				mat[i][j] = 0;
	}

	
	public int situacao() {

		// Confere se tem ganhador ou empate
		if (ConfereSituacao() == 1) {
			System.out.println("Jogador Ganhou!");
			this.imprime();
			return 1;
		} else if (ConfereSituacao() == 2) {
			System.out.println("Computador Ganhou!");
			this.imprime();
			return 2;
		} else if (cheio() == true) {
			System.out.println("Jogo Empatado!");
			return 3;
		}

		//Continua Ate o jogo estar completo, ou com um ganhador
		return 0;
	}

	// reinicia
	public void reset() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				mat[i][j] = 0;
	}

	// verifica se o todos os espa�os est�o marcados
	public Boolean cheio() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (mat[i][j] == 0)
					return false;

		return true;
	}

	public int ConfereSituacao() {
		// Verifica se alguem ganhou o jogo 
		
		for (int i = 0; i < 3; i++)
			if (mat[i][0] > 0 && (mat[i][0] == mat[i][1] && mat[i][1] == mat[i][2])) {
				return mat[i][0];
			}

		for (int i = 0; i < 3; i++)
			if (mat[0][i] > 0 && (mat[0][i] == mat[1][i] && mat[1][i] == mat[2][i])) {
				return mat[0][i];
			}

		
		if (mat[0][0] > 0 && (mat[0][0] == mat[1][1] && mat[1][1] == mat[2][2])) {
			return mat[1][1];
		}

		if (mat[2][0] > 0 && (mat[2][0] == mat[1][1] && mat[1][1] == mat[0][2])) {
			return mat[1][1];
		}

		// Se ninguem ganhou o jogo retorna empate
		if (cheio())
			return 3;
		else
			return 0;// Se n�o estiver cheio continua o jogo
	}

	public void preenchePosicao(PosicaoMarcada m) {
		mat[m.getX()][m.getY()] = m.getMarca();
	}

	public int getPosicao(PosicaoMarcada m) {
		return mat[m.getX()][m.getY()];
	}

	public int getPosicao(int x, int y) {
		return mat[x][y];
	}

	public void imprime() {
		// Desenha a tabela na tela
		System.out.println("  1 2 3");
		for (int i = 0; i < 3; i++) {
			System.out.print(i + 1 + " ");
			for (int j = 0; j < 3; j++) {
			if (mat[i][j] == 0)
			System.out.print("# ");
			else if (mat[i][j] == 1)
			System.out.print("X ");
			else if (mat[i][j] == 2)
			System.out.print("O ");
			}
			System.out.println("");

		}

	}

}