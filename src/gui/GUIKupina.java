package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class GUIKupina extends JFrame {

	private JPanel contentPane;
	private JTextArea textAreaIspis;
	private JPanel panel;
	private JLabel lblUnosNovogRadnika;
	private JTextField textFieldIme;
	private JLabel lblIme;
	private JTextArea textAreaBroj;
	private JButton btnUnesi;
	private JSeparator separator;
	private JLabel lblUnosNovogMerenja;
	private JLabel lblBrojGajbi;
	private JTextField textFieldGajbe;
	private JTextField textFieldTezina;
	private JLabel lblBrutoTezina;
	private JButton btnUnesi_1;
	private JSeparator separator_1;

	/**
	 * Launch the application.
	 */
	LinkedList<Radnik> listaRadnika=new LinkedList<>();
	
	private JLabel lblBrojRadnika;
	private JTextField textFieldID;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmNew;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIKupina frame = new GUIKupina();
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
	public GUIKupina() {
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent arg0) {
				windowClosin();
			}
		});
		
	
		setTitle("Obracun");
		setMinimumSize(new Dimension(1000, 1000));
		setPreferredSize(new Dimension(1000, 1000));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 450, 300);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.WEST);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}

	private JTextArea getTextAreaIspis() {
		if (textAreaIspis == null) {
			textAreaIspis = new JTextArea();
			textAreaIspis.setEditable(false);
			textAreaIspis.setAutoscrolls(false);
			textAreaIspis.setFont(new Font("Monospaced", Font.PLAIN, 18));
		}
		return textAreaIspis;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(250, 10));
			panel.add(getLblUnosNovogRadnika());
			panel.add(getLblIme());
			panel.add(getTextFieldIme());
			panel.add(getBtnUnesi());
			panel.add(getTextAreaBroj());
			panel.add(getSeparator());
			panel.add(getLblUnosNovogMerenja());
			panel.add(getLblBrojRadnika());
			panel.add(getTextFieldID());
			panel.add(getLblBrojGajbi());
			panel.add(getTextFieldGajbe());
			panel.add(getLblBrutoTezina());
			panel.add(getTextFieldTezina());
			panel.add(getBtnUnesi_1());
			panel.add(getSeparator_1());
		}
		return panel;
	}
	private JLabel getLblUnosNovogRadnika() {
		if (lblUnosNovogRadnika == null) {
			lblUnosNovogRadnika = new JLabel("     Unos novog radnika:");
			lblUnosNovogRadnika.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblUnosNovogRadnika.setPreferredSize(new Dimension(200, 25));
		}
		return lblUnosNovogRadnika;
	}
	private JTextField getTextFieldIme() {
		if (textFieldIme == null) {
			textFieldIme = new JTextField();
			textFieldIme.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldIme.setColumns(10);
		}
		return textFieldIme;
	}
	private JLabel getLblIme() {
		if (lblIme == null) {
			lblIme = new JLabel("Ime:");
			lblIme.setPreferredSize(new Dimension(50, 14));
			lblIme.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblIme;
	}
	private JTextArea getTextAreaBroj() {
		if (textAreaBroj == null) {
			textAreaBroj = new JTextArea();
			textAreaBroj.setFont(new Font("Arial", Font.PLAIN, 14));
			textAreaBroj.setPreferredSize(new Dimension(180, 45));
		}
		return textAreaBroj;
	}
	private JButton getBtnUnesi() {
		if (btnUnesi == null) {
			btnUnesi = new JButton("Unesi");
			btnUnesi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(!textFieldIme.getText().equals("")){
					Radnik r=new Radnik();
					r.setIme(textFieldIme.getText());
					listaRadnika.add(r);
					textFieldIme.setText(null);
					int a=listaRadnika.indexOf(r);
					textAreaBroj.setText("Radnik: "+r.getIme()+" je broj: "+(a+1)+".");
					refresh();
					}
				}
			});
			btnUnesi.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		return btnUnesi;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setPreferredSize(new Dimension(200, 3));
		}
		return separator;
	}
	private JLabel getLblUnosNovogMerenja() {
		if (lblUnosNovogMerenja == null) {
			lblUnosNovogMerenja = new JLabel("Unos novog merenja:");
			lblUnosNovogMerenja.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblUnosNovogMerenja.setPreferredSize(new Dimension(200, 25));
		}
		return lblUnosNovogMerenja;
	}
	private JLabel getLblBrojGajbi() {
		if (lblBrojGajbi == null) {
			lblBrojGajbi = new JLabel("Broj gajbi:");
			lblBrojGajbi.setPreferredSize(new Dimension(78, 15));
			lblBrojGajbi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblBrojGajbi;
	}
	private JTextField getTextFieldGajbe() {
		if (textFieldGajbe == null) {
			textFieldGajbe = new JTextField();
			textFieldGajbe.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldGajbe.setColumns(10);
		}
		return textFieldGajbe;
	}
	private JTextField getTextFieldTezina() {
		if (textFieldTezina == null) {
			textFieldTezina = new JTextField();
			textFieldTezina.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldTezina.setColumns(10);
		}
		return textFieldTezina;
	}
	private JLabel getLblBrutoTezina() {
		if (lblBrutoTezina == null) {
			lblBrutoTezina = new JLabel("Bruto tezina:");
			lblBrutoTezina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblBrutoTezina;
	}
	private JButton getBtnUnesi_1() {
		if (btnUnesi_1 == null) {
			btnUnesi_1 = new JButton("Unesi");
			
			btnUnesi_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					if( !textFieldID.getText().equals("") && Integer.parseInt(textFieldID.getText())<=listaRadnika.size() &&!textFieldGajbe.getText().equals("") && !textFieldTezina.getText().equals("")){
						int broj=Integer.parseInt(textFieldID.getText());
						int gajbe=Integer.parseInt(textFieldGajbe.getText());
						double bruto=Double.parseDouble(textFieldTezina.getText());
						System.out.println(bruto);
						Merenje m= new Merenje();
						GregorianCalendar vreme= new GregorianCalendar();
						m.setBrojGajbi(gajbe);
						m.setBruto(bruto);
						m.setVreme(vreme);
					listaRadnika.get(broj-1).listaMerenja.add(m);
					refresh();
					textFieldID.setText(null);
					textFieldGajbe.setText(null);
					textFieldTezina.setText(null);
					textAreaBroj.setText(null);
					}
				}
			});
			btnUnesi_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		return btnUnesi_1;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setPreferredSize(new Dimension(200, 4));
		}
		return separator_1;
	}
	private JLabel getLblBrojRadnika() {
		if (lblBrojRadnika == null) {
			lblBrojRadnika = new JLabel("Broj radnika:");
			lblBrojRadnika.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblBrojRadnika;
	}
	private JTextField getTextFieldID() {
		if (textFieldID == null) {
			textFieldID = new JTextField();
			textFieldID.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldID.setColumns(10);
		}
		return textFieldID;
	}
	void refresh(){
		textAreaIspis.setText(null);
		int ukupnoG=0;
		double neto=0;
		for(int i=0;i<listaRadnika.size();i++){
			textAreaIspis.append((i+1)+". "+listaRadnika.get(i).getIme());
			textAreaIspis.append("\n");
			textAreaIspis.append("---------------------------------------------------------------------");
			textAreaIspis.append("\n");
			textAreaIspis.append("---- Datum -- Vreme --- Br. Gajbi ---- Bruto Kg -----");
			
			textAreaIspis.append("\n");
			for(int j=0;j<listaRadnika.get(i).listaMerenja.size();j++){
				textAreaIspis.append(listaRadnika.get(i).listaMerenja.get(j).toString());
				textAreaIspis.append("\n");
			}
			textAreaIspis.append("\n");
			textAreaIspis.append("---------------------------------------------------------------------");
			textAreaIspis.append("\n");
			textAreaIspis.append("Ukupno:  "+listaRadnika.get(i).getUkupnoG()+" gajbi; neto: "+listaRadnika.get(i).getNeto()+"kg.");
			ukupnoG+=listaRadnika.get(i).getUkupnoG();
			neto+=listaRadnika.get(i).getNeto();
			textAreaIspis.append("\n");
			textAreaIspis.append("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
			textAreaIspis.append("\n");
			textAreaIspis.append("\n");
		}
		textAreaIspis.append("Ukupno:  "+ukupnoG+" gajbi; neto: "+neto+"kg.");
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextAreaIspis());
		}
		return scrollPane;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			//mnFile.add(getMntmNew());
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmSave());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
//	private JMenuItem getMntmNew() {
//		if (mntmNew == null) {
//			mntmNew = new JMenuItem("New");
//			mntmNew.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent arg0) {
//					String s = (String)JOptionPane.showInputDialog(null,"Upisi naziv fajla:");
//					if(s!=null && !s.equals("")){
//					ObjectOutputStream o1;
//					try {
//						o1 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("c:\\merenje\\"+s+".out")));
//						
//						o1.close();
//					} catch (FileNotFoundException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}}
//			});
//		}
//		return mntmNew;
//	}
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser jc= new JFileChooser();
					jc.showOpenDialog(null);
					File f=jc.getSelectedFile();
					if(f!=null){
					ObjectInputStream o1;
					listaRadnika.clear();
					try {
						o1 = new ObjectInputStream(new FileInputStream(f));
						try {
							while(true){
								Radnik r= (Radnik) (o1.readObject());
								listaRadnika.add(r);
							}
						} catch (EOFException e1) {}
						
						o1.close();
					}  catch (Exception e1) {
						e1.printStackTrace();
					}
				refresh();
				}}
			});
		}
		return mntmOpen;
	}
	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser jc= new JFileChooser();
					jc.showSaveDialog(null);
					File f=jc.getSelectedFile();
					if(f!=null){
					ObjectOutputStream o1;
					
					try {
						o1 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
						for(int i=0;i<listaRadnika.size();i++){
							o1.writeObject(listaRadnika.get(i));
						}
						o1.close();
					}  catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}}
			});
		}
		return mntmSave;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					windowClosin();
				}
			});
		}
		return mntmExit;
	}
	
	public void windowClosin() {
			    int confirmed = JOptionPane.showConfirmDialog(null, "Da li zelite da sacuvate?", "da/ne", JOptionPane.YES_NO_OPTION);

			    if (confirmed == JOptionPane.YES_OPTION) {
			    	JFileChooser jc= new JFileChooser();
					jc.showSaveDialog(null);
					File f=jc.getSelectedFile();
					if(f!=null){
					ObjectOutputStream o1;
					
					try {
						o1 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
						for(int i=0;i<listaRadnika.size();i++){
							o1.writeObject(listaRadnika.get(i));
						}
						o1.close();
					}  catch (Exception e1) {
						e1.printStackTrace();
					}
					 System.exit(0);
			     
			     
			    }}
					if (confirmed == JOptionPane.NO_OPTION){
						System.exit(0);
			    	
			    }
			  
		}
	}
