package SingletonGrafik;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SingletonGrafik extends JFrame {

	
	private static SingletonGrafik ornek;
	private static  Object lock=new Object();
	
	private JLabel testlbl = new JLabel("TEST SAYISI");
	private JLabel vakalbl = new JLabel("VAKA SAYISI");
	private JLabel yngBlbl = new JLabel("YOGUN BAKIM");
	private JLabel entlbl = new JLabel("ENTUBE");
	private JLabel oluSlbl = new JLabel("OLU");
	private JLabel iyilesenlbl = new JLabel("IYILESEN");
	
	private JLabel testcizlbl = new JLabel("");
	private JLabel vakacizlbl = new JLabel("");
	private JLabel ygnBcizlbl = new JLabel("");
	private JLabel entcizlbl = new JLabel("");
	private JLabel oluscizlbl = new JLabel("");
	private JLabel iyicizlbl = new JLabel("");
	private JLabel tarihbl = new JLabel("");
	private JLabel bilgilbl = new JLabel("");
	private String tarih="tarih";
	
	
	private JButton btnNewButton = new JButton("GÜNCELLE");
	
	
	
	private int test,vaka,ygnBs,entHSayisi,oluSayisi,IyilesenSayisi;
	 private int  toplamtest,toplamvaka,toplamYgn,toplament,toplamOlu,toplamiyilesen=0;
	
	
	 public static SingletonGrafik instance() {
			if(ornek==null) {
				synchronized (lock) {
					if(ornek==null) {
						ornek=new SingletonGrafik();
					}
					
				}
			}
			return ornek;
		}
	 
	 private SingletonGrafik() {
		  setBounds(100, 100, 1100, 750);
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			
			//VERÝLERÝ ALDIÐIM BUTON TÝMERLA DÜZELTMEM LAZIM BURAYI
			
			testlbl.setBounds(5, 5, 424, 14);
			getContentPane().add(testlbl);
			
			vakalbl.setBounds(5, 55, 424, 14);
			getContentPane().add(vakalbl);
			
			yngBlbl.setBounds(5, 105, 424, 14);
			getContentPane().add(yngBlbl);
			entlbl.setBounds(5, 155, 424, 14);
			getContentPane().add(entlbl);
			oluSlbl.setBounds(5, 205, 424, 14);
			getContentPane().add(oluSlbl);
			iyilesenlbl.setBounds(5, 255, 424, 14);
			getContentPane().add(iyilesenlbl);
			
			
			
			testcizlbl.setBounds(200, 5, 1500, 14);
			getContentPane().add(testcizlbl);
			
			vakacizlbl.setBounds(200, 55, 424, 14);
			getContentPane().add(vakacizlbl);
			
			ygnBcizlbl.setBounds(200, 105, 424, 14);
			getContentPane().add(ygnBcizlbl);
			
			entcizlbl.setBounds(200, 155, 424, 14);
			getContentPane().add(entcizlbl);
			
			oluscizlbl.setBounds(200, 205, 424, 14);
			getContentPane().add(oluscizlbl);
			
			iyicizlbl.setBounds(200, 255, 424, 14);
			getContentPane().add(iyicizlbl);
			
			
			
			
			
			btnNewButton.setBounds(105, 500, 150, 23);
			getContentPane().add(btnNewButton);
			
		
			
			
				
		 
		 
	 }
	 
	 public void Goster() {
			setVisible(true);
		}
	 public void Ciz() {
		 
		 //BURAYI TIMER KULLANARAK DUZENLEMEM LAZIM.
		 
		 btnNewButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					Socket s1;
					
					
					try {
						s1 = new Socket("localhost",1567);
						InputStream s1In=s1.getInputStream();
						DataInputStream dis= new DataInputStream(s1In);
						String st=new String(dis.readUTF());
						System.out.println(st);
						  test=dis.readInt();	
						 
							toplamtest=toplamtest+test;
						dis.equals(s1In);
						 vaka=dis.readInt();
						toplamvaka= toplamvaka+vaka;
						
						
						dis.equals(s1In);
						
						 ygnBs=dis.readInt();
							toplamYgn= toplamYgn+ygnBs;
							
							
							entHSayisi=dis.readInt();
							toplament= toplament+entHSayisi;
						
							
							oluSayisi=dis.readInt();
							toplamOlu= toplamOlu+oluSayisi;
							
						
							IyilesenSayisi=dis.readInt();
							toplamiyilesen= toplamiyilesen+IyilesenSayisi;
							
							tarih=dis.readUTF();
							 tarihbl.setText(tarih);
							
									
						dis.close();
						s1In.close();
						s1.close();
						 
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String sttest="";
					for(int i=0;i<=toplamtest/5;i++) {
						
						sttest+=("#");
						 testcizlbl.setText(sttest);
						
						
					}
					
					String stvaka="";
					for(int i=0;i<=toplamiyilesen/5;i++) {
						
						stvaka+=("#");
						 vakacizlbl.setText(stvaka);
						
						
					}
					
					String styhn="";
					for(int i=0;i<=toplamYgn/5;i++) {
						
						styhn+=("#");
						ygnBcizlbl.setText(styhn);
						
						
					}
					
					String stent="";
					for(int i=0;i<=toplament/5;i++) {
						
						stent+=("#");
						 entcizlbl.setText(stent);
						
						
					}
					
					String stolu="";
					for(int i=0;i<=toplamOlu/5;i++) {
						
						stolu+=("#");
						 oluscizlbl.setText(stolu);
						
						
					}
					
					String stiyilesen="";
					for(int i=0;i<=toplamiyilesen/5;i++) {
						
						stiyilesen+=("#");
						 iyicizlbl.setText(stiyilesen);
						
						
					}
					
					
					
					 System.out.println(toplamtest);
					 System.out.println(toplament);
					 System.out.println(toplamiyilesen);
					 System.out.println(tarih);
					
				}
			}
			
			);
			 
	 }
	 
	 public void Baslik() {
		
		 setTitle("----COVID-19 --GRAFIK CLIENT-----");
	 }
	 public void Arkaplan() {
		 getContentPane().setBackground(Color.yellow);
		 
	 }
	 public void Tarih() {
		
		
		 tarihbl.setBounds(200, 500, 300, 300);
		 getContentPane().add(tarihbl);
		
		 tarihbl.setForeground(Color.red);;
		 
	 }
	 
	 public void Bilgi() {
		 bilgilbl.setBounds(400, 500, 1000, 300);
		 getContentPane().add(bilgilbl);
		 bilgilbl.setText("HER 5 SAYI ICIN BÝR '#'YI TEMSIL EDER VERILERI ALMAK ICIN GUNCELLEYE TIKLAYIN");
		
		 bilgilbl.setForeground(Color.red);
		
	 }
	 public void Tasarim() {
		 
		 //RENK AYARLARI
		 entcizlbl.setForeground(Color.blue);
		 entlbl.setForeground(Color.DARK_GRAY);
		 iyicizlbl.setForeground(Color.blue);
		 iyilesenlbl.setForeground(Color.DARK_GRAY);
		 oluscizlbl.setForeground(Color.blue);
		 oluSlbl.setForeground(Color.DARK_GRAY);
		 testcizlbl.setForeground(Color.blue);
		 testlbl.setForeground(Color.DARK_GRAY);
		 vakacizlbl.setForeground(Color.blue);
		 vakalbl.setForeground(Color.DARK_GRAY);
		 ygnBcizlbl.setForeground(Color.blue);
		 yngBlbl.setForeground(Color.DARK_GRAY);
		
	 }
	 
	 
}
