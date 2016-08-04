package egat.kampeepan.showtraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private ListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Statement

        //Bind Widget
        listView = (ListView) findViewById(R.id.listView);  //R=ที่เก็บรายชื่อ widget ทั้งหมด
        button = (Button) findViewById(R.id.button);    //Alt+enter = cast to ...

        //Button Controller
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sound Effect
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.cat);
                mediaPlayer.start();

                //Go to Web View
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://youtu.be/R10mrTJpqPw"));
                startActivity(intent);

            }   //onClick
        });

    }   //Main Method


}   //Main Class
