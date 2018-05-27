package TextAdventure;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
public class Menu 
{
	static Scanner in = new Scanner(System.in);
	static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	static Date date = new Date();
	static Gameplay g = new Gameplay();
	
	
	@SuppressWarnings({ "static-access", "rawtypes" })
	public static void main(String[] args) throws Exception 
	{
		Weapons ls = new Weapons();
		ls.setName("Long Sword");
		ls.setDmg(4);
		ls.setCrit(10);
		ls.setCritbound(5);
		ls.setCritchance("20%");
		ls.setImage("\r\n" + 
				"         />_________________________________\r\n" + 
				"[########[]_________________________________>\r\n" + 
				"         \\>\r\n" + 
				"");
		
		Weapons s = new Weapons();
		s.setName("Spear");
		s.setDmg(8);
		s.setCrit(4);
		s.setCritbound(3);
		s.setCritchance("33%");
		s.setImage("________________________________________\\`-._\r\n" + 
				   "                                        //.-'");
		
		Weapons b = new Weapons();
		b.setName("Bow");
		b.setDmg(6);
		b.setCrit(7);
		b.setCritbound(4);
		b.setCritchance("25%");
		b.setImage("   (\r\n" + 
				"    \\\r\n" + 
				"     )\r\n" + 
				"##-------->    \r\n" + 
				"     )\r\n" + 
				"    /\r\n" + 
				"   (");
		Weapons fist = new Weapons();
		fist.setName("Fist");
		fist.setDmg(1);
		fist.setCrit(2);
		fist.setCritbound(5);
		
		
		
		
		FileHandling f = new FileHandling();
		int x;
		Scanner a = new Scanner(System.in);
		do 
		{
			System.out.println("\t==================================");
			System.out.println("\t|       Text Adventure v1.0      |");
			System.out.println("\t==================================");
			System.out.println("\t|	0. Exit                  |"); 
			System.out.println("\t|	1. New Game              |");
			System.out.println("\t|	2. Load Game             |");
			System.out.println("\t|       3.View Scores            |");
			System.out.println("\t==================================");
			x = a.nextInt();
			switch(x)
			{
			case 1:
				Player.setGold(0);
				int choice;
				System.out.println("WELCOME TO TEXT ADVENTURE V1.0!");
				do
				{
					System.out.println("");
					System.out.println("Press 1,2 or 3 to view the weapons, press 999 to choose your weapon....");
					choice = a.nextInt();
					switch(choice)
					{
						case 1:
							ls.printweapon();
							break;
						case 2:
							s.printweapon();
							break;
						case 3:
							b.printweapon();
							break;
					}
				
				}while(choice!=999);
				System.out.println("Which weapon do you choose?");
				choice=a.nextInt();
				switch(choice)
				{
				case 1:
					System.out.println("You have chosen the Long Sword!");
					System.out.println("--------------------");
					Player.setWeapon(ls.getName());
					Player.setDmg(ls.getDmg());
					Player.setCrit(ls.getCrit());
					Player.setCritbound(ls.getCritbound());
					break;
				case 2:
					System.out.println("You have chosen the Spear!");
					System.out.println("--------------------");
					Player.setWeapon(s.getName());
					Player.setDmg(s.getDmg());
					Player.setCrit(s.getCrit());
					Player.setCritbound(s.getCritbound());
					break;
				case 3:
					System.out.println("You have chosen the Bow!");
					System.out.println("--------------------");
					Player.setWeapon(s.getName());
					Player.setDmg(b.getDmg());
					Player.setCrit(b.getCrit());
					Player.setCritbound(b.getCritbound());
					break;
				default:
					System.out.println("You decided to not picking any weapon!");
					System.out.println("--------------------");
					Player.setWeapon(fist.getName());
					Player.setDmg(fist.getDmg());
					Player.setCrit(fist.getCrit());
					Player.setCritbound(fist.getCritbound());
					
					break;
				}
				
				g.play();
				System.out.println("Enter your name: ");
				String name = in.next();
				Player.setName(name);
				f.addScore(Player.getName()+" | "+Player.getScore()+" | "+(dateFormat.format(date))+"\n");
				break;
			case 2:
				if(f.checkfile()==true)
				{
					System.out.println("No save game found!");
				}
				else
				{
					ArrayList<List> save=f.loadSave();
					Player.setScore((int)(save.get(0)).get(0));
					Player.setHp((int)(save.get(0)).get(1));
					Player.setHpcap((int)(save.get(0)).get(2));
					Player.setDmg((int)(save.get(0)).get(3));
					Player.setCrit((int)(save.get(0)).get(4));
					Player.setInchp((int)(save.get(0)).get(5));
					Player.setIncdmg((int)(save.get(0)).get(6));
					Player.setGold((int)(save.get(0)).get(7));
					Player.setCritbound((int)(save.get(0)).get(8));
					Player.setWeapon((String)(save.get(2)).get(0));
					for(int i =0;i!=(save.get(1).size());i++)
					{
						Inventory.addInventory((String)(save.get(1)).get(i));
					}
					System.out.println("Game loaded");
					System.out.println("");;
					g.play();
					System.out.println("Enter your name: ");
					name = in.next();
					Player.setName(name);
					f.addScore(Player.getName()+" | "+Player.getScore()+" | "+(dateFormat.format(date))+"\n");
				}
				break;
			case 3:
				f.readScore();
				break;
			}
		} while(x!=0);
		System.out.println("Exit game....");
		System.exit(0);
		a.close();
	}

}
