/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbradio;

/**
 *
 * @author bendeati
 */
public class radioClass {
        
    //adattagok
    private byte ora;
    private byte perc;
    private byte adasDb;
    private String nev;
    
    //getterek
    public byte getOra() {
        return ora;
    }

    public byte getPerc() {
        return perc;
    }

    public byte getAdasDb() {
        return adasDb;
    }

    public String getNev() {
        return nev;
    }
    
    //konstruktor

    public radioClass(String sor) {
        String[] d = sor.split(";");
        this.ora = Byte.parseByte(d[0]);
        this.perc = Byte.parseByte(d[1]);
        this.adasDb = Byte.parseByte(d[2]);
        this.nev = d[3];
    }
    
    public int atSzamolPercre()
    {
        return (ora * 60 + perc);
    }
}
