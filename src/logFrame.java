

import javatutorials.javamail.JavaMailUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class logFrame extends JFrame implements ActionListener  {
    //Fields of the form
    private Container form;
    private JLabel title;
    private JLabel fName;
    private  JTextField fName_Field;
    private JLabel sName;
    private JTextField sName_Field;
    private JLabel dob;
    private JComboBox day;
    private JComboBox month;
    private JComboBox year;
    private JLabel email;
    private JTextField email_Field;
    private JLabel password;
    private  JPasswordField password_Field;
    private JPasswordField repeat_Field;
    private JButton submit_button;
    private JButton Login;

    //Initializing  dayCombo

    private String days[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    //Initializing months in Array
    private String months[]
            = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    private String years[]
            = { "1994","1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019" };


     public logFrame()
     {
         setTitle("New Account");
         setSize(900,600);
         setLocationRelativeTo(null);
         setDefaultCloseOperation(EXIT_ON_CLOSE);

         Container form  = getContentPane();
         form.setLayout(new GroupLayout(form));




         title = new JLabel("Create New Account");
         title.setBounds(390,100,500,20);
         title.setFont(Font.getFont("Arial"));
         form.add(title);



         fName = new JLabel("First Name");
         fName.setBounds(320,180,100,20);
         fName.setFont(Font.getFont("Arial"));
         form.add(fName);

         fName_Field= new JTextField();
         fName_Field.setBounds(500,180,200,20);

         form.add(fName_Field);

         sName = new JLabel("Second Name");
         sName.setBounds(320,220,200,20);
         sName.setFont(Font.getFont("Arial"));
         form.add(sName);

         sName_Field= new JTextField();
         sName_Field.setBounds(500,220,200,20);
         form.add(sName_Field);

         dob = new JLabel("Date Of Birth");
         dob.setBounds(320,260,100,20);
         dob.setFont(Font.getFont("Arial"));
         form.add(dob);

         day=new JComboBox(days);
         month= new JComboBox(months);
         year= new JComboBox(years);

         day.setBounds(500,260,50,20);
         month.setBounds(560, 260,50,20);
         year.setBounds(620,260, 60, 20);

         form.add(day);
         form.add(month);
         form.add(year);

         email_Field= new JTextField();
         email_Field.setBounds(500,300,200,20);
         form.add(email_Field);

         email = new JLabel("Email");
         email.setBounds(320,300,200,20);
         email.setFont(Font.getFont("Arial"));
         form.add(email);

         password = new JLabel("Password");
         password.setBounds(320,340,200,20);
         password.setFont(Font.getFont("Arial"));
         form.add(password);

         password_Field = new JPasswordField();
         password_Field.setBounds(500,340,200,20);
         form.add(password_Field);

         repeat_Field = new JPasswordField();
         repeat_Field.setBounds(500,380,200,20);
         form.add(repeat_Field);

         JLabel repeat_pwordBox = new JLabel("Retype Password");
         repeat_pwordBox.setBounds(320,380,200,20);
         repeat_pwordBox.setFont(Font.getFont("Arial"));
         form.add(repeat_pwordBox);

         submit_button = new JButton("Sign In");
         submit_button.setBounds(400,420,100,20);
         submit_button.addActionListener((this));
         form.add(submit_button);


         Login = new JButton("Log In");
         Login.setBounds(520,420,100,20);
         form.add(Login);






         setVisible(true);



    }
    public boolean Validate_Input() {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        String str_fname = fName_Field.getText();
        String str_sname = sName_Field.getText();
        String str_email = email_Field.getText();
        String str_pass = password_Field.getText();
        String str_retry = repeat_Field.getText();
        String str_day = String.valueOf(day.getSelectedItem());
        String str_month = String.valueOf(month.getSelectedItem());
        String str_year = String.valueOf(year.getSelectedItem());

        if (str_fname.equals("") || str_fname.equals("")) {
            JOptionPane.showMessageDialog(null, "Name  Cannot be Empty");
            fName_Field.grabFocus();
            return false;
        }
      else   if (!Pattern.matches("[a-zA-Z]+", str_fname)) {
            JOptionPane.showMessageDialog(null, "Name Cannot contain characters");
            return false;
        }
      else   if (str_sname.equals("") || str_sname.equals("")) {
            JOptionPane.showMessageDialog(null, "Name  Cannot be Empty");
            sName_Field.grabFocus();
            return false;
        }
     else    if (!Pattern.matches("[a-zA-Z]+", str_sname)) {
            JOptionPane.showMessageDialog(null, "Name Cannot contain characters");
             sName_Field.grabFocus();
            return false;
        }
    else     if (str_email.equals("")) {
            JOptionPane.showMessageDialog(null, "Email cannot be empty");
            email_Field.grabFocus();
            return false;
        }
    else if (!str_email.matches(regex))
        {
            JOptionPane.showMessageDialog(null, "Email is incorrect");
            email_Field.grabFocus();
            return false;
        }
    else    if (str_pass.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Password cannot be empty");
            password_Field.grabFocus();
            return false;

        }
    else if (!str_pass.equals(str_retry))
        {
            JOptionPane.showMessageDialog(null, "Passwords don't match");
            password_Field.setText("");
            repeat_Field.setText("");
            password_Field.grabFocus();
            return false;
        }
    else {
            return true;
        }



    }










    @Override
    public void actionPerformed(ActionEvent e) {
        Validate_Input();
        if (Validate_Input() == true)
        {
            try {
                JavaMailUtil.sendMail(email_Field.getText());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }


    }
    public void fNameKeyReleased(java.awt.event.KeyEvent evt)
    {

    }
    public void reg_button(ActionEvent e) throws Exception {


    }
}
