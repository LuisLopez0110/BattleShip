import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame {
    private int rows = 10; // Eje X 
    private int cols = 10; // Eje y

    // Matriz de paneles
    private JPanel[][] matrixPanels = new JPanel[rows][cols];

    // Matriz de botones
    private JButton[][] matrixButtons = new JButton[rows][cols];

    private int clickedRow = 0;
    private int clickedCol = 0;

    // Constructor del frame
    MyFrame() {

        ImageIcon imagenLogo  = new ImageIcon("LOGO.png"); // Creamos la instancia del Icon del logo
        ImageIcon imagenRadar = new ImageIcon("RADAR.png");

        JLabel labelLogo = new JLabel(); // Creamos un label que almacenara el logo
        labelLogo.setIcon(imagenLogo); // Asignamos el Icon del logo al label

        JLabel labelRadar = new JLabel();
        labelRadar.setIcon(imagenRadar);

        JPanel panelLogo = new JPanel(); // Creamos un panel que almacenara el label que a su vez contiene el logo
        /*El label es un objeto que puede contener una palabra o una imagen, esta la ponemos dentro de un panel para poder manejarlo en el frame*/
        panelLogo.setBackground(new Color(103, 99, 98)); // Le asignamos un fondo
        panelLogo.setBounds(250, 0, 500, 200); // Le asignamos un tamano y posicion
        panelLogo.add(labelLogo); // Anadimos el label al panel

        JPanel panelShips = new JPanel(); // Creamos un panel que almacenara la matriz de paneles
        panelShips.setBackground(Color.red); // Le asignamos un fondo
        panelShips.setBounds(0, 200, 500, 500); // Le asignamos un tamano y posicion
        panelShips.setLayout(new GridLayout(rows, cols)); // Le damos el layout de un grid 

        JPanel panelButtons = new JPanel();
        panelButtons.setBackground(Color.green);
        panelButtons.setBounds(500, 200, 500, 500);
        panelButtons.setLayout(new GridLayout(rows, cols));

        // Codigo para hacer el grid de paneles para nuestros barcos
        int xPosition = 0; // Posicion en x
        int yPosition = 0; // Posicion en y

        //Ciclo para hacer los paneles
        for (int i = 0; i < rows; i++) {
            xPosition = 0;
            for (int j = 0; j < cols; j++) {
                matrixPanels[i][j] = new JPanel(); // Hacemos un panel
                matrixPanels[i][j].setBounds(xPosition, yPosition, 50, 50); // Le asignamos un tamano y posicion
                matrixPanels[i][j].setBackground(new Color(10, 103, 137)); // Le asignamos un fondo
                panelShips.add(matrixPanels[i][j]); // Lo almacenamos en el panel de barcos
                xPosition += 50; // Actualizamos la coordenada x 
            }
            yPosition += 50; // Actualizamos la coordenada y
        }

        // Codigo para hacer el grid de botones para disparar
        int xPosition2 = 0; //Posicion en x
        int yPosition2 = 0; // Posicion en y

        //Ciclo para hacer los botones
        for (int i = 0; i < rows; i++) {
            int row = i;
            xPosition = 0;
            for (int j = 0; j < cols; j++) {
                int col = j;
                matrixButtons[i][j] = new JButton(); // Hacemos un boton
                matrixButtons[i][j].setBounds(xPosition2, yPosition2, 50, 50); // Le asignamos una posicion y un tamano
                // Le damos una accion
                matrixButtons[i][j].addActionListener(new ActionListener() { 
                    public void actionPerformed(ActionEvent e) {
                        clickedCol = col;
                        clickedRow = row;
                        System.out.println("Button "+ row + "," + col);
                    }
                    
                });
                matrixButtons[i][j].setIcon(imagenRadar); // Cambiamos el icono
                panelButtons.add(matrixButtons[i][j]); // Anadimos el boton al panel de botones
                xPosition2 += 50; // Actualizamos la coordenada en x
            }
            yPosition2 += 50; // Actualizamos la coordenada en y
        }


        matrixPanels[4][5].setBackground(Color.RED);

        JFrame frame = new JFrame(); // Creamos un nuevo frame
        frame.setLayout(null); // El layout sera nulo, por lo que nosotros tendremos que asignar las posiciones
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Hacemos que al cerrar la ventana se eliminen los procesos
        frame.setSize(1015, 740); // Le asignamos un tamano 
        frame.setResizable(false); // Hacemos que no se epueda modificar su tamano
        frame.setIconImage(imagenLogo.getImage()); // Cambiamos el logo de la ventana
        frame.getContentPane().setBackground(new Color(103, 99, 98)); // Le asignamos un fondo
        frame.add(panelLogo); // Anadimos el panel que contiene el logo
        frame.add(panelShips); // Anadimos el panel que contiene la matriz de barcos
        frame.add(panelButtons); // Anadimos el panel que contiene la matriz de botones
        frame.setVisible(true); // Hacemos visible al frame
    }
}