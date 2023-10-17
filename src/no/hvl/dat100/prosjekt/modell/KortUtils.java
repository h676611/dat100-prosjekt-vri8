package no.hvl.dat100.prosjekt.modell;

import java.util.Random;

import no.hvl.dat100.prosjekt.TODO;

public class KortUtils {


	/**
	 * Sorterer en samling. Rekkefølgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling samling av kort som skal sorteres.
	 */

	public static void sorter(KortSamling samling) {

		// TODO - START

		int n = samling.getAntalKort();
		Kort temp;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (samling.getSamling()[j - 1].compareTo(samling.getSamling()[j]) > 0) {
					temp = samling.getSamling()[j - 1];
					samling.getSamling()[j - 1] = samling.getSamling()[j];
					samling.getSamling()[j] = temp;
				}

			}
		}

		// TODO - END
	}

	/**
	 * Stokkar en kortsamling.
	 * 
	 * @param samling samling av kort som skal stokkes.
	 */
	public static void stokk(KortSamling samling) {

		// TODO - START
		Random random = new Random();
		
		KortSamling temp = new KortSamling();
		
		for (int i = 0; i < samling.getAntalKort(); i++) {			
			if (temp.getSamling()[random.nextInt(samling.getAntalKort())] != null) {
				temp.getSamling()[random.nextInt(samling.getAntalKort())] = samling.getSamling()[i];
			}
		}
		samling = temp;
		
		// TODO - END
	}

}
