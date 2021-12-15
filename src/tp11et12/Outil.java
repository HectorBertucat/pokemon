package tp11et12;

public class Outil extends Item implements ChangerItems {

	public Outil(String nom, int frequence, int nombreUtilisations) {
		super(nom, frequence, nombreUtilisations);
	}
	
	
	@Override
	public void utiliser(Modifiable item) {
		if (null != item && this.getUtilisationsRestantes() > 0) {
			item.modifier();
			this.baisserUtilisationsRestantes(1);
		}

	}

	@Override
	public Item genererMemeItem(boolean generer) {
		if (generer) {
			return new Outil(this.getNom(), this.getFrequence(), this.getNombreUtilisations());
		}
		return null;
	}

}
