package otomasyon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.ScrollPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Yonetici extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Yonetici frame = new Yonetici();
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
	public Yonetici() {
		
		
		setTitle("Y\u00F6netici \u0130\u015Flemleri");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String dosyaMetni = "";
		String dosyaMetni2 = "";
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
		
		ArrayList markaList = new ArrayList();
		ArrayList modelList = new ArrayList();
		ArrayList gunList = new ArrayList();
		ArrayList ucretList = new ArrayList();
		
		String[] liste = dosyaMetni.split("-");
		for (int i = 0; i< liste.length ; i++ ) {
			String satir = liste[i].toString();
			String[] satirDizi = satir.split(",");
			markaList.add(satirDizi[0].toString());
			modelList.add(satirDizi[1].toString());
			gunList.add(satirDizi[2].toString());
			ucretList.add(satirDizi[3].toString());
		}
		int s = markaList.size();
		
		
		
		String col[] = {"MARKA","MODEL","GUN","UCRET"};
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Arial", Font.BOLD, 12));
		table.setBounds(29, 10, 481, 167);
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		for (int i = 0; i < markaList.size(); i++) {
			Object[] objs = {markaList.get(i).toString(), modelList.get(i).toString(), gunList.get(i).toString(), ucretList.get(i).toString()};
			tableModel.addRow(objs);
		}
		table = new JTable(tableModel);
		//contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 442, 190);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home yeniForm = new Home();
				yeniForm.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBounds(10, 220, 442, 62);
		contentPane.add(btnNewButton);
	}
}
