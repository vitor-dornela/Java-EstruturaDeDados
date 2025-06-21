package br.faesa.aula8_arvores;

import br.faesa.entidades.NoArv;
import br.faesa.aula2_lista_contigua.LCInteiro;

public class ABBInt {
	/*
	 * Operacoes
	 * 1 - construtor  ok
	 * 2 - pesquisa   ok
	 * 3 - inserir   ok
	 * 4 - remover  ok
	 * 5 - como caminhar
	 * 6 - toString
	 * 7 - balancear
	 */

	// Atributos
	private NoArv raiz;
	private int quant;
	public ABBInt() {
		this.raiz = null;
		this.quant = 0;
	}

	public NoArv pesquisa (int num) {
		return pesquisa(num, raiz);
	}
	private NoArv pesquisa (int num, NoArv no) {
		if (no == null) {
			return null;
		}
		if (num == no.getNum()) {
			return no;
		}
		if (num > no.getNum()) {
			return pesquisa(num, no.getDir());
		}
		return pesquisa(num, no.getEsq());
	}

	public boolean insere (int num) {
		if (pesquisa(num) == null) {
			this.raiz = insere (num, this.raiz);
			return true;
		}
		return false;
	}

	private NoArv insere(int num, NoArv no) {
		if (no==null) {
			NoArv novo = new NoArv(num);
			this.quant++;
			return novo;
		}
		if (num < no.getNum()) {
			no.setEsq (insere (num, no.getEsq()));
		}else {
			no.setDir (insere (num, no.getDir()));
		}
		return no;
	}

	public NoArv remove (int num) {
		NoArv[] removido = new NoArv[1];
		this.raiz = remove (num, this.raiz, removido);
		return removido[0];
	}

	private NoArv remove (int num, NoArv no, NoArv[] removido) {
		if (no == null) {
			removido [0]=null;
			return no;
		}
		if (num < no.getNum()) {
			no.setEsq(remove(num, no.getEsq(), removido));
		} else if (num > no.getNum()) {
			no.setDir(remove(num, no.getDir(), removido));
		} else {
			removido [0] = no;
			this.quant--;
			if (no.getDir()== null) {
				return no.getEsq();
			} else if (no.getEsq() == null) {
				return no.getDir();
			} else {
				no.setEsq(maiorEsq(no, no.getEsq()));
			}
		}

		return no;
	}

	private NoArv maiorEsq(NoArv noRemovido, NoArv maior) {
		/*
		 * andar para a direita o maximo possivel, procurando o maior
		 * da esquerda.
		 */
		if (maior.getDir() != null) {
			maior.setDir(maiorEsq(noRemovido, maior.getDir()));
			return maior;
		}
		noRemovido.setNum(maior.getNum());
		return maior.getEsq();
	}
	public LCInteiro CamInOrdem() {
		LCInteiro vetor = new LCInteiro(this.quant);
		fazCamInOrdem(vetor, this.raiz);
		return (vetor);
	}

	private void fazCamInOrdem(LCInteiro vetor, NoArv no) {
		if (no != null) {
			fazCamInOrdem(vetor, no.getEsq());
			vetor.insereFinal(no.getNum());
			fazCamInOrdem(vetor, no.getDir());
		}
	}

	public LCInteiro CamPreOrdem() {
		LCInteiro vetor = new LCInteiro(this.quant);
		fazCamPreOrdem(vetor, this.raiz);
		return (vetor);
	}

	private void fazCamPreOrdem(LCInteiro vetor, NoArv no) {
		if (no != null) {
			vetor.insereFinal(no.getNum());
			fazCamPreOrdem(vetor, no.getEsq());
			fazCamPreOrdem(vetor, no.getDir());
		}
	}

	public LCInteiro CamPosOrdem() {
		LCInteiro vetor = new LCInteiro(this.quant);
		fazCamPosOrdem(vetor, this.raiz);
		return (vetor);
	}

	private void fazCamPosOrdem(LCInteiro vetor, NoArv no) {
		if (no != null) {
			fazCamPosOrdem(vetor, no.getEsq());
			fazCamPosOrdem(vetor, no.getDir());
			vetor.insereFinal(no.getNum());
		}
	}

	public ABBInt balancear() {
		LCInteiro vetor = CamInOrdem();
		ABBInt arvAux = new ABBInt();
		balancear(vetor, arvAux, 0, vetor.getQuant() - 1);
		return arvAux;
	}

	private void balancear(LCInteiro vetor, ABBInt arv, int esq, int dir) {
		int meio;

		if (esq <= dir) {
			meio = (esq + dir) / 2;
			arv.insere(vetor.get(meio));
			balancear(vetor, arv, esq, meio - 1);
			balancear(vetor, arv, meio + 1, dir);
		}
	}







}
