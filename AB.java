package git;

import arboles.Arboles;
import arboles.NodoDoble;

public class AB {
	
	public NodoAB raiz;
	
	public AB() {
		raiz = null;
	}
	
	public boolean inserta(int dato) {
		
			if(raiz != null) {
				return ins(dato,raiz, null);
			}
			else {
				raiz = new NodoAB(dato);
				return true;
			}
				
		
	}
	
	public boolean ins(int dato, NodoAB ap, NodoAB apPant) {
		boolean bo;
		
		
		if(dato<ap.info) {
			if(ap.izq==null) {
				NodoAB nuevoNodo = new NodoAB(dato);
				ap.izq = nuevoNodo;
				bo = true; 
			}
			else {
				bo = ins(dato, ap.izq,ap);
			}
			if(bo) {
				if(ap.fe == 0) {
					ap.fe = -1;
					return true;
				}
				else {
					if(ap.fe==1) {
						ap.fe = 0;
						return false;
					}
					else {
						ap.fe=-2;
						rota(ap,apPant); 
					}
				}
			}
		}
		else {
			if(dato > ap.info) {
				if(ap.der==null) {
					NodoAB nuevoNodo = new NodoAB(dato);
					ap.der = nuevoNodo;
					bo = true; 
				}
				else {
					bo = ins(dato, ap.der,ap);
				}
				if(bo) {
					if(ap.fe == 0) {
						ap.fe = 1;
						return true;
					}
					else {
						if(ap.fe==-1) {
							ap.fe = 0;
							return false;
						}
						else {
							//rotaciones 
							ap.fe=2;
							rota(ap,apPant);
						}
					}
				}
			}
			else {
				return false;
			}
		}
		
		return bo;
	}
	
	public void rota(NodoAB ap, NodoAB apPant) {
		NodoAB aux; 
		if(ap.fe > 0 ) {
			aux = ap.der;
			if(ap.der.fe==-1) {
				//DI
				System.out.println("DI");
				NodoAB aux1 = aux.izq;
				aux1.der=aux;
				aux1.izq = ap;
				ap.der=null;
				aux.izq= null;
				if(apPant != null){
					if(apPant.der==ap) {
						apPant.der = aux1;
					}
					else {
						apPant.izq = aux1;
					}
				}
				
				if(ap == raiz) {
					raiz = aux1;
				}
				ap.fe= 0;
				aux.fe=0;
				
				
			}
			else {
				//DD
				System.out.println("ap:" + ap.info + " aux:" + aux.info + " Raiz" + raiz.info);
				
				aux.izq= ap;
				ap.der = null;
				if(apPant != null){
					if(apPant.der==ap) {
						apPant.der = aux;
					}
					else {
						apPant.izq = aux;
					}
				}
				
				ap.fe =0;
				aux.fe=0;
				
				if(raiz==ap) {
					raiz = aux;
				}
			}
			
		}
		else {
			aux = ap.izq;
			if(ap.izq.fe==-1) {
				//II
				aux.der= ap;
				ap.izq = null;
				if(apPant != null){
					if(apPant.der==ap) {
						apPant.der = aux;
					}
					else {
						apPant.izq = aux;
					}
				}
				ap.fe =0;
				aux.fe=0;
				
				if(raiz==ap) {
					raiz = aux;
				}
				
			}
			else {
				//ID
				System.out.println("ID");System.out.println("DI");
				NodoAB aux1 = aux.der;
				aux1.izq=aux;
				aux1.der = ap;
				ap.izq=null;
				aux.der= null;
				if(apPant != null){
					if(apPant.izq==ap) {
						apPant.izq = aux1;
					}
					else {
						apPant.der = aux1;
					}
				}
				
				if(ap == raiz) {
					raiz = aux1;
				}
				ap.fe= 0;
				aux.fe=0;
				
				
				
			}
		}
	}
	
	public void imp(NodoAB ap) {
		if(ap != null) {
			System.out.println(ap.info);
			imp(ap.izq);
			imp(ap.der);
		}
	}
	
	public static void main(String[] args) {
        // TODO code application logic here
		
		AB t = new AB();
		
		t.inserta(10);
		t.inserta(20);
		t.inserta(30);
		t.inserta(40);
		t.inserta(50);
		
		t.inserta(8);
		t.inserta(1);
		t.inserta(2);
		
		t.imp(t.raiz);
		
		
    }
}


