package creative.com.poprat;

import android.content.Context;
import android.content.SharedPreferences;

public class Config {
    public static final String POPPREF = "POPPREF.com";
    public static final String BUKA_SETIAP = "BUKASETIAP";
    public static final String BUKA_SAATINI = "BUKA_SAATINI";

    public static final String TAMPIL_POPUP = "TAMPIL_POPUP";

    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor sharedEditor;

    public Config(Context context){
        this.sharedPreferences = context.getSharedPreferences(POPPREF, Context.MODE_PRIVATE);
        this.sharedEditor = sharedPreferences.edit();
    }

    public void setBukaSetiap(int val){
        sharedEditor.putInt(BUKA_SETIAP, val);
        sharedEditor.commit();
        sharedEditor.apply();
    }

    public void setBukaSaatini(int val){
        sharedEditor.putInt(BUKA_SAATINI, val);
        sharedEditor.commit();
        sharedEditor.apply();
    }
    public boolean getTampilPopup(){
        return sharedPreferences.getBoolean(TAMPIL_POPUP, true);
    }

    public void setstatustampil(boolean status){
        sharedEditor.putBoolean(TAMPIL_POPUP, status);
        sharedEditor.apply();
    }

    public int getIntSaatIni(){
        return sharedPreferences.getInt(BUKA_SAATINI, 1);
    }

    public int getIntSetiap(){
        return sharedPreferences.getInt(BUKA_SETIAP, 5);
    }
}
