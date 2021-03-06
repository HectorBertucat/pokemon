package tp11et12;

import java.util.Random;

public class AttaqueSpeciale extends Attaque {

	public AttaqueSpeciale(String nom, String[] compatibilites, int puissance, int precision, int nombreRepetitions) {
		super(nom, compatibilites, puissance, precision, nombreRepetitions);
	}

	
	@Override
	public void utiliserAttaque(Pokemon attaquant, Pokemon victime) {

		if (this.getRepetitionsRestantes() > 0 && null != attaquant && null!= victime) {
			Random random = new Random();
			int aleatoireAttaquant = random.nextInt(attaquant.getNiveau() + 1);
			int aleatoireVictime = random.nextInt(victime.getNiveau() + 1);
			int precision = random.nextInt(101);
			
			if (attaquant.getAttaqueSpeciale()+aleatoireAttaquant > victime.getDefenseSpeciale() + aleatoireVictime && precision <= this.getPrecision()) {
				int dommage = random.nextInt(this.getPuissance());
				victime.blessure(dommage);
				this.baisserNombreRepetitions();
				System.out.println("Succes. Dommage au pokemon victime : " +dommage + " HP.");
			}
			
		}


	}

	@Override
	public boolean isCompatible(Pokemon pokemon) {

		boolean isCompatible = false;
		
		if (null != pokemon) {
			int i = 0; 
			
			while (i < this.getCompatibilites().length && ! isCompatible) {
				if (this.getCompatibilites()[i].equals(pokemon.getType())) {
					isCompatible = true;
				}
				i++;
			}
		}
		
		return isCompatible;
	}

	@Override
	public Attaque genererMemeAttaque(boolean generer) {
		if (generer) {
			return new AttaqueSpeciale(this.getNom(), this.getCompatibilites(), this.getPuissance(), 
					this.getPrecision(), this.getNombreRepetitions());
		}
		else {
			return null;
		}
	}
}
