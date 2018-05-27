package TextAdventure;
public class Player 
{
	private static int hp = 50;
	private static String name;
	private static int Score;
	private static String weapon;
	private static int dmg;
	private static int critdmg;
	private static int gold;
	private static int critbound;
	private static int inchp;
	private static int incdmg;
	private static int hpcap=50;
	
	public static void setHp(int hp) {
		Player.hp = hp;
	}

	public static int getCritbound() {
		return critbound;
	}

	public static void setCritbound(int d) {
		Player.critbound = d;
	}

	public static int getGold() {
		return gold;
	}

	public static void setGold(int gold) {
		Player.gold = gold;
	}

	public static void setName(String n)
	{
		name = n;
	}
	
	public static String getName()
	{
		return name;
	}
	
	public static void setScore(int s)
	{
		Score = s;
	}
	
	public static int getScore()
	{
		return Score;
	}
	
	public Player()
	{
		Player.name="";
		Player.Score=0;
	}
	
	public Player(String n, int s)
	{
		Player.name=n;
		Player.Score=s;
	}
	
	public static void setWeapon(String w)
	{
		Player.weapon=w;
	}
	
	public static String getWeapon()
	{
		return weapon;
	}
	
	public static void setDmg(int d)
	{
		Player.dmg=d;
	}
	
	public static int getDmg()
	{
		return dmg;
	}
	
	public static int getHp()
	{
		return hp;
	}
	
	public static void setCrit(int a)
	{
		Player.critdmg=a;
	}
	
	public static int getCrit()
	{
		return critdmg;
	}

	public static int getInchp() {
		return inchp;
	}

	public static void setInchp(int inchp) {
		Player.inchp = inchp;
	}

	public static int getIncdmg() {
		return incdmg;
	}

	public static void setIncdmg(int incdmg) {
		Player.incdmg = incdmg;
	}

	public static int getHpcap() {
		return hpcap;
	}

	public static void setHpcap(int hpcap) {
		Player.hpcap = hpcap;
	}
	
	

	
	
}