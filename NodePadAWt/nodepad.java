import java.awt.*;
import java.awt.event.*;

class setup extends Frame{
    setup(){

        super("NodePad");

        MenuBar menuBar =  new MenuBar();
        
        Menu File = new Menu("File");
        Menu Edit = new Menu("Edit");
        Menu Format = new Menu("Format");
        Menu View = new Menu("View");
        Menu Help = new Menu("Help");

        // file menuItem
        MenuItem New = new MenuItem("New");
        MenuItem Open = new MenuItem("Open");
        MenuItem Save = new MenuItem("Save");
        MenuItem Save_as = new MenuItem("Save as");
        MenuItem Exit = new MenuItem("Exit");

        File.add(New);
        File.add(Open);
        File.add(Save);
        File.add(Save_as);
        File.add(Exit);
        

        // Edit menuItem
        MenuItem Cut = new MenuItem("Cut");
        MenuItem Copy = new MenuItem("Copy");
        MenuItem Paste = new MenuItem("Paste");
        MenuItem Find = new MenuItem("Find");
        MenuItem Delete = new MenuItem("Delete");

        Edit.add(Cut);
        Edit.add(Copy);
        Edit.add(Paste);
        Edit.add(Find);
        Edit.add(Delete);
               
        
        // Format MenuItems
        MenuItem Word_wrap =  new MenuItem("Word Wrap");
        MenuItem Font =  new MenuItem("Font");
        
        Format.add(Word_wrap);
        Format.add(Font);

        // View MenuItem
        MenuItem zoom = new MenuItem("Zoom");
        MenuItem status_bar = new MenuItem("Status Bar");

        View.add(zoom);
        View.add(status_bar);


        // Help MenuItem
        MenuItem AboutNodepad = new MenuItem("About Nodepad");
        MenuItem Sendfeedback = new MenuItem("Send feedback");

        Help.add(AboutNodepad);
        Help.add(Sendfeedback);
        
        // Adding Menu in MenuBar
        menuBar.add(File);
        menuBar.add(Edit);
        menuBar.add(Format);
        menuBar.add(View);
        menuBar.add(Help);

        // Adding TextArea
        TextArea ta = new TextArea("Hello");
        ta.setBounds(5, 50, 800, 400);
        add(ta);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(-1);
            }
        });


        setMenuBar(menuBar);
        setSize(800,500);
        setLayout(null);
        setVisible(true);

    }
}

class nodepad{
    public static void main(String[] args) {
        setup s = new setup();
    }
}