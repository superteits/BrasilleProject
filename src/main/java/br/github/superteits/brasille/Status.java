package br.github.superteits.brasille;

public class Status {

	private long totalExp;
	private long currentExp;
	private int str;
	private int vit;
	private int dex;
	private int agi;
	private int inte;
	private int fp;
	private double flee;
	private boolean canChangeLvl;
	private double critChance;
	
	public Status(long totalExp, long currentExp, int str, int vit, int dex, int agi, int inte, int fp, boolean canChangeLvl, double critChance, double flee) {
		this.totalExp = totalExp;
		this.currentExp = currentExp;
		this.str = str;
		this.vit = vit;
		this.dex = dex;
		this.agi = agi;
		this.inte = inte;
		this.fp = fp;
		this.canChangeLvl = canChangeLvl;
		this.critChance = critChance;
		this.flee = flee;
	}
	
	public int getFp() {
		return this.fp;
	}
	
	public void addFp(int quantidade) {
		this.fp += quantidade; 
	}
	
	public void removeFp(int quantidade) {
		this.fp -= quantidade; 
	}
	
	public int getStr() {
		return this.str;
	}
	
	public void addStr(int quantidade) {
		this.str += quantidade; 
	}
	
	public int getVit() {
		return this.vit;
	}
	
	public void addVit(int quantidade) {
		this.vit += quantidade; 
	}
	
	public int getDex() {
		return this.dex;
	}
	
	public void addDex(int quantidade) {
		this.dex += quantidade; 
	}
	
	public int getAgi() {
		return this.agi;
	}
	
	public void addAgi(int quantidade) {
		this.agi += quantidade; 
	}
	
	public int getInte() {
		return this.inte;
	}
	
	public void addInte(int quantidade) {
		this.inte += quantidade; 
	}
	
	public void toggleCanChangeLvl(boolean canChangeLvl) {
		this.canChangeLvl = canChangeLvl;
	}
    public boolean getCanChangeLvl() {
    	return this.canChangeLvl;
    }
    public double getCritChance() {
    	return this.critChance;
    }
    public void addCritChance(double quantidade) {
    	this.critChance += quantidade;
    }
    public double getFlee() {
    	return this.flee;
    }
    public void addFlee(double quantidade) {
    	this.flee += quantidade;
    }
    public void addTotalExp(long quantidade) {
    	this.totalExp += quantidade;
    }
    public void addCurrentExp(long quantidade) {
    	this.currentExp += quantidade;
    }
    public long getTotalExp() {
    	return this.totalExp;
    }
    public long getCurrentExp() {
    	return this.currentExp;
    }
    public void setTotalExp(long quantity) {
   	 	this.totalExp = quantity;
    }
    public void setCurrentExp(long quantity) {
    	this.currentExp = quantity;
    }
}
