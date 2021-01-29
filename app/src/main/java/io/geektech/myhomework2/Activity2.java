package io.geektech.myhomework2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    ImageView imageView;
    EditText editText;
    public static final String KEY_TEXT = "txtKey";
    public static final String KEY_IMG = "imgKey";
    private static Uri uri;
    private static String txtUri = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        setTitle("Activity 2");
        init();

    }

    private void init() {
        imageView = findViewById(R.id.imageTwo);
        editText = findViewById(R.id.edit_second);

    }

    public void imgOnClick(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, 1);
    }

    public void sendFirstAct(View view) {
        String text = editText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(KEY_TEXT, text);
        intent.putExtra(KEY_IMG, txtUri);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            uri = data.getData();
            txtUri = uri.toString();
            imageView.setImageURI(uri);
        }

    }
}