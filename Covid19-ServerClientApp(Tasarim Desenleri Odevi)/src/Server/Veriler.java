package Server;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;



public class Veriler implements Subject  {
	
	private int gunlukTest;
	private int vakaSayisi;
	private int yogunBHSayisi;
	private int entHSayisi;
	private int oluSayisi;
    private int IyilesenSayisi;
    
	
	
	private Vector<Observer>observers;
	//BURADA AYRICA SERVERCONNECTÝONS ARRAYLIST OLMASI LAIZM.
	

	public Veriler() {
		observers=new Vector<Observer>();
		
	}

	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
		
	}
	

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.remove(o);
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for (Observer observer : observers) {
			int portNo=getPortNo();
			 
			
			String tarih=getTarih();
			observer.update(portNo,gunlukTest, vakaSayisi, yogunBHSayisi,entHSayisi,oluSayisi,IyilesenSayisi,tarih);
			
		}
		
	}
	
	public int getPortNo() {
		return 1567;
	}
	
	public void setVaka(int vaka) {
		
		this.vakaSayisi=vaka;
		
	}

	public void setYogunBHSayisi(int ygb) {
	   yogunBHSayisi=ygb;
	}
	public void setEntHSayisi(int ent) {
		
		entHSayisi=ent;
	}
	public void setOluSayisi(int olus) {
		oluSayisi=olus;
	}
	public void setIyilesen(int iyilesen) {
		IyilesenSayisi=iyilesen;
		
	}
	public String getTarih() {
		Date date=new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
		    String sttarih = formatter.format(date);
		return sttarih;
	}

	public void setTest(int gunlukTest2) {
		// TODO Auto-generated method stub
		this.gunlukTest=gunlukTest2;
		
	}

}
