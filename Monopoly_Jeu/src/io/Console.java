package io;

import java.io.*;

/**
*Classe permettant d'utiliser le clavier comme entree.
*<DT>Organisation possible des repertoires :
*<PRE>HOME
  |
  outils
    |
    +--classes--outils--fichiers compiles dont <B>Console.class</B>
    |
    +--doc--outils--fichiers de documentation  dont <B>Console.html</B>
    |
    +--src--outils--fichiers sources dont <B>Console.java</B>
*</PRE>
*Mettre .../outils/classes dans le CLASSPATH.
*<DT>sous Unix ou Linux
*<PRE><B>setenv CLASSPATH .:${HOME}/outils/classes</B>
*</PRE>
*<DT>Utilisation habituelle pour saisie au clavier:
*<PRE>
    Console es = new Console();
    //saisie :
    es.print("Nom : ?");
    String nom = es.readLine();
    es.println("Bonjour "+nom);
    es.print(es.readLine());
    es.println(". Termine ");
    .................................
</PRE>
 */

public class Console {

  protected BufferedReader fluxEntree = new BufferedReader(
	new InputStreamReader(System.in));

  private boolean ok;

  public Console() {
    fluxEntree = new BufferedReader(new InputStreamReader(System.in));
  }

  /**
  * Retourne une ligne de texte saisie au clavier.
  */
  public String readLine(){
    String saisie = null;
    try{
	saisie = fluxEntree.readLine();
    }
    catch(IOException e){
	System.out.println(e.getMessage());
	System.exit(0);
    }
    return saisie;
  }

  /**
  *Retourne un entier int saisi au clavier.
  */
  public int readInt(){
    int res = 0 ;
    do{
      try{res = Integer.parseInt(this.readLine()); ok = true;}
      catch(NumberFormatException e){ok = false;}
    }while(!ok);
    return res;
  }


  /**
  *Retourne un entier short saisi au clavier.
  */
  public short readShort(){
    short result = 0 ;
    do{
      try{ result = Short.parseShort(this.readLine());ok = true;}
      catch(NumberFormatException e){ok = false;}
    }while(!ok);
    return result;
  }


  /**
  *Retourne un entier byte saisi au clavier.
  */
  public byte readByte(){
    byte result = 0 ;
    do{
      try{ result = Byte.parseByte(this.readLine());ok = true;}
      catch(NumberFormatException e){ok = false;}
    }while(!ok);
    return result;
  }


  /**
  *Retourne un entier long saisi au clavier.
  */
  public long readLong(){
    long result = 0 ;
    do{
      try{ result = Long.parseLong(this.readLine());ok = true;}
      catch(NumberFormatException e){ok = false;}
    }while(!ok);
    return result;
  }


  /**
  *Retourne un reel double saisi au clavier.
  */
  public double readDouble(){
    double result = 0 ;
    do{
      try{ result = Double.parseDouble(this.readLine());ok = true;}
      catch(NumberFormatException e){ok = false;}
    }while(!ok);
    return result;
  }


  /**
  *Retourne un reel float saisi au clavier.
  */
  public float readFloat(){
    float result = 0 ;
    do{
      try{ result = Float.parseFloat(this.readLine());ok = true;}
      catch(NumberFormatException e){ok = false;}
    }while(!ok);
    return result;
  }

  /**
  * Ecriture de textes avec passage a la ligne.
  */
  public void println(String s){
    System.out.println(s);
  }

  /**
  * Ecriture de textes sans passage a la ligne.
  */
  public void print(String s){
    System.out.print(s);
  }

  /**
  * Ecriture de la traduction d'un objet
  * sous forme de texte avec passage a la ligne.
  */
  public void println(Object s){
    System.out.println(s);
  }

  /**
  * Ecriture de la traduction d'un objet
  * sous forme de texte sans passage a la ligne.
  */
  public void print(Object s){
    System.out.print(s.toString());
  }


  /**
  * Affiche un entier int avec passage a la ligne.
  */
  public void println(int s){
    System.out.println(String.valueOf(s));
  }

  /**
  * Affiche un entier int sans passage a la ligne.
  */
  public void print(int s){
    System.out.print(String.valueOf(s));
  }

  /**
  * Affiche un entier long avec passage a la ligne.
  */
  public void println(long s){
    System.out.println(String.valueOf(s));
  }

  /**
  * Affiche un entier long sans passage a la ligne.
  */
  public void print(long s){
    System.out.print(String.valueOf(s));
  }

  /**
  * Affiche un entier short avec passage a la ligne.
  */
  public void println(short s){
    System.out.println(String.valueOf(s));
  }

  /**
  * Affiche un entier short sans passage a la ligne.
  */
  public void print(short s){
    System.out.print(String.valueOf(s));
  }

  /**
  * Affiche un entier byte avec passage a la ligne.
  */
  public void println(byte s){
    System.out.println(String.valueOf(s));
  }

  /**
  * Affiche un entier byte sans passage a la ligne.
  */
  public void print(byte s){
    System.out.print(String.valueOf(s));
  }

  /**
  * Affiche un reel double avec passage a la ligne.
  */
  public void println(double s){
    System.out.println(String.valueOf(s));
  }

  /**
  * Affiche un reel double sans passage a la ligne.
  */
  public void print(double s){
    System.out.print(String.valueOf(s));
  }

  /**
  * Affiche un reel float avec passage a la ligne.
  */
  public void println(float s){
    System.out.println(String.valueOf(s));
  }

  /**
  * Affiche un reel float sans passage a la ligne.
  */
  public void print(float s){
    System.out.print(String.valueOf(s));
  }

  /**
  * Affiche un boolean avec passage a la ligne.
  */
  public void println(boolean s){
    System.out.println(String.valueOf(s));
  }

  /**
  * Affiche un boolean sans passage a la ligne.
  */
  public void print(boolean s){
    System.out.print(String.valueOf(s));
  }
}