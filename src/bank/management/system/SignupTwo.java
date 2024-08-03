package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignupTwo extends JFrame implements ActionListener {
    JTextField  pan,aadhar;
    JButton next;
    JRadioButton  syes,sno,eyes,eno;
    JComboBox religion, category, income, education, occupation;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");


        JLabel additionalDetails = new JLabel("page 2: Additional Details");
        additionalDetails.setFont((new Font("Raleway",Font.BOLD,22)));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel Religion = new JLabel("Religion:");
        Religion.setFont((new Font("Raleway",Font.BOLD,20)));
        Religion.setBounds(100,140,100,30);
        add(Religion);

        String valreligion[] = {"Hindu", "Muslim", "Sikh", "Christian","Other"};
        religion = new JComboBox(valreligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.white);
        add(religion);

        JLabel Category = new JLabel("Category:");
        Category.setFont((new Font("Raleway",Font.BOLD,20)));
        Category.setBounds(100,190,200,30);
        add(Category);

        String valcategory[] = {"General","OBC", "SC", "ST","other"};
        category = new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel Income  = new JLabel("Income:");
        Income.setFont((new Font("Raleway",Font.BOLD,20)));
        Income.setBounds(100,240,200,30);
        add(Income);

        String incomecategory[] = {"Null","< 1,50,000", "< 2,50,000", "< 5,00,000","upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel Education = new JLabel("Educational");
        Education.setFont((new Font("Raleway",Font.BOLD,20)));
        Education.setBounds(100,290,200,30);
        add(Education);

        JLabel Qualification = new JLabel(" Qualification:");
        Qualification.setFont((new Font("Raleway",Font.BOLD,20)));
        Qualification.setBounds(100,315,200,30);
        add(Qualification);

        String educationValues[] = {"Non Graduate","Graduate", "Post Graduate", "Doctorate","Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel Occupation = new JLabel("Occupation:");
        Occupation.setFont((new Font("Raleway",Font.BOLD,20)));
        Occupation.setBounds(100,390,200,30);
        add(Occupation);

        String occupationValues[] = {"Salaried","Self Employed", "Business", "Student","Retired","others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);



        JLabel Pan = new JLabel("PAN Number:");
        Pan.setFont((new Font("Raleway",Font.BOLD,20)));
        Pan.setBounds(100,440,200,30);
        add(Pan);

        pan = new JTextField();
        pan.setFont (new Font("Raleway", Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);

        JLabel Aadhar = new JLabel(" Aadhar Number:");
        Aadhar.setFont((new Font("Raleway",Font.BOLD,20)));
        Aadhar.setBounds(100,490,200,30);
        add(Aadhar);

        aadhar = new JTextField();
        aadhar.setFont (new Font("Raleway", Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);

        JLabel seniorcitizen = new JLabel("Senior Citizen:");
        seniorcitizen.setFont((new Font("Raleway",Font.BOLD,20)));
        seniorcitizen.setBounds(100,540,200,30);
        add(seniorcitizen);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.white);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup seniorcitizenGroup = new ButtonGroup();
        seniorcitizenGroup.add(syes);
        seniorcitizenGroup.add(sno);

        JLabel existingaccount = new JLabel("Existing Account:");
        existingaccount.setFont((new Font("Raleway",Font.BOLD,20)));
        existingaccount.setBounds(100,590,200,30);
        add(existingaccount);

        eyes = new JRadioButton("yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.white);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup existingaccountGroup = new ButtonGroup();
        existingaccountGroup.add(eyes);
        existingaccountGroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SignupTwo("");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String sreligion =  (String) religion.getSelectedItem(); // setText
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }
        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        }

        String span = pan.getText();
        String saadhar = aadhar.getText();

        try {
                Conn c = new Conn();
                String query = "insert into SignupTwo values ('"+formno+"','"+sreligion+"','"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"', '"+ existingaccount+"')";
                c.s.executeUpdate(query);

                //signup3 object
            setVisible(false);
            new SignupThree("formno").setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
