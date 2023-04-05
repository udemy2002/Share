
package Code;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author Admin
 */
public class TShare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try {
            RSAEncryption rsa = new RSAEncryption();
            RC4Encryption rc4 = new RC4Encryption();
            rc4.init();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        InfomationUser user = new InfomationUser();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.out.println("LAF ERROR");
        }
        HomeUser home = new HomeUser();
        SocketClient socket = new SocketClient(home);
        HomePage page = new HomePage(socket);
        home.updateSocket(socket);
        socket.updatehomePage(page);
        page.setVisible(true);

    }

}
