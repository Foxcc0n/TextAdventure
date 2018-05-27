package TextAdventure;

class Weapons
{
	String name;
	int dmg;
	int crit;
	String image;
	int critbound;
	String critchance;
	
	
	public void printweapon()
	{
		System.out.println("Name: "+this.name);
		System.out.println("Damage: "+this.dmg);
		System.out.println("Crit chance: "+ this.critchance);
		System.out.println("Bonus crit damage: "+this.crit);
		System.out.println(getImage());
		System.out.println("================");
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getDmg()
	{
		return dmg;
	}
	
	public int getCrit()
	{
		return crit;
	}
	
	public void setName(String n)
	{
		this.name=n;
	}
	
	public void setDmg(int d)
	{
		this.dmg=d;
	}
	


	public void setCrit(int a) 
	{
		this.crit=a;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	public int getCritbound() {
		return critbound;
	}

	public void setCritbound(int critbound) {
		this.critbound = critbound;
	}

	public String getCritchance() {
		return critchance;
	}

	public void setCritchance(String critchance) {
		this.critchance = critchance;
	}
	




	
	

}
