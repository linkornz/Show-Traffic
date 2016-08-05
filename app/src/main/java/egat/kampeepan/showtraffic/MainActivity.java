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

        //ListView Controller
        //Easy Setup Array Type
        int[] iconInts = new int[20];   //ตามจำนวนรูป
        iconInts[0] = R.drawable.traffic_01;    //ตำแหน่งของภาพ array ที่1
        iconInts[1] = R.drawable.traffic_02;
        iconInts[2] = R.drawable.traffic_03;
        iconInts[3] = R.drawable.traffic_04;
        iconInts[4] = R.drawable.traffic_05;
        iconInts[5] = R.drawable.traffic_06;
        iconInts[6] = R.drawable.traffic_07;
        iconInts[7] = R.drawable.traffic_08;
        iconInts[8] = R.drawable.traffic_09;
        iconInts[9] = R.drawable.traffic_10;
        iconInts[10] = R.drawable.traffic_11;
        iconInts[11] = R.drawable.traffic_12;
        iconInts[12] = R.drawable.traffic_13;
        iconInts[13] = R.drawable.traffic_14;
        iconInts[14] = R.drawable.traffic_15;
        iconInts[15] = R.drawable.traffic_16;
        iconInts[16] = R.drawable.traffic_17;
        iconInts[17] = R.drawable.traffic_18;
        iconInts[18] = R.drawable.traffic_19;
        iconInts[19] = R.drawable.traffic_20;

        //Setup Array from XML
        String[] titlStrings = getResources().getStringArray(R.array.title); //นำเข้าค่าข้อมูลจาก xml ใน values my_data.xml
        String[] detailLongStrings = getResources().getStringArray(R.array.detail);

        //การตัดคำ
        String[] detailShortStrings = new String[detailLongStrings.length]; //จำนวน short เท่ากับ จำนวน long
        for (int i=0;i<detailLongStrings.length;i+=1) {

            detailShortStrings[i] = detailLongStrings[i].substring(0, 30) + "...";

        }   //for

        //Create ListView
        TrafficAdapter trafficAdapter = new TrafficAdapter(this,iconInts,titlStrings,detailShortStrings);
        listView.setAdapter(trafficAdapter);

    }   //Main Method



}   //Main Class
