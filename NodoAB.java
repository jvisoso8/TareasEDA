package git;

public class NodoAB {
	public NodoAB izq;
	public NodoAB der;
	public int fe;
	public int info;
	
	public NodoAB(int dato) {
		this.der= null;
		this.izq = null;
		fe = 0; 
		this.info = dato; 
	}
	
	
	

}
