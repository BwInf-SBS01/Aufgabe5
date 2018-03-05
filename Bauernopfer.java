/**
  *
  * Beschreibung
  *        
  * @version 1.0 vom 04.10.2017
  * @author Pham Anh Trung
  */

public class Bauernopfer {
  public  int Schachbrett[][]  = new int[8][8];
  public  int Turm = 2 ;
  public  int Bauer = 1;
  public  int TurmPosX;
  public  int TurmPosY;
  public  int BauerPosY;
  public  int Züge = 0;
  public  boolean Tmove = false;
  public  boolean Bmove = true;
  public  boolean capture = false;
  
  public void createSchachbrett (){
	    for (int i1 = 0;i1< 8 ;i1++) {
	      for (int i2 = 0;i2< 8;i2++) {
	        Schachbrett[i1][i2] = 0; 
	      } // end of for
	    } // end of for
	    
	  }
	  
  // Aufgabe 1
  public void setzen1() {
//setzen
	 TurmPosX = 0;
	    TurmPosY = 7;
	    BauerPosY = 3;
for (int i = 0;i< 8 ;i++) {
	Schachbrett [i][BauerPosY] = Bauer;
} // end of for 
Schachbrett [TurmPosX][TurmPosY] = Turm;


  }

  
  // Aufgabe 2
  public void setzen2() {
	 TurmPosX = 7;
	 TurmPosY = 0; 
	 // setzen 
	    for (int i = 0;i< 7 ;i++ ) {
	      Schachbrett[i][i] = Bauer;
	    } // end of for
	    Schachbrett [TurmPosX][TurmPosY] = Turm;
  }
 
  

} // end of class Bauernopfer


