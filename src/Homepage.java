import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Homepage extends JFrame implements ActionListener  {
    JFrame frame = new JFrame();
    JLabel label= new JLabel("Hello" );



       public Homepage()
       {



           setTitle("Welcome Page");
           setSize(900,600);
           setLocationRelativeTo(null);
           setDefaultCloseOperation(EXIT_ON_CLOSE);

           label.setBounds(0,0,100,50);
           label.setFont(new Font(null,Font.PLAIN,15));

           Container form  = getContentPane();
           form.setLayout(new GroupLayout(form));

           form.add(label);

           setVisible(true);
       }
       @Override
       public void actionPerformed(ActionEvent e) {

       }
   }


