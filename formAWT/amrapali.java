import java.awt.*;
import java.awt.event.*;

class form extends Frame{

    form()
    {   
        TextField firstname = new TextField(20);
        TextField lastname = new TextField(20);
        TextField email = new TextField(20);
        TextField phone_number = new TextField(20);

        Label label_title = new Label("Registration Details");
        Label label_firstname = new Label("First Name");
        Label label_lastname = new Label("Last Name");
        Label label_lemail = new Label("Email");
        Label label_lphone = new Label("Phone");

        Button Submit = new Button("Submit");

        setBackground(Color.white);

        label_title.setForeground(Color.GREEN);
        label_title.setFont(new Font("serif", Font.BOLD, 50));
        label_firstname.setForeground(Color.BLACK);
        label_firstname.setFont(new Font("serif", Font.ITALIC, 20));
        label_lastname.setForeground(Color.BLACK);
        label_lastname.setFont(new Font("serif", Font.ITALIC, 20));
        label_lemail.setForeground(Color.BLACK);
        label_lemail.setFont(new Font("serif", Font.ITALIC, 20));
        label_lphone.setForeground(Color.BLACK);
        label_lphone.setFont(new Font("serif", Font.ITALIC, 20));

        label_title.setBounds(100, 0, 1000, 100);
        label_firstname.setBounds(200, 140, 100, 20);
        firstname.setBounds(200, 165, 100, 30);
        label_lastname.setBounds(200, 205, 100, 20);
        lastname.setBounds(200, 225, 100, 30);
        label_lemail.setBounds(200, 265, 60, 20);
        email.setBounds(200, 285, 100, 30);
        label_lphone.setBounds(200, 325, 60, 20);
        phone_number.setBounds(200, 345, 100, 30);
        Submit.setBounds(200, 485, 80, 40);

        CheckboxGroup cbg = new CheckboxGroup();
        Checkbox male = new Checkbox("Male",cbg,false);
        Checkbox female = new Checkbox("Female",cbg,false);

        Label Gender = new Label("SELECT GENDER");
        Gender.setBounds(200, 385, 1000, 20);
        male.setBounds(200, 415, 60, 20);
        female.setBounds(290, 415, 60, 20);

        // Event handling
        Submit.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                String getfirstname = firstname.getText();
                String getlastname = lastname.getText();
                String getemail = email.getText();
                String getphone_number = phone_number.getText();
                
                String getname = getfirstname+" "+getlastname;
                
                show s=new show();
                s.showresult(true,getname,getphone_number,getemail);
                setVisible(false);
            
            }
        });

        

        // window closing
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                // dispose();
                System.exit(-1);
            }
        });
        
        add(label_title);
        add(label_firstname);
        add(firstname);
        add(label_lastname);
        add(lastname);
        add(label_lemail);
        add(email);
        add(label_lphone);
        add(phone_number);
        add(Gender);
        add(male);
        add(female);
        add(Submit);

        resize(600,600);
        // setVisible(true);
        setLayout(null);
        show();

    }

}

class show extends Frame{
    void showresult(boolean value,String getname,String getphone,String getemail){
        
        Label lname = new Label("Name :- ");
        Label lemail = new Label("Email :- ");
        Label lphone = new Label("Phone :- ");

        Label name = new Label(getname);
        Label email = new Label(getemail);
        Label phone = new Label(getphone);

        lname.setBounds(20, 30,100, 100);
        name.setBounds(130, 30,1000, 100);
        lemail.setBounds(20, 130, 100, 100);
        email.setBounds(130, 130, 1000, 100);
        lphone.setBounds(20, 230, 100, 100);
        phone.setBounds(130, 230, 1000, 100);

        lname.setForeground(Color.BLACK);
        lname.setFont(new Font("serif", Font.BOLD, 20));
        name.setForeground(Color.GREEN);
        name.setFont(new Font("serif", Font.BOLD, 20));
        lemail.setForeground(Color.BLACK);
        lemail.setFont(new Font("serif", Font.BOLD, 20));
        email.setForeground(Color.GREEN);
        email.setFont(new Font("serif", Font.BOLD, 20));
        lphone.setForeground(Color.BLACK);
        lphone.setFont(new Font("serif", Font.BOLD, 20));
        phone.setForeground(Color.GREEN);
        phone.setFont(new Font("serif", Font.BOLD, 20));

        add(lname);
        add(name);
        add(lemail);
        add(email);
        add(lphone);
        add(phone);
        
        setLayout(null);
        resize(600,600);
        setVisible(value);
    }
}



class amrapali{
    public static void main(String[] args) {
        form f = new form();
    }
}