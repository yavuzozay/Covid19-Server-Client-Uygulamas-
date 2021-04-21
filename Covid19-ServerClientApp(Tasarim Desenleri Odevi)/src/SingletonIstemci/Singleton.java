package SingletonIstemci;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Singleton extends JFrame{
	
	private static Singleton ornek;
	private static  Object lock=new Object();
	private JButton btnNewButton2 = new JButton("kaydet");
	
	private int test;
	private int vaka;
	private int ygnBs;
	private int entHSayisi;
	private int oluSayisi;
    private int IyilesenSayisi;
    private String tarih;
    private JLabel tarihlbl= new JLabel("Tarih ");
    private JLabel bilgilbl=new JLabel("");
	 int toplamtest=0;
	 int toplamvaka,toplamYgn,toplament,toplamOlu,toplamiyilesen=0;
	 
	 
	 public static Singleton instance() {
			if(ornek==null) {
				synchronized (lock) {
					if(ornek==null) {
						ornek=new Singleton();
					}
					
				}
			}
			return ornek;
		}
	private Singleton() {
		
		setBounds(100, 100, 1100, 750);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		JLabel gunlukTestlbl = new JLabel("Günlüktest Sayisi	");
		gunlukTestlbl.setBounds(700, 100, 500, 14);
		getContentPane().add(gunlukTestlbl);
		
		
		JLabel vakaSayisilbl = new JLabel("Vaka Sayisi");
		vakaSayisilbl.setBounds(700, 150, 500, 14);
		getContentPane().add(vakaSayisilbl);
		
		JLabel yogunblbl = new JLabel("Yogun bakim hasta:  ");
		yogunblbl.setBounds(700, 200, 500, 14);
		getContentPane().add(yogunblbl);
		
		JLabel enthlbl = new JLabel("Entube Hasta :");
		enthlbl.setBounds(700, 250, 500, 14);
		getContentPane().add(enthlbl);
		
		JLabel olusayisilbl = new JLabel("Olu Sayisi");
		olusayisilbl.setBounds(700, 300, 500, 14);
		getContentPane().add(olusayisilbl);
		
		JLabel iyilesenlbl = new JLabel("Iyilesen Sayisi");
		iyilesenlbl.setBounds(700, 350, 500, 14);
		getContentPane().add(iyilesenlbl);
		
		
		
		JLabel toplamTestlbl = new JLabel("TOPLAM TEST SAYISI   :");
		toplamTestlbl.setBounds(20, 100, 500, 14);
		getContentPane().add(toplamTestlbl);
		
		JLabel toplamVakalbl = new JLabel("TOPLAM VAKA SAYISI   :");
		toplamVakalbl.setBounds(20, 150, 500, 14);
		getContentPane().add(toplamVakalbl);
		
		JLabel toplamYgnlbl = new JLabel("TOPLAM YOGUN BAKIM SAYISI   :");
		toplamYgnlbl.setBounds(20, 200, 500, 14);
		getContentPane().add(toplamYgnlbl);
		
		JLabel toplamEntlbl = new JLabel("TOPLAM ENTUBE SAYISI   :");
		toplamEntlbl.setBounds(20, 250, 500, 14);
		getContentPane().add(toplamEntlbl);
		
		JLabel toplamOlulbl = new JLabel("TOPLAM OLU SAYISI   :");
		toplamOlulbl.setBounds(20, 300, 500, 14);
		getContentPane().add(toplamOlulbl);
		
		JLabel toplamIyilbl = new JLabel("TOPLAM IYILESEN SAYISI   :");
		toplamIyilbl.setBounds(20, 350, 500, 14);
		getContentPane().add(toplamIyilbl);
		
		btnNewButton2.setBounds(300, 500, 89, 23);
		getContentPane().add(btnNewButton2);
		
		
		JButton btnNewButton = new JButton("Verileri al");
		btnNewButton.setBounds(105, 500, 89, 23);
		getContentPane().add(btnNewButton);
		
		
		tarihlbl.setBounds(250, 150, 500, 200);
		getContentPane().add(tarihlbl);
		
		
		
		
		
		
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
					
						toplamTestlbl.setText("TOPLAM TEST SAYISI   :  "+Integer.toString(toplamtest));
					 
						gunlukTestlbl.setText("Günlük Test Sayisi	"+Integer.toString(test));		 
					
						
					dis.equals(s1In);
					 vaka=dis.readInt();
					toplamvaka= toplamvaka+vaka;
					vakaSayisilbl.setText(" Günlük Vaka Sayýsý"+Integer.toString(vaka));
					toplamVakalbl.setText("TOPLAM VAKA SAYISI   :"+Integer.toString(toplamvaka));
					
					dis.equals(s1In);
					
					    ygnBs=dis.readInt();
						toplamYgn= toplamYgn+ygnBs;
						yogunblbl.setText("  Yoðun bakým Sayýsý"+Integer.toString(ygnBs));
						toplamYgnlbl.setText("TOPLAM YOÐUN BAKIM SAYISI   :"+Integer.toString(toplamYgn));
						
						entHSayisi=dis.readInt();
						toplament= toplament+entHSayisi;
						enthlbl.setText("  Entübe Sayýsý"+Integer.toString(entHSayisi));
						toplamEntlbl.setText("TOPLAM ENTUBE  SAYISI   :"+Integer.toString(toplament));
						
						oluSayisi=dis.readInt();
						toplamOlu= toplamOlu+oluSayisi;
						olusayisilbl.setText("  Ölü Sayýsý"+Integer.toString(oluSayisi));
						toplamOlulbl.setText("TOPLAM ÖLÜ  SAYISI   :"+Integer.toString(toplamOlu));
					
						IyilesenSayisi=dis.readInt();
						toplamiyilesen= toplamiyilesen+IyilesenSayisi;
						iyilesenlbl.setText("  Ýyileþen Sayýsý"+Integer.toString(IyilesenSayisi));
						toplamIyilbl.setText("TOPLAM ÝYÝLEÞEN  SAYISI   :"+Integer.toString(toplamiyilesen));
						
						tarih=dis.readUTF();
						System.out.println(tarih);
						tarihlbl.setText("Tarih     :\n"+tarih);
								
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
				
			}
		}
		
		);
		
		
		
	}
	public void Tarih() {
		tarihlbl.setForeground(Color.white);
		tarihlbl.setFont(new Font("Tahoma",Font.PLAIN,30));
		
	}
	
	
	
	
	public void Yapan() {
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(224, 600, 460, 14);
		getContentPane().add(lblNewLabel_5);
		lblNewLabel_5.setText("Yavuz Selim ÖZAY");
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}

	 public void Bilgi() {
		 bilgilbl.setBounds(400, 500, 1000, 300);
		 getContentPane().add(bilgilbl);
		 bilgilbl.setText("VERILERI ALMAK ICIN 'VERILERI AL', KAYDETMEK ICIN 'KAYDET' E TIKLAYIN");
		
		 bilgilbl.setForeground(Color.red);
		
	 }
	 
	public void Arkaplan() {
		
		getContentPane().setBackground(Color.cyan);
		
	}
	
	public void title() {
		setTitle("---COVID-19 BILDIRIM UYGULAMASI---");
		
	}
	
	public void Kaydet() {
		
       btnNewButton2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
		
    	File file=new File("veriler.txt");
    	
    	String sttest=("TOPLAM TEST SAYISI "+toplamtest+"\n");
    	String stvaka=("TOPLAM VAKA SAYISI "+toplamvaka+"\n");
    	String stygn=("TOPLAM VAKA SAYISI "+toplamYgn+"\n");
    	String strnt=("TOPLAM VAKA SAYISI "+toplament+"\n");
    	String stolu=("TOPLAM VAKA SAYISI "+toplamOlu+"\n");
    	String stiyi=("TOPLAM VAKA SAYISI "+toplamiyilesen+"\n");
    	
		String veriler=("\n"+tarih +"\n "+sttest+stvaka+stygn+strnt+stolu+stiyi+"******\n");
		
		try {
			
			if(!file.exists()) {
				file.createNewFile();
			}
				FileWriter fw=new FileWriter(file,true);
				BufferedWriter bw=new BufferedWriter(fw);
				bw.append(veriler);
				bw.close();
			
		} catch (Exception e1) {
			// TODO: handle exception
		}
			}
}

);
		
		System.out.println(toplamtest);
	}
	
	public void Goster() {
		setVisible(true);
	}
	
}

