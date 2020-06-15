package otomasyon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setTitle("Ana Sayfa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 257);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton MusteriIslemleriBT = new JButton("M\u00FC\u015Fteri \u0130\u015Flemleri");
		MusteriIslemleriBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Musteri yeniForm = new Musteri();
				yeniForm.setVisible(true);
				dispose();
				
			}
		});
		
		
		MusteriIslemleriBT.setFont(new Font("Arial", Font.BOLD, 16));
		MusteriIslemleriBT.setBounds(119, 10, 169, 70);
		contentPane.add(MusteriIslemleriBT);
		
		JButton YoneticiIslemleriBT = new JButton("Y\u00F6netici \u0130\u015Flemleri");
		YoneticiIslemleriBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Yonetici yeniForm = new Yonetici();
				yeniForm.setVisible(true);
				dispose();
			}
		});
		YoneticiIslemleriBT.setFont(new Font("Arial", Font.BOLD, 16));
		YoneticiIslemleriBT.setBounds(119, 109, 169, 70);
		contentPane.add(YoneticiIslemleriBT);
	}
}
