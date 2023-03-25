package Controller;

import View.Frame;
import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.Timer;



public class Main {
    
    public SQLite sqlite;
    
    public static void main(String[] args) {
        new Main().init();
    }
    
    public void init(){
        // Initialize a driver object
        sqlite = new SQLite();

        // Initialize User Interface
        Frame frame = new Frame();
        frame.init(this);
      
        // Session management (2 minutes / 120000ms of inactivity)
        // Reference: www.java2s.com/Tutorials/Java/Swing_How_to/JFrame/Close_JFrame_after_user_inactivity.htm
        Timer timer = new Timer(120000, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            frame.logOut();
          }
        });
        
        Toolkit.getDefaultToolkit().addAWTEventListener(
            new AWTEventListener() {
                
              public void eventDispatched(AWTEvent event) {
                Object source = event.getSource();
                if (source instanceof Component) {
                  Component comp = (Component) source;
                  Window win = null;
                  if (comp instanceof Window) {
                    win = (Window) comp;
                  } else {
                    win = SwingUtilities.windowForComponent(comp);
                  }
                  if (win == frame) {
                    timer.restart();
                  }
                }
              }
            },
            AWTEvent.KEY_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK
                | AWTEvent.MOUSE_MOTION_EVENT_MASK
                | AWTEvent.MOUSE_WHEEL_EVENT_MASK);
     
        timer.start();
    }
 
    
   
}
