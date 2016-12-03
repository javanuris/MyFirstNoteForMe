package com.example.admin.notedevelop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] arr = {"1", "2" , "3"};
    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.main_list_view);
        arrayAdapter = new ArrayAdapter<String>(MainActivity.this ,R.layout.list_item_shower , arr );
        listView.setAdapter(arrayAdapter);
    }

    private void openItemWhichChosen(){
        Intent intent = new Intent(this ,ItemDetail.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_activity , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
switch (item.getItemId()){
    case R.id.add:{
openItemWhichChosen();
        return true;
    }
    default:
        break;
}
        return super.onOptionsItemSelected(item);
    }
}
