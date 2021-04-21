package in.welldoc.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import in.welldoc.ui.home.CategoryAdapter;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import in.welldoc.R;
import in.welldoc.data.remote.model.Datum;

public class HomeActivity extends AppCompatActivity  implements HomeContract.MainView{
    private RecyclerView recyclerView;

    private HomeContract.presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initialize();
        presenter = new HomePresenterImpl(this, new GetNoticeIntractorImpl());
    }

    private void initialize() {
        recyclerView = findViewById(R.id.items);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setDataToRecyclerView(ArrayList<Datum> noticeArrayList) {
        CategoryAdapter adapter = new CategoryAdapter(noticeArrayList , recyclerItemClickListener);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(HomeActivity.this,
                "Something went wrong...Error message: " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();

    }
    private RecyclerItemClickListener recyclerItemClickListener = new RecyclerItemClickListener() {
        @Override
        public void onItemClick(Datum notice) {

            Toast.makeText(HomeActivity.this,
                    "List title:  " + notice.getName(),
                    Toast.LENGTH_LONG).show();

        }
    };
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}