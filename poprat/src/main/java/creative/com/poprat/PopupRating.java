package creative.com.poprat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class PopupRating {

    private Activity activity_saatini;
    private TextView aksiiya, aksitidak, tvpesan;
    private RatingBar aksirb;
    boolean tampilkedua = false;


    private Config config;
    public PopupRating(Activity context){
        config = new Config(context);
        activity_saatini = context;

        if (config.getIntSaatIni() > config.getIntSetiap()){
            tampilPopup();
        }else {
            int nilai = config.getIntSaatIni();
            config.setBukaSaatini(nilai+1);
        }
    }

    public void setBukaSetiap(int val){
        config.setBukaSetiap(val);
    }

    void tampilPopup(){
        final android.support.v7.app.AlertDialog.Builder als  = new android.support.v7.app.AlertDialog.Builder(activity_saatini);
        LayoutInflater ll = activity_saatini.getLayoutInflater();
        View view1 = ll.inflate(R.layout.dialog_ratingapp, null);
        als.setView(view1);

        final android.support.v7.app.AlertDialog k = als.create();
        aksiiya = view1.findViewById(R.id.dialogratingapp_tv_aksiiya);
        aksitidak = view1.findViewById(R.id.dialogratingapp_tv_aksitidak);
        tvpesan = view1.findViewById(R.id.dialogratingapp_tv_pesan);
        aksirb = view1.findViewById(R.id.dialogratingapp_ratbar_1);
        if (tampilkedua==false){
            aksitidak.setVisibility(View.GONE);
            aksiiya.setText(activity_saatini.getString(R.string.lanjutkan));
        }
        aksitidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                k.cancel();
            }
        });
        aksiiya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tampilkedua==false){
                    if (aksirb.getRating() > 0){
                        tampilkedua = true;
                        aksitidak.setVisibility(View.VISIBLE);
                        aksiiya.setText(activity_saatini.getString(R.string.iya));
                        aksirb.setVisibility(View.GONE);
                        tvpesan.setText(activity_saatini.getString(R.string.berbagi_pengalaman));
                    }else {
                        Toast.makeText(activity_saatini, activity_saatini.getString(R.string.masukan_rating), Toast.LENGTH_SHORT).show();
                    }
                }else {
                    final String appPackageName = activity_saatini.getPackageName(); // getPackageName() from Context or Activity object
                    try {
                        activity_saatini.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        activity_saatini.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                    }
                    k.cancel();
                }


            }
        });
        k.show();

    }

}
