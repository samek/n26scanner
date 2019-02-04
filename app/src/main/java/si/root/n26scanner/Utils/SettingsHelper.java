package si.root.n26scanner.Utils;

import android.content.SharedPreferences;
import android.util.Base64;


public class SettingsHelper {

    private static String EmailAlias = "n26EmailAlias";
    private static String PassowrdAlias = "n26PassAlias";
    private static String PinAlias = "n26PinAlias";
    SharedPreferences mSettings = null;
    SharedPreferences.Editor editor;
    private String email = "";
    private String password = "";
    private String pin = "";


    public SettingsHelper(SharedPreferences mSettings) {
        this.mSettings = mSettings;
        this.editor = mSettings.edit();

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        this.editor.putString(EmailAlias, this.email);
        this.editor.commit();
        this.editor.apply();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        this.editor.putString(PassowrdAlias, this.password);
        this.editor.commit();
        this.editor.apply();
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
        this.editor.putString(PinAlias, this.pin);
        this.editor.commit();
        this.editor.apply();
    }

    public boolean FillInCredentials() {

        String Spass = mSettings.getString(PassowrdAlias, "");
        String Semail = mSettings.getString(EmailAlias, "");
        String Spin = mSettings.getString(PinAlias, "");


        if (Spass.equals("") || Semail.equals("") || Spin.equals("")) {
            return false;
        }


        this.email = Semail;
        this.password = Spass;
        this.pin = Spin;
        return true;
    }


    private byte[] baseToByte(String base) {
        return Base64.decode(base, Base64.DEFAULT);
    }


}
