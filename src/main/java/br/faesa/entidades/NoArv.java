package br.faesa.entidades;

public class NoArv {
	private Integer num;
	private NoArv dir, esq;
	
	public NoArv(Integer num) {
		this.num = num;
		this.dir = null;
		this.esq = null;
	}

	public NoArv getDir() {
		return dir;
	}

	public void setDir(NoArv dir) {
		this.dir = dir;
	}

	public NoArv getEsq() {
		return esq;
	}

	public void setEsq(NoArv esq) {
		this.esq = esq;
	}

	public Integer getNum() {
		return num;
	}
	
	public void setNum (int num) {
		this.num = num;
	}
	
	public String toString () {
		return ""+this.num;
	}
	
	

}
