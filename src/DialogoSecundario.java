/*
 * Fichero: DialogoSecundario.java
 * Autor: Chuidiang
 * Fecha: 1/06/07 23:06
 */

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


/**
 * Ejemplo de como retrasar la creaci�n de un JDialog secundario hasta que se
 * pulse un bot�n y c�mo obtener el padre de este JDialog a partir del ActionEvent.
 *
 * @author Chuidiang
 */
public class DialogoSecundario
{
    /** 
     * JDialog secundario a desplegar. Se inicializa a null para crearlo
     * posteriormente, cuando se pulse el bot�n.
     */
    JDialog dialogo = null;

    /**
     * Crea un nuevo objeto DialogoSecundario.
     */
    public DialogoSecundario()
    {
    	// Creaci�n de la venana princpial con el bot�n.
        JFrame v = new JFrame("Prueba Dialogo Secundario");
        JButton b = new JButton("Pulsame");
        v.getContentPane().add(b);
        v.pack();
        v.setVisible(true);
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // ActionListener del bot�n.
        b.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                	// Si no est� construido ya el JDialog, se construye
                    if (dialogo == null)
                    {
                    	// Obtenemos la ventana que contiene al bot�n que se ha
                    	// pulsado.
                    	// e.getSource() nos devuelve ese bot�n.
                    	// SwingUtilities.getWindowAncestor() nos devuelve la ventana
                    	// que contiene ese bot�n, es decir, en este caso el
                    	// JFrame principal.
                        Window ventanaPadre = SwingUtilities.getWindowAncestor(
                                (Component) e.getSource());

                        // Codigo general para crear el JDialog en funci�n del
                        // tipo de ventana padre.
                        if (ventanaPadre instanceof Frame)
                        {
                        	dialogo = new JDialog((Frame) ventanaPadre);
                        }
                        else if (ventanaPadre instanceof Dialog)
                        {
                        	dialogo = new JDialog((Dialog) ventanaPadre);
                        }
                        else
                        {
                        	dialogo = new JDialog();
                        }

                        // Resto de la construcci�n del JDialog.
                        dialogo.setTitle("Dialogo Secundario");
                        dialogo.setSize(400, 400);
                        dialogo.setLayout(null);                        
                        JTextField tf = new JTextField();
                        tf.setBounds(10, 50, 300, 30);
                        JButton c= new JButton("Pulzame");
                        c.setBounds(10, 10, 100, 30);
                        dialogo.getContentPane().add(c);
                        dialogo.getContentPane().add(tf);
                        //dialogo.pack();
                    }

                    // Se hace visible el JDialog.
                    dialogo.setVisible(true);
                }
            });
    }

    /**
     * Metodo principal.
     *
     * @param args Se ignora.
     */
    public static void main(String[] args)
    {
        new DialogoSecundario();
    }
}