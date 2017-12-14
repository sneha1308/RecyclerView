package recycler.com.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    RvAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view_rv);


       /* Way -1
        //layout manger
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //adapter
        RvAdapter rvAdapter=new RvAdapter(Arrays.asList("Fichis", "H2", "H3", "S1", "S2", "S3", "N1", "N2", "N3"));
        recyclerView.setAdapter(rvAdapter);
        */

        //---or ---

        //Way-2 and best
        buildList(Arrays.asList("H1", "H2", "H3", "S1", "S2", "S3", "N1", "N2", "N3"));


    }


    private void buildList(List<String> list) {
        if (null == recyclerView.getAdapter()) {
            //layout manger
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            //adapter
            rvAdapter = new RvAdapter(list);
            recyclerView.setAdapter(rvAdapter);
        } else {
            rvAdapter.notifyWithNewData(list);
        }
    }
}
