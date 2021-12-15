package tp11et12;

public class AttaqueMorsure extends AttaquePhysique {
	
	public AttaqueMorsure() {
		super("morsure", 60, 100, 25);
	}
	
	@Override
	public AttaqueMorsure genererMemeAttaque(boolean generer) {
		if(generer) {
			return new AttaqueMorsure();
		}
		else {
			return null;
		}
	}

}
