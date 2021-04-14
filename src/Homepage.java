import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class Homepage extends JFrame    {


    JLabel label= new JLabel("User: " );
    JLabel firstName=new JLabel();




       public Homepage() throws Exception {

           setTitle("Scholar: ");
           setSize(900,600);
           setLocationRelativeTo(null);
           setDefaultCloseOperation(EXIT_ON_CLOSE);

           label.setBounds(0,0,100,50);
           firstName.setBounds(50,0,200,50);
           label.setFont(new Font(null,Font.PLAIN,15));

           Container form  = getContentPane();
           form.setLayout(new GroupLayout(form));

           form.add(label);
           form.add(firstName);

           setVisible(true);







       }
       public void main(String args[]) throws Exception {
           fetchingUser();
       }

         private void fetchingUser() throws Exception {


         }
   }


