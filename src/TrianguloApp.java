import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrianguloApp extends JFrame implements ActionListener {
    private JLabel ladoLabel, perimetroLabel, alturaLabel, areaLabel;
    private JTextField ladoField;
    private JButton calcularButton;

    public TrianguloApp() {
        // Configurar la ventana
        setTitle("Calculadora de Triángulo Equilátero");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Componentes de la interfaz
        ladoLabel = new JLabel("Lado del Triángulo:");
        ladoField = new JTextField(10);
        calcularButton = new JButton("Calcular");
        perimetroLabel = new JLabel("Perímetro:");
        alturaLabel = new JLabel("Altura:");
        areaLabel = new JLabel("Área:");

        // Agregar componentes a la ventana
        add(ladoLabel);
        add(ladoField);
        add(calcularButton);
        add(perimetroLabel);
        add(alturaLabel);
        add(areaLabel);

        // Manejar el evento del botón Calcular
        calcularButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            // Obtener el valor del lado ingresado por el usuario
            double lado = Double.parseDouble(ladoField.getText());

            // Calcular el perímetro, la altura y el área
            double perimetro = 3 * lado;
            double altura = (lado / 2) * Math.sqrt(3);
            double area = (lado * altura) / 2;

            // Mostrar los resultados en las etiquetas
            perimetroLabel.setText("Perímetro: " + perimetro);
            alturaLabel.setText("Altura: " + altura);
            areaLabel.setText("Área: " + area);
        } catch (NumberFormatException ex) {
            perimetroLabel.setText("Error: Ingresa un valor numérico válido.");
            alturaLabel.setText("");
            areaLabel.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TrianguloApp app = new TrianguloApp();
            app.setVisible(true);
        });
    }
}

