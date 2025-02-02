package GameProject;

import java.rmi.RemoteException;

import GameProject.business.CampaignManager;
import GameProject.business.CategoryManager;
import GameProject.business.GameManager;
import GameProject.business.PlayerManager;
import GameProject.business.SaleManager;
import GameProject.entities.Campaign;
import GameProject.entities.Category;
import GameProject.entities.Game;
import GameProject.entities.Player;

//

public class Main {

	public static void main(String[] args) throws NumberFormatException, RemoteException{
		
		
		Category category1 = new Category(1, "FPS", "Multiplayer Game");
		CategoryManager categoryManager = new CategoryManager();
		categoryManager.add(category1);
		System.out.println("----------------------------------------------------------------------");
		
		Game game1 = new Game(1, "Call of Duty: Black Ops Cold War", 
				category1.getCategoryId());
		game1.setUnitPrice(600);
		GameManager gameManager = new GameManager();
		gameManager.add(game1);
		System.out.println("----------------------------------------------------------------------");
		
		Player player1 = new Player(1, "Mehmet �a�atay", "ALSANCAK", 1993, "12548659855", "cagatay.alsancak71@gmail.com");
		PlayerManager playerManager = new PlayerManager();
		playerManager.add(player1);
		System.out.println("----------------------------------------------------------------------");
		
		Campaign campaign1 = new Campaign(1, "Black Friday", 20);
		CampaignManager campaignManager = new CampaignManager();
		campaignManager.add(campaign1);
		System.out.println("----------------------------------------------------------------------");
		gameManager.addCampaign(game1, campaign1);
		System.out.println("----------------------------------------------------------------------");
		SaleManager saleManager = new SaleManager();
		saleManager.sell(game1, player1);
		
		
		
		
		
		
		

	}

}
