import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;


public class Homepage extends JFrame implements ActionListener {


    JLabel firstName = new JLabel();
    private String[] Education = {"Undergraduate", "Postgraduate"};
    JComboBox lev = new JComboBox(Education);
    JButton reset = new JButton("RESET");

    JTextField Searchbar= new JTextField();


    JRadioButton SAT = new JRadioButton("SAT");
    JRadioButton GRE = new JRadioButton("GRE");
    ButtonGroup Btn_group = new ButtonGroup();
    JRadioButton OTHER = new JRadioButton("OTHER");
    JTextField Score = new JTextField();
    JLabel Score_Text = new JLabel("Test Score: ");
    JLabel Search = new JLabel("Search ");

    JButton submit = new JButton("Submit");

    JTextField GPA = new JTextField();
    JLabel GPA_Text = new JLabel("GPA: ");

    JTable Scholar_list = new JTable();

    JScrollPane scroll = new JScrollPane(Scholar_list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);


    public Homepage() throws Exception {
        setTitle("Scholarship Blog");
        setSize(1100, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setResizable(false);

        Container form = getContentPane();
        form.setLayout(new GroupLayout(form));

        ImageIcon img = new ImageIcon(this.getClass().getResource("/user.png"));
        Image im = (img.getImage().getScaledInstance(img.getIconWidth(), img.getIconHeight(), Image.SCALE_SMOOTH));
        img = new ImageIcon(im);
        JLabel image = new JLabel();
        image.setIcon(img);
        image.setBounds(8, 10, 450, 150);
        image.setBorder(new LineBorder(Color.gray, 2));
        LineBorder border = (LineBorder) image.getBorder();
        System.out.println("Border color = " + border.getLineColor()
                + "  size= " + border.getThickness());
        JLabel INFO = new JLabel();

        INFO.setBounds(8, 150, 450, 300);
        INFO.setFont(Font.getFont("Arial"));
        INFO.setBorder(new LineBorder(Color.gray, 2));

        JLabel Level = new JLabel("Educational level :");
        Level.setFont(Font.getFont("Arial"));
        Level.setBounds(8, 230, 200, 40);

        lev.setBounds(120, 240, 200, 30);
        lev.setFont(Font.getFont("Arial"));
        JLabel Exam_type = new JLabel("Examination Type");
        Exam_type.setFont(Font.getFont("Arial"));
        Exam_type.setBounds(8, 280, 200, 30);

        Score.setBounds(120, 320, 200, 30);
        Score.setFont(Font.getFont("Arial"));
        Score_Text.setBounds(8, 320, 200, 30);
        Score_Text.setFont(Font.getFont("Arial"));

        GPA_Text.setBounds(8, 360, 200, 30);
        GPA_Text.setFont(Font.getFont("Arial"));

        GPA.setBounds(120, 360, 200, 30);
        GPA.setFont(Font.getFont("Arial"));
        scroll.setBounds(500, 68, 540, 200);
        Search.setBounds(500, 18,50,30);
        Search.setFont(Font.getFont("Arial"));
        scroll.setFont(Font.getFont("Arial"));
        scroll.setBorder(new LineBorder(Color.gray, 2));
         Searchbar.setBounds(580,18,240,25);
         Searchbar.setFont(Font.getFont("Arial"));

        submit.setBounds(8, 410, 100, 30);
        submit.setFont(Font.getFont("Arial"));
        submit.addActionListener((this));
        reset.addActionListener(this);
        Searchbar.addActionListener(action);

        reset.setBounds(120, 410, 100, 30);


        this.getContentPane().add(SAT);
        this.getContentPane().add(GRE);
        this.getContentPane().add(OTHER);
        this.getContentPane().add(scroll);

        Btn_group.add(SAT);
        Btn_group.add(GRE);
        Btn_group.add(OTHER);


        SAT.setFont(Font.getFont("Arial"));

        SAT.setBounds(120, 280, 80, 30);
        GRE.setFont(Font.getFont("Arial"));
        GRE.setBounds(230, 280, 60, 30);
        OTHER.setFont(Font.getFont("Arial"));
        OTHER.setBounds(360, 280, 70, 30);

        this.setVisible(true);


        firstName.setBounds(50, 30, 200, 100);
        firstName.setBackground(Color.GRAY);
        firstName.setFont(Font.getFont("Arial"));
        form.add(firstName);
        form.add(image);
        form.add(INFO);
        form.add(lev);
        form.add(Level);

        form.add(Exam_type);
        form.add(Score);
        form.add(Score_Text);
        form.add(GPA);
        form.add(GPA_Text);
        form.add(submit);
        form.add(reset);
        form.add(Searchbar);
        form.add(Search);

        initialize();


        setVisible(true);


    }

    private void initialize() {

    }

    public void RadioButton() {

        for (Enumeration<AbstractButton> buttons = Btn_group.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {

                if (lev.getSelectedItem() == "Undergraduate" && button.getText() == "GRE") {


                    GRE.setEnabled(false);
                    SAT.setEnabled(true);
                    Btn_group.clearSelection();
                    Score.setText("");


                } else if (lev.getSelectedItem() == "Postgraduate" && button.getText() == "SAT") {

                    GRE.setEnabled(true);
                    SAT.setEnabled(false);
                    Btn_group.clearSelection();
                    Score.setText("");


                }
            }
        }


    }

    public int ScoreReleased() throws Exception {
        try {

            int x = Integer.parseInt(Score.getText());
            if (SAT.isSelected() && (x < 400 || x > 1600)) {
                JOptionPane.showMessageDialog(null, "Keep score in range 400-1600")
                ;
                Score.setText("");
            } else if (GRE.isSelected() && (x < 130 || x > 170)) {
                JOptionPane.showMessageDialog(null, "Keep score in range 130-170")
                ;
                Score.setText("");
            } else if ((!SAT.isSelected() && !GRE.isSelected() && !OTHER.isSelected())) {
                Connection conn = MyConnection.getConnection();

                conn.close();
                JOptionPane.showMessageDialog(null, "Please select Exam type");
                Score.setText("");


            }
            return x;

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Test Score Incorrect");

        }


        return 0;
    }

    public int GpaReleased() throws Exception {
        double x = Double.parseDouble(GPA.getText());
        if (x > 4.0 || x < 0.0) {
            JOptionPane.showMessageDialog(null, "Test Score Incorrect");
            GPA.setText("");

        }

        return 0;
    }

    public void RESET() {
        Btn_group.clearSelection();
        Score.setText("");
        GPA.setText("");

        GRE.setEnabled(true);
        SAT.setEnabled(true);
        OTHER.setEnabled(true);
        Scholar_list.clearSelection();


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


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            RadioButton();
            try {
                ScoreReleased();
                GpaReleased();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            try {
                ScholarSearch();
            } catch (Exception exception) {
                System.out.println("Search wrong");
            }
        }
        if (e.getSource() == reset) {
            RESET();
        }
    }

    public void ScholarSearch() throws Exception {
        MyConnection.getConnection();
        String query = "Select * from scholarship_list " + " where Score<='" + Double.parseDouble(Score.getText()) + "' AND GPA<='" + Double.parseDouble(GPA.getText()) + "'";

        Statement stm = MyConnection.getConnection().createStatement();
        ResultSet rs = stm.executeQuery(query);
        DefaultTableModel model = new DefaultTableModel(new String[]{"College Name", "Scholarship Name", "SAT ", "GPA", "Name"}, 0);

        while (rs.next()) {

            try {
                String d = rs.getString("College_Name");
                String e = rs.getString("Scholarship_Name");
                String f = rs.getString("Score");
                String h = rs.getString("GPA");
                String g = rs.getString("Aid_Type");
                model.addRow(new Object[]{d, e, f, h, g});

                Scholar_list.setDefaultEditor(Object.class, null);

                Scholar_list.setModel(model);

            } catch
            (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public void SearchBar() throws Exception {
        MyConnection.getConnection();
        String query = "Select * from scholarship_list " + " where College_Name  ='" + Searchbar.getText() + "' OR Scholarship_Name  ='" + Searchbar.getText()+ "'";


        Statement stm = MyConnection.getConnection().createStatement();
        ResultSet rs = stm.executeQuery(query);
        DefaultTableModel model = new DefaultTableModel(new String[]{"College Name", "Scholarship Name", "SAT ", "GPA", "Name"}, 0);

        while (rs.next()) {

            try {
                String d = rs.getString("College_Name");
                String e = rs.getString("Scholarship_Name");
                String f = rs.getString("Score");
                String h = rs.getString("GPA");
                String g = rs.getString("Aid_Type");
                model.addRow(new Object[]{d, e, f, h, g});

                Scholar_list.setDefaultEditor(Object.class, null);

                Scholar_list.setModel(model);

            } catch
            (Exception e) {
                e.printStackTrace();
            }

        }
    }
    Action action = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try {
                SearchBar();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    };





}


