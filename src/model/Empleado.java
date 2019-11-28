package model;

import java.util.ArrayList;

public class Empleado extends Human  {
	private int size;
	private Empleado der;
	private Empleado izq;
	
	/**
	 * @param raiz
	 * @param size
	 */
	public Empleado(int size, String name, String id) {
		super(name, id);
		this.size = size;
	}
	
	public Empleado getDer() {
		return der;
	}

	public void setDer(Empleado der) {
		this.der = der;
	}

	public Empleado getIzq() {
		return izq;
	}

	public void setIzq(Empleado izq) {
		this.izq = izq;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}


	public void addEmploy(Empleado em) throws RepetitiveException {
		if(compareTo(em)==0) {
			throw new RepetitiveException("Este empleado ya existe!");
		}else if(compareTo(em)>0) {
			if(izq==null) {
				izq = em;
			}else {
				izq.addEmploy(em);
			}
		}else {
			if(der==null) {
				der = em;
			}else {
				der.addEmploy(em);
			}
		}
	}

	@Override
	public int compareTo(Empleado em) {
		int substraction = 0;
		double x = this.getId().compareTo(em.getId());
		if(x > 0) {
			substraction = 1;
		}else if(x < 0) {
			substraction = -1;
		}
		return substraction;
	}
	
	public void inorder(ArrayList<String> acum) {
		
		if(izq!=null) {
			izq.inorder(acum);
		}
		acum.add(this.getName());
		if(der!=null) {
			der.inorder(acum);
		}
	}
	
}
