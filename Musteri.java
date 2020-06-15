package otomasyon;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.AbstractListModel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionEvent;
import java.io.*;

public class Musteri extends JFrame {

	private JPanel contentPane;
	public JComboBox modellerCB;
	public JComboBox arabalarCB;
	public JLabel fiyatLB;
	private JLabel lblNewLabel_2;
	public JSpinner gunSayisi;
	public int gun = 1;
	public int fiyat = 150;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Musteri frame = new Musteri();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Musteri() {
		setTitle("M\u00FC\u015Fteri \u0130\u015Flemleri");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 401);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		arabalarCB = new JComboBox();
		
		arabalarCB.setToolTipText("");
		
		arabalarCB.addItem("FORD");
		arabalarCB.addItem("HONDA");
		arabalarCB.addItem("TOYOTA");
		arabalarCB.addItem("RENAULT");
		arabalarCB.addItem("HYUNDAI");
		
		arabalarListener ls = new arabalarListener();
		

		arabalarCB.addItemListener(ls);
		
		arabalarCB.setBounds(97, 42, 148, 21);
		contentPane.add(arabalarCB);
		
		modellerCB = new JComboBox();
		modellerCB.setToolTipText("");
		modellerCB.setBounds(97, 106, 148, 21);
		contentPane.add(modellerCB);
		
		JLabel lblNewLabel = new JLabel("Marka:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(23, 41, 52, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Model:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(23, 105, 51, 19);
		contentPane.add(lblNewLabel_1);
		
		modellerCB.addItem("ESCORD");
		modellerCB.addItem("FIESTA");
		modellerCB.addItem("FOCUS");
		modellerCB.addItem("MUSTANG");
		modellerCB.addItem("KUGA");
		modellerListener ml = new modellerListener();
		modellerCB.addItemListener(ml);
		
		fiyatLB = new JLabel("");
		fiyatLB.setFont(new Font("Arial", Font.BOLD, 13));
		fiyatLB.setBounds(10, 215, 347, 65);
		contentPane.add(fiyatLB);
		fiyatLB.setText(modellerCB.getSelectedItem().toString() + " aracýnýn 1 günlük kiralama bedeli: 150 TL'dir.");
		
		lblNewLabel_2 = new JLabel("G\u00FCn:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setBounds(23, 171, 51, 19);
		contentPane.add(lblNewLabel_2);
		
		gunSayisi = new JSpinner();
		gunSayisi.addChangeListener(new ChangeListener() {

	        @Override
	        public void stateChanged(ChangeEvent e) {
	            gun = Integer.parseInt(gunSayisi.getValue().toString());
	            fiyatDegisim(fiyat, modellerCB.getSelectedItem().toString(), gun);
	        }
	    });
		gunSayisi.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		gunSayisi.setFont(new Font("Arial", Font.BOLD, 16));
		gunSayisi.setBounds(97, 159, 52, 46);
		contentPane.add(gunSayisi);
		
		btnNewButton = new JButton("K\u0130RALA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Araç baþarýyla kiralandý!", "Baþarýlý" , JOptionPane.INFORMATION_MESSAGE);
				
				String dosyaMetni = "";
				
				File dosya = new File("C:\\Users\\muham\\eclipse-workspace\\otomasyon\\src\\otomasyon\\kiralama.txt");

				FileReader fileReader = null;
				try {
					fileReader = new FileReader(dosya);
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				String line;

				BufferedReader br = new BufferedReader(fileReader);

				try {
					while ((line = br.readLine()) != null) {

					    dosyaMetni += line;

					}
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				

				
				
				
				
				 try {
				        if(!dosya.exists()){ 
				            dosya.createNewFile(); 
				        }else{
				        }
				    } catch (IOException k) { 
				        // TODO: handle exception
				        k.printStackTrace();
				    }
				
				try {
					String yazi = arabalarCB.getSelectedItem().toString() + "," + modellerCB.getSelectedItem() + "," + gunSayisi.getValue().toString() + "," + yazdirilanFiyat;
					dosyaMetni += "-" + yazi;
					FileWriter fileWriter = new FileWriter(dosya,false);
					BufferedWriter bWriter = new BufferedWriter(fileWriter);
					bWriter.write(dosyaMetni);
					bWriter.close();
				}
				catch (FileNotFoundException hata) {
					hata.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Home form = new Home();
				form.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(10, 290, 342, 56);
		contentPane.add(btnNewButton);
	}
	
	private class arabalarListener implements ItemListener{
		 
        public void itemStateChanged(ItemEvent e) {
        	if (arabalarCB.getSelectedItem().toString().equals("FORD")) {
        		modellerCB.removeAllItems();
        		modellerCB.addItem("ESCORD");
        		modellerCB.addItem("FIESTA");
        		modellerCB.addItem("FOCUS");
        		modellerCB.addItem("MUSTANG");
        		modellerCB.addItem("KUGA");
        	}
        	else if (arabalarCB.getSelectedItem().toString().equals("TOYOTA")) {
        		modellerCB.removeAllItems();
        		modellerCB.addItem("COROLLA");
        		modellerCB.addItem("RAV4");
        		modellerCB.addItem("YARÝS");
        		modellerCB.addItem("HILUX");
        		modellerCB.addItem("CAMRY");
        	}
        	else if (arabalarCB.getSelectedItem().toString().equals("HONDA")) {
        		modellerCB.removeAllItems();
        		modellerCB.addItem("CR-V");
        		modellerCB.addItem("HR-V");
        		modellerCB.addItem("Civic Type R");
        		modellerCB.addItem("Civic");
        		modellerCB.addItem("NSX");
        	}
        	else if (arabalarCB.getSelectedItem().toString().equals("RENAULT")) {
        		modellerCB.removeAllItems();
        		modellerCB.addItem("CLIO");
        		modellerCB.addItem("KADJAR");
        		modellerCB.addItem("MEGANE");
        		modellerCB.addItem("TALISMAN");
        		modellerCB.addItem("SYMBOL");
        	}
        	else {
        		modellerCB.removeAllItems();
        		modellerCB.addItem("i10");
        		modellerCB.addItem("i20");
        		modellerCB.addItem("ELANTRA");
        		modellerCB.addItem("KONA");
        		modellerCB.addItem("TUCSON");
        	}       	
        	
        	if (modellerCB.getSelectedIndex() == 0) {
        		fiyatDegisim(150, modellerCB.getSelectedItem().toString(), gun);
        		fiyat = 150;
        	}
        	else if (modellerCB.getSelectedIndex() == 1) {
        		fiyatDegisim(200, modellerCB.getSelectedItem().toString(), gun);
        		fiyat = 200;
        	}
        	else if (modellerCB.getSelectedIndex() == 2) {
        		fiyatDegisim(250, modellerCB.getSelectedItem().toString(), gun);
        		fiyat = 250;
        	}
        	else if (modellerCB.getSelectedIndex() == 3) {
        		fiyatDegisim(300, modellerCB.getSelectedItem().toString(), gun);
        		fiyat = 300;
        	}
        	else {
        		fiyatDegisim(350, modellerCB.getSelectedItem().toString(), gun);
        		fiyat = 350;
        	}
        } 
    } 
	private class modellerListener implements ItemListener{
 		 
        public void itemStateChanged(ItemEvent e) {
        	
        	
        	if (modellerCB.getSelectedIndex() == 0) {
        		fiyatDegisim(150, modellerCB.getSelectedItem().toString(), gun);
        		fiyat = 150;
        	}
        	else if (modellerCB.getSelectedIndex() == 1) {
        		fiyatDegisim(200, modellerCB.getSelectedItem().toString(), gun);
        		fiyat = 200;
        	}
        	else if (modellerCB.getSelectedIndex() == 2) {
        		fiyatDegisim(250, modellerCB.getSelectedItem().toString(), gun);
        		fiyat = 250;
        	}
        	else if (modellerCB.getSelectedIndex() == 3) {
        		fiyatDegisim(300, modellerCB.getSelectedItem().toString(), gun);
        		fiyat = 300;
        	}
        	else if (modellerCB.getSelectedIndex() == 4){
        		fiyatDegisim(350, modellerCB.getSelectedItem().toString(), gun);
        		fiyat = 350;
        	}
        	
        } 
    }
	public int yazdirilanFiyat = 0;
	public void fiyatDegisim(int fiyat, String model, int gun) {
		fiyatLB.setText(model + " aracýnýn "+ gun +" günlük kiralama bedeli: " + (this.fiyat * gun) + " TL'dir.");
		yazdirilanFiyat = fiyat;
		this.yazdirilanFiyat *= gun;
	}
	
	
}
