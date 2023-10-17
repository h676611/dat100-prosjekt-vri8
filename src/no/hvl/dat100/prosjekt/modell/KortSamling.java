package no.hvl.dat100.prosjekt.modell;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;

/**
 * Struktur for å lagre ei samling kort. Kan lagre hele kortstokken. Det finnes
 * en konstant i klassen Regler som angir antall kort i hver av de 4 fargene.
 * Når programmet er ferdig settes denne til 13, men under utvikling / testing
 * kan det være praktisk å ha denne mindre.
 * 
 */
public class KortSamling {

	private final int MAKS_KORT = 4 * Regler.MAKS_KORT_FARGE;

	private Kort[] samling;
	private int antall;

	/**
	 * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken).
	 */
	public KortSamling() {

		// TODO - START

		samling = new Kort[MAKS_KORT];

		// TODO - END
	}

	/**
	 * Returnerer en tabell med kortene i samlinga. Tabellen trenger ikke være full.
	 * Kortene ligger sammenhengende fra starten av tabellen. Kan få tilgang til
	 * antallet ved å bruke metoden getAntallKort(). Metoden er først og fremst ment
	 * å brukes i testklasser. Om man trenger kortene utenfor, anbefales metoden
	 * getAlleKort().
	 * 
	 * @return tabell av kort.
	 */
	public Kort[] getSamling() {

		return samling;

	}

	/**
	 * Antall kort i samlingen.
	 * 
	 * @return antall kort i samlinga.
	 */
	public int getAntalKort() {

		// TODO - START

		int antall = 0;
		for (int i = 0; i < samling.length; i++) {
			if (samling[i] != null) {
				antall++;
			}
		}
		return antall;

		// TODO - END
	}

	/**
	 * Sjekker om samlinga er tom.
	 * 
	 * @return true om samlinga er tom, false ellers.
	 */
	public boolean erTom() {

		// TODO - START

		for (Kort e : samling) {
			if (e != null) {
				return false;
			}
		}
		return true;

		// TODO - END
	}

	/**
	 * Legg et kort til samlinga.
	 * 
	 * @param kort er kortet som skal leggast til.
	 */
	public void leggTil(Kort kort) {

		// TODO - START

		for (int i = 0; i < samling.length; i++) {
			if (samling[i] == null) {
				samling[i] = kort;
				break;
			}
		}

		// TODO - END

	}

	/**
	 * Legger alle korta (hele kortstokken) til samlinga. Korta vil være sortert
	 * slik at de normalt må stokkes før bruk.
	 */
	public void leggTilAlle() {

		// TODO - START

		for (Kortfarge f : Kortfarge.values()) {
			for (int i = 1; i <= Regler.MAKS_KORT_FARGE; i++) {
				this.leggTil(new Kort(f, i));
			}
		}

		// TODO - END
	}

	/**
	 * Fjerner alle korta fra samlinga slik at den blir tom.
	 */
	public void fjernAlle() {

		// TODO - START

		for (int i = 0; i < samling.length; i++) {
			samling[i] = null;
		}

		// TODO - END
	}

	/**
	 * Ser på siste kortet i samlinga.
	 * 
	 * @return siste kortet i samlinga, men det blir ikke fjernet. Dersom samlinga
	 *         er tom, returneres null.
	 */
	public Kort seSiste() {

		// TODO - START

		if (this.erTom()) {
			return null;
		}
		return samling[this.getAntalKort() - 1];

		// TODO - END

	}

	/**
	 * Tek ut siste kort fra samlinga.
	 * 
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres null.
	 */
	public Kort taSiste() {
		// TODO - START

		if (this.erTom()) {
			return null;
		}
		Kort siste = this.seSiste();
		samling[this.getAntalKort() - 1] = null;
		return siste;

		// TODO - END
	}

	/**
	 * Undersøker om et kort finst i samlinga.
	 * 
	 * @param kort.
	 * 
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	public boolean har(Kort kort) {

		// TODO - START

		for (int i = 0; i < samling.length; i++) {
			if (samling[i] != null && kort != null && samling[i].lik(kort)) {
				return true;
			}
		}

		return false;

		// TODO - END

	}

	/**
	 * Fjernar et kort frå samlinga. Dersom kortet ikke finnest i samlinga, skjer
	 * ingenting med samilingen
	 * 
	 * @param kort kortet som skal fjernast. Dersom kortet ikke finnes, skjer
	 *             ingenting.
	 * @return true om kortet blev fjernet fra samlinga, false ellers.
	 */

	public boolean fjern(Kort kort) {

		// TODO - START

		for (int i = 0; i < samling.length; i++) {
			if (samling[i] != null && kort != null && samling[i].lik(kort)) {
				samling[i] = null;
				return true;
			}
		}

		return false;

		// TODO - END
	}

	/**
	 * Gir kortene som en tabell av samme lengde som antall kort i samlingen
	 * 
	 * @return tabell av kort som er i samlingen, der kort skal ha samme rekkefølge
	 *         som i kortsamlinga.
	 */
	public Kort[] getAllekort() {

		// TODO - START

		Kort[] tab = new Kort[this.getAntalKort()];

		for (int i = 0; i < tab.length; i++) {
			tab[i] = samling[i];
		}
		return tab;

		// TODO - END

	}

}
