import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Review {

	private JFrame ReviewWindow;
	private JTextField textFieldName;
	private JTextField textFieldChef;
	private JDialog Dialog;
	private JTextField textFieldComment;

	public void setVisible(boolean visible) {
        if (ReviewWindow != null) {
        	ReviewWindow.setVisible(visible);
        }
    }
	
	
	/**
	 * Create the application.
	 */
	
	
	public Review() {
		initialize();
	}
	
    
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ReviewWindow = new JFrame("Payment Info");
		ReviewWindow.setBounds(300, 300, 700, 700);
		ReviewWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ReviewWindow.getContentPane().setLayout(null);
		
		JLabel lblImage = new JLabel();
		lblImage.setBounds(111, 51, 551, 244);
		ReviewWindow.getContentPane().add(lblImage);
		
		textFieldChef = new JTextField();
		textFieldChef.setText("Card number");
		textFieldChef.setBounds(100, 200, 130, 29);
		ReviewWindow.getContentPane().add(textFieldChef);
		textFieldChef.setColumns(10);
		
		Label lblStar = new Label("Security Code(3 digits)");
		lblStar.setBounds(100, 300, 180, 26);
		ReviewWindow.getContentPane().add(lblStar);
		
		
		
		
		textFieldName = new JTextField();
		textFieldName.setText("Name on card");
		textFieldName.setBounds(100, 100, 130, 26);
		ReviewWindow.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
	
		
		JButton btnReturnButton = new JButton("Return");
		btnReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReviewWindow.dispose();
				new StartPage().setVisible(true);
			}
		});
		btnReturnButton.setBounds(396, 617, 139, 29);
		ReviewWindow.getContentPane().add(btnReturnButton);
		
		
		
	
		
		JButton btnComment = new JButton("Save");
		btnComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
	                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","root");
	                Statement mySt =myConn.createStatement();
	                String sql6= "UPDATE `Restaurant`.`Menu` "
	                		+ "SET `Comment`='"+(textFieldComment.getText())+"' WHERE `FoodName`= '"+textFieldName.getText()+"'";
        			
                    mySt.executeUpdate(sql6);
                    JOptionPane.showMessageDialog(Dialog, "Successfully Rating!", "",JOptionPane.INFORMATION_MESSAGE);
                    mySt.close();
                    myConn.close();
	                       
	            }catch(Exception ex){
	            	JOptionPane.showMessageDialog(Dialog, "Failed To Rating!", "",JOptionPane.WARNING_MESSAGE);
	                ex.printStackTrace();
	            }
			}
		});
		
		btnComment.setBounds(161, 617, 139, 29);
		ReviewWindow.getContentPane().add(btnComment);
		
		JLabel lblStarImage = new JLabel("");
		int widthSI=316,heightSI=63;
		ImageIcon imageSI = new ImageIcon("src/Pictures/RateStar.jpg");
        imageSI.setImage(imageSI.getImage().getScaledInstance(widthSI,heightSI,Image.SCALE_DEFAULT));
        lblStarImage.setIcon(imageSI);
        lblStarImage.setSize(widthSI,heightSI);
		lblStarImage.setBounds(206, 394, 316, 63);
		ReviewWindow.getContentPane().add(lblStarImage);
		
		
		JLabel lblWallpaper = new JLabel(" ");
		int widthBG=750,heightBG=678;
		ImageIcon imageBG = new ImageIcon("src/Pictures/lobby2.jpg");
        imageBG.setImage(imageBG.getImage().getScaledInstance(widthBG,heightBG,Image.SCALE_DEFAULT));
        lblWallpaper.setIcon(imageBG);
        lblWallpaper.setSize(widthBG,heightBG);
		lblWallpaper.setBounds(0, 0, 750, 678);
		ReviewWindow.getContentPane().add(lblWallpaper);
		
		
		
		
		
		
		
		
		
	
		
		
		
	}
}
