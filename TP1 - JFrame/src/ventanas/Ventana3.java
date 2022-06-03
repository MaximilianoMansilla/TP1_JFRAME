package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


import bancoUTN.Usuario;
import negocio.Negocio;


@SuppressWarnings("serial")
public class Ventana3 extends JFrame implements ActionListener{
	private Usuario usu;
	private Negocio neg;
	private JPanel panel;
	private JRadioButton rBoton1;
	private JRadioButton rBoton2;
	//private JTextField texto1;
	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	private JButton boton4;
	private JButton boton5;
	private JButton boton8;
	private JTextArea area1;
	private JScrollPane roll;
	private Boolean esc;
	private int op=0;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Ventana3(Usuario u, Negocio n) {
		usu=u;
		neg=n;
	}
	
	public void mainMenu() {
		this.setTitle("Ingreso al Sistema");
		setSize(500,200);
		setLocation(285,200);
		setMinimumSize(new Dimension(800,400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		iniciarComponentes();
	}
	
	
	private void iniciarComponentes() {
		this.agregarPaneles();
		this.agregarRadioBotones();
		this.agregarEtiquetas();
		this.agregarAreaTexto();
		this.agregarBotones();
	}
	
	private void agregarPaneles() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		this.getContentPane().add(panel);
	}
	private void agregarRadioBotones() {
		rBoton1 = new JRadioButton("Caja de Ahorro");
		rBoton1.setBackground(Color.LIGHT_GRAY);
		rBoton1.setBounds(40, 70, 150, 20);
		rBoton1.addActionListener(this);
		panel.add(rBoton1);
		
		rBoton2 = new JRadioButton("Cuenta Corriente");
		rBoton2.setBounds(40,100,150,20);
		rBoton2.setBackground(Color.LIGHT_GRAY);
		rBoton2.addActionListener(this);
		panel.add(rBoton2);
		
		ButtonGroup grupoRBotones = new ButtonGroup();
		grupoRBotones.add(rBoton1);
		grupoRBotones.add(rBoton2);
	}
	
	private void agregarEtiquetas() {
		JLabel etiqueta = new JLabel("Tipo de Cuenta");
		etiqueta.setHorizontalAlignment(SwingConstants.LEFT);
		etiqueta.setBounds(20,30,300,30);
		etiqueta.setFont(new Font ("futura",2,20));
		panel.add(etiqueta);
		
		JLabel etiqueta2 = new JLabel ("Seleccione la operación");
		etiqueta2.setHorizontalAlignment(SwingConstants.LEFT);
		etiqueta2.setBounds(20,130,300,30);
		etiqueta2.setFont(new Font ("futura",2,20));
		panel.add(etiqueta2);
		
		JLabel etiqueta3 = new JLabel ("Menú de cuentas");
		etiqueta3.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta3.setOpaque(true);
		etiqueta3.setBackground(Color.ORANGE);
		etiqueta3.setForeground(Color.BLACK);
		etiqueta3.setBounds(0,0,784,30);
		etiqueta3.setFont(new Font ("futura",3,15));
		panel.add(etiqueta3);
	}

	private void agregarAreaTexto() {
		area1 = new JTextArea();
		area1.setBounds(350,95,400,200);
		roll = new JScrollPane(area1);
		area1.setEditable(false);
		panel.add(area1);
		panel.add(roll);
	}
	
	private void agregarBotones() {
		boton1 = new JButton("Consulta");
		boton2 = new JButton("Transferencia");
		boton3 = new JButton("Extracción");
		boton4 = new JButton("Depósitos");
		boton5 = new JButton("SALIR");
		boton8 = new JButton ("Clear");
		
		boton1.setBounds(40,170,150,30);
		boton2.setBounds(40,210,150,30);
		boton3.setBounds(40,250,150,30);
		boton4.setBounds(40,290,150,30);
		boton5.setBounds(40,330,70,30);
		boton8.setBounds(120, 330, 70, 30);
		boton5.setBackground(Color.RED);
		boton5.setForeground(Color.BLACK);
		boton8.setBackground(Color.DARK_GRAY);
		boton8.setForeground(Color.BLACK);
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		boton3.addActionListener(this);
		boton4.addActionListener(this);
		boton5.addActionListener(this);
		boton8.addActionListener(this);
		panel.add(boton1);
		panel.add(boton2);
		panel.add(boton3);
		panel.add(boton4);
		panel.add(boton5);
		panel.add(boton8);
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== boton5) {
			int op3;
			op3 = JOptionPane.showOptionDialog(null, "Seguro desea salir?", "Seleccione una opcion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, "no");
			if(op3==0) {
				Ventana2 v2 = new Ventana2(neg);
				v2.ingresoSistema();
				v2.setVisible(true);
				}
		}
		if(e.getSource()== boton1) {
			if(op==0)JOptionPane.showMessageDialog(null, "Seleccione primero un Tipo de Cuenta!","",JOptionPane.INFORMATION_MESSAGE);
			else if(op==1) {
				area1.append("Saldo disponbible en Cuenata Corriente al: "+LocalDateTime.now().format(formatter)+" \n$"+ usu.getCtaCte().getSaldo()+"\n");
			}else if(op==2) {
				area1.append("Saldo disponible en Caja de Ahorro al: "+ LocalDateTime.now().format(formatter)+" \n$"+usu.getCajaAhorro().getSaldo()+"\n");
			}
		}
		if(e.getSource()== boton2) {
			int op2=0;
			Double saldo=0.0;

			op2 = JOptionPane.showOptionDialog(null, "Cuenta Corriente a Caja Ahorro (cc-ca)?\n Caja Ahorro a Cuenta Corriente (ca-cc)?", "Seleccione una opcion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"ca-cc","cc-ca"}, "ca-cc");
			if(op2==0) {
				if(usu.getCajaAhorro().getSaldo()==0) {
					JOptionPane.showMessageDialog(null, "No posee saldo en Caja de Ahorro para transferir.","",JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Saldo disponible para transferir: "+ usu.getCajaAhorro().getSaldo());
					do {
						esc=false;
						try {
							saldo = Double.parseDouble(JOptionPane.showInputDialog("ingrese el monto a transferir"));
							if(saldo > usu.getCajaAhorro().getSaldo()) JOptionPane.showMessageDialog(null, "El monto ingresado excede al disponible en la cuenta");
						}catch(NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Error de formato", "Error", JOptionPane.ERROR_MESSAGE);
							esc=true;
						}
					}while(esc || saldo > usu.getCajaAhorro().getSaldo());
					neg.transferencia(usu, saldo,0);
					JOptionPane.showMessageDialog(null, "Transferencia Exitosa!","",JOptionPane.INFORMATION_MESSAGE);

				}
			}else {
				if(usu.getCtaCte().getSaldo()==0) {
					JOptionPane.showMessageDialog(null, "No posee saldo en Cuenta Corriente para transferir.","",JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Saldo disponible para transferir: "+ usu.getCtaCte().getSaldo());
					do {
						esc=false;
						try {
							saldo = Double.parseDouble(JOptionPane.showInputDialog("ingrese el monto a transferir"));
							if(saldo > usu.getCtaCte().getSaldo()) JOptionPane.showMessageDialog(null, "El monto ingresado excede al disponible en la cuenta");
						}catch(NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Error de formato", "Error", JOptionPane.ERROR_MESSAGE);
							esc=true;
						}
					}while(esc || saldo > usu.getCtaCte().getSaldo());
					neg.transferencia(usu, saldo,1);
					JOptionPane.showMessageDialog(null, "Transferencia Exitosa!","",JOptionPane.INFORMATION_MESSAGE);

				}
			}

		}//BOTON2
		if (e.getSource()== boton3) {
			Double saldoUsu=0.0,saldo=0.0;
			if(op==0) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar la cuenta de la cual va a extraer dinero.","",JOptionPane.ERROR_MESSAGE);
			}else if(op==1){
				saldoUsu=usu.getCtaCte().getSaldo();
				do {
					esc=false;
					try {
						saldo=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a extraer"));
						if (saldo>saldoUsu)JOptionPane.showMessageDialog(null,"No puede retirar esa suma");
					}catch(NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Error de formato", "Error", JOptionPane.ERROR_MESSAGE);
						esc=true;
					}
				}while(saldo>saldoUsu || esc);
				usu.getCtaCte().setSaldo(saldoUsu-saldo);
			}else {
				saldoUsu=usu.getCajaAhorro().getSaldo();
				do {
					esc=false;
					try {
						saldo=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a extraer"));
						if (saldo>saldoUsu)JOptionPane.showMessageDialog(null,"No puede retirar esa suma");
					}catch(NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Error de formato", "Error", JOptionPane.ERROR_MESSAGE);
						esc=true;
					}
				}while(saldo>saldoUsu || esc);
				usu.getCajaAhorro().setSaldo(saldoUsu-saldo);
			}

		}//BOTON3
		if(e.getSource() == boton4) {
			Double saldo=0.0;
			if(op==0) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar la cuenta en la que va a depositar dinero.","",JOptionPane.ERROR_MESSAGE);
			}else  {
				do {
					esc=false;
					try {
						saldo=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a depositar"));
					}catch(NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Error de formato", "Error", JOptionPane.ERROR_MESSAGE);
						esc=true;
					}
				}while(esc);
				if(op==1)usu.getCtaCte().setSaldo(saldo + usu.getCtaCte().getSaldo());
				else usu.getCajaAhorro().setSaldo(saldo + usu.getCajaAhorro().getSaldo());
			} 
				
			
		}
		if (e.getSource()== rBoton1) {
			op=2;
		}
		if(e.getSource()== rBoton2) {
			op=1;
		}
		if(e.getSource()== boton8) {
			area1.setText("");
		}
	
	}

}
