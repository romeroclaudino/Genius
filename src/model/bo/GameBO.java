package model.bo;

import model.dao.GameDAO;

public class GameBO
{	
	public static boolean verifyAnswer(int answer)
	{	
		return GameDAO.queue.get(GameDAO.index) == answer ? true : false;
	}
}
