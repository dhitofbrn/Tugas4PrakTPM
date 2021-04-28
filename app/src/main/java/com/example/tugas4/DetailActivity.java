package com.example.tugas4;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    TextView tvName, tvPreview;
    ImageView ivPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivPhoto = findViewById(R.id.det_photo);
        tvName = findViewById(R.id.det_name);
        tvPreview = findViewById(R.id.det_preview);

        getIncomingExtra();
    }

    private void getIncomingExtra(){
        if (getIntent().hasExtra("photo") && getIntent().hasExtra("name") && getIntent().hasExtra("preview")){
            int photoPlayer = getIntent().getIntExtra("photo", 0);
            String namePlayer = getIntent().getStringExtra("name");
            String previewPlayer = getIntent().getStringExtra("preview");

            setDataActivity(photoPlayer, namePlayer, previewPlayer);
        }
    }

    private void setDataActivity(int photoPlayer, String namePlayer, String previewPlayer){
        Glide.with(this).asBitmap().load(photoPlayer).into(ivPhoto);
        tvName.setText(namePlayer);
        tvPreview.setText(previewPlayer);
    }
}