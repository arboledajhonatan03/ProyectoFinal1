package model;

public class Producto {
	private String name;
	private double cost;
	
	/**
	 * @param name
	 * @param cost
	 * @param numProd
	 */
	public Producto(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	/**
	 * @return the numProd
	 */

	
	
	
	
	
	
	@Override
	public String toString() {
		return "name=" + name + ", cost=" + cost;
	}
	
	
	
}
