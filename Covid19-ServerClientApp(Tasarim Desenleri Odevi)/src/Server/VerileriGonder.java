package Server;



import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class VerileriGonder implements Observer {

	private int portNo;
	private int gunlukTest;
	private int vakaSayisi;
	private int yogunBHSayisi;
	private int entHSayisi;
	private int oluSayisi;
    private int IyilesenSayisi;
    private String tarih;
    
	
    
    public void Gonder() throws IOException {
    	try (ServerSocket s = new ServerSocket(portNo)) {
			Socket s1=s.accept();
			OutputStream s1out=s1.getOutputStream();
			DataOutputStream dos = new DataOutputStream(s1out);
			System.out.println(gunlukTest);
			
	     
			dos.writeUTF("GÜNCELLENDÝ");
			
	   
			dos.writeInt(gunlukTest);
			
			dos.flush();
			
		
			dos.writeInt(vakaSayisi);
			
			
			dos.flush();
            dos.writeInt(yogunBHSayisi);
			
			dos.flush();
			dos.writeInt(entHSayisi);
			dos.flush();
			dos.writeInt(oluSayisi);
			dos.flush();
			dos.writeInt(IyilesenSayisi);
			dos.flush();
			dos.writeUTF(tarih);
			dos.flush();
			
			dos.close();
			s1out.close();
			
		}
    }

	@Override
	public void update(int portNo, int gunlukTest, int vakaSayisi, int yogunBHSayisi, int entHSayisi, int oluSayisi,
			int iyilesenSayisi,String tarih) {
		// TODO Auto-generated method stub
		this.portNo=portNo;
		this.gunlukTest=gunlukTest;
		this.vakaSayisi=vakaSayisi;
		this.yogunBHSayisi=yogunBHSayisi;
		this.entHSayisi=entHSayisi;
		this.oluSayisi=oluSayisi;
		this.IyilesenSayisi=iyilesenSayisi;
		this.tarih=tarih;
		
		try {
			Gonder();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
