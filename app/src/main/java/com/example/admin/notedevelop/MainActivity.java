package com.example.admin.notedevelop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<ToDoDocument> arrayAdapter;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.main_list_view);
        arrayAdapter = new ArrayAdapter<ToDoDocument>(MainActivity.this ,R.layout.list_item_shower ,AppContex.getToDoDocuments());

        listView.setOnItemSelectedListener(new OnClickItem());
        intent = new Intent(this , ItemDetail.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        listView.setAdapter(arrayAdapter);
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
     Bundle bundle = new Bundle();
        bundle.putInt(AppContex.ACTION_TYPE,AppContex.NEW_DOCUMENT);
        intent.putExtras(bundle);
        startActivity(intent);
        return true;
    }
    default:
        break;
}
        return super.onOptionsItemSelected(item);
    }

    class OnClickItem implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Bundle bundle = new Bundle();
            bundle.putInt(AppContex.ACTION_TYPE,AppContex.DOCUMENT_UPDATE);
            bundle.putInt(AppContex.DOC_INDEX,((ToDoDocument)parent.getAdapter().getItem(position)).getNumber());
            intent.putExtras(bundle);
            startActivity(intent);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
