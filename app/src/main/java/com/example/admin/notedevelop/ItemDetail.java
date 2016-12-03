package com.example.admin.notedevelop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;

public class ItemDetail extends AppCompatActivity {
private EditText editText;
    private ToDoDocument toDoDocument;
private ArrayList<ToDoDocument>arrayList;
    private int typeResalt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_item_detail);
        editText = (EditText)findViewById(R.id.editText_detail);
        arrayList =AppContex.getToDoDocuments();
        typeResalt = getIntent().getExtras().getInt(AppContex.ACTION_TYPE);

        prepareDocument(typeResalt);
        setTitle(toDoDocument.getName());
    }
private void prepareDocument(int typeResalt){
    switch (typeResalt){
        case AppContex.NEW_DOCUMENT:{
            toDoDocument = new ToDoDocument();
        }
        break;
        case AppContex.DOCUMENT_UPDATE:{
            typeResalt = getIntent().getExtras().getInt(AppContex.DOC_INDEX);
            toDoDocument = arrayList.get(typeResalt);
            editText.setText(toDoDocument.getContent());
        }
        break;
        default:
            break;
    }
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_detail_actyvity , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save:{
arrayList.add(toDoDocument);
                finish();
                return true;
            }
            case R.id.delete:{

                return true;
            }
            case R.id.back:{
                finish();
            }
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
