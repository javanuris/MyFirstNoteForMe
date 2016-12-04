package com.example.admin.notedevelop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class ItemDetail extends AppCompatActivity {
    private EditText editText;
    private ToDoDocument toDoDocument;
    private ArrayList<ToDoDocument>arrayList;

    public static final int LENGHT_SIZE = 20;

    private int typeResalt;
    private int docIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_item_detail);
        editText = (EditText)findViewById(R.id.editText_detail);
        arrayList =AppContex.getToDoDocuments();
        typeResalt = getIntent().getExtras().getInt(AppContex.ACTION_TYPE);

        prepareDocument(typeResalt);
        setTitle(toDoDocument.getName());
        editText.setText(toDoDocument.getContent());
    }
private void prepareDocument(int typeResalt){
    switch (typeResalt){
        case AppContex.NEW_DOCUMENT:{
            toDoDocument = new ToDoDocument();
        }
        break;
        case AppContex.DOCUMENT_UPDATE:{
           docIndex = getIntent().getExtras().getInt(AppContex.DOC_INDEX);
            toDoDocument = arrayList.get(typeResalt);

        }
        break;
        default:
            break;
    }
}

    private String getDocumentName(){
StringBuilder sb = new StringBuilder(editText.getText());
        if(sb.length() >LENGHT_SIZE){
            sb.delete(LENGHT_SIZE , sb.length()).append("...");
        }
        String tmpName = sb.toString().trim().split("\n")[0];
        String name = (tmpName.length()> 0)?tmpName:"New Doc";
        return name;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_detail_actyvity, menu);
        return true;
    }
    private void save(){
        toDoDocument.setName(getDocumentName());
        if(typeResalt == AppContex.NEW_DOCUMENT){
            arrayList.add(toDoDocument);
        }
        else if(typeResalt == AppContex.DOCUMENT_UPDATE){
            if(editText.getText().toString().trim().equals(toDoDocument.getContent())){
                finish();
                return;
            }
        }
        toDoDocument.setDate(new Date());
        toDoDocument.setContent(editText.getText().toString().trim());
        Collections.sort(arrayList);
        updateIndexes();
        finish();
    }
    private void delete(){
        if(typeResalt == AppContex.DOCUMENT_UPDATE) {
            arrayList.remove(docIndex);
updateIndexes();
        }
        finish();
    }
    private void updateIndexes(){
        int i = 0;
        for(ToDoDocument doc : arrayList){
            doc.setNumber(i++);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save:{
                save();

                return true;
            }
            case R.id.delete:{
            delete();
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
