
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;

public class Interface extends JFrame{
	
    public Interface()
    {
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        JTextArea inputText = new JTextArea();
        JTextArea outputText = new JTextArea();
        Color myColor = new Color(255,255,255);
        inputText.setBackground(myColor);
        Color myColor2 = new Color(255,255,255);
        outputText.setBackground(myColor2);
        JPanel bottomPanel = new JPanel();
        JPanel btnsPanel = new JPanel();
        final JPasswordField textPwd = new JPasswordField();
        textPwd.setEchoChar('*');
        

        textPwd.setPreferredSize(new Dimension(100, 30));
        btnsPanel.setLayout(new BoxLayout(btnsPanel, BoxLayout.Y_AXIS));
        JButton encryptBtn = new JButton("Encrypt");
        JButton decryptBtn = new JButton("Decrypt");
        encryptBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String myPwd = new String(textPwd.getPassword());
                if( !myPwd.equals("123") ) {
                    JOptionPane.showMessageDialog(null, "Password is not correct！" );
                    return;
                }
                if(inputText.getText().equals("")) {
                		JOptionPane.showMessageDialog(null, "The input is invalid...");
                		return;
                }
                //如果密码正确，在此处后面开始加密
                //JOptionPane.showMessageDialog(null, inputText.getText() + " will be encoded... ");
                String textInput = inputText.getText();
                encryption myEncrypt = new encryption(textInput, myPwd);
                /*for(int i = 0; i < 100; i++) {
                	if(afterEncryptArray[i] != null) {
                		afterEncryptArray[i] = myEncrypt.getAfterEncrypt();
                		inputTextArray[i] = textInput;
                		break;
                	}
                }*/
                
                outputText.setText(myEncrypt.getAfterEncrypt());
           
            }  
        });
      

        decryptBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	   String myPwd = new String(textPwd.getPassword());
                if( !myPwd.equals("123") ) {
                    JOptionPane.showMessageDialog(null, "Password is not correct！" );
                    return;
                } 
                if(inputText.getText().equals("")) {
            		JOptionPane.showMessageDialog(null, "The input is invlaid...");
            		return;
            }
                //如果密码正确，在此处后面开始解密
                //JOptionPane.showMessageDialog(null, outputText.getText() + " will be decoded... ");
                String decryptCode = inputText.getText();
                for(int i = 0; i < encryption.encryptList.length; i++) {
                	     System.out.println(i + " " + encryption.encryptList[i]);
                	     System.out.println(decryptCode);
                	     System.out.println(encryption.encryptList[i].getAfterEncrypt());
                		if (decryptCode.equals(encryption.encryptList[i].getAfterEncrypt())) {
                			outputText.setText(encryption.encryptList[i].getAfterDecrypt());
                			System.out.println("!");
                			break;
                		}
                		
                }
                
               /* boolean flag = false;
                for (int i = 0; i < afterEncryptArray.length; i++) {
                		if (decryptCode == afterEncryptArray[i]) {
                			flag = true;
                			outputText.setText(inputTextArray[i]);
                			break;
                		}
                }
                if (flag == false) {
                	JOptionPane.showMessageDialog(null,"The Encoded Message is not found!");
                }
               */ 
                
            }
        });
        btnsPanel.add(encryptBtn);
        btnsPanel.add(decryptBtn);

        bottomPanel.add(new JLabel("Enter Password:"));
        bottomPanel.add(textPwd);
        bottomPanel.add(btnsPanel);

        add(new JLabel("Input"));
        add(inputText);
        add(new JLabel("Output"));
        add(outputText);
        add(bottomPanel);
    }
    
    public static void main(String args[]) {
        Interface f = new Interface();
        f.setTitle("Encoder/Decoder");
        Color myColor = new Color(3,141,207);
        f.setBackground(myColor);
        f.setVisible(true);
        f.setSize(500,600);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}



