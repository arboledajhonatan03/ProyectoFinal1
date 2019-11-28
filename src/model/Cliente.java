package model;

import java.util.ArrayList;

public class Cliente extends Human {
	private final static String TARJETA = "tarjeta";
	private final static String EFECTIVO = "efectivo";
	private Cliente next;
	private Cliente prev;
	private ArrayList<Producto> prod;
	/**
	 * @param first
	 * @param next
	 * @param prev
	 * @param id 
	 * @param id 
	 * @param name 
	 */
	public Cliente(String id, String name) {
		super(name, id);
		prod = new ArrayList<Producto>();
	}
	public ArrayList<Producto> getProd() {
		return prod;
	}
	public void setProd(ArrayList<Producto> prod) {
		this.prod = prod;
	}
	/**
	 * @return the next
	 */
	public Cliente getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(Cliente next) {
		this.next = next;
	}
	/**
	 * @return the prev
	 */
	public Cliente getPrev() {
		return prev;
	}
	/**
	 * @param prev the prev to set
	 */
	public void setPrev(Cliente prev) {
		this.prev = prev;
	}
     
    public double totalCount() {
    	double total = 0;
    	for (int i = 0; i < prod.size(); i++) {
			total += prod.get(i).getCost();
		}
    	return total;
    }
    
    public void addProducto( Producto p ) {
    	prod.add(p);
    }
    
    public String productNameAndCost() {
    	String msg = " ";
    	for (int i = 0; i < prod.size(); i++) {
			msg += prod.get(i).getName() + prod.get(i).getCost() +"\n";
		}
    	return msg;
    }
    
    
    
}
