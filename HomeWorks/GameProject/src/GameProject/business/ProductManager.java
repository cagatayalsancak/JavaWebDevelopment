package GameProject.business;

import GameProject.entities.Campaign;
import GameProject.entities.Product;

public class ProductManager implements ProductService {

	@Override
	public void add(Product product) {
		System.out.println("�r�n eklendi : " + product.getName());
		
	}

	@Override
	public void update(Product product) {
		System.out.println("�r�n g�ncellendi : " + product.getName());
		
	}

	@Override
	public void delete(Product product) {
		System.out.println("�r�n silindi : " + product.getName());
		
	}

	@Override
	public void addCampaign(Product product, Campaign campaign) {
		product.setCampaignDiscountRatio(campaign);
		System.out.println(product.getName() + " adl� �r�ne " + campaign.getName() + " kampanyas� uygulanm��t�r.");
		
	}

}
