import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class FormularioPadre{
	JFrame pantalla;
	JTextArea areaTexto;
	JTextField textoEnviar;
	JButton bEnviar;

	
	public void creaGui(){
		pantalla = new JFrame();
		pantalla.setSize(420, 420);
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantalla.setLayout(null);
		
		areaTexto = new JTextArea();
		areaTexto.setBounds(10, 10, 380, 300);
		
		textoEnviar = new JTextField();
		textoEnviar.setBounds(10, 320, 380,	20);
		
		bEnviar = new JButton("Enviar");
		bEnviar.setBounds(150, 360, 100, 20);
		bEnviar.addActionListener(new EnviarListener());
		
		pantalla.add(areaTexto);
		pantalla.add(textoEnviar);
		pantalla.add(bEnviar);
		pantalla.setVisible(true);
		
	}
	class EnviarListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			FormularioHijo ds = new FormularioHijo("Hola");
			textoEnviar.setText(ds.getTexto());
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FormularioPadre fp = new FormularioPadre();
		//fp.creaGui();
		
		javax.swing.SwingUtilities.invokeLater (
				new Runnable() {
					public void run() {
						FormularioPadre fp = new FormularioPadre();
						fp.creaGui();
					}
				}
		);

	}

}
