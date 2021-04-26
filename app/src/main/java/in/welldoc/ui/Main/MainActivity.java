package in.welldoc.ui.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import in.welldoc.R;
import in.welldoc.data.remote.staticModel.MyListData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.WHITE);
        }
        MyListData[] myListData = new MyListData[]{
                new MyListData( android.R.drawable.ic_dialog_email,"u Rapid"),
                new MyListData( android.R.drawable.ic_dialog_info,"min"),
                new MyListData( android.R.drawable.ic_delete,"gm"),
                new MyListData( android.R.drawable.ic_dialog_dialer,"mg/dl"),
                new MyListData( android.R.drawable.ic_dialog_alert,"mil"),
                new MyListData( android.R.drawable.ic_dialog_map,"amp"),
                new MyListData( android.R.drawable.ic_dialog_email,"u Rapid"),
                new MyListData( android.R.drawable.ic_dialog_info,"min"),
                new MyListData( android.R.drawable.ic_delete,"gm"),
                new MyListData( android.R.drawable.ic_dialog_dialer,"mg/dl"),
                new MyListData( android.R.drawable.ic_dialog_alert,"mil"),
                new MyListData( android.R.drawable.ic_dialog_map,"amp"),

        };
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.items);
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}