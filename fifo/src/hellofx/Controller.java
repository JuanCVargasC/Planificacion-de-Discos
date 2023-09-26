package hellofx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Controller {

    @FXML
    private Pane Pane;

    @FXML
    private Button btnC;

    @FXML
    private TextArea data;

    @FXML
    private TextArea dataOut;

    @FXML
    private TextField inputC;

    @FXML
    private TextField inputCa;

    @FXML
    void addC(ActionEvent event) {
        int cabecera = Integer.parseInt(inputCa.getText());
        int tamano = Integer.parseInt(inputC.getText());
        int[] miArray = new int[tamano];
        int totalMovimientos = 0;
        float promedio;
        try {

            for (int index = 0; index < miArray.length; index++) {
                boolean inputValido = false;
                while (!inputValido) {
                    String input = JOptionPane.showInputDialog("Ingrese el valor para el proceso en Cola # " + index);
                    try {
                        miArray[index] = Integer.parseInt(input);
                        inputValido = true;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
                    }

                    data.appendText(Integer.toString(miArray[index]) + "\n");

                }

            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "NO es una entrada valida");
        }

        for (int i = 0; i < miArray.length; i++) {
            int distancia = Math.abs(miArray[i] - cabecera);
            totalMovimientos += distancia;
            cabecera = miArray[i];

            dataOut.appendText(totalMovimientos + "\n");
            cabecera = miArray[i];
            System.out
                    .println(miArray[i] + "+" + cabecera + " igual " + distancia + " movimientos: " + totalMovimientos);
        }
        float cantidad = miArray.length;
        promedio = totalMovimientos / cantidad;
        System.out.println(promedio);
        dataOut.appendText("Promedio: " + promedio);

    }

    @FXML
    void addDw(ActionEvent event) {
        int cabecera = Integer.parseInt(inputCa.getText());
        int tamano = Integer.parseInt(inputC.getText());
        int[] miArray = new int[tamano];
        int[] salida = new int[tamano];
        int totalMovimientos = 0;
        float promedio;

        for (int index = 0; index < miArray.length; index++) {
            boolean inputValido = false;
            while (!inputValido) {
                String input = JOptionPane.showInputDialog("Ingrese el valor para el proceso en Cola # " +
                        index);
                try {
                    miArray[index] = Integer.parseInt(input);
                    inputValido = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
                }

                // data.appendText(Integer.toString(miArray[index]) + "\n");

            }
        }

        try {

            List<Integer> mayores = new ArrayList<>();
            List<Integer> menores = new ArrayList<>();

            for (int numero : miArray) {
                if (numero < cabecera) {
                    menores.add(numero);
                } else {
                    mayores.add(numero);
                }
            }

            Collections.sort(menores, Collections.reverseOrder());

            Collections.sort(mayores, Collections.reverseOrder());

            menores.addAll(mayores);
            // imprimir
            for (int numero : menores) {
                System.out.print(numero + " ");
                data.appendText(numero + "\n");

            }

            int totalDiferencias = 0;
            int diferencia;

            for (int i = 0; i < menores.size() - 1; i++) {
                if (i == 0) {
                    diferencia = Math.abs(cabecera - menores.get(i));
                    totalDiferencias += diferencia;
                }
                diferencia = Math.abs(menores.get(i) - menores.get(i + 1));
                totalDiferencias += diferencia;

                dataOut.appendText("\n" + diferencia);

            }
            float cantidad = menores.size();
            float promedioDiferencias = totalDiferencias / cantidad;

            // for (int numero : menores) {
            // dataOut.appendText(numero + "\n");
            // }

            dataOut.appendText("\nTotal: " + totalDiferencias);
            dataOut.appendText("\nPromedio: " + promedioDiferencias);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "NO es una entrada valida");
        }

    }

    @FXML
    void addUp(ActionEvent event) {

        int cabecera = Integer.parseInt(inputCa.getText());
        int tamano = Integer.parseInt(inputC.getText());
        int[] miArray = new int[tamano];
        int[] salida = new int[tamano];
        int totalMovimientos = 0;
        float promedio;

        for (int index = 0; index < miArray.length; index++) {
            boolean inputValido = false;
            while (!inputValido) {
                String input = JOptionPane.showInputDialog("Ingrese el valor para el proceso en Cola # " +
                        index);
                try {
                    miArray[index] = Integer.parseInt(input);
                    inputValido = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
                }

                // data.appendText(Integer.toString(miArray[index]) + "\n");

            }
        }

        try {

            List<Integer> mayores = new ArrayList<>();
            List<Integer> menores = new ArrayList<>();

            for (int numero : miArray) {
                if (numero > cabecera) {
                    mayores.add(numero);
                } else {
                    menores.add(numero);
                }
            }

            Collections.sort(mayores);

            Collections.sort(menores);

            mayores.addAll(menores);
            // imprimir
            for (int numero : mayores) {
                System.out.print(numero + " ");
                data.appendText(numero + "\n");
            }

            int totalDiferencias = 0;
            int diferencia = 0;

            for (int i = 0; i < mayores.size() - 1; i++) {
                if (i == 0) {
                    diferencia = Math.abs(cabecera - mayores.get(i));
                    totalDiferencias += diferencia;
                }
                diferencia = Math.abs(mayores.get(i) - mayores.get(i + 1));
                totalDiferencias += diferencia;

                // dataOut.appendText(diferencia + "--" + mayores.get(i).intValue() + "\n");
                dataOut.appendText("\n" + diferencia);

            }
            float cantidad = mayores.size();
            float promedioDiferencias = totalDiferencias / cantidad;

            // for (int numero : mayores) {
            // dataOut.appendText(diferencia + "--" + numero + "\n");
            // }

            dataOut.appendText("\nTotal: " + totalDiferencias);
            dataOut.appendText("\nPromedio: " + promedioDiferencias);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "NO es una entrada valida");
        }

    }

}
