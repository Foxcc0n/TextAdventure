package TextAdventure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileHandling {
	private static final String file = "Score.txt";
	private static final String save = "Save.txt";
	private static final String newLine = System.getProperty("line.separator");
	public void addScore(String data)
	{
		BufferedWriter bw = null;
		FileWriter fw = null;
		try
		{
			String content = data;
			File f = new File(file);
			if(!f.exists())
			{
				f.createNewFile();
			}
			fw = new FileWriter(f.getAbsoluteFile(),true);
			bw = new BufferedWriter(fw);
			bw.write(content+newLine);
			System.out.println("Your score has been added to the list!");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(bw!=null)
					bw.close();
				if(fw!=null)
					fw.close();
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	public void readScore()
	{
		BufferedReader br = null;
		FileReader fr = null;
		try
		{
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String sCurrentLine;
			
			br = new BufferedReader(new FileReader(file));
			while((sCurrentLine = br.readLine())!=null)
			{
				if(!sCurrentLine.equals(""))
				{
					System.out.println("\t"+sCurrentLine);
				}
			}

		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(br!=null)
					br.close();
				if(fr!=null)
					fr.close();
				
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
		
		
	}

	@SuppressWarnings("rawtypes")
	public void saveGame(ArrayList<List> a) throws IOException
	{
		FileOutputStream  fos = new FileOutputStream(save);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(a);
        oos.close();
        System.out.println("Game saved!");
        System.out.println("");
	}
	
	public boolean checkfile() throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader(save));     
		if (br.readLine() == null ) {
			br.close();
		    return true;
		}
		else
		{
			br.close();
			return false;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<List> loadSave() throws ClassNotFoundException, IOException
	{
		FileInputStream fis = new FileInputStream(save);
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<List> loadsave;
		loadsave=(ArrayList<List>)ois.readObject();
		ois.close();
		return loadsave;
	}

}
