/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbradio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author bendeati
 */
public class CBradio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<radioClass> lista = new ArrayList<>();
        
        //beolvasás
        try 
        {
            FileReader fajl = new FileReader("cb.txt");
            BufferedReader br = new BufferedReader(fajl);
            String sor = br.readLine(); //fejléc beolvasása
            while ((sor = br.readLine()) != null) 
            {                
                radioClass cb = new radioClass(sor);
                lista.add(cb);
            }
            br.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Hiba a beolvasásákor! " + e);
        }
        
        System.out.println("3. feladat");
        System.out.println("Bejegyzések száma: " + lista.size());
        
        System.out.println("4. feladat");
        boolean megvan = false;
        int i = 0;
        while(megvan == false && i < lista.size())
        {
            if(lista.get(i).getAdasDb() == 4)
            {
                megvan = true;
                System.out.println("Van pontosan 4 adás!");
            }
            i++;
        }
        if(megvan == false) System.out.println("Nincs pontosan 4!");
        
        
        System.out.println("5. feladat");
        Scanner be = new Scanner(System.in);
        System.out.print("Kérem egy sofőr nevét: ");
        String sofor = be.next();
        int adasDbOsszeg = 0;
        for (radioClass cbradio : lista) {
            if(cbradio.getNev().equals(sofor))
            {
                adasDbOsszeg += cbradio.getAdasDb();
            }
        }
        if (adasDbOsszeg == 0) 
        {
            System.out.println("Nincs ilyen sofőr!");
        }
        else
        {
            System.out.println(sofor + " " + adasDbOsszeg + " alkalommal használta"
                    + " a rádiót!");
        }
        
        //7. feladat
        try 
        {
            System.setProperty("file.encoding","UTF8");
            PrintWriter pw = new PrintWriter("cb2.txt");
            pw.println("Kezdes;Nev;AdasDb");
            for (radioClass cbradio : lista) {
                pw.println(cbradio.atSzamolPercre() + ";" + 
                        cbradio.getNev() + ";" + 
                        cbradio.getAdasDb());
            }
            pw.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Hiba az íráskor!" + e);
        }
        
        System.out.println("8. feladat");
        ArrayList<String> nevek = new ArrayList<>();
        for (radioClass cbradio : lista) {
            if(!nevek.contains(cbradio.getNev())){
                nevek.add(cbradio.getNev());
            }
        }
        System.out.println("Ennyi sofőr van: " + nevek.size());
        
        System.out.println("9. feladat");
        ArrayList<Integer> hivasok = new ArrayList<>();
        for (String nev : nevek) 
        {
            int osszeg = 0;
            for (radioClass cbradio : lista) 
            {
                if(nev.equals(cbradio.getNev()))
                {
                  osszeg += cbradio.getAdasDb();
                }
            }
            hivasok.add(osszeg);
        }
        //legtöbb hívás megállapítása
        int maxAdas = hivasok.get(0);
        int maxIndex = 0;
        for (int j = 0; j < hivasok.size(); j++) {
            if(hivasok.get(j) > maxAdas)
            {
                maxAdas = hivasok.get(j);
                maxIndex = j;
            }
        }
        //maximum kiírása
        System.out.println("Legtöbb hívást bonyolította:");
        System.out.println(nevek.get(maxIndex));
        System.out.println("Hívások száma: " + maxAdas);
        
    }
    
}
    

