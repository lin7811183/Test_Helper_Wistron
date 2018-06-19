import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;
import java.awt.Image;//Image
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class InterFace extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterFace frame = new InterFace();
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
	public InterFace() {
		setResizable(false);
		setTitle("Test Helper1.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel Label = new JLabel("");
        Image img = new ImageIcon(this.getClass().getResource("/Computer-icon.png")).getImage();
        Label.setIcon(new ImageIcon(img));
		
		JLabel lblNewLabel_1 = new JLabel("Mahine Status");
		
		JLabel lblNewLabel_2 = new JLabel("Computer Name:");
		lblNewLabel_2.setForeground(Color.RED);
		
		String COM = System.getenv("COMPUTERNAME");//Computer Name
		JLabel lblNewLabel_3 = new JLabel(COM);
		lblNewLabel_3.setForeground(Color.BLUE);
		
		JLabel lblNewLabel_4 = new JLabel("OS Verison:");
		lblNewLabel_4.setForeground(Color.RED);
		
		String NA = System.getProperty("os.name");//OS Name
		JLabel lblNewLabel_5 = new JLabel(NA);
		lblNewLabel_5.setForeground(Color.BLUE);
		
		JLabel lblNewLabel_6 = new JLabel("OS Arch:");
		lblNewLabel_6.setForeground(Color.RED);
		
		String ARCH = System.getProperty("os.arch");//OS Arch
		JLabel lblNewLabel_7 = new JLabel(ARCH);
		lblNewLabel_7.setForeground(Color.BLUE);
		
		JLabel lblNewLabel_8 = new JLabel("OS Time:");
		lblNewLabel_8.setForeground(Color.RED);
		
		Date date = new Date();//OS Time
		JLabel lblNewLabel_9 = new JLabel(date.toString());
		lblNewLabel_9.setForeground(Color.BLUE);
		
		JLabel lblNewLabel_10 = new JLabel("Function~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		JButton btnNewButton = new JButton("Open Test Mode");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//Test Mode Function
				try {
					Process T= Runtime.getRuntime().exec("cmd  /c  Bcdedit -set TESTSIGNING ON");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JButton btnChangeTime = new JButton("Change System Time");
		btnChangeTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//§ï®É°Ï
				try {
					Process P= Runtime.getRuntime().exec("cmd /c tzutil /s \"Taipei Standard Time\"");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ChangTime Ti = new ChangTime();//Call ChangeTime Frame
				Ti.setVisible(true);
			}
		});
		
		JButton btnTpm = new JButton("TPM");//TPM Function
		btnTpm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Process P= Runtime.getRuntime().exec("powershell /c $Tpm = Get-WmiObject -class Win32_Tpm -namespace \"root\\CIMv2\\Security\\MicrosoftTpm\" ;$ConfirmationStatus = $Tpm.GetPhysicalPresenceConfirmationStatus(22).ConfirmationStatus ;if($ConfirmationStatus -ne 4) {$Tpm.SetPhysicalPresenceRequest(18)}");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnChangeComputerName = new JButton("Change Computer Name");//Change Computer Name
		btnChangeComputerName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangeName N = new ChangeName();//Call ChangeName Frame
				N.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Msinfo32");//Msinfo32
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String UR = System.getProperty("user.name");
					String CMDA ="cmd /c msinfo32 /nfo C:\\Users\\";
					String CMDB = UR+"\\Desktop\\";
					String CMDC= COM+".nfo";
					String CMDD =" /categories + systemsummary";
				
					String CMD = CMDA+CMDB+CMDC+CMDD;
					//String CMDQ="";
					//System.out.println(CMD);
					Process P= Runtime.getRuntime().exec(CMD);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_2 = new JButton("Check  Driver List");//Check Driver List Function
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					Process D=Runtime.getRuntime().exec("cmd /c D:\\jre\\MOVE.Bat");
					Process E= Runtime.getRuntime().exec("cmd /c E:\\jre\\MOVE.Bat");
					Process F= Runtime.getRuntime().exec("cmd /c F:\\jre\\MOVE.Bat");
					Process G=Runtime.getRuntime().exec("cmd /c G:\\jre\\MOVE.Bat");
					Process H=Runtime.getRuntime().exec("cmd /c H:\\jre\\MOVE.Bat");
					GoDriverList  GO= new GoDriverList();//Call Restore Frame
					GO.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_3 = new JButton("Restore Point");//Restore Point Function
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Restore  RES= new Restore();//Call Restore Frame
				RES.setVisible(true);
			}
		});

		
		JButton btnNewButton_4 = new JButton("Check EK-Key");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String UR = System.getProperty("user.name");
					String CMDA ="cmd  /c reg export \"HKEY_LOCAL_MACHINE\\SYSTEM\\ControlSet001\\Services\\TPM\\WMI\\Endorsement\\EKCertStore\\Certificates\"  C:\\Users\\";
					String CMDB = UR+"\\Desktop\\";
					String CMDC= "EK.TXT ";
					String CMD = CMDA+CMDB+CMDC;
					Process P= Runtime.getRuntime().exec(CMD);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(Label, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_6)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_8)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_9, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))))
						.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
						.addComponent(btnChangeTime, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
						.addComponent(btnChangeComputerName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnTpm, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
					.addGap(101))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(Label, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_5))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_6)
								.addComponent(lblNewLabel_7))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_8)
								.addComponent(lblNewLabel_9))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_10)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnChangeComputerName)
						.addComponent(btnTpm))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnChangeTime)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_4))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
