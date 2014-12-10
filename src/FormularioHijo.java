import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class FormularioHijo {
	JDialog pantalla;
	JTextArea areaTexto;
	JTextField textoEnviar;
	JButton bSalir;

	
	FormularioHijo(String s){
		pantalla = new JDialog();
		pantalla.setModal(true);
		pantalla.setSize(200, 200);
		pantalla.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		pantalla.setLayout(null);
		
		areaTexto = new JTextArea();
		areaTexto.setBounds(10, 10, 140, 100);
		
		textoEnviar = new JTextField();
		textoEnviar.setBounds(10, 120, 180,	20);
		textoEnviar.setText(s);
		
		bSalir = new JButton("Salir");
		bSalir.setBounds(50, 140, 100, 20);
		bSalir.addActionListener(new EnviarListener());
		
		pantalla.add(areaTexto);
		pantalla.add(textoEnviar);
		pantalla.add(bSalir);
		pantalla.setVisible(true);
		
	}
	
	public String getTexto(){
		return textoEnviar.getText();
	}
	
	class EnviarListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			pantalla.dispose();
		}
		
	}
}
