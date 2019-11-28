package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Empresa {
	private final static double VALOR_TO_DISCOUNT = 50000;
	private final static double DISCOUNT = 0.15;
	private final static double VALOR_TO_FINANCE = 50000;
	private Empleado empleadoRaiz;
	private Cliente first;

	public Empresa() {
		// TODO Auto-generated constructor stub
	}

	public Cliente findIdClient(String id) {
		Cliente comp = null;
		Cliente act = first;
		boolean finded = false;
		
		while(act != null && !finded) {
			if(act.getId().equals(id)) {
				comp = act;
				finded = true;
			}
			act = act.getNext();
		}
		return comp;
	}
	
	public void insertEmployee(Empleado em) throws RepetitiveException {
		if(empleadoRaiz == null) {
			empleadoRaiz = em;
		} else {
			empleadoRaiz.addEmploy(em);
		}
	}
	
	/**
	 * @param t a new Charact
	 * return upda
	 */
	
	public boolean addCliente(Cliente c) throws RepetitiveException {
		boolean added = false;
		Cliente actual = first;
		if(actual == null) {
			added = true;
			first = c;
		}else if(!sameCliente(c)) {
			while(actual!=null && !added) {
				if(actual.getNext()==null) {
					actual.setNext(c);
					actual.getNext().setPrev(actual);
					added = true;
				}
				actual = actual.getNext();
			}
		}else {
			throw new RepetitiveException("El cliente ya existe!"); 
		}
		return added;
	}
	
	public boolean sameCliente(Cliente c) {
		boolean same = false;
		Cliente actual = first;
		while(actual != null && !same) {
			if(actual.compareTo(c)==0) {
				same = true;
			}
			actual = actual.getNext();
		}
		return same;
	}
	
	
	public void orderClients() {
		Cliente actual = first;
		while(actual != null) {
			Cliente next = actual.getNext();
			while(next != null) {
				if(actual.compare(actual, next) > 0) {
					if(actual.getPrev() != null) {
						actual.getPrev().setNext(next);
					}
					if(next.getNext() != null) {
						next.getNext().setPrev(actual);
					}
					actual.setNext(next.getNext());
					next.setPrev(actual.getPrev());
					actual.setPrev(next);
					next.setNext(actual);
					next = actual.getNext();
				}
				else {
					actual = actual.getNext();
					next = next.getNext();
				}
			}
		}
		findTheFirst();
	}
	
	
	
	public void findTheFirst() {
		Cliente actual = first;
		Cliente theFirst = null;
		while(actual != null) {
			theFirst = actual;
			actual = actual.getPrev();
		}
		first = theFirst;
	}
	
	public int ClientNumber() {
		int clients = 0; 
		Cliente actual = first;
		while(actual != null) {
			clients++;
			actual = actual.getNext();
		}
		return clients;
	}
	
	public double totalIncomes() {
		double total = 0;
		
		return total;
	}
	
	/*Cuando el cliente decida que ya tiene los productos suficientes de su compra y decida pagar entonces se debe guardar el valor
	 * de esa venta en un archivo serializado y a la vez se debe vaciar el arraylist de productos de ese cliente.
	 * Se crea una clase llamada factura para almacenar el nombre del empleado que atendio a cada cliente.
	 */
	
	/** Description :  the weight
	 * return int
	 */
    public int weight(){
    	int p =0;
    	if(empleadoRaiz == null)
    		p=0;
    	else
    		p=empleadoRaiz.weight();
        return p;
    }
	/** Description :  the height
	 * return int
	 */
    public int Height() {
    	int p =0;
    	if(empleadoRaiz == null)
    		p=0;	
    	else
    		p=empleadoRaiz.Height();
        return p;
    }
    
    public Human searchId(String id) {
		return empleadoRaiz == null ? null : empleadoRaiz.searchId(id); 
	}
    
    public String listEmployeeInorder() {
    	String msg = "";
    	ArrayList<String> acum = new ArrayList<>();
    	if(empleadoRaiz!=null) {
    		empleadoRaiz.inorder(acum);
    	}for (int i = 0; i < acum.size(); i++) {
			msg += acum.get(i) + "\n";
		}
    	return msg;
    }
    
    public boolean mereceDescuento(Cliente c) {
    	boolean merece = false;
    	if(c.totalCount()>VALOR_TO_DISCOUNT) {
    		merece = true;
    	}
    	return merece;
    }
    
    public double discount(Cliente c){
    	double total = 0;
    	if(mereceDescuento(c)) {
    		total = c.totalCount()*DISCOUNT;
    	}
    	return total;
    }
    
    public void saveClientFile(Cliente c) throws FileNotFoundException, IOException {
    	String msg = "";
    	String idEmployee = JOptionPane.showInputDialog("Digite el id del empleado: ");
    	Factura f = new Factura(c.getId(), idEmployee, c.getProd(), c.totalCount());
    	msg += f.toString();
    	File file = new File("client1.txt");
    	ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(file));
    	oos.writeObject(msg);
    	oos.close();
    }
    
    public void addProduct(Producto p, String idCliente) {
    	Cliente actual = first;
    	boolean added = false;
    	if(actual!=null && !added) {
    		if(actual.getId().equals(idCliente)) {
    			actual.addProducto(p);
    		}
    		actual = actual.getNext();
    	}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
