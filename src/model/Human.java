package model;

import java.util.ArrayList;

public class Human implements Comparable<Human>{
	private String name;
	private boolean empleado;
	private String id;
	private Human left;
	private Human right;
	private Human next;

	
	
	
	/**
	 * @param name
	 * @param empleado
	 * @param id
	 * @param left
	 * @param right
	 * @param next
	 * @param prod
	 */
	public Human(String name, String id) {
		super();
		this.name = name;
		this.empleado = empleado;
		this.id = id;
		this.left = left;
		this.right = right;
		this.next = next;
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
	 * @return the empleado
	 */
	public boolean isEmpleado() {
		return empleado;
	}



	/**
	 * @param empleado the empleado to set
	 */
	public void setEmpleado(boolean empleado) {
		this.empleado = empleado;
	}



	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}



	/**
	 * @return the left
	 */
	public Human getLeft() {
		return left;
	}



	/**
	 * @param left the left to set
	 */
	public void setLeft(Human left) {
		this.left = left;
	}



	/**
	 * @return the right
	 */
	public Human getRight() {
		return right;
	}



	/**
	 * @param right the right to set
	 */
	public void setRight(Human right) {
		this.right = right;
	}



	/**
	 * @return the next
	 */
	public Human getNext() {
		return next;
	}



	/**
	 * @param next the next to set
	 */
	public void setNext(Human next) {
		this.next = next;
	}



	@Override
	public int compareTo(Human o) {
		
		return o.getId().compareTo(id) ;
	}
	
	/** Description : is this a leaf
	 * return boolean
	 */
	
    public boolean leaf( ){
    	boolean p=false;
    	if(left == null && right == null) {
    		p=true;
    	}
        return p;
    }
	
	/** Description : inset a Human in tree
	 */
	public void insertHuman(Human v) throws RepetitiveException {

		 if((compareTo(v)< 0)) {
			
            if( right == null )
            	right = v;
            else
            	right.insertHuman( v );
		}
		else if((compareTo(v)> 0)) {
			
            if( left == null )
            	left = v;
            else
            	left.insertHuman( v );
		}
		else if(compareTo(v)==0) {
				throw new RepetitiveException(" Esta id ya esta siendo usada");
			}
		
	}
	
	/** Description : search the id
	 * return Human
	 */
	public Human searchId(String iden) {
		Human vi = new Human(name, id);

			if(vi.getId().compareTo(iden)==0) {
				return this;
			}
			else if(vi.getId().compareTo(iden)>0){
				return left.searchId( iden );
			}
			else if(vi.getId().compareTo(iden)<0){
				return right.searchId( iden );
			}
	
		
			else 
				return null;
	}
	/** Description :  the weight
	 * return int
	 */
	
    public int weight() {
    	
    	int weight1=0;
    	int weight2=0;
    	
    	if(left  != null)
    		weight1= left.weight();
    	else if(right != null) {
    		weight2= right.weight();
    	}
    	else if(left  == null){
    		weight1=0;
    		
    	}
    	else if(right == null){
    		
    		weight2=0;
    	}
 
        return weight1 + weight2 +1;
    }
	
	/** Description :  the Height
	 * return int
	 */
    public int Height() {
    	
    	
        if( leaf() )
            return 1;
        else{
        	int height1=0;
        	int height2=0;
        	
        	if(left  != null)
        		height1= left.Height();
        	else if(right != null) {
        		height2= right.Height();
        	}
        	else if(left  == null){
        		height1=0;
        		
        	}
        	else if(right == null){
        		
        		height2=0;
        	}

    	    return 1 + Math.max( height1, height2) ;
    	}
    }
    
	@Override
	public String toString() {
		return "Name=" + name + ", empleado=" + empleado + ", id=" + id + ", left=" + left + ", right=" + right
				+ ", next=" + next;
	}



	public int compare(Cliente o1, Cliente o2) {
		int substraction = 0;
		double x = o1.getId().compareTo(o2.getId());
		if(x > 0) {
			substraction = 1;
		}else if(x < 0) {
			substraction = -1;
		}
		return substraction;
	}



	public int compareTo(Empleado em) {
		// TODO Auto-generated method stub
		return 0;
	}
    
	
	
}
