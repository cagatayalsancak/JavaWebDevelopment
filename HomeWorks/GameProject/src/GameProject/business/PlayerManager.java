package GameProject.business;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;



import GameProject.entities.Player;

public class PlayerManager implements PlayerService{
	
	Scanner scanner = new Scanner(System.in);
	
	private static final String emailPattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|io|biz|info|xyz)(.[A-Z]{2})?$";
	
	PlayerCheckAdapter playerValid;
	
	
	@Override
	public boolean isIdentityNumberValid(String identityNumber) {
		if(identityNumber.length() != 11) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean isFirstName(String firstName) {
		if(firstName.length() < 3) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean isSurName(String surName) {
		if(surName.length() < 2) {
			return false;
		}
		return true; 
	}
	
	@Override
	public boolean isEmailAddress(String emailAddress) {
		Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(emailAddress).find();
	}
	
	
	@Override
	public void add(Player player) {
		if(isFirstName(player.getFirstName())
				&& isSurName(player.getSurName())
				&& isIdentityNumberValid(player.getIdentityNumber())
				&& isEmailAddress(player.getEmailAddress())) {
			
			System.out.println("Oyuncu Eklendi : " + player.getFirstName() + " " + player.getSurName());

		} else {
			System.out.println("L�tfen bilgilerinizi kontrol ediniz.");
		}
		
	}
	@Override
	public void update(Player player) {
		System.out.println("Oyuncu ad� giriniz:");
		String firstName = scanner.nextLine();
		
		System.out.println("Oyuncu soyad� giriniz:");
		String surName = scanner.nextLine();
		
		System.out.println("Oyuncu email adresi giriniz:");
		String emailAddress = scanner.nextLine();
		
		System.out.println("Oyuncu TC kimlik numaras� giriniz:");
		String identityNumber = scanner.nextLine();
		
		
		
		if(player.getFirstName() != firstName && player.getSurName() != surName && player.getEmailAddress() != emailAddress && player.getIdentityNumber() != identityNumber) {
			if(isFirstName(firstName) && isSurName(surName) && isIdentityNumberValid(identityNumber)) {
				player.setFirstName(firstName);
				player.setSurName(surName);
				player.setIdentityNumber(identityNumber);
				System.out.println("Oyuncu bilgileri g�ncellendi : " + firstName + " " + surName);
				}
			
		} else {
			System.out.println("L�tfen bilgilerinizi kontrol ediniz.");
		}
		
	}
	@Override
	public void delete(Player player) {
		System.out.println("Oyuncu silindi : " + player.getFirstName() + " " + player.getSurName());
		
	}

	@Override
	public List<Player> getAll() {

		return null;
	}

	
	
}
