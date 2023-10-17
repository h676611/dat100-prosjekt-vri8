package no.hvl.dat100.prosjekt.kontroll;

import java.util.ArrayList;

import no.hvl.dat100.prosjekt.modell.KortSamling;
import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;
import no.hvl.dat100.prosjekt.kontroll.dommer.Tur;
import no.hvl.dat100.prosjekt.kontroll.spill.Handling;
import no.hvl.dat100.prosjekt.kontroll.spill.HandlingsType;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;
import no.hvl.dat100.prosjekt.modell.Kort;
import no.hvl.dat100.prosjekt.modell.KortUtils;

/**
 * Klassen har objektvariaber som er referanser til de spillerne, nord og syd
 * (type ISpiller). Den har ogsÂ en bunke man deler/trekker fra og en bunke man
 * spiller til.
 * 
 */
public class Spill {

	private ISpiller nord;
	private ISpiller syd;

	private Bord bord;

	// antall kort som skal deles ut til hver spiller ved start
	public final static int ANTALL_KORT_START = Regler.ANTALL_KORT_START;

	public Spill() {

		// TODO - START

		this.start();

		// TODO - END

	}

	/**
	 * Gir referanse/peker til bord.
	 * 
	 * @return referanse/peker bord objekt.
	 */
	public Bord getBord() {

		// TODO - START

		return bord;

		// TODO - END

	}

	/**
	 * Gir referanse/peker til syd spilleren.
	 * 
	 * @return referanse/peker til syd spiller.
	 */
	public ISpiller getSyd() {

		// TODO - START

		return syd;

		// TODO - END

	}

	/**
	 * Gir referanse/peker til nord.
	 * 
	 * @return referanse/peker til nord.
	 */
	public ISpiller getNord() {

		// TODO - START

		return nord;

		// TODO - END
	}

	/**
	 * Metoden oppretter to spillere, nord og syd. Det opprettes to bunker, fra og
	 * til. Alle kortene legges til fra. Bunken fra stokkes. Deretter deles det ut
	 * kort fra fra-bunken til nord og syd i henhold til regler. Til slutt tas
	 * øverste kortet fra fra-bunken og legges til til-bunken.
	 * 
	 * Nord har type RandomSpiller (som er forhåndefinert). Syd vil være spiller av
	 * en klasse laget av gruppen (implementeres i oppgave 3).
	 */
	public void start() {

		// TODO - START
		this.bord = new Bord();
		this.nord = new NordSpiller(Spillere.NORD);
		this.syd = new NordSpiller(Spillere.SYD);

		KortSamling bunkeFra = bord.getBunkeFra();
		KortSamling bunkeTil = bord.getBunkeTil();

		bunkeFra.leggTilAlle();
		KortUtils.stokk(bunkeFra);
		this.delutKort();
		bunkeTil.leggTil(bunkeFra.taSiste());

		// TODO - END
	}

	/**
	 * Deler ut kort til nord og syd.
	 * 
	 */
	private void delutKort() {

		// TODO - START
		KortUtils.stokk(bord.getBunkeFra());
		for (int i = 0; i < ANTALL_KORT_START; i++) {
			nord.leggTilKort(bord.taOversteFraBunke());
			syd.leggTilKort(bord.taOversteFraBunke());
		}

		// TODO - END
	}

	/**
	 * Trekker et kort fra fra-bunken til spilleren gitt som parameter. Om
	 * fra-bunken er tom, må man "snu" til-bunken. Se info om metoden
	 * snuTilBunken().
	 * 
	 * @param spiller spilleren som trekker.
	 * 
	 * @return kortet som trekkes.
	 */
	public Kort trekkFraBunke(ISpiller spiller) {

		// TODO - START

		Kort kort = null;
		if (bord.getBunkeFra().erTom()) {
			bord.snuTilBunken();
		}
		kort = bord.taOversteFraBunke();
		spiller.trekker(kort);
		return kort;

		// TODO - END
	}

	/**
	 * Gir neste handling for en spiller (spilt et kort, trekker et kort, forbi)
	 * 
	 * @param spiller spiller som skal handle.
	 * 
	 * @return handlingen som skal utføres av kontroll delen.
	 */
	public Handling nesteHandling(ISpiller spiller) {

		// TODO - START
		// Hint: se på hvilke metoder som er tilgjengelig på en spiller

		Handling handling = new Handling(null, null);

		if (spiller.getAntallTrekk() > Regler.maksTrekk()) {
			handling.setType(HandlingsType.FORBI);
			return handling;
		}
		return handling;

		// TODO - END

	}

	/**
	 * Metoden spiller et kort. Den sjekker at spiller har kortet. Dersom det er
	 * tilfelle, fjernes kortet fra spilleren og legges til til-bunken. Metoden
	 * nullstiller også antall ganger spilleren har trukket kort.
	 * 
	 * @param spiller den som spiller.
	 * @param kort    kort som spilles.
	 * 
	 * @return true dersom spilleren har kortet, false ellers.
	 */
	public boolean leggnedKort(ISpiller spiller, Kort kort) {

		// TODO - START

		if (spiller.getHand().har(kort)) {
			spiller.fjernKort(kort);
			bord.leggNedBunkeTil(kort);
			spiller.setAntallTrekk(0);
			return true;
		}
		return false;

		// TODO - END
	}

	/**
	 * Metode for å si forbi. Må nullstille antall ganger spilleren har trukket
	 * kort.
	 * 
	 * @param spiller spilleren som er i tur.
	 */
	public void forbiSpiller(ISpiller spiller) {

		// TODO - START

		spiller.setAntallTrekk(0);
		Tur.skiftSpiller();

		// TODO - END
	}

	/**
	 * Metode for å utføre en handling (trekke, spille, forbi). Dersom handling er
	 * kort, blir kortet også spilt.
	 * 
	 * @param spiller  spiller som utfører handlingen.
	 * @param handling handling som utføres.
	 * 
	 * @return kort som trekkes, kort som spilles eller null ved forbi.
	 */
	public Kort utforHandling(ISpiller spiller, Handling handling) {

		// TODO - START
		Kort kort = null;

		// Hint: del opp i de tre mulige handlinger og vurder
		// om noen andre private metoder i klassen kan brukes
		// til å implementere denne metoden

		switch (handling.getType()) {
		case FORBI:
			this.forbiSpiller(spiller);
			return null;
		case LEGGNED:
			this.leggnedKort(spiller, handling.getKort());
			return handling.getKort();
		case TREKK:
			return this.trekkFraBunke(spiller);
		default:
			break;

		}
		return null;

		// TODO - END
	}

}