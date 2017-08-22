package formulariobd;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Sergio Cañas
 * @version 1.0
 */
public class Datos implements ActionListener{
    
    /** Es la ventana del programa*/
    JFrame ventana;
    
    /** Campos de texto que esperan los datos*/
    JTextField nombre, apellidoP, apellidoM, grupo;
    
    /** Indica el dato que requiere el campo de texto*/
    JLabel nom, app, apm, grup;
    
    /** Guarda los datos introducidos*/
    JButton guardar;
    
    /** Contiene a los elementos visuales*/
    Container cont;
    
    /** Realiza la conexión a base de datos*/
    BaseD baseD;
    
    /**
     * Constructor. Crea la ventana y añade los componentes
     */
    public Datos(){
        ventana = new JFrame("Formulario");
        ventana.setSize(400, 500);
        ventana.setLayout(null);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        
        cont = ventana.getContentPane();
        cont.setBackground(Color.white);
        
        Componentes();
        
        ventana.setVisible(true);
    }
    
    public void Componentes(){
        nom = new JLabel("Nombre: ");
        nom.setBounds(90, 100, 110, 20);
        cont.add(nom);
        
        nombre = new JTextField("");
        nombre.setBounds(200, 100, 100, 20);
        cont.add(nombre);
        
        app = new JLabel("Apellido Paterno: ");
        app.setBounds(90, 150, 110, 20);
        cont.add(app);
        
        apellidoP = new JTextField("");
        apellidoP.setBounds(200, 150, 100, 20);
        cont.add(apellidoP);
        
        apm = new JLabel("Apellido Materno: ");
        apm.setBounds(90, 200, 110, 20);
        cont.add(apm);
        
        apellidoM = new JTextField("");
        apellidoM.setBounds(200, 200, 100, 20);
        cont.add(apellidoM);
        
        grup = new JLabel("Grupo: ");
        grup.setBounds(90, 250, 110, 20);
        cont.add(grup);
        
        grupo = new JTextField("");
        grupo.setBounds(200, 250, 100, 20);
        cont.add(grupo);
        
        guardar = new JButton("Guardar");
        guardar.setBounds(150, 300, 100, 50);
        guardar.addActionListener(this);
        cont.add(guardar);
    }

    /**
     * Sobre escritura del método actionPerformed
     * 
     * @param e Recibe un evento
     */
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == guardar){
            baseD = new BaseD();
            try {
                baseD.Conectar();
                baseD.Agregar(nombre.getText(), apellidoP.getText(), apellidoM.getText(), grupo.getText());
                baseD.Cerrar();
                JOptionPane.showMessageDialog(null, "La información se guardó correctamente");
                nombre.setText("");
                apellidoP.setText("");
                apellidoM.setText("");
                grupo.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Hubo un error");
            }
        }
    }
}