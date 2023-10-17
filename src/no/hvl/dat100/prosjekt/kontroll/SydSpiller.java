package no.hvl.dat100.prosjekt.kontroll;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;
import no.hvl.dat100.prosjekt.kontroll.spill.Handling;
import no.hvl.dat100.prosjekt.kontroll.spill.HandlingsType;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;
import no.hvl.dat100.prosjekt.modell.Kort;

/**
 * Klasse som for å representere en vriåtter syd-spiller. Strategien er å lete
 * gjennom kortene man har på hand og spille det første som er lovlig.
 *
 */
public class SydSpiller extends Spiller {

	/**
	 * Konstruktør.
	 * 
	 * @param spiller posisjon for spilleren (nord eller syd).
	 */
	public SydSpiller(Spillere spiller) {
		super(spiller);
	}

	/**
	 * Metode for å implementere strategi. Strategien er å spille det første kortet
	 * som er lovlig (også en åtter selv om man har andre kort som også kan
	 * spilles). Dersom man ikke har lovlige kort å spille, trekker man om man ikke
	 * allerede har trukket maks antall ganger. I så fall sier man forbi.
	 * 
	 * @param topp kort som ligg øverst på til-bunken.
	 */
	@Override
	public Handling nesteHandling(Kort topp) {

		// TODO - START
		/* first-fit strategi */
		Handling handling = new Handling(null, topp);

		if (this.getAntallTrekk() < Regler.maksTrekk()) {
			for (int i = 0; i < this.getHand().getAntalKort(); i++) {
				if (Regler.kanLeggeNed(this.getHand().getSamling()[i], topp)) {
					handling.setType(HandlingsType.LEGGNED);
					handling.setKort(this.getHand().getSamling()[i]);
					return handling;
				}
			}
			handling.setType(HandlingsType.TREKK);
		} else {
			handling.setType(HandlingsType.FORBI);
		}
		return handling;

		// TODO - END
	}
}
