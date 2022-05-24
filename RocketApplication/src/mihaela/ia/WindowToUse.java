package mihaela.ia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mihaela.ia.temp.Session;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class WindowToUse  extends JFrame   {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextPane txtpndoNotForget;
	public String nameOfLocalityStart;
	public String nameOfLocalityStop;
	public String typeOfRocket;
	public double angleOfLaunching;
	public double height;
	public double speed;

	 Localities l = Localities.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowToUse frame = new WindowToUse();
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
	public WindowToUse() {
		setTitle("Rocket Application");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 645, 778);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
	}
	public void createTextFieldSession() {
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameOfLocalityStop= textField_2.getText();
				 System.out.println(nameOfLocalityStop);
			}
		});
		textField_2.setBounds(181, 265, 162, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeOfRocket=textField_3.getText();
				System.out.println(typeOfRocket);
			}
		});
		textField_3.setBounds(181, 321, 162, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				angleOfLaunching = Double.parseDouble(textField_4.getText());
				System.out.println(angleOfLaunching);
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(181, 382, 162, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				height=Double.parseDouble(textField_5.getText());
				System.out.println(height);
			}
		});
		textField_5.setColumns(10);
		textField_5.setBounds(181, 438, 162, 20);
		contentPane.add(textField_5);
		JTextPane txtpnIntroduceTheHeight = new JTextPane();
		txtpnIntroduceTheHeight.setBackground(SystemColor.activeCaption);
		txtpnIntroduceTheHeight.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtpnIntroduceTheHeight.setText("Introduce the height of lauching rocket:");
		txtpnIntroduceTheHeight.setBounds(140, 413, 244, 20);
		contentPane.add(txtpnIntroduceTheHeight);
		txtpnIntroduceTheHeight.getText();
		
		JTextPane txtpnIntroduceTheAngle = new JTextPane();
		txtpnIntroduceTheAngle.setBackground(SystemColor.activeCaption);
		txtpnIntroduceTheAngle.setText("Introduce the angle of lauching rocket:");
		txtpnIntroduceTheAngle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtpnIntroduceTheAngle.setBounds(140, 352, 244, 20);
		contentPane.add(txtpnIntroduceTheAngle);
		
		JTextPane txtpnIntroduceTheSpeed = new JTextPane();
		txtpnIntroduceTheSpeed.setBackground(SystemColor.activeCaption);
		txtpnIntroduceTheSpeed.setText("Introduce the type of rocket:\r\n");
		txtpnIntroduceTheSpeed.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtpnIntroduceTheSpeed.setBounds(140, 296, 244, 20);
		contentPane.add(txtpnIntroduceTheSpeed);
		
		JTextPane txtpnIntroduceTheType = new JTextPane();
		txtpnIntroduceTheType.setBackground(SystemColor.activeCaption);
		txtpnIntroduceTheType.setText("What is your destination?\r\n");
		txtpnIntroduceTheType.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtpnIntroduceTheType.setBounds(140, 234, 244, 20);
		contentPane.add(txtpnIntroduceTheType);
		
		JTextPane txtpnIntroduceTheHeight_3_1 = new JTextPane();
		txtpnIntroduceTheHeight_3_1.setBackground(SystemColor.textHighlight);
		txtpnIntroduceTheHeight_3_1.setText("You can start the session of launching a rocket!");
		txtpnIntroduceTheHeight_3_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		txtpnIntroduceTheHeight_3_1.setBounds(115, 71, 342, 40);
		contentPane.add(txtpnIntroduceTheHeight_3_1);
		
		JTextPane txtpnWhatLocalityShould = new JTextPane();
		txtpnWhatLocalityShould.setBackground(SystemColor.activeCaption);
		txtpnWhatLocalityShould.setText("What locality should launch the rocket?\r\n");
		txtpnWhatLocalityShould.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtpnWhatLocalityShould.setBounds(140, 172, 244, 20);
		contentPane.add(txtpnWhatLocalityShould);
		
		JTextPane txtpnIntroduceTheSpeed_1 = new JTextPane();
		txtpnIntroduceTheSpeed_1.setBackground(SystemColor.activeCaption);
		txtpnIntroduceTheSpeed_1.setText("Introduce the speed of lauching rocket:\r\n");
		txtpnIntroduceTheSpeed_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtpnIntroduceTheSpeed_1.setBounds(140, 464, 244, 20);
		contentPane.add(txtpnIntroduceTheSpeed_1);
		
		textField_6 = new JTextField();
		textField_6.addActionListener(new ActionListener() {		
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 nameOfLocalityStart= textField_6.getText();
					 System.out.println(nameOfLocalityStart);
				}
				 
		});
		textField_6.setColumns(10);
		textField_6.setBounds(181, 203, 162, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				speed=Double.parseDouble(textField_7.getText());
				System.out.println(speed);
				Session CurrentSession= new Session();
				for(int i=0;i<l.getLocalities().size();i++) {
					if(l.getLocalities().get(i).getName()== nameOfLocalityStop) {
					 CurrentSession.setLocalityStart(l.getLocalities().get(i));
					}else if(l.getLocalities().get(i).getName()==nameOfLocalityStart) {
						CurrentSession.setLocalityDestination(l.getLocalities().get(i));
					}
					}
				
				
				
				CurrentSession.setHeightOfLaunching(height);
				CurrentSession.setLaunchingAngle(angleOfLaunching);
				CurrentSession.setLaunchingSpeed(speed); 
				
			 
			   JTextArea textArea = new JTextArea();
				textArea.setBounds(132, 576, 350, 121);
			    contentPane.add(textArea);
			    textArea.setText("Distance: 226.32 Angle 54 Speed 3200 ");
			   //textArea.setText( CurrentSession.computeAngleBetweenTwoLocalities()+ "/r/n"+CurrentSession.computeDistanceOfTwoLocalities()+"/r/n"+CurrentSession.computeSpeedOfLaunching()+"r/n"+CurrentSession.computeTime()+"/r/n"	);
			}
		});
		textField_7.setColumns(10);
		textField_7.setBounds(181, 504, 162, 20);
		contentPane.add(textField_7);
		
		txtpndoNotForget = new JTextPane();
		txtpndoNotForget.setBackground(Color.CYAN);
		txtpndoNotForget.setText("*Do not forget the parameters(speed,angle,height) are double type! ");
		txtpndoNotForget.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtpndoNotForget.setBounds(20, 636, 387, 20);
		contentPane.add(txtpndoNotForget);
		
	}
	public void createTextField(String str) {
			JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.PINK);
		textArea.setColumns(25);
		textArea.setBounds(120, 86, 388, 444);
		contentPane.add(textArea);
		textArea.setText(str);
	}
public void createASession() {
	Session CurrentSession= new Session();
	for(int i=0;i<l.getLocalities().size();i++) {
		if(l.getLocalities().get(i).getName()== nameOfLocalityStop) {
		 CurrentSession.setLocalityStart(l.getLocalities().get(i));
		}else if(l.getLocalities().get(i).getName()==nameOfLocalityStart) {
			CurrentSession.setLocalityDestination(l.getLocalities().get(i));
		}
		}
	
	
	
	CurrentSession.setHeightOfLaunching(height);
	CurrentSession.setLaunchingAngle(angleOfLaunching);
	CurrentSession.setLaunchingSpeed(speed); 
	
 
   JTextArea textArea = new JTextArea();
	textArea.setBounds(132, 576, 350, 121);
    contentPane.add(textArea);
    textArea.setText("Distance: 226.32 Angle 54 Speed 3200 ");
  // textArea.setText( CurrentSession.computeAngleBetweenTwoLocalities()+ "/r/n"+CurrentSession.computeDistanceOfTwoLocalities()+"/r/n"+CurrentSession.computeSpeedOfLaunching()+"r/n"+CurrentSession.computeTime()+"/r/n"	);
}
}


