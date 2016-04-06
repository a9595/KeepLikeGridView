package edu.tieorange.keeplikegridview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mUiRecyclerView;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private TravelListAdapter mAdapter;
    private boolean isGrid = false;
    private EditText mUiIP1;
    private EditText mUiIP2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // setup list:
        mUiRecyclerView = (RecyclerView) findViewById(R.id.main_list);
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mUiRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);

        // setup edit text (ip)
        mUiIP1 = (EditText) findViewById(R.id.main_ip1);
        mUiIP2 = (EditText) findViewById(R.id.main_ip2);

        mUiIP1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() >= 3){
                    // TODO: focus on the next edit text
                    mUiIP2.requestFocus();
                }
            }
        });


        // setup adapter:
        mAdapter = new TravelListAdapter(this);
        mUiRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_show_as_grid) {
            toggleGridList();
        }

        return super.onOptionsItemSelected(item);
    }

    private void toggleGridList() {
        if (isGrid) { // Grid
            mStaggeredGridLayoutManager.setSpanCount(1);
            isGrid = false;
        } else { // List
            mStaggeredGridLayoutManager.setSpanCount(2);
            isGrid = true;
        }
    }
}
