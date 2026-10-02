
package controllers;

//* @author Carlo Salas

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

 
public class notificacion {
    private JFrame miframe;
    private PopupMenu popup = new PopupMenu();
    private Image image =new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage() ;
    private final TrayIcon trayIcon = new TrayIcon(image, "Sistema - HashNetwork", popup);
    //para el Timer
    private Timer timer;    
    private boolean band;


public notificacion( JFrame frame)
 {
    this.miframe = frame;
    //comprueba si SystemTray es soportado en el sistema
    if (SystemTray.isSupported())
    {
      
      SystemTray systemtray = SystemTray.getSystemTray();
      
	MouseListener mouseListener = new MouseListener() {

        public void mouseClicked(MouseEvent evt) {            
            
            if( evt.getButton() == MouseEvent.BUTTON1 && miframe.getExtendedState()==JFrame.ICONIFIED )
                MensajeTrayIcon("'Sistema-HashNetwork '\n Haga click derecho para restaurar", MessageType.WARNING);
        }

        public void mouseEntered(MouseEvent evt) {}

        public void mouseExited(MouseEvent evt) {}

        public void mousePressed(MouseEvent evt) {}

        public void mouseReleased(MouseEvent evt) {}
    };

    
    ActionListener exitListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {            
            System.exit(0);
        }
    };
    
    ActionListener RestaurarListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {            
            miframe.setVisible(true);
            miframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
            miframe.repaint();
            band = true;
           
        }
    };
    
    MenuItem ItemRestaurar = new MenuItem("Restaurar");
    ItemRestaurar.addActionListener(RestaurarListener);
    popup.add(ItemRestaurar);
    trayIcon.setImageAutoSize(true);
    trayIcon.addMouseListener(mouseListener);

    MenuItem SalirItem = new MenuItem("Salir");
    SalirItem.addActionListener(exitListener);
    popup.add(SalirItem);
    //Añade el TrayIcon al SystemTray
    try {
        systemtray.add(trayIcon);
    } catch (AWTException e) {
        System.err.println( "Error:" + e.getMessage() );
    }
  } else {
     System.err.println( "Error: SystemTray no es soportado" );
  }

    miframe.addWindowListener(new WindowAdapter(){
        @Override
        public void windowIconified(WindowEvent e){
           miframe.setVisible(false);//Se oculta JFrame
           band = false;
           timer = new Timer();           
           timer.schedule(new MyTimerTask(),0, 190000 );//Se ejecuta cada 90 segundos
        }
    });

    }

    public void MensajeTrayIcon(String texto, MessageType tipo)
    {
        trayIcon.displayMessage("Sugerencia:", texto, tipo);
    }

    class MyTimerTask extends TimerTask {
        public void run() {
            if(band)
                timer.cancel();
            else 
                Mensaje();
        }
        public void Mensaje()
        {
            MensajeTrayIcon("'El sistema no se ha cerrado sigue en ejecución' \nhaga click derecho para restaurar" , MessageType.INFO);
        }

    }

}

