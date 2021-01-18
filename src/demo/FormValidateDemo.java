package demo;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import lib.IValidationResult;
import lib.AbtractValidator;
import lib.AbtractValidator.BuilderType;
import java.awt.Color;

/**
 * User Registration using Swing
 * @author javaguides.net
 *
 */
public class FormValidateDemo extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField email;
    private JTextField username;
    private JTextField mob;
    private JButton btnNewButton;
    private JLabel lblEmailMessage;
    private JLabel lblPassValid;
    private JTextField passwordField;
    private JTextField textTime;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormValidateDemo frame = new FormValidateDemo();
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

    public FormValidateDemo() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("Validate Infomation");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(362, 23, 355, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("First name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 123, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Last name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 214, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Email\r\n address");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setBounds(58, 295, 124, 36);
        contentPane.add(lblEmailAddress);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(214, 122, 228, 50);
        contentPane.add(firstname);
        firstname.setColumns(10);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lastname.setBounds(214, 206, 228, 50);
        contentPane.add(lastname);
        lastname.setColumns(10);

        email = new JTextField();

        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBounds(214, 291, 228, 50);
        contentPane.add(email);
        email.setColumns(10);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(707, 122, 228, 50);
        contentPane.add(username);
        username.setColumns(10);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(542, 130, 99, 29);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(58, 384, 99, 24);
        contentPane.add(lblPassword);

        JLabel lblMobileNumber = new JLabel("Mobile number");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMobileNumber.setBounds(542, 215, 139, 26);
        contentPane.add(lblMobileNumber);
        

        

        mob = new JTextField();
        mob.setFont(new Font("Tahoma", Font.PLAIN, 32));
        mob.setBounds(708, 202, 228, 50);
        contentPane.add(mob);
        mob.setColumns(10);
        
        passwordField = new JTextField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(214, 367, 228, 50);
        contentPane.add(passwordField);
        passwordField.setColumns(10);
        
        lblEmailMessage = new JLabel("New label");
        lblEmailMessage.setForeground(Color.RED);
        lblEmailMessage.setBounds(214, 347, 228, 13);
        lblEmailMessage.setVisible(false);

        JLabel lbValidPhoneNum = new JLabel("New label");
        lbValidPhoneNum.setForeground(Color.RED);
        lbValidPhoneNum.setBounds(708, 262, 228, 13);
        contentPane.add(lbValidPhoneNum);
        lbValidPhoneNum.setVisible(false);
        
        
        lblPassValid = new JLabel("New label");
        lblPassValid.setForeground(Color.RED);
        lblPassValid.setBounds(58, 424, 726, 29);
        contentPane.add(lblPassValid);
        lblPassValid.setVisible(false); 
        
        textTime = new JTextField();
        textTime.setBounds(708, 281, 228, 44);
        contentPane.add(textTime);
        textTime.setColumns(10);
        
        JLabel lblValidTime = new JLabel("New label");
        lblValidTime.setForeground(Color.RED);
        lblValidTime.setBounds(707, 335, 228, 13);
        contentPane.add(lblValidTime);
        lblValidTime.setVisible(false);
        
        btnNewButton = new JButton("Validate");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String emailId = email.getText();
                String mobileNumber = mob.getText();
                String pass = passwordField.getText();
                String time = textTime.getText();

                AbtractValidator emailValidator = AbtractValidator.getInstance(BuilderType.EMAIL)
            			.build();
                IValidationResult validationResult = emailValidator.validate(emailId);
                
                AbtractValidator phoneNumlValidator = AbtractValidator.getInstance(BuilderType.PHONE_NUMBER)
            			.build();
                IValidationResult phoneNumValidationResult = phoneNumlValidator.validate(mobileNumber);
                
                AbtractValidator passwordValidator = AbtractValidator.getInstance(BuilderType.PASSWORD)
            			.build();
                IValidationResult passwordValidationResult = passwordValidator.validate(pass);
                
                AbtractValidator timeValidator = AbtractValidator.getInstance(BuilderType.TIME)
            			.build();
                IValidationResult timeValidationResult = timeValidator.validate(time);
                if (!validationResult.isValid()) {
                	lblEmailMessage.setVisible(true);
                	lblEmailMessage.setText(validationResult.processedValidations());
                } else {
                	lblEmailMessage.setVisible(false);
                }
                if (!phoneNumValidationResult.isValid()) {
                	lbValidPhoneNum.setVisible(true);
                	lbValidPhoneNum.setText(phoneNumValidationResult.processedValidations());
                } else {
                	lbValidPhoneNum.setVisible(false);
                }
                if (!passwordValidationResult.isValid()) {
                	lblPassValid.setVisible(true);
                	lblPassValid.setText(passwordValidationResult.processedValidations());
                } else {
                	lblPassValid.setVisible(false);
                }
                if (!timeValidationResult.isValid()) {
                	lblValidTime.setVisible(true);
                	lblValidTime.setText(timeValidationResult.processedValidations());
                } else {
                	lblValidTime.setVisible(false);
                }

                
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(380, 467, 259, 74);
        contentPane.add(btnNewButton);
        
        contentPane.add(lblEmailMessage);
        
        JLabel lblTime = new JLabel("Time");
        lblTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTime.setBounds(542, 289, 124, 36);
        contentPane.add(lblTime); 
    }
}