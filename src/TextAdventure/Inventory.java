package TextAdventure;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	static List<String> inventory = new ArrayList<String>();
	public static void addInventory(String i)
	{
		inventory.add(i);
	}
	
	public List<String> getInventory() {
		return inventory;
	}

	public void setInventory(List<String> inventory) {
		Inventory.inventory = inventory;
	}

	public static void viewInventory()
	{
		System.out.println(inventory);
	}
	
	public static void removeInventory(int i)
	{
		inventory.remove(i);
	}
	public static String viewItem(int i)
	{
		return inventory.get(i);	
	}
	public static int lengthinventory()
	{
		return inventory.size();
	}
	public static String viewSlot(int i)
	{
		return inventory.get(i);
	}

}
