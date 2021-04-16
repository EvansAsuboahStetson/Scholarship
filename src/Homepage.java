import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;
import java.io.InputStreamReader;


public class Homepage extends JFrame    {

     JPanel jPanel= new JPanel();

    JLabel firstName=new JLabel();
    private String Education[]={
            "Undergraduate","PostGraduate"
    };
    JRadioButton SAT = new JRadioButton("SAT");
    JRadioButton GRE = new JRadioButton("GRE");
    ButtonGroup Btn_group = new ButtonGroup();
    JRadioButton OTHER= new JRadioButton("OTHER");
    JTextField Score= new JTextField();
    JLabel Score_Text =new JLabel("Test Score: ");

    JTextField GPA= new JTextField();
    JLabel GPA_Text =new JLabel("GPA: ");

    JTextArea Scholar_list= new JTextArea(10,10);

    JScrollPane scroll= new JScrollPane(Scholar_list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);










    public Homepage() throws Exception {
        setTitle("Scholarship Blog");
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container form  = getContentPane();
        form.setLayout(new GroupLayout(form));

        ImageIcon img = new ImageIcon(this.getClass().getResource("/user.png"));
        Image im= (img.getImage().getScaledInstance(img.getIconWidth(), img.getIconHeight(),Image.SCALE_SMOOTH));
        img = new ImageIcon(im);
        JLabel image= new JLabel();
        image.setIcon(img);
        image.setBounds(8,10,450,150);
        image.setBorder(new LineBorder(Color.gray, 2));
        LineBorder border = (LineBorder) image.getBorder();
        System.out.println("Border color = "+  border.getLineColor()
                + "  size= " + border.getThickness());
        JLabel INFO = new JLabel();

        INFO.setBounds(8, 150,450,300);
        INFO.setFont(Font.getFont("Arial"));
        INFO.setBorder(new LineBorder(Color.gray,2));

        JLabel Level= new JLabel("Educational level :");
        Level.setFont(Font.getFont("Arial"));
        Level.setBounds(8,230,200,40);
        JComboBox lev = new JComboBox(Education);
        lev.setBounds(120,240,200,30);
        lev.setFont(Font.getFont("Arial"));
        JLabel Exam_type = new JLabel("Examination Type");
        Exam_type.setFont(Font.getFont("Arial"));
        Exam_type.setBounds(8,280,200,30);

        Score.setBounds(120,320,200,30);
        Score.setFont(Font.getFont("Arial"));
        Score_Text.setBounds(8,320,200,30);
        Score_Text.setFont(Font.getFont("Arial"));

        GPA_Text.setBounds(8,360,200,30);
        GPA_Text.setFont(Font.getFont("Arial"));

        GPA.setBounds(120,360,200,30);
        GPA.setFont(Font.getFont("Arial"));
        scroll.setBounds(500,18,350,135);
        scroll.setFont(Font.getFont("Arial"));
        scroll.setBorder(new LineBorder(Color.gray,2));






        this.getContentPane().add(SAT);
        this.getContentPane().add(GRE);
        this.getContentPane().add(OTHER);
        this.getContentPane().add(scroll);

        Btn_group.add(SAT);
        Btn_group.add(GRE);
        Btn_group.add(OTHER);



        SAT.setFont(Font.getFont("Arial"));
        SAT.setSelected(true);
        SAT.setBounds(120,280,80,30);
        GRE.setFont(Font.getFont("Arial"));
        GRE.setBounds(230,280,60,30);
        OTHER.setFont(Font.getFont("Arial"));
        OTHER.setBounds(360,280,70,30);
        this.setVisible(true);









        firstName.setBounds(50,30,200,100);
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
        initialize();












        setVisible(true);



       }
       private void initialize ()
       {
           try
           {
               Scholar_list.read(new InputStreamReader(
                               getClass().getResourceAsStream("/data.txt")),
                       null);
           } catch (IOException e) {
               e.printStackTrace();
           }
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





}


