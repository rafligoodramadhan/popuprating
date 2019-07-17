package creative.com.popuprating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import creative.com.poprat.Config;
import creative.com.poprat.PopupRating;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PopupRating popupRating = new PopupRating(MainActivity.this);
        popupRating.setBukaSetiap(3);

    }
}
