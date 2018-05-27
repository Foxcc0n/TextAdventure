
package TextAdventure;
import java.util.*;

public class Gameplay
{
	static Scanner in = new Scanner(System.in);
	static Random rand = new Random();

	public static int randElements()
	{
		int n = rand.nextInt(12)+1;
		return n;
	}
	public static int randCombat()
	{
		int n = rand.nextInt(3)+1;
		return n;
	}
	public static int randCrit()
	{
		int n = rand.nextInt(Player.getCritbound())+1;
		return n;
	}
	public static int toZero(int a)
	{
		return Math.max(0, a);
	}
	
	
	
	

	@SuppressWarnings("rawtypes")
	public void play() throws Exception
	{
		try
		{
			FileHandling f= new FileHandling();
			int score=Player.getScore();
			int currentHP=Player.getHp();
			int hpcap = Player.getHpcap();
			int choice;
			int dmg = Player.getDmg();
			int crit = Player.getCrit();
			int inchp=Player.getInchp();
			int incdmg=Player.getIncdmg();
			int gold=Player.getGold();
			int critbound=Player.getCritbound();
			while(currentHP>0)
			{	boolean gonext=false;
				while(gonext!=true)
				{
					System.out.println("Press 1,2,3 or 4 to choose your direction");
					System.out.println("Press 5 to view your inventory");
					System.out.println("Press 6 to view the shop");
					System.out.println("Press 7 to view player info");
					System.out.println("Press 8 to save the game");
					System.out.println("Press 9 to exit");
					choice = in.nextInt();
					if(choice==1 || choice==2 || choice==3 || choice==4)
					{
						gonext=true;
					}
					else if(choice==5)
					{
						if(Inventory.inventory.isEmpty())
						{
							System.out.println("There is nothing in your inventory!");
							System.out.println("");
							continue;
						}
						while(choice!=999)
						{
							try {
							Inventory.viewInventory();
							System.out.println("Press numbers to use item, press 999 to exit inventory(Array starts at 1)");
							choice = in.nextInt();
							if(choice==999)
							{
								continue;
							}
							else
							{	
								if(Inventory.viewItem(choice-1).equals("Health potion"))
								{
									if(currentHP==hpcap)
									{
										System.out.println("HP already full, can't use more potion!");
									}
									else if(currentHP+10>=hpcap)
									{
										System.out.println("You consumed: "+Inventory.viewItem(choice-1));
										System.out.println("Restored "+(hpcap-currentHP)+" HP! HP at max!");
										currentHP+=(hpcap-currentHP);
										Inventory.removeInventory(choice-1);
									}
									else 
									{
										System.out.println("You consumed: "+Inventory.viewItem(choice-1));
										System.out.println("Restored 10 HP! You now have "+(currentHP+=10)+"HP");
										Inventory.removeInventory(choice-1);
									}
								}
								else if(Inventory.viewItem(choice-1).equals("Attack potion"))
								{
									System.out.println("You consumed: "+Inventory.viewItem(choice-1));
									System.out.println("Damage increased by 4!");
									dmg+=4;
									inchp+=1;
									incdmg+=2;
									Inventory.removeInventory(choice-1);
								}

							}
						}catch(Exception e){
							System.out.println("Input out of range!");
							System.out.println("");
						}
						}
					}
					else if(choice==6)
					{
						boolean outshop=false;
						while(outshop!=true)
						{
							System.out.println("Welcome to the shop!");
							System.out.println("---------------------");
							System.out.println("1.Upgrade weapon - 300 gold");
							System.out.println("2.Health potion - 50 gold");
							System.out.println("3.Increase HP cap - 400 gold");
							System.out.println("4.Sell items");
							System.out.println("5.Exit shop");
							System.out.println("Current gold: "+gold);
							choice=in.nextInt();
							switch(choice)
							{
							case 1:
								if(gold<300)
								{
									System.out.println("Not enough gold!");
									System.out.println("--------------------");
								}
								else 
								{
									System.out.println("Weapon upgraded! Damage increased by 3!");
									System.out.println("--------------------");
									gold-=300;
									dmg+=3;
									incdmg+=1;
								}
								break;
							case 2:
								if(gold<50)
								{
									System.out.println("Not enough gold!");
									System.out.println("--------------------");
								}
								else
								{
									System.out.println("Health potion purchase!");
									Inventory.addInventory("Health potion");
									System.out.println("--------------------");
									gold-=50;
								}
								break;
							case 3:
								if(gold<400)
								{
									System.out.println("Not enough gold!");
									System.out.println("--------------------");
								}
								else
								{
									System.out.println("HP cap increased by 10!");
									hpcap+=10;
									gold-=400;
								}
								break;
							case 4:
								if(Inventory.inventory.isEmpty())
								{
									System.out.println("There is nothing in your inventory!");
									System.out.println("");
									continue;
								}
								while(choice!=999)
								{
									Inventory.viewInventory();
									System.out.println("Press numbers to sell items, press 999 to go back(Array starts at 1, out of bound input will not be tolerate!)");
									choice = in.nextInt();
									if(choice==999)
									{
										break;
									}
									else
									{
										if(Inventory.viewItem(choice-1).equals("Health potion"))
										{
											System.out.println("Sold health potion for 25 gold!");
											Inventory.removeInventory(choice-1);
											gold+=25;
										}
										else if(Inventory.viewItem(choice-1).equals("Attack potion"))
										{
											System.out.println("Sold attack potion for 50 gold!");
											Inventory.removeInventory(choice-1);
											gold+=50;
										}
										else
										{
											System.out.println("Invalid choice!");
										}
										break;
									}
									
								}
							case 5:
								outshop=true;
								break;
							}
							
						}
					}
					else if(choice==7)
					{
						System.out.println("-----------------------");
						System.out.println("Current HP: "+currentHP);
						System.out.println("HP cap: "+hpcap);
						System.out.println("Current damage: "+dmg);
						System.out.println("Current crit damage: "+crit);;
						System.out.println("Current gold: "+gold);
						System.out.println("-----------------------");
					}
					else if(choice==8)
					{
						ArrayList<List> save = new ArrayList<List>();
						ArrayList<Integer> intelements = new ArrayList<Integer>();
						ArrayList<String> strelements = new ArrayList<String>();
						ArrayList<String> weapon = new ArrayList<String>();
						intelements.add(score);
						intelements.add(currentHP);
						intelements.add(hpcap);
						intelements.add(dmg);
						intelements.add(crit);
						intelements.add(inchp);
						intelements.add(incdmg);
						intelements.add(gold);
						intelements.add(critbound);
						weapon.add(Player.getWeapon());
						for(int i=0;i!=Inventory.lengthinventory();i++)
						{
							strelements.add(Inventory.viewSlot(i));
						}
						save.add(intelements);
						save.add(strelements);
						save.add(weapon);
						f.saveGame(save);
					}
					else if(choice==9)
					{
						System.out.println("Are you sure? Press 'y' to confirm");
						String a = in.next();
						if(a.equals("y"))
						{
							System.out.println("Exit game....");
							System.exit(0);
						}
						else
						{
							continue;
						}
					}
					else
					{
						continue;
					}
				}
				int spawn = randElements();
				if(spawn==1 || spawn==2 || spawn==3 || spawn==4)
				{
					int monshp=10+inchp;
					int monsdmg=6+incdmg;
					boolean run=false;
					System.out.println("You encountered a monster!");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
					while(monshp>0 && run!=true && currentHP>0)
					{
						System.out.println("");
						System.out.println("What do you want to do?     |                  Monster HP    : "+monshp);
						System.out.println("1.Attack	            |                  Monster damage: "+monsdmg);
						System.out.println("2.Defend                    |    ");
						System.out.println("3.Run away                  |                  Current HP    : "+currentHP);
						System.out.print(">>>                                            Current damage: "+dmg);
						System.out.println("");
						choice = in.nextInt();
						switch(choice)
						{
						case 1:
							int chancetoblock=randCombat();
							int critchance = randCrit();
							if(chancetoblock==3)
							{
								if(critchance==1)
								{
									System.out.println("You attacked the monster! Dealt "+(dmg+crit)+" damage, a critical hit!");
									System.out.println("The monster blocked the attack!It has "+toZero((monshp-=((dmg+crit)/2)))+" HP left!");
								}
								else
								{
									System.out.println("You attacked the monster! Dealt "+dmg+" damage!");
									System.out.println("The monster blocked the attack! It has "+toZero((monshp-=(dmg/2)))+" HP left!");
								}
							}
							else
							{
								if(critchance==1)
								{
									System.out.println("You attacked the monster! Dealt "+(dmg+crit)+" damage, a critical hit!");
									System.out.println("The monster has "+toZero((monshp-=(dmg+crit)))+" HP left!");
								}
								else
								{
									System.out.println("You attacked the monster! Dealt "+dmg+" damage!");
									System.out.println("The monster has "+toZero((monshp-=dmg))+" HP left!");
								}
							}
							if(monshp<=0)
							{
								System.out.println("The monster died!");
								System.out.println("You gained 100 gold!");
								System.out.println("--------------------");
								score+=100;
								inchp+=4;
								incdmg+=1;
								gold+=100;
								break;
							}
							System.out.println("The monster attacked! Dealt "+monsdmg+" damage! You have "+toZero((currentHP-=monsdmg))+" HP left!");
							break;
							
						case 2:
							chancetoblock=randCombat();
							int chancetoparry=randCombat();
							if(chancetoblock==3)
							{
								System.out.println("You and the monster both defended. No damage dealt!");
							}
							else
							{
								if(chancetoparry==3 || chancetoparry==2)
								{
									System.out.println("You parried the monster attack and dealt "+(dmg-5)+ " damage! The monster has "+toZero((monshp-=(dmg-5)))+" HP left!");
									if(monshp<=0)
									{
										System.out.println("The monster died!");
										System.out.println("You gained 100 gold!");
										System.out.println("--------------------");
										score+=100;
										inchp+=4;
										incdmg+=1;
										gold+=100;
										break;
									}
								}
								else
								{
									System.out.println("Your block breaks ! Recieved "+(monsdmg-5)+" damage! You have "+toZero((currentHP-=(monsdmg-5)))+" HP left!");
								}
							}
							break;
						case 3:
							int chancetotrip=randCombat();
							if(chancetotrip==3)
							{
								System.out.println("You ran away but tripped over a rock, loss 5HP ! You have "+toZero((currentHP-=5))+" HP left!");
								System.out.println("");
								inchp+=4;
								incdmg+=1;
								run=true;
							}
							else
							{
								System.out.println("You ran away safely!");
								System.out.println("");
								inchp+=4;
								incdmg+=1;
								run=true;
							}
							break;
						}
					}
				}
				else if(spawn==5 | spawn==6)
				{
					System.out.println("");
					System.out.println("You found a health potion!");
					System.out.println("");
					Inventory.addInventory("Health potion");
				}
				else if(spawn==7 | spawn==8)
				{
					System.out.println("");
					System.out.println("You found an attack potion");
					System.out.println("");
					Inventory.addInventory("Attack potion");
				}
				else if(spawn==10)
				{
					System.out.println("");
					System.out.println("You found 100 gold!");
					System.out.println("");
					gold+=100;
					inchp+=1;
					incdmg+=1;
				}
				else
				{
					System.out.println("");
					System.out.println("Nothing here");
					System.out.println("");
				}
			}
			System.out.println("You died!");
			Player.setScore(score);
			Player.setGold(gold);
	
		}
		//gotta catch 'em all
		catch(Exception e)
		{
			System.out.println("FATAL ERROR! GAME CRASHES");
			System.exit(0);
		}
	}	
	
}
