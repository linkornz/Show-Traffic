package egat.kampeepan.showtraffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 21100 on 8/5/2016.
 */
public class TrafficAdapter extends BaseAdapter{

    //Explicit
    private Context context;    //ต้องมีในการโยน data
    private int[] iconInts; // ตั้งชื่อให้มีความหมาย ในที่นี้คือ รูปภาพเป็น icon ละเป็น int
    private String[] titleStrings, detailStrings;

    //Create Constructor


    public TrafficAdapter(Context context,
                          int[] iconInts,
                          String[] titleStrings,
                          String[] detailStrings) {
        this.context = context;
        this.iconInts = iconInts;
        this.titleStrings = titleStrings;
        this.detailStrings = detailStrings;
    }

    @Override
    public int getCount() {
        return iconInts.length; // จำนวนของ listview
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //Open Service
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //สร้าง layout เสมือน
        View view1 = layoutInflater.inflate(R.layout.traffic_listview, viewGroup, false);   //service ไปที่ไหน ไปแบบไหน มี security มั้ยย

        //Bind Widget
        ImageView iconImageView = (ImageView) view1.findViewById(R.id.imageView);
        TextView titleTextView = (TextView) view1.findViewById(R.id.textView2);
        TextView detailTextView = (TextView) view1.findViewById(R.id.textView3);

        //Show View
        iconImageView.setImageResource(iconInts[i]);    //โยนรูป
        titleTextView.setText(titleStrings[i]);     //โยน title
        detailTextView.setText(detailStrings[i]);   //โยน detail

        return view1;
    }
}   //Main Class
