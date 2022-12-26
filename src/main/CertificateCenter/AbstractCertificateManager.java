package main.CertificateCenter;

import main.CryptoPackage.CryptoManager;
import main.QrProcessing.QrManager;
import org.json.JSONObject;

abstract public class AbstractCertificateManager {
    private static CryptoManager cryptoManager = new CryptoManager();
    private static QrManager qrManager = new QrManager();
    private JSONObject jsonObject;

    public static CryptoManager getCryptoManager() {
        return cryptoManager;
    }

    public static QrManager getQrManager() {
        return qrManager;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }
}
