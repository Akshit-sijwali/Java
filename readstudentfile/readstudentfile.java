
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class readstudentfile extends Frame implements ActionListener {
    // Defining window components

    TextField number, name, marks;
    Button next, done;
    Label numLabel, nameLabel, markLabel;

    boolean moreRecord = true;
    DataInputStream dis;
    // Initiazing the frame

    public readstudentfile() {
        super("Create student file");
        resize(400, 200);
        setLayout(new GridLayout(4, 2));

        // create the component of the frame

        number = new TextField(25);
        numLabel = new Label("Roll Number");
        name = new TextField(25);
        nameLabel = new Label("Student Name");
        marks = new TextField(25);
        markLabel = new Label("Marks");
        next = new Button("NEXT");
        done = new Button("DONE");
        next.addActionListener(this);
        done.addActionListener(this);
        // Add the components of the frame
        add(numLabel);
        add(number);
        add(nameLabel);
        add(name);
        add(markLabel);
        add(marks);
        add(next);
        add(done);
    }

    // setup the window
    public void setup() {

        // Show the frame
        show();

        // open the file
        try {
            dis = new DataInputStream(new FileInputStream("Student.dat"));
        } catch (IOException e) {
            System.err.println(e.toString());
            System.exit(1);
        }
    }

    // Read from the file
    public void readRecord() {
        int n;
        String s;
        double d;
        try {
            n = dis.readInt();
            s = dis.readUTF();
            d = dis.readDouble();
            number.setText(String.valueOf(n));
            name.setText(String.valueOf(s));
            marks.setText(String.valueOf(d));
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
        readstudentfile student  = new readstudentfile();
        student.setup();
    }

}