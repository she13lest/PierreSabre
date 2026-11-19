package personnages;

public class Ronin extends Humain{
	private int honneur = 1;

	public Ronin(String nom, String boissonFavorite, int argent) {
		super(nom, boissonFavorite, argent);
	}

	public void donner(Commercant beneficiaire) {
		int don = getArgent() / 10;
		parler(beneficiaire.getNom() + " prend ces " + don + " sous.");
		perdreArgent(don);
		beneficiaire.recevoir(don);
	}
	
	public void provoquer(Yakuza adversaire) {
		int force = 2 * honneur;
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		if (force >= adversaire.getReputation()) {
			honneur++;
			parler("Je t’ai eu petit yakusa!");
			int argentGagne = adversaire.perdre();
			gagnerArgent(argentGagne);
		} else {
			honneur--;
			int argentPerdu = getArgent();
			perdreArgent(argentPerdu);
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			adversaire.gagner(argentPerdu);
		}
	}
}
