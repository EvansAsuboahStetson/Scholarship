import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class Homepage extends JFrame    {



    JLabel firstName=new JLabel();
    JLabel country= new JLabel("Ghana");





    public Homepage() throws Exception {
           JFrame frame = new JFrame();

           frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
           frame.setSize(900,400);

           Container form =  frame.getContentPane();
           frame.setTitle("User");


            form.setLayout(new GridLayout(2,2,2,2));

            form.add(firstName);
            form.add(country);

            frame.setVisible(true);

    /*  setTitle("Scholar: ");
           setSize(900,600);
           setLocationRelativeTo(null);
           setDefaultCloseOperation(EXIT_ON_CLOSE);

           label.setBounds(0,0,100,50);
        JPanel pane = new JPanel();
        pane.setBorder(BorderFactory.createLineBorder(Color.black));
           firstName.setBounds(50,0,200,50);
           label.setFont(new Font(null,Font.PLAIN,15));

           Container form  = getContentPane();
           form.setLayout(new GroupLayout(form));

           form.add(label);
           form.add(firstName);
           form.add(pane);

           setVisible(true);
*/


       }
       public static void main(String args[]) throws Exception {
       SwingUtilities.invokeLater(new Runnable() {
           @Override
           public void run() {
               try {
                   new Homepage();
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       });
       }

         private void fetchingUser() throws Exception {


         }
   }


