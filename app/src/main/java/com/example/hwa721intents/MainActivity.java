package com.example.hwa721intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGeo = findViewById(R.id.btnForGeo);
        btnGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);

                EditText editText = findViewById(R.id.search_edit_geo);

                String text = editText.getText().toString().trim();

                try {
                    char ch = text.charAt(0);

                    if (!Character.isLetter(ch)) {
                        Uri uri = Uri.parse("geo:" + text);
                        intent.setData(uri);
                    } else {
                        Uri uri = Uri.parse("geo:?q=" + text);
                        intent.setData(uri);
                    }

                    startActivity(intent);

                }catch (StringIndexOutOfBoundsException e) {
                    Toast.makeText(MainActivity.this, "Заполните строку", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}
