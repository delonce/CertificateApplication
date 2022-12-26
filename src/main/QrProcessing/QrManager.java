package main.QrProcessing;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class QrManager {
    public static void CreateQrCode(String qrStringData, String pathToSave){
        ByteArrayOutputStream outputStream = QRCode.from(qrStringData).to(ImageType.PNG).stream();

        try (FileOutputStream fos = new FileOutputStream(new File(pathToSave));) {
            fos.write(outputStream.toByteArray());
            fos.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String ScanQrCode(String pathToQrCode) {
        try {
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new File(pathToQrCode)))));
            Result result = new MultiFormatReader().decode(binaryBitmap);
            String myDecodedQr = result.getText();

            return myDecodedQr;
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
