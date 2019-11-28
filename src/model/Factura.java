package model;

import java.util.ArrayList;

public class Factura {
	private String idClient;
	private String idEmpleado;
	private ArrayList<Producto> numberProduct;
	private double total;
	/**
	 * @param idClient
	 * @param idEmpleado
	 * @param firstProduct
	 */
	public Factura(String idClient, String idEmpleado, ArrayList<Producto> numberProduct, double total) {
		this.idClient = idClient;
		this.idEmpleado = idEmpleado;
		this.numberProduct = numberProduct;
		this.total = total;
	}
	public String getIdClient() {
		return idClient;
	}
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public ArrayList<Producto> getNumberProduct() {
		return numberProduct;
	}
	public void setNumberProduct(ArrayList<Producto> numberProduct) {
		this.numberProduct = numberProduct;
	}
	@Override
	public String toString() {
		return "idClient: " + idClient + "\n"
				+ " idEmpleado: " + idEmpleado + "\n"
				+ " numberProduct: " + numberProduct + "\n"
				+ " total: " + total;
	}
	
	
	
	
}
