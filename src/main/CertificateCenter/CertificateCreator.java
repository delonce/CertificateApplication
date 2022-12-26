package main.CertificateCenter;

import main.CryptoPackage.CryptoManager;
import main.QrProcessing.QrManager;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CertificateCreator extends AbstractCertificateManager {

    public void fillNewCertificate(String from, String to, String reason, String org) {
        JSONObject obj = new JSONObject();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());

        try {
            obj.put("Rewarded", from);
            obj.put("Awarded", to);
            obj.put("Description", reason);
            obj.put("Organization", org);
            obj.put("Date", formatter.format(date));
        } catch (JSONException jsonException) {
            throw new RuntimeException();
        }

        setJsonObject(obj);
        System.out.println(getJsonObject().toString());
    }

    public void encryptCertificate() {
        try {
            JSONObject jsonObject = getJsonObject();

            String encodedData = getCryptoManager().DoEncodingData(jsonObject.toString(), jsonObject.getString("Awarded") + ".key");
            String dataForQrCode = encodedData + "___" + jsonObject.toString();

            QrManager.CreateQrCode(dataForQrCode, jsonObject.getString("Awarded") + ".png");
        } catch (JSONException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
