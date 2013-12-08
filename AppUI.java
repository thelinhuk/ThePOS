import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.border.CompoundBorder;

import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTabbedPane;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



public class AppUI extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtSearch;
	private JTextField txtPaid;
	private static final int TIMER_DELAY = 1000;
	private int counter;
	private JButton btnFind;
	private JButton btnLogin;
	private JButton btnOne, btnTwo,btnThree, btnFour, btnFive, btnSix, 
			btnSeven, btnEight, btnNine,btnFivePnd,btnZero,btnLogout,
			btnDelete,btnClear,btnTenPnd,btnTwentyPnd,btnFiftyPnd;
	private JButton btnDot;
	private boolean isSwitch;
	private DBQuery dbQuery;
	private boolean isPaid;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
 


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppUI frame = new AppUI();
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
	public AppUI() {
		setUndecorated(true);
		counter++;
		isSwitch = false;
		isPaid = false;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(45, 50, 61));
		panel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{60, 475, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_22 = new JPanel();
		GridBagConstraints gbc_panel_22 = new GridBagConstraints();
		gbc_panel_22.insets = new Insets(0, 0, 5, 0);
		gbc_panel_22.fill = GridBagConstraints.BOTH;
		gbc_panel_22.gridx = 0;
		gbc_panel_22.gridy = 0;
		panel_1.add(panel_22, gbc_panel_22);
		panel_22.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(lblNewLabel_1);
		
		JPanel panel_23 = new JPanel();
		GridBagConstraints gbc_panel_23 = new GridBagConstraints();
		gbc_panel_23.fill = GridBagConstraints.BOTH;
		gbc_panel_23.gridx = 0;
		gbc_panel_23.gridy = 1;
		panel_1.add(panel_23, gbc_panel_23);
		GridBagLayout gbl_panel_23 = new GridBagLayout();
		gbl_panel_23.columnWidths = new int[]{667, 0};
		gbl_panel_23.rowHeights = new int[]{397, 67, 0};
		gbl_panel_23.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_23.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_23.setLayout(gbl_panel_23);
		
		JPanel panel_24 = new JPanel();
		GridBagConstraints gbc_panel_24 = new GridBagConstraints();
		gbc_panel_24.insets = new Insets(0, 0, 5, 0);
		gbc_panel_24.fill = GridBagConstraints.BOTH;
		gbc_panel_24.gridx = 0;
		gbc_panel_24.gridy = 0;
		panel_23.add(panel_24, gbc_panel_24);
		
		model = new DefaultTableModel();
		table = new JTable(model);
		table.setSurrendersFocusOnKeystroke(true);
		table.setShowGrid(false);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setFont(new Font("Tahoma", Font.BOLD, 32));
		table.setRowHeight(50);
		scrollPane = new JScrollPane(table);
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(JLabel.RIGHT);
		model.addColumn("Item");
		model.addColumn("Price");
		table.getColumnModel().getColumn(1).setCellRenderer(centerRender);
		
		
		panel_24.setLayout(new BorderLayout(0, 0));
		panel_24.add(scrollPane);
		
		JPanel panel_25 = new JPanel();
		GridBagConstraints gbc_panel_25 = new GridBagConstraints();
		gbc_panel_25.fill = GridBagConstraints.BOTH;
		gbc_panel_25.gridx = 0;
		gbc_panel_25.gridy = 1;
		panel_23.add(panel_25, gbc_panel_25);
		panel_25.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_26 = new JPanel();
		panel_25.add(panel_26);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(this);
		panel_26.setLayout(new GridLayout(0, 1, 0, 0));
		panel_26.add(btnRemove);
		
		
		JPanel panel_27 = new JPanel();
		panel_25.add(panel_27);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(45, 50, 61));
		panel.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[] {60, 140, 30, 30, 30, 30, 30, 30, 30, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(45, 50, 61));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		panel_2.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(45, 50, 61));
		panel_5.add(panel_15);
		panel_15.setLayout(null);
		
		btnFind = new JButton("Add");
		btnFind.setBounds(0, 0, 99, 66);
		btnFind.setForeground(Color.WHITE);
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnFind.setBackground(new Color(44, 91, 166));
		btnFind.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		btnFind.addActionListener(this);
		panel_15.add(btnFind);
		
		txtSearch = new JTextField();
		txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearch.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtSearch.setBounds(98, 4, 335, 50);
		txtSearch.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				isPaid = false;	
			}
			@Override
			public void focusLost(FocusEvent e) {}
		});
		panel_15.add(txtSearch);
		txtSearch.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(554, 3, 118, 55);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnLogin.setBackground(new Color(44, 91, 166));
		btnLogin.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		btnLogin.addActionListener(this);
		panel_15.add(btnLogin);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(439, 2, 115, 55);
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnLogout.setBackground(new Color(44, 91, 166));
		btnLogout.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		btnLogout.addActionListener(this);
		panel_15.add(btnLogout);
		
		JPanel panel_12 = new JPanel();
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.insets = new Insets(0, 0, 5, 0);
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 0;
		gbc_panel_12.gridy = 1;
		panel_2.add(panel_12, gbc_panel_12);
		panel_12.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(Color.WHITE);
		panel_16.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		panel_12.add(panel_16);
		panel_16.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_18 = new JPanel();
		panel_16.add(panel_18);
		
		JPanel panel_17 = new JPanel();
		panel_16.add(panel_17);
		panel_17.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_19 = new JPanel();
		panel_17.add(panel_19);
		panel_19.setLayout(null);
		
		txtPaid = new JTextField();
		txtPaid.setText("0.00");
		txtPaid.setHorizontalAlignment(SwingConstants.CENTER);
		txtPaid.setFont(new Font("Tahoma", Font.BOLD, 26));
		txtPaid.setBounds(102, 4, 214, 55);
		txtPaid.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				isPaid = true;
			}
			@Override
			public void focusLost(FocusEvent e) {}
			
		});
		panel_19.add(txtPaid);
		txtPaid.setColumns(10);
		
		JPanel panel_20 = new JPanel();
		panel_17.add(panel_20);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBackground(new Color(45, 50, 51));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridheight = 7;
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		panel_2.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		panel_4.setBackground(new Color(45, 50, 51));
		gbl_panel_4.columnWidths = new int[]{50, 44, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.gridwidth = 3;
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 0;
		panel_4.add(panel_6, gbc_panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(45, 50, 51));
		panel_6.add(panel_7);
		panel_7.setLayout(new GridLayout(6, 0, 0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(45, 50, 61));
		panel_7.add(panel_14);
		panel_14.setLayout(new GridLayout(0, 2, 0, 0));
		
		btnClear = new JButton("Clear");
		btnClear.setSelectedIcon(new ImageIcon("E:\\POS_Button_Icons\\deleteIcon.png"));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnClear.setForeground(Color.WHITE);
		btnClear.setBackground(new Color(44, 91, 166));
		btnClear.setIcon(new ImageIcon("E:\\POS_Button_Icons\\clearIcon.png"));
		btnClear.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		btnClear.addActionListener(this);
		panel_14.add(btnClear);
		
		btnDelete = new JButton("Delete");
		btnDelete.setSelectedIcon(new ImageIcon("E:\\POS_Button_Icons\\deleteIcon.png"));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(44, 91, 166));
		btnDelete.setIcon(new ImageIcon("E:\\POS_Button_Icons\\clearIcon.png"));
		btnDelete.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		btnDelete.addActionListener(this);
		panel_14.add(btnDelete);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(45, 50, 61));
		panel_7.add(panel_13);
		panel_13.setLayout(new GridLayout(0, 4, 0, 0));
		
		btnOne = new JButton("1");
		btnOne.setForeground(Color.WHITE);
		btnOne.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnOne.setBackground(new Color(27, 188, 155));
		btnOne.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		btnOne.addActionListener(this);
		panel_13.add(btnOne);
		
		btnTwo = new JButton("2");
		btnTwo.setForeground(Color.WHITE);
		btnTwo.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnTwo.setBackground(new Color(27, 188, 155));
		btnTwo.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		btnTwo.addActionListener(this);
		panel_13.add(btnTwo);
		
		
		btnThree = new JButton("3");
		btnThree.setForeground(Color.WHITE);
		btnThree.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnThree.setBackground(new Color(27, 188, 155));
		btnThree.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		btnThree.addActionListener(this);
		panel_13.add(btnThree);
		
		btnFivePnd = new JButton("£ 5");
		btnFivePnd.setForeground(Color.WHITE);
		btnFivePnd.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnFivePnd.setBackground(new Color(44, 91, 166));
		btnFivePnd.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		panel_13.add(btnFivePnd);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(45, 50, 51));
		panel_7.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 4, 0, 0));
		
		btnFour = new JButton("4");
		btnFour.setForeground(Color.WHITE);
		btnFour.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnFour.setBackground(new Color(27, 188, 155));
		btnFour.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		btnFour.addActionListener(this);
		panel_9.add(btnFour);
		
		btnFive = new JButton("5");
		btnFive.setForeground(Color.WHITE);
		btnFive.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnFive.setBackground(new Color(27, 188, 155));
		btnFive.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		btnFive.addActionListener(this);
		panel_9.add(btnFive);
		
		btnSix = new JButton("6");
		btnSix.setForeground(Color.WHITE);
		btnSix.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnSix.setBackground(new Color(27, 188, 155));
		btnSix.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		btnSix.addActionListener(this);
		panel_9.add(btnSix);
		
		btnTenPnd = new JButton("£ 10");
		btnTenPnd.setForeground(Color.WHITE);
		btnTenPnd.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnTenPnd.setBackground(new Color(44, 91, 166));
		btnTenPnd.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		panel_9.add(btnTenPnd);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(45, 50, 51));
		panel_7.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 4, 0, 5));
		
		btnSeven = new JButton("7");
		btnSeven.setForeground(Color.WHITE);
		btnSeven.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnSeven.setBackground(new Color(27, 188, 155));
		btnSeven.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		btnSeven.addActionListener(this);
		panel_11.add(btnSeven);
		
		btnEight = new JButton("8");
		btnEight.setForeground(Color.WHITE);
		btnEight.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnEight.setBackground(new Color(27, 188, 155));
		btnEight.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		btnEight.addActionListener(this);
		panel_11.add(btnEight);
		
		btnNine = new JButton("9");
		btnNine.setForeground(Color.WHITE);
		btnNine.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNine.setBackground(new Color(27, 188, 155));
		btnNine.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		btnNine.addActionListener(this);
		panel_11.add(btnNine);
		
		btnTwentyPnd = new JButton("£ 20");
		btnTwentyPnd.setForeground(Color.WHITE);
		btnTwentyPnd.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnTwentyPnd.setBackground(new Color(44, 91, 166));
		btnTwentyPnd.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		panel_11.add(btnTwentyPnd);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(45, 50, 51));
		panel_7.add(panel_10);
		panel_10.setLayout(null);
		
		btnZero = new JButton("0");
		btnZero.setBounds(0, 0, 170, 85);
		btnZero.setForeground(Color.WHITE);
		btnZero.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnZero.setBackground(new Color(27, 188, 155));
		btnZero.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		btnZero.addActionListener(this);
		panel_10.add(btnZero);
		
		btnDot = new JButton(".");
		btnDot.setBounds(170, 0, 338, 85);
		btnDot.setForeground(Color.WHITE);
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnDot.setBackground(new Color(27, 188, 155));
		btnDot.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		btnDot.addActionListener(this);
		panel_10.add(btnDot);
		
		btnFiftyPnd = new JButton("£ 50");
		btnFiftyPnd.setBounds(509, 0, 168, 85);
		btnFiftyPnd.setForeground(Color.WHITE);
		btnFiftyPnd.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnFiftyPnd.setBackground(new Color(44, 91, 166));
		btnFiftyPnd.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		panel_10.add(btnFiftyPnd);
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.setForeground(Color.WHITE);
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnEnter.setBackground(new Color(44, 91, 166));
		btnEnter.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		panel_8.add(btnEnter);
		
		JPanel panel_21 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_21, null);
		Border emptyBorder = BorderFactory.createEmptyBorder();
	    javax.swing.Timer timer = new javax.swing.Timer(TIMER_DELAY, new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	counter++;
	        	if(counter > 10){
	        		isSwitch = true;
	        		if(isSwitch){
	        			
	        			btnFind.setEnabled(false);
	        			btnDelete.setEnabled(false);
	        			btnClear.setEnabled(false);
	        			btnDot.setEnabled(false);
	        			btnFivePnd.setEnabled(false);
	        			btnTenPnd.setEnabled(false);
	        			btnTwentyPnd.setEnabled(false);
	        			btnFiftyPnd.setEnabled(false);
	        			counter = 0;
	        			
	        			
	        		}
	        		
	        	}
	
	        }

	      });
	    timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		KeyPad keypad;
		JButton btnAction = (JButton)e.getSource();
		if(isPaid){
			keypad = new KeyPad();
			String txtVal = keypad.operate(btnAction.getText(),txtPaid.getText());
			txtPaid.setText(txtVal);
		}else if(!isPaid){
			keypad = new KeyPad();
			String txtVal = keypad.validateSearch(btnAction.getText(),txtSearch.getText());
			txtSearch.setText(txtVal);
			
		}

		if(isSwitch && btnAction.getText().equals("Login")){
			String srch = txtSearch.getText(); 
			dbQuery = new DBQuery("root","root");
			dbQuery.connectDB();
			if(dbQuery.isLogin(srch)){	   			
				btnFind.setEnabled(true);
    			btnDelete.setEnabled(true);
    			btnClear.setEnabled(true);
    			btnDot.setEnabled(true);
    			btnFivePnd.setEnabled(true);
    			btnTenPnd.setEnabled(true);
    			btnTwentyPnd.setEnabled(true);
    			btnFiftyPnd.setEnabled(true);
				counter = 0;
				isSwitch = false;
			}

			
		}else if(btnAction.getText().equals("Add")){
			System.out.println("test");
			model.addRow(new Object[]{"test","test"});
			
		}else if(btnAction.getText().equals("Remove")){
			removeSelectedRow(table);
			
		}
		
	}
	
	public void removeSelectedRow(JTable table){
		DefaultTableModel model = (DefaultTableModel) this.table.getModel();
		int[] rows = table.getSelectedRows();
		for(int i=0;i< rows.length;i++){
			model.removeRow(rows[i]-i);
		}
	}
}
 