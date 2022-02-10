import java.io.*;
import java.awt.*;
import java.awt.event.*;

class studentfile extends Frame implements ActionListener {
    // Defining window components

    TextField number, name, marks;
    Button enter, done;
    Label numLabel, nameLabel, markLabel;

    DataOutputStream dos;
    // Initiazing the frame

    public studentfile() {
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
        enter = new Button("ENTER");
        done = new Button("DONE");
        enter.addActionListener(this);
        done.addActionListener(this);
        // Add the components of the frame
        add(numLabel);
        add(number);
        add(nameLabel);
        add(name);
        add(markLabel);
        add(marks);
        add(enter);
        add(done);
    }

    // setup the window
    public void setup() {

        // Show the frame
        show();

        // open the file
        try {
            dos = new DataOutputStream(new FileOutputStream("Student.dat"));
        } catch (IOException e) {
            System.err.println(e.toString());
            System.exit(1);
        }
    }

    // write to file
    public void addRecord() {
        int num;
        Double d;
        num = (new Integer(number.getText())).intValue();// dote here in command
        try {
            dos.writeInt(num);
            dos.writeUTF(name.getText());
            d = new Double(marks.getText());
            dos.writeDouble(d.doubleValue());
        } catch (IOException e) {
        }
        // clear the text fields
        number.setText("");
        name.setText("");
        marks.setText("");
    }
    // Adding the record and clearing the textfields

    public void cleanup() {
        if (!number.getText().equals("")) {
            addRecord();
        }
        try {
            dos.flush();
            dos.close();
        } catch (IOException e) {
        }
    }

// Processing the event
    // public boolean action(Event event, Object o) {
    // if (event.target instanceof Button) {
    // if (event.arg.equals("ENTER")){
    // addRecord();
    // return true;
    // }
    // }
    // return super.action(event, o);
    // }

    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
          if (str.equals("ENTER")) {
            addRecord();
          } else {
            cleanup();
            System.exit(0);
          }
        
    }

    // public void actionPerformed(ActionEvent e) {
    //     cleanup();
    // }

    /*
     * public boolean handleEvent(Event event) {
     * if (event.target instanceof Button) {
     * if (event.arg.equals("DONE")) {
     * cleanup();
     * System.exit(0);
     * return true;
     * }
     * }
     * return super.handleEvent(event);
     * }
     */

    // execute the program

    public static void main(String args[]) {
        studentfile student = new studentfile();
        student.setup();
    }
}
