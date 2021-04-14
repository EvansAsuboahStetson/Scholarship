import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class LogIn extends JFrame implements ActionListener{
      private JLabel email_label;
      private JLabel pass_label;
      private Connection conn;
      public JTextField emai_Field;
      public JPasswordField pass_Field;
      private JButton submit_button;
      private JButton regbutton;

      public LogIn ()
      {
          setTitle("Scholarship Blog");
          setSize(900,600);
          setLocationRelativeTo(null);
          setDefaultCloseOperation(EXIT_ON_CLOSE);

          Container form  = getContentPane();
          form.setLayout(new GroupLayout(form));


          JLabel title = new JLabel("Log In");
          title.setBounds(450,100,500,20);
          title.setFont(Font.getFont("Arial"));
          form.add(title);

          email_label = new JLabel("Email");
          email_label.setBounds(320,180,100,20);
          email_label.setFont(Font.getFont("Arial"));
          form.add(email_label);

          pass_label = new JLabel("Password");
          pass_label.setBounds(320,250,200,20);
          pass_label.setFont(Font.getFont("Arial"));
          form.add(pass_label);

          pass_Field = new JPasswordField();
          pass_Field.setBounds(500,250,200,20);
          form.add(pass_Field);

          emai_Field= new JTextField();
          emai_Field.setBounds(500,180,200,20);
          form.add(emai_Field);

          submit_button = new JButton("Log In");
          submit_button.setBounds(500,320,100,20);
          submit_button.addActionListener((this));
          form.add(submit_button);

          regbutton = new JButton("Sign IN");
          regbutton.setBounds(350,320,100,20);
          regbutton.addActionListener((this::regButton));
          form.add(regbutton);




          setVisible(true);


      }



      @Override
      public void actionPerformed(ActionEvent e) {
          try {
              if(e.getSource()==submit_button)
              {


                   if (((isLogIn(emai_Field.getText(), pass_Field.getText()))))
                  {
                      dispose();


                      String query = "Select * from user_details where email='" + emai_Field.getText() + "' and psword= '" + pass_Field.getText() + "'";
                      Statement stm = MyConnection.getConnection().createStatement();
                      ResultSet rs = stm.executeQuery(query);
                      if(rs.next())
                      {
                          Homepage v1= new Homepage();
                          v1.firstName.setText(rs.getString(2));
                          v1.setVisible(true);


                      }

                  }
                   else {

                        JOptionPane.showMessageDialog(null, "Username not registered. Sign up");

              }




          }

      } catch (Exception exception) {
              exception.printStackTrace();
          }



      }
      public void regButton(java.awt.event.ActionEvent e)
      {
          logFrame log = new logFrame();
          log.setVisible(true);
         this.dispose();
      }
      public boolean isLogIn (String email, String p_word) throws Exception {


          this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scholar", "root","SarahDufie1999$");

          String query = "Select * from user_details where email='" + email + "' and psword= '" + p_word + "'";
          Statement stm = this.conn.createStatement();
          ResultSet rs = stm.executeQuery(query);
          if (rs.next()) {
              System.out.println("LogIn successful");




              return true;





          } else {
              return false;
          }
      }
  }

