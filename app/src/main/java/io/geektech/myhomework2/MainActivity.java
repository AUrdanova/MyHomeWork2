package io.geektech.myhomework2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
            String imgUri;
            String  txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
       textView = findViewById(R.id.txtViewResult);
       imageView = findViewById(R.id.img);

    }

    public void openActivity(View view) {
        Intent intent = new Intent(this, Activity2.class);
        startActivityForResult(intent,1);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK && data != null) {
            imgUri = data.getStringExtra(Activity2.KEY_IMG);
            txt = data.getStringExtra(Activity2.KEY_TEXT);
            imageView.setImageURI(Uri.parse(imgUri));
            textView.setText(txt);
    }
    }

    public void onClickMail(View view) {
        Intent intentGmail = new Intent(Intent.ACTION_VIEW);
        intentGmail.setType("message/rfc822")
                .setData(Uri.parse("mailto:your.email@gmail.com"))
                .putExtra(Intent.EXTRA_EMAIL, "your.email@gmail.com")
                .putExtra(Intent.EXTRA_TEXT, textView.getText().toString())
                .setPackage("com.google.android.gm");
        startActivity(intentGmail);

}
}