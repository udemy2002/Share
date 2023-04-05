/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code;

import java.security.KeyFactory; //lớp này cung cấp một giao diện cho các thuật toán tạo và chuyển đổi khóa.
import java.security.NoSuchAlgorithmException; 
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec; // Lớp này đại diện cho một bản mã hóa của khóa công khai X.509.
import java.util.Base64; //lớp này cung cấp các phương thức để mã hóa và giải mã dữ liệu văn bản theo chuẩn Base64.
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher; // lớp này cung cấp các phương thức để thực hiện mã hóa và giải mã dữ liệu.
import javax.crypto.KeyGenerator; //lớp này cung cấp phương thức để tạo ra khóa đối xứng ngẫu nhiên sử dụng cho thuật toán RC4.
import javax.crypto.NoSuchPaddingException; //Là một ngoại lệ (exception) trong Java được ném ra khi một giải thuật mã hóa yêu cầu một loại lớp padding không tồn tại. 
                                             //Padding là quá trình thêm dữ liệu vào phía cuối của một khối dữ liệu trước khi mã hóa nó. 
import javax.crypto.SecretKey; // lớp này đại diện cho một khóa đối xứng trong hệ thống mật mã.
import javax.crypto.spec.SecretKeySpec; //lớp này đại diện cho một khóa đối xứng được cung cấp bởi một mảng byte.

/**
 *
 * @author Admin
 */
public class RC4Encryption {

    InfomationUser infomationUser;
    public SecretKey secretKey;
    public RC4Encryption() {

    }

    public void init() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("RC4");
            keyGenerator.init(512);
            secretKey = keyGenerator.generateKey();
            byte[] key = secretKey.getEncoded();
            infomationUser = new InfomationUser(key);
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }

    public Cipher maHoa(String Key) {
        try {
            byte[] keyByte = Base64.getDecoder().decode(Key);
            Cipher cipher = Cipher.getInstance("RC4");
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyByte, "RC4");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            return cipher;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Cipher giaima(String Key) {
        try {
            InfomationUser inf = new InfomationUser();
            System.out.println("GiaiMa:" + Key);
            byte[] keyByte = Base64.getDecoder().decode(Key);
            Cipher cipher = Cipher.getInstance("RC4");
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyByte, "RC4");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            return cipher;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String encryptKeyRSA(String PublicKey) {
        try {
            InfomationUser user = new InfomationUser();
            byte[] byteKey = Base64.getDecoder().decode(PublicKey);
            X509EncodedKeySpec X509publicKey = new X509EncodedKeySpec(byteKey);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            PublicKey pk = kf.generatePublic(X509publicKey);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, pk);
            byte[] RC4Key = Base64.getDecoder().decode(InfomationUser.getRc4Key());
            byte[] cipherText = cipher.doFinal(RC4Key);
            String res = Base64.getEncoder().encodeToString(cipherText);
            
            return res;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String decryptKeyRSA(String Data) {
        try {
            System.out.println(Data);
            InfomationUser user = new InfomationUser();
            KeyFactory kf = KeyFactory.getInstance("RSA");
            byte[] byteKey = Base64.getDecoder().decode(infomationUser.getPrivateKey());
            PKCS8EncodedKeySpec PKCS8privateKey = new PKCS8EncodedKeySpec(byteKey);
            PrivateKey privateKey = kf.generatePrivate(PKCS8privateKey);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[]keyData = Base64.getDecoder().decode(Data);
            byte[] cipherText = cipher.doFinal(keyData);
            String res =  Base64.getEncoder().encodeToString(cipherText);
            return res;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
