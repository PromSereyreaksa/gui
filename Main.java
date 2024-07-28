
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Main implements ActionListener {

    private static JLabel userLabel;
    private static JTextField userText;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;
    private static JLabel passwordLabel;
    private static JButton button1;
    private static JLabel text;
    private static ImageIcon image;
    private static ImageIcon user;
    private static JLabel user1;
    private static JLabel user2;
    private static JLabel password1;
    private static ImageIcon password;
    private static ImageIcon background;
    private static JLabel qrLabel;
    private static JLabel regLabel;
    private static JButton signup;
    private static JTextField regUser;
    private static JPasswordField regPassword;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 500);
        frame.setTitle("Login GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Create a custom JPanel with the background image
        BackgroundPanel panel = new BackgroundPanel("background.png");
        
        panel.setLayout(null);
        

        user1 = new JLabel();
        ImageIcon user = new ImageIcon("user1.png");
        user1.setIcon(user);
        user1.setBounds(105, 15, 400, 260);
        panel.add(user1);

        user2 = new JLabel();
        ImageIcon user1 = new ImageIcon("user.png");
        user2.setIcon(user1);
        user2.setBounds(97,245,200,25);
        panel.add(user2);

            
        password1 = new JLabel();
        ImageIcon password = new ImageIcon("password.png");
        password1.setIcon(password);
        password1.setBounds(100, 285, 200, 25);
        panel.add(password1);

        // userLabel = new JLabel("User");
        // userLabel.setBounds(10, 25, 80, 25);
        // userLabel.setForeground(Color.white);
        // panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(125, 245, 165, 25);
        panel.add(userText);

        qrLabel = new JLabel("Scan for more info");
        ImageIcon image = new ImageIcon("qr.png");
        qrLabel.setIcon(image);
        qrLabel.setHorizontalTextPosition(JLabel.CENTER);
        qrLabel.setVerticalTextPosition(JLabel.BOTTOM);
        qrLabel.setBounds(270, 25, 200, 100);
        qrLabel.setForeground(Color.white);
        // panel.add(qrLabel);

        text = new JLabel("Login Interface");
        text.setBounds(115, 10, 200, 25);
        text.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 25));
        text.setForeground(Color.BLUE);
        // panel.add(text);

        // passwordLabel = new JLabel("Password");
        // passwordLabel.setBounds(10, 55, 80, 25);
        // passwordLabel.setForeground(Color.WHITE);
        // panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(125, 285, 165, 25);
        panel.add(passwordText);

        button = new JButton("Login");
        button.setBounds(125, 320, 80, 25);
        button.addActionListener(new Main());
        panel.add(button);
        button.setBackground(Color.white);

        button1 = new JButton("Sign up");
        button1.setBounds(210, 320, 80, 25);
        panel.add(button1);
        button1.setBackground(Color.white);

        success = new JLabel("");
        success.setBounds(75, 440, 300, 25);
        success.setForeground(Color.RED);
        panel.add(success);

        frame.add(panel);
        frame.setVisible(true);

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = passwordText.getText();
        if (user.equals("Sou") && password.equals("ilovejun")) {
            success.setText("Login success!");
        } else if (user.isBlank() && password.isBlank()) {
            success.setText("Please enter your username and password");
        } else if (user.isBlank()) {
            success.setText("Enter your username");
        } else if (password.isBlank()) {
            success.setText("Enter your password");
        } else if (user != "Sou") {
            success.setText("Username not found");
        } else if (user != "Sou" && password.equals("ilovejun")) {
            success.setText("Username not found");
        } else if (user != "Sou" && password != "ilovejun") {
            success.setText("Username not found");
        } else if (user.equals("Sou") && password != "ilovejun") {
            success.setText("Wrong password, Please try again.");
        } else if (password != "ilovejun") {
            success.setText("Wrong Password, Please try again.");
        }
        else if (user.equals("Sou") && password.equals("ilovejun"));
    }
}

class BackgroundPanel extends JPanel {

    private ImageIcon background;

    public BackgroundPanel(String backgroundImagePath) {
        background = new ImageIcon(backgroundImagePath);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background.getImage(), 0, 30, getWidth(), getHeight(), this);
    }
}
