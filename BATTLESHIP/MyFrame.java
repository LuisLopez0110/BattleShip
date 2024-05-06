import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.Random;

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


        //matrixPanels[4][5].setBackground(Color.RED);

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
        crearBarco1();
    }


    public void crearBarco1() {
        // Cargar las imágenes del primer barco en orden
        ImageIcon barco1Icon1 = new ImageIcon("SHIP 1\\SHIP 1 (1).png");
        ImageIcon barco1Icon2 = new ImageIcon("SHIP 1\\SHIP 1 (2).png");
        ImageIcon barco1Icon3 = new ImageIcon("SHIP 1\\SHIP 1 (3).png");
        ImageIcon barco1Icon1Volteado = new ImageIcon("SHIP 1\\SHIP 1 (1) - copia.png");
        ImageIcon barco1Icon2Volteado = new ImageIcon("SHIP 1\\SHIP 1 (2) - copia.png");
        ImageIcon barco1Icon3Volteado = new ImageIcon("SHIP 1\\SHIP 1 (3) - copia.png");
        // Cargar las imagenes del segundo barco en orden
        ImageIcon barco2Icon1 = new ImageIcon("SHIP 2\\SHIP 2.png");
        ImageIcon barco2Icon2 = new ImageIcon("SHIP 2\\SHIP 2 (2).png");
        ImageIcon barco2Icon3 = new ImageIcon("SHIP 2\\SHIP 2 (3).png");
        ImageIcon barco2Icon4 = new ImageIcon("SHIP 2\\SHIP 2 (4).png");
        ImageIcon barco2Icon1Volteado = new ImageIcon("SHIP 2\\SHIP 2 - copia.png");
        ImageIcon barco2Icon2Volteado = new ImageIcon("SHIP 2\\SHIP 2 (2) - copia.png");
        ImageIcon barco2Icon3Volteado = new ImageIcon("SHIP 2\\SHIP 2 (3) - copia.png");
        ImageIcon barco2Icon4Volteado = new ImageIcon("SHIP 2\\SHIP 2 (4) - copia.png");
        // Cargar las imagenes del tercer barco en orden
        ImageIcon barco3Icon1 = new ImageIcon("SHIP 3\\SHIP 3 (1).png");
        ImageIcon barco3Icon2 = new ImageIcon("SHIP 3\\SHIP 3 (2).png");
        ImageIcon barco3Icon3 = new ImageIcon("SHIP 3\\SHIP 3 (3).png");
        ImageIcon barco3Icon4 = new ImageIcon("SHIP 3\\SHIP 3 (4).png");
        ImageIcon barco3Icon5 = new ImageIcon("SHIP 3\\SHIP 3 (5).png");
        ImageIcon barco3Icon1Volteado = new ImageIcon("SHIP 3\\SHIP 3 (1) - copia.png");
        ImageIcon barco3Icon2Volteado = new ImageIcon("SHIP 3\\SHIP 3 (2) - copia.png");
        ImageIcon barco3Icon3Volteado = new ImageIcon("SHIP 3\\SHIP 3 (3) - copia.png");
        ImageIcon barco3Icon4Volteado = new ImageIcon("SHIP 3\\SHIP 3 (4) - copia.png");
        ImageIcon barco3Icon5Volteado = new ImageIcon("SHIP 3\\SHIP 3 (5) - copia.png");
        // Cargar las imagenes del cuarto barco en orden
        ImageIcon barco4Icon1 = new ImageIcon("SHIP 4\\SHIP 4 (1).png");
        ImageIcon barco4Icon2 = new ImageIcon("SHIP 4\\SHIP 4 (2).png");
        ImageIcon barco4Icon3 = new ImageIcon("SHIP 4\\SHIP 4 (3).png");
        ImageIcon barco4Icon4 = new ImageIcon("SHIP 4\\SHIP 4 (4).png");
        ImageIcon barco4Icon5 = new ImageIcon("SHIP 4\\SHIP 4 (5).png");
        ImageIcon barco4Icon6 = new ImageIcon("SHIP 4\\SHIP 4 (6).png");
        ImageIcon barco4Icon1Volteado = new ImageIcon("SHIP 4\\SHIP 4 (1) - copia.png");
        ImageIcon barco4Icon2Volteado = new ImageIcon("SHIP 4\\SHIP 4 (2) - copia.png");
        ImageIcon barco4Icon3Volteado = new ImageIcon("SHIP 4\\SHIP 4 (3) - copia.png");
        ImageIcon barco4Icon4Volteado = new ImageIcon("SHIP 4\\SHIP 4 (4) - copia.png");
        ImageIcon barco4Icon5Volteado = new ImageIcon("SHIP 4\\SHIP 4 (5) - copia.png");
        ImageIcon barco4Icon6Volteado = new ImageIcon("SHIP 4\\SHIP 4 (6) - copia.png");
        // Cargar las imagenes del quinto barco en orden
        ImageIcon barco5Icon1 = new ImageIcon("SHIP 5\\SHIP 5 (1).png");
        ImageIcon barco5Icon2 = new ImageIcon("SHIP 5\\SHIP 5 (2).png");
        ImageIcon barco5Icon3 = new ImageIcon("SHIP 5\\SHIP 5 (3).png");
        ImageIcon barco5Icon1Volteado = new ImageIcon("SHIP 5\\SHIP 5 (1) - copia.png");
        ImageIcon barco5Icon2Volteado = new ImageIcon("SHIP 5\\SHIP 5 (2) - copia.png");
        ImageIcon barco5Icon3Volteado = new ImageIcon("SHIP 5\\SHIP 5 (3) - copia.png");

        Random random = new Random();
        boolean horizontal = random.nextBoolean(); // Determinar aleatoriamente si crear en horizontal o vertical
    
        ImageIcon[] imagenesAleatorias1 = {barco1Icon1, barco1Icon2, barco1Icon3};
        ImageIcon[] imagenesAleatorias1Volteado = {barco1Icon1Volteado, barco1Icon2Volteado, barco1Icon3Volteado};
        ImageIcon[] imagenesAleatorias2 = {barco2Icon1, barco2Icon2, barco2Icon3, barco2Icon4};
        ImageIcon[] imagenesAleatorias2Volteado = {barco2Icon1Volteado, barco2Icon2Volteado, barco2Icon3Volteado, barco2Icon4Volteado};
        ImageIcon[] imagenesAleatorias3 = {barco3Icon1, barco3Icon2, barco3Icon3, barco3Icon4, barco3Icon5};
        ImageIcon[] imagenesAleatorias3Volteado = {barco3Icon1Volteado, barco3Icon2Volteado, barco3Icon3Volteado, barco3Icon4Volteado, barco3Icon5Volteado};
        ImageIcon[] imagenesAleatorias4 = {barco4Icon1, barco4Icon2, barco4Icon3, barco4Icon4, barco4Icon5, barco4Icon6};
        ImageIcon[] imagenesAleatorias4Volteado = {barco4Icon1Volteado, barco4Icon2Volteado, barco4Icon3Volteado,barco4Icon4Volteado, barco4Icon5Volteado, barco4Icon6Volteado};
        ImageIcon[] imagenesAleatorias5 = {barco5Icon1, barco5Icon2, barco5Icon3};
        ImageIcon[] imageensAleatorias5Volteado = {barco5Icon1Volteado, barco5Icon2Volteado, barco5Icon3Volteado};

        // Banderas para validar las posiciones de los barcos
        boolean barco1 = validarPosiciones(matrixPanels, horizontal, 3);
        boolean barco2 = validarPosiciones(matrixPanels, horizontal, 4);
        boolean barco3 = validarPosiciones(matrixPanels, horizontal, 5);
        boolean barco4 = validarPosiciones(matrixPanels, horizontal, 6);
        boolean barco5 = validarPosiciones(matrixPanels, horizontal, 3);

        if(barco1 && barco2 && barco3 && barco4 && barco5){
        if (horizontal) {
            int fila = random.nextInt(matrixPanels.length); // Fila aleatoria
            int columnaInicio = random.nextInt(matrixPanels[0].length - 2); // Columna de inicio para asegurar espacio suficiente
            for (int i = 0; i < 3; i++) {
                matrixPanels[fila][columnaInicio + i].add(new JLabel(imagenesAleatorias1Volteado[i])); // Establecer la imagen del barco en el panel
            }
        } else {
            int columna = random.nextInt(matrixPanels[0].length); // Columna aleatoria
            int filaInicio = random.nextInt(matrixPanels.length - 2); // Fila de inicio para asegurar espacio suficiente
            for (int i = 0; i < 3; i++) {
                matrixPanels[filaInicio + i][columna].add(new JLabel(imagenesAleatorias1[i])); // Establecer la imagen del barco en el panel
            }
        }
        
        if (horizontal) {
            int fila = random.nextInt(matrixPanels.length); // Fila aleatoria
            int columnaInicio = random.nextInt(matrixPanels[0].length - 3); // Columna de inicio para asegurar espacio suficiente
            for (int i = 0; i < 4; i++) {
                matrixPanels[fila][columnaInicio + i].add(new JLabel(imagenesAleatorias2Volteado[i])); // Establecer la imagen del barco en el panel
            }
        }else {
            int columna = random.nextInt(matrixPanels[0].length);
            int filaInicio = random.nextInt(matrixPanels.length - 3);
            for(int i = 0; i < 4; i++) { 
                matrixPanels[filaInicio + i][columna].add(new JLabel(imagenesAleatorias2[i]));
            }
        }

        if(horizontal) {
            int fila = random.nextInt(matrixPanels.length);
            int columnaInicio = random.nextInt(matrixPanels[0].length - 4);
            for(int i = 0; i < 5; i++) {
                matrixPanels[fila][columnaInicio + i].add(new JLabel(imagenesAleatorias3Volteado[i]));
            }
        } else {
            int columna = random.nextInt(matrixPanels[0].length);
            int filaInicio = random.nextInt(matrixPanels.length - 4);
            for(int i = 0; i < 5; i++) { 
                matrixPanels[filaInicio + i][columna].add(new JLabel(imagenesAleatorias3[i]));
            }
        }

        if(horizontal) {
            int fila = random.nextInt(matrixPanels.length);
            int columnaInicio = random.nextInt(matrixPanels[0].length - 5);
            for(int i = 0; i < 6; i++) {
                matrixPanels[fila][columnaInicio + i].add(new JLabel(imagenesAleatorias4Volteado[i]));
            }
        } else {
            int columna = random.nextInt(matrixPanels[0].length);
            int filaInicio = random.nextInt(matrixPanels.length - 5);
            for(int i = 0; i < 6; i++) {
                matrixPanels[filaInicio + i][columna].add(new JLabel(imagenesAleatorias4[i]));
            }
        }

        if (horizontal) {
            int fila = random.nextInt(matrixPanels.length); // Fila aleatoria
            int columnaInicio = random.nextInt(matrixPanels[0].length - 2); // Columna de inicio para asegurar espacio suficiente
            for (int i = 0; i < 3; i++) {
                matrixPanels[fila][columnaInicio + i].removeAll(); // Limpiar cualquier componente anterior
                matrixPanels[fila][columnaInicio + i].add(new JLabel(imageensAleatorias5Volteado[i])); // Establecer la imagen del barco en el panel
            }
        } else {
            int columna = random.nextInt(matrixPanels[0].length); // Columna aleatoria
            int filaInicio = random.nextInt(matrixPanels.length - 2); // Fila de inicio para asegurar espacio suficiente
            for (int i = 0; i < 3; i++) {
                matrixPanels[filaInicio + i][columna].removeAll(); // Limpiar cualquier componente anterior
                matrixPanels[filaInicio + i][columna].add(new JLabel(imagenesAleatorias5[i])); // Establecer la imagen del barco en el panel
            }
        }

        // Actualizar los paneles
        for (int i = 0; i < matrixPanels.length; i++) {
            for (int j = 0; j < matrixPanels[i].length; j++) {
                matrixPanels[i][j].revalidate();
                matrixPanels[i][j].repaint();
            }
        }}
    }
    
    private boolean validarPosiciones(JPanel[][] matrixPanels, boolean horizontal, int longitud) {
        Random random = new Random();
        boolean posicionValida = true;
    
        if (horizontal) {
            int fila = random.nextInt(matrixPanels.length); // Fila aleatoria
            int columnaInicio = random.nextInt(matrixPanels[0].length - longitud); // Columna de inicio para asegurar espacio suficiente
    
            // Verificar si hay algún componente en las posiciones que ocuparía el barco
            for (int i = 0; i < longitud; i++) {
                if (matrixPanels[fila][columnaInicio + i].getComponents().length > 0) {
                    // Si hay un componente en el panel, la posición no es válida
                    posicionValida = false;
                    break; // Salir del bucle
                }
            }
        } else {
            int columna = random.nextInt(matrixPanels[0].length);
            int filaInicio = random.nextInt(matrixPanels.length - longitud);
    
            // Verificar si hay algún componente en las posiciones que ocuparía el barco
            for (int i = 0; i < longitud; i++) {
                if (matrixPanels[filaInicio + i][columna].getComponents().length > 0) {
                    // Si hay un componente en el panel, la posición no es válida
                    posicionValida = false;
                    break; // Salir del bucle
                }
            }
        }
    
        return posicionValida; // Devolver si la posición es válida o no
    
    }
}
