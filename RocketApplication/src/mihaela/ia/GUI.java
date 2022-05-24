package mihaela.ia;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

import mihaela.ia.Localities;
import mihaela.ia.temp.Session;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class GUI extends JFrame {
	private JButton btnNewButton;
	private JTextField txtWelcomeToThe;
	public String nameOfLocalityStart;
	public String nameOfLocalityStop;
	public String typeOfRocket;
	public double angleOfLaunching;
	public double height;
	public double speed;
	Session CurrentSession;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setTitle("Rocket Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 778);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
	
		contentPane.setToolTipText("");
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Show the localities\r\n");
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.setVisible(true);
				WindowToUse w2= new WindowToUse();
	        	w2.setVisible(true);
				Localities l = Localities.getInstance();
				l.initializeLocalities();
				w2.createTextField( l.toString());
			  
			}
		});
	
	
		btnNewButton.setBounds(231, 248, 150, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1_1 = new JButton("Show the details of current session");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.setVisible(true);
				WindowToUse w2= new WindowToUse();
	        	w2.setVisible(true);
	        	w2.createASession();
			}
		});
		btnNewButton_1_1.setBounds(199, 321, 207, 25);
		contentPane.add(btnNewButton_1_1);
		
		/*JButton btnNewButton_1_2 = new JButton("Announce the localities about the current session");
		btnNewButton_1_2.setBounds(170, 367, 281, 25);
		contentPane.add(btnNewButton_1_2);
		*/
		JButton btnNewButton_1_3 = new JButton("Exit");
		btnNewButton_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 System.exit(0);
			}
		});
		btnNewButton_1_3.setBounds(231, 406, 150, 25);
		contentPane.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_1_1 = new JButton("Start a session");
		btnNewButton_1_1_1.setBounds(231, 285, 150, 25);
		contentPane.add(btnNewButton_1_1_1);
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.setVisible(true);
				WindowToUse w2= new WindowToUse();
				w2.setVisible(true);
				w2.createTextFieldSession();
				
				
			  
			}
		});
		
		txtWelcomeToThe = new JTextField();
		txtWelcomeToThe.setBackground(Color.PINK);
		txtWelcomeToThe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtWelcomeToThe.setText("WELCOME TO THE ROCKET APP!");
		txtWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		txtWelcomeToThe.setBounds(170, 167, 236, 20);
		contentPane.add(txtWelcomeToThe);
		txtWelcomeToThe.setColumns(10);
	}
}
