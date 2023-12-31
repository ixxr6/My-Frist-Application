package com.jnu.student;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class BookItemDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_item_detail);
        Intent intent = getIntent();
        if(intent != null){
            String name = intent.getStringExtra("name");

            if(null != name ){
                intent.getIntExtra("position", -1);
                EditText editTextItemName= findViewById(R.id.edittext_item_name);
                editTextItemName.setText(name);
            }
        }
        Button buttonOk= findViewById(R.id.button_item_details_ok);

        buttonOk.setOnClickListener(v -> {
            Intent intent1 = new Intent();
            EditText editTextItemName= findViewById(R.id.edittext_item_name);

            intent1.putExtra( "name" , editTextItemName.getText().toString());
            setResult(Activity.RESULT_OK, intent1) ;

            BookItemDetailActivity.this.finish();
        });
    }
}