import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Label;

public class Retrieve {

	private JFrame Retrieve;
	private JTextField textFieldNumber;

	 public void setVisible(boolean visible) {
	        if (Retrieve != null) {
	        	Retrieve.setVisible(visible);
	        }
	    }

	/**
	 * Create the application.
	 */
	public Retrieve() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Retrieve = new JFrame("Retrieve Food Image");
	    Retrieve.setBounds(260, 260, 750, 700);
		Retrieve.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Retrieve.getContentPane().setLayout(null);
		//Retrieve.getContentPane().setBackground(Color.decode("#bdb76b"));
		
		
		JLabel lblImage = new JLabel();
		lblImage.setBounds(111, 51, 551, 244);
		Retrieve.getContentPane().add(lblImage);
		
		JLabel lblFoodPrice = new JLabel("Price:");
		lblFoodPrice.setForeground(Color.YELLOW);
		lblFoodPrice.setBounds(100, 200, 107, 29);
		Retrieve.getContentPane().add(lblFoodPrice);
		
		JLabel lblPrice = new JLabel("");
		lblPrice.setBounds(100, 200, 130, 29);
		Retrieve.getContentPane().add(lblPrice);
		
		JLabel lblFoodName = new JLabel("Name:");
		lblFoodName.setForeground(Color.YELLOW);
		lblFoodName.setBounds(100, 100, 107, 11);
		Retrieve.getContentPane().add(lblFoodName);
		
		JLabel lblName = new JLabel("");
		lblName.setBounds(100, 100, 117, 26);
		Retrieve.getContentPane().add(lblName);
		
		
		
		
		JButton btnRetrieve = new JButton("Choose");
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

	            try{
	                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","root");
	                Statement mySt = myConn.createStatement();
	                ResultSet myRs = mySt.executeQuery("select * from Menu where FoodID = '"+textFieldNumber.getText()+"'");
	                if(myRs.next()){
	                    byte[] img = myRs.getBytes("FoodImage");
	                    ImageIcon image = new ImageIcon(img);
	                    Image im = image.getImage();
	                    Image myImg = im.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(),Image.SCALE_SMOOTH);
	                    ImageIcon newImage = new ImageIcon(myImg);
	                    lblImage.setIcon(newImage);
	                    
	                    lblPrice.setText(myRs.getString("FoodPrice"));
	                    lblPrice.setForeground(Color.blue);
	                    lblName.setText(myRs.getString("FoodName"));
	                    lblName.setForeground(Color.blue);
	                    labelDescription.setText(myRs.getString("Description"));
	                    lblPrice.setForeground(Color.blue);
	                    
	                    
	                }
	                
	                else{
	                    JOptionPane.showMessageDialog(null, "Please Enter Correct Number");
	                }
	            }catch(Exception ex){
	                ex.printStackTrace();
	            }
	        
			}
		});
		btnRetrieve.setBounds(200, 300, 117, 29);
		Retrieve.getContentPane().add(btnRetrieve);
		
		textFieldNumber = new JTextField();
		textFieldNumber.setText("Please enter food name");
		textFieldNumber.setBounds(400, 300, 130, 26);
		Retrieve.getContentPane().add(textFieldNumber);
		textFieldNumber.setColumns(10);
		
		
		JLabel lblCollection = new JLabel("");
		int width=542,height=216;
		ImageIcon image = new ImageIcon("src/Pictures/FoodList.png");
        image.setImage(image.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));
		lblCollection.setIcon(image);
		lblCollection.setSize(width,height);
        lblCollection.setBounds(150, 350, 551, 300);
		Retrieve.getContentPane().add(lblCollection);
		
		JButton btnReturnButton = new JButton("Return");
		btnReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Retrieve.dispose();
				new StartPage().setVisible(true);
			}
		});
		btnReturnButton.setBounds(6, 6, 117, 29);
		Retrieve.getContentPane().add(btnReturnButton);
		
	
		
		JLabel lblWallpaper = new JLabel(" ");
		lblWallpaper.setBounds(0, 0, 750, 678);
		lblWallpaper.setIcon(new ImageIcon("src/Pictures/lobby3.jpg"));
		Retrieve.getContentPane().add(lblWallpaper);	
	
		
	}
}
