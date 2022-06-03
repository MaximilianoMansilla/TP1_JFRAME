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

import negocio.Negocio;

@SuppressWarnings("serial")
public class Ventana1 extends JFrame implements ActionListener{
	public JPanel panel;
	private JButton boton1 = new JButton("Aceptar");
	private JButton boton2 = new JButton("Finalizar Carga");
	private JTextField texto1 = new JTextField();
	private JTextField texto2 = new JTextField();
	private Negocio neg = new Negocio();
	int i=0;
	
	public void ventanaIngreso() {
		neg.limpiarArray();
		this.setTitle("Registro de Usuarios");
		setSize(500,200);
		setLocation(285,200);
		setMinimumSize(new Dimension(800,400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		this.agregarPaneles();
		this.agregarCajasDeTexto();
		this.agregarBotones();
		this.agregarEtiquetas();
		
	}
	
	private void agregarBotones() {
		boton1.setBounds(270,170,250,30);//Establece posicion y tamaño del boton
		boton1.addActionListener(this);
		boton2.setBounds(270, 210, 250, 30);
		boton2.setBackground(Color.RED);
		boton2.addActionListener(this);
		boton2.setForeground(Color.BLACK);

		panel.add(boton1);
		panel.add(boton2);
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
		JLabel etiqueta = new JLabel("Registro de Usuarios");
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta.setBounds(270,50,250,30);
		etiqueta.setFont(new Font ("futura",0,25));
		panel.add(etiqueta);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int op=0;
		if(e.getSource()== boton1) {
			if(i<10) {
				if(!(texto1.getText().length()>=8 && texto1.getText().length()<=20)) {
					JOptionPane.showMessageDialog(null,"El nombre debe tener minimo 8 caracteres y maximo 20","", JOptionPane.ERROR_MESSAGE);
				}else if (texto2.getText().length()!=8) {
					JOptionPane.showMessageDialog(null,"La contraseña debe tener 8 caracteres","", JOptionPane.ERROR_MESSAGE);
				}else {
					if(neg.registrarUsuarios(texto1.getText(), texto2.getText(), i)) {
						op = JOptionPane.showOptionDialog(null, "Usuario registrado exitosamente!\nDesea Registrar otro usuario?", "Seleccione una opcion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, "yes");
						if(op==1) {
							if(i<2) {
								JOptionPane.showMessageDialog(null, "Se deben registrar como mínimo 3 usuarios para poder usar el sistema. Lleva cargados "+ (i+1));
								op=0;
							}else {
								Ventana2 v2 = new Ventana2(neg);
								v2.ingresoSistema();
								v2.setVisible(true);
							}
						}
						i++;
					}else JOptionPane.showMessageDialog(null,"Nombre de usuario ya registrado. Intenete nuevamente","", JOptionPane.ERROR_MESSAGE);
					texto1.setText("Nombre de Usuario");
					texto2.setText("Contraseña");
				} 
			}else JOptionPane.showMessageDialog(null, "No se puede cargar más","Limite de usuarios", JOptionPane.ERROR_MESSAGE);// if 2
		}
		
		if(e.getSource()== boton2) {
			if(i>=2) {
				Ventana2 v2 = new Ventana2(neg);
				v2.ingresoSistema();
				v2.setVisible(true);
			}else JOptionPane.showMessageDialog(null,"Se deben cargar como minimo 3 usuarios para que funcione el sistema","", JOptionPane.ERROR_MESSAGE);
		}// if boton2
	}//metodo
		
	}//CLASE
