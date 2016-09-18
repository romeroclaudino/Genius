package model.dao;

import java.util.ArrayList;
import java.util.Random;

public class GameDAO
{
	public static ArrayList<Integer> queue = new ArrayList<>();
	public static int index = 0;
	
	public static void insertElement()
	{
		Random rN = new Random();
		queue.add(rN.nextInt(4));
	}
}
