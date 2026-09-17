package agm_system;

import java.util.Locale;
import javax.swing.SwingUtilities;

public class AGM_System {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        SwingUtilities.invokeLater(() -> {
            TelaPrincipal tela = new TelaPrincipal();
            tela.setVisible(true);
        });
    }
}