import java.io.*;
import java.awt.*;
import java.awt.event.*;

class employefile extends Frame implements ActionListener {
    // Defining window components

    TextField eid, name, address, basicsalary, payment;
    Button exit, add;
    Label eidLabel, nameLabel, addressLabel, basicLabel, paymentLabel;

    DataOutputStream dos;
    // Initiazing the frame

    public employefile() {
        super("Employee Record");
    }

    // setup the window
    public void setup() {
        resize(400, 200);
        setLayout(new GridLayout(7, 2));

        // create the component of the frame

        eid = new TextField(25);
        eidLabel = new Label("Employe ID");
        name = new TextField(25);
        nameLabel = new Label("NAME");
        address = new TextField(25);
        addressLabel = new Label("ADDRESS");
        basicsalary = new TextField(25);
        basicLabel = new Label("BASIC SALARY");
        payment = new TextField(25);
        paymentLabel = new Label("PAYMENT");
        exit = new Button("EXIT");
        add = new Button("ADD");
        add.addActionListener(this);
        exit.addActionListener(this);

        // Add the components of the frame
        add(eidLabel);
        add(eid);
        add(nameLabel);
        add(name);
        add(addressLabel);
        add(address);
        add(basicLabel);
        add(basicsalary);
        add(paymentLabel);
        add(payment);
        add(exit);
        add(add);

        // Show the frame
        show();

        // open the file
        try {
            dos = new DataOutputStream(new FileOutputStream("emp.dat"));
        } catch (IOException e) {
            System.err.println(e.toString());
            System.exit(1);
        }
    }

    // write to file
    public void addRecord() {
        int eid1;
        Double ab, pa;
        eid1 = (new Integer(eid.getText())).intValue();// dote here in command
        try {
            dos.writeInt(eid1);
            dos.writeUTF(name.getText());
            dos.writeUTF(address.getText());
            ab = new Double(basicsalary.getText());
            pa = new Double(payment.getText());
            dos.writeDouble(ab.doubleValue());
            dos.writeDouble(pa.doubleValue());
        } catch (IOException e) {
        }
        // clear the text fields
        eid.setText("");
        name.setText("");
        address.setText("");
        basicsalary.setText("");
        payment.setText("");
    }
    // Adding the record and clearing the textfields

    public void cleanup() {
        if (!eid.getText().equals("")) {
            addRecord();
        }
        try {
            dos.flush();
            dos.close();
        } catch (IOException e) {
        }
    }

    // Processing the event

    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("ADD")) {
            addRecord();
        } else {
            cleanup();
            System.exit(0);
        }

    }

    public static void main(String args[]) {
        employefile emply = new employefile();
        emply.setup();
    }
}
