package main.CertificateCenter;

public class CertificateChecker extends AbstractCertificateManager {
    private static String pathToQr;
    private static String pathToKey;

    public boolean isFilesExist() {
        try {
            if (!pathToKey.isEmpty() && !pathToQr.isEmpty()) {
                return true;
            } else {
                return false;
            }
        } catch (NullPointerException exception) {
            return false;
        }
    }

    public static String getPathToQr() {
        return pathToQr;
    }

    public static void setPathToQr(String pathToQr) {
        CertificateChecker.pathToQr = pathToQr;
    }

    public static String getPathToKey() {
        return pathToKey;
    }

    public static void setPathToKey(String pathToKey) {
        CertificateChecker.pathToKey = pathToKey;
    }
}
