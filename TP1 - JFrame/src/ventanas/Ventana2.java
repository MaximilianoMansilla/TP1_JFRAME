package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bancoUTN.Usuario;
import negocio.Negocio;

@SuppressWarnings("serial")
public class Ventana2 extends JFrame implements ActionListener {
	private JPanel panel;
	private JButton boton1 = new JButton("Ingresar");
	private JButton boton2 = new JButton("SALIR");
	private JTextField texto1 = new JTextField();
	private JTextField texto2 = new JTextField();
	private int cont=0;
	private Negocio neg;
	
	public Ventana2(Negocio n) {
		neg = n;
	}
	
	public void ingresoSistema() {
		this.setTitle("Ingreso al Sistema");
		setSize(500,200);
		setLocation(285,200);
		setMinimumSize(new Dimension(800,400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		this.agregarPaneles();
		this.agregarCajasDeTexto();
		this.agregarEtiquetas();
		this.agregarBotones();
		
	}
	
	private void agregarPaneles() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		this.getContentPane().add(panel);
	}
	
	private void agregarCajasDeTexto() throws NullPointerException {
		texto1.setBounds(270,100,250,30);
		texto1.setText("Nombre Usuario");
		panel.add(texto1);
		texto2.setBounds(270, 130, 250, 30);
		texto2.setText("Contraseña");
		panel.add(texto2);
	}
	
	private void agregarEtiquetas() {
		JLabel etiqueta = new JLabel("Ingreso al Sistema");
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta.setBounds(270,50,250,30);
		etiqueta.setFont(new Font ("futura",0,25));
		panel.add(etiqueta);
	}
	
	private void agregarBotones() {
		boton1.setBounds(270,170,250,30);//Establece posicion y tamaño del boton
		boton1.addActionListener(this);
		panel.add(boton1);
		boton2.setBounds(270,210,250,30);
		boton2.setBackground(Color.RED);
		boton2.setForeground(Color.BLACK);
		boton2.addActionListener(this);
		
		panel.add(boton2);

	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Usuario usu = new Usuario();
		Boolean esc;
		if(e.getSource()== boton1) {
			
			if(cont<2) {		
				usu = neg.buscaUsuario(texto1.getText());
				esc=false;
				if(usu!=null) {
					if(neg.validaPwd(texto2.getText(), usu)) {
						cont=0;
						Ventana3 v3 = new Ventana3(usu,neg);
						v3.mainMenu();
						v3.setVisible(true);
					}else {						
						esc=true;
					}
				}else {
					esc=true;
				}
				if(esc) {
					JOptionPane.showMessageDialog(null,"Usuario o contraseña inválidos. Le restan "+(2-cont)+ " intentos","",JOptionPane.ERROR_MESSAGE);
				}
				texto1.setText("Usuario");
				texto2.setText("Contraseña");
				cont++;
			}else {
				JOptionPane.showMessageDialog(null,"Ha excedido el límite de intentos. Pruebe nuevamente más tarde.","",JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
			
		}
		if(e.getSource()== boton2) {
			int op3;
			op3 = JOptionPane.showOptionDialog(null, "Seguro desea salir?", "Seleccione una opcion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, "no");
			if(op3==0) {
				System.exit(0);
				}
		}
		
	}

}//CLASE
