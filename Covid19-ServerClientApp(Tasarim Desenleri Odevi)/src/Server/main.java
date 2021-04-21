package Server;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;



public class main {

	private JFrame frame;
	private JTextField textField;
    private int gunlukTest;
    private int vaka;
    private int yogunBHSayisi;
	private int entHSayisi;
	private int oluSayisi;
    private int IyilesenSayisi;
   
	private JTextField textfield;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}

	/**
	 * Create the application.
	 */
	public main() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(750, 100, 750, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("VERI GIRISI --SERVER---");
		
		//
		JButton btnNewButton = new JButton("Gonder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					gunlukTest=Integer.parseInt(textField.getText());
					
					vaka=Integer.parseInt(textField_1.getText());
					yogunBHSayisi=Integer.parseInt(textField_2.getText());
					entHSayisi=Integer.parseInt(textField_3.getText());
					oluSayisi=Integer.parseInt(textField_4.getText());
					IyilesenSayisi=Integer.parseInt(textField_5.getText());
					
					
					Veriler v=new Veriler();
					VerileriGonder vg= new VerileriGonder();
					v.setTest(gunlukTest);
					v.setVaka(vaka);
					v.setYogunBHSayisi(yogunBHSayisi);
					v.setEntHSayisi(entHSayisi);
					v.setOluSayisi(oluSayisi);
					v.setIyilesen(IyilesenSayisi);
					
					
					v.addObserver(vg);
					v.notifyObserver();
					
				
			
				
				
				
			}
		});
		
		
		
		btnNewButton.setBounds(281, 387, 126, 46);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("G\u00FCnl\u00FCk Test");
		lblNewLabel.setBounds(45, 25, 73, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblVaka = new JLabel("Vaka");
		lblVaka.setBounds(45, 81, 73, 14);
		frame.getContentPane().add(lblVaka);
		
		JLabel lblYogunBakim = new JLabel("Yogun Bakim");
		lblYogunBakim.setBounds(45, 124, 73, 14);
		frame.getContentPane().add(lblYogunBakim);
		
		JLabel lblEntube = new JLabel("Entube");
		lblEntube.setBounds(45, 167, 73, 14);
		frame.getContentPane().add(lblEntube);
		
		JLabel lblOluSayisi = new JLabel("Olu Sayisi");
		lblOluSayisi.setBounds(45, 210, 73, 14);
		frame.getContentPane().add(lblOluSayisi);
		
		JLabel lblIyileen = new JLabel("iyile\u015Fen");
		lblIyileen.setBounds(45, 253, 73, 16);
		frame.getContentPane().add(lblIyileen);
		
		JLabel lblTarih = new JLabel("Tarih");
		lblTarih.setBounds(45, 298, 73, 14);
		
		frame.getContentPane().add(lblTarih);
		
		textField = new JTextField();
		textField.setBounds(174, 25, 86, 18);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(174, 78, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(174, 121, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(174, 164, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(174, 207, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(174, 251, 86, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		
		
		
	}
}

