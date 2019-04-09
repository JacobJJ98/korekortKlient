package server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		KøreskolePriserInterface kp = null;
		try {
			//	        KøreskolePriserInterface k = (KøreskolePriserInterface) Naming.lookup("rmi://130.225.170.204:5477/s165477");
			kp = (KøreskolePriserInterface) Naming.lookup("rmi://localhost:1235/koereskolepriser");

			System.out.println("logget ind");

		} catch (Exception e) {
			// TODO: handle exception
		}

		String brugernavn = "s165477";
		String kodeord = "kodekode";

		boolean b = false;
		try {
			b = kp.logIndAdmin(brugernavn, kodeord);			
		} catch (Exception e) {

		}

		System.out.println("admin="+b);
		/*
        Køreskole k = new Køreskole();
        k.id="s165501";
        k.navn="peders køretimer";
        k.adresse="hovedvejen 410";
        k.postnummer=2640;
        k.telefonnummer=22222222;
        k.mail="hejhej@sjov.dk";
        try {
           kp.opretKøreskole(brugernavn, kodeord, k);			
            System.out.println("oprettet køreskole");

		} catch (Exception e) {

		}
        try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        Tilbud t=null;
		try {
			t = new Tilbud();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        t.koreskole_id=k.id;
        t.beskrivelse="hop i kanen også skal jeg nok vise dig sjov!";
        t.bilmarke="andet";
        t.bilstørrelse="lille";
        t.korekort_type="d";
        t.køn="mand";
        t.lynkursus=0;
        t.pris=11000;
        t.tilgængeligeDage = new TilgængeligeDage();
        t.tilgængeligeDage.tilgængelig_mandag=0;
        t.tilgængeligeDage.tilgængelig_tirsdag=1;
        t.tilgængeligeDage.tilgængelig_onsdag=0;
        t.tilgængeligeDage.tilgængelig_torsdag=1;
        t.tilgængeligeDage.tilgængelig_fredag=0;
        t.tilgængeligeDage.tilgængelig_lørdag=1;
        t.tilgængeligeDage.tilgængelig_søndag=0;

        try {
			kp.opretTilbud(brugernavn, kodeord, t);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 */
		try {

			Tilbud  t = new Tilbud();
			t.koreskole_id="s165477";
			t.beskrivelse="besse besse";
			t.bilmarke="lada";
			t.bilstørrelse="mellem";
			t.korekort_type="e";
			t.køn="mand";
			t.lynkursus=1;
			t.pris=11000;
			t.tilgængeligeDage=new TilgængeligeDage();
			t.tilgængeligeDage.tilgængelig_mandag=1;
			t.tilgængeligeDage.tilgængelig_tirsdag=0;
			t.tilgængeligeDage.tilgængelig_onsdag=0;
			t.tilgængeligeDage.tilgængelig_torsdag=0;
			t.tilgængeligeDage.tilgængelig_fredag=0;
			t.tilgængeligeDage.tilgængelig_lørdag=0;
			t.tilgængeligeDage.tilgængelig_søndag=0;

			//kp.aendreTilbud(brugernavn, kodeord, 2, t);
			//kp.opretTilbud(brugernavn, kodeord, t);


		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<Tilbud> tilbud = new ArrayList<Tilbud>();
		try {
			
			tilbud = (ArrayList<Tilbud>) kp.getTilbudKøreskole(brugernavn, kodeord);

			for (int i = 0; i < tilbud.size(); i++) {
				System.out.println(tilbud.get(i).beskrivelse);
			}
			
			System.out.println(tilbud.get(0).beskrivelse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		ArrayListe l = new ArrayListe();
		try {
			l=(ArrayListe) kp.getTilbudKøreskole(brugernavn, kodeord);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(l.get(i).beskrivelse);
		}
		



	}





}
