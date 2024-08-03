package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, fNameTextField, dobTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinCodeTextField;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;

    SignupOne() {

        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) +1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO."+ random);
        formno.setFont((new Font("Raleway",Font.BOLD,38)));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personalDetails = new JLabel("page 1:personal Details");
        personalDetails.setFont((new Font("Raleway",Font.BOLD,22)));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

         JLabel name = new JLabel("Name:");
         name.setFont((new Font("Raleway",Font.BOLD,20)));
         name.setBounds(100,140,100,30);
         add(name);

         nameTextField = new JTextField();
         nameTextField.setFont (new Font("Raleway", Font.BOLD,14));
         nameTextField.setBounds(300,140,400,30);
         add(nameTextField);

        JLabel fName = new JLabel("Father's Name:");
         fName.setFont((new Font("Raleway",Font.BOLD,20)));
         fName.setBounds(100,190,200,30);
         add(fName);

         fNameTextField = new JTextField();
         fNameTextField.setFont (new Font("Raleway", Font.BOLD,14));
         fNameTextField.setBounds(300,190,400,30);
         add(fNameTextField);

          JLabel dob = new JLabel("Date of Birth:");
          dob.setFont((new Font("Raleway",Font.BOLD,20)));
          dob.setBounds(100,240,200,30);
          add(dob);

           dateChooser = new JDateChooser();
           dateChooser.setBounds(300,240,400,30);
           dateChooser.setForeground(new Color(105,105,105));
           add(dateChooser);

          JLabel gender = new JLabel("Gender:");
          gender.setFont((new Font("Raleway",Font.BOLD,20)));
          gender.setBounds(100,290,200,30);
          add(gender);

           male = new JRadioButton("Male");
           male.setBounds(300,290,60,30);
           male.setBackground(Color.white);
           add(male);

           female = new JRadioButton("Female");
           female.setBounds(450,290,120,30);
           female.setBackground(Color.white);
           add(female);

           ButtonGroup genderGroup = new ButtonGroup();
           genderGroup.add(male);
           genderGroup.add(female);

          JLabel   email = new JLabel(" Email:");
          email.setFont((new Font("Raleway",Font.BOLD,20)));
          email.setBounds(100,340,200,30);
          add(email);

          emailTextField = new JTextField();
          emailTextField.setFont (new Font("Raleway", Font.BOLD,14));
          emailTextField.setBounds(300,340,400,30);
          add( emailTextField);

          JLabel marital = new JLabel("Marital Status:");
          marital.setFont((new Font("Raleway",Font.BOLD,20)));
          marital.setBounds(100,390,200,30);
          add(marital);

          married = new JRadioButton("Married");
          married.setBounds(300,390,100,30);
          married.setBackground(Color.white);
          add(married);

          unmarried = new JRadioButton("Unmarried");
          unmarried.setBounds(450,390,100,30);
          unmarried.setBackground(Color.white);
          add(unmarried);

          other = new JRadioButton("Other");
          other.setBounds(630,390,100,30);
          other.setBackground(Color.white);
          add(other);

          ButtonGroup maritalGroup = new ButtonGroup();
          maritalGroup.add(married);
          maritalGroup.add(unmarried);
          maritalGroup.add(other);

          JLabel address = new JLabel("Address:");
          address.setFont((new Font("Raleway",Font.BOLD,20)));
          address.setBounds(100,440,200,30);
          add( address);

          addressTextField = new JTextField();
          addressTextField.setFont (new Font("Raleway", Font.BOLD,14));
          addressTextField.setBounds(300,440,400,30);
          add( addressTextField);

          JLabel city = new JLabel(" City:");
          city.setFont((new Font("Raleway",Font.BOLD,20)));
          city.setBounds(100,490,200,30);
          add(city);

          cityTextField = new JTextField();
          cityTextField.setFont (new Font("Raleway", Font.BOLD,14));
          cityTextField.setBounds(300,490,400,30);
          add(cityTextField);

          JLabel state = new JLabel("State:");
          state.setFont((new Font("Raleway",Font.BOLD,20)));
          state.setBounds(100,540,200,30);
          add(state);

          stateTextField = new JTextField();
          stateTextField.setFont (new Font("Raleway", Font.BOLD,14));
          stateTextField.setBounds(300,540,400,30);
          add( stateTextField);

          JLabel pinCode = new JLabel("PinCode:");
          pinCode.setFont((new Font("Raleway",Font.BOLD,20)));
          pinCode.setBounds(100,590,200,30);
          add(pinCode);

          pinCodeTextField = new JTextField();
          pinCodeTextField.setBounds(300,590,400,30);
          add(pinCodeTextField);

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
        new SignupOne();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formNo = "" + random; // long
        String name = nameTextField.getText(); // setText
        String fName = fNameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "others";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pinCode = pinCodeTextField.getText();


        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('"+formNo+"','"+name+"', '"+fName+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pinCode+"', '"+state+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo("").setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
      }
    }

