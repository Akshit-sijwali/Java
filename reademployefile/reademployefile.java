
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class reademployfile extends Frame implements ActionListener {
    // Defining window components

    TextField eid, name, address, basicsalary, payment;
    Button next,done;
    Label eidLabel, nameLabel, addressLabel, basicLabel, paymentLabel;

    boolean moreRecord = true;
    DataInputStream dis;
    // Initiazing the frame

    public reademployfile() {
        super("Create student file");
        resize(400, 200);
        setLayout(new GridLayout(6, 2));

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
        next = new Button("NEXT");
        done = new Button("DONE");
        next.addActionListener(this);
        done.addActionListener(this);

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
        add(next);
        add(done);
    }

    // setup the window
    public void setup() {

        // Show the frame
        show();

        // open the file
        try {
            dis = new DataInputStream(new FileInputStream("emp.dat"));
        } catch (IOException e) {
            System.err.println(e.toString());
            System.exit(0);
        }
    }

    // Read from the file
    public void readRecord() {
        int eid1;
        String s,ad;
        double ab, pa;
        try {
            eid1 = dis.readInt();
            s = dis.readUTF();
            ad = dis.readUTF();
            ab = dis.readDouble();
            pa = dis.readDouble();
            eid.setText(String.valueOf(eid1));
            name.setText(String.valueOf(s));
            address.setText(String.valueOf(ad));
            basicsalary.setText(String.valueOf(ab));
            payment.setText(String.valueOf(pa));
        } catch (EOFException e) {
            moreRecord = false;
        } catch (IOException ioe) {
            System.out.println("IOError");
            System.exit(1);
        }
    }

    // closing the input file
    public void cleanup() {
        try {
            dis.close();
        } catch (IOException e) {
        }
    }

    // processing the Event
    public void actionPerformed(ActionEvent ae){
        String str = ae.getActionCommand();
        if (str.equals("NEXT")) {

            readRecord();
            
        } else if (str.equals("DONE") || moreRecord == false) {
            cleanup();
            System.exit(0);
        }
    }

    // Executing the program
    public static void main(String args[]) {
        reademployfile employee  = new reademployfile();
        employee.setup();
    }

}