package com.study.zxingdemo.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.study.zxingdemo.R;
import com.uuzuche.lib_zxing.activity.CodeUtils;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        final int type = getIntent().getIntExtra("type", 0);
        Button btn = (Button) findViewById(R.id.btn_create);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = ((EditText)findViewById(R.id.et_key)).getText().toString();
                if (key == null || key.equals("")) {
                    Toast.makeText(CreateActivity.this, "您的输入为空!", Toast.LENGTH_SHORT).show();
                    return;
                }
                ((EditText)findViewById(R.id.et_key)).setText("");

                ImageView iv = (ImageView) findViewById(R.id.iv_result);
                Bitmap bitmap = null;
                if(type == 0){
                    bitmap = CodeUtils.createImage(key, 400, 400, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                    iv.setImageBitmap(bitmap);
                }else{
                    bitmap = CodeUtils.createImage(key, 400, 400, null);
                    iv.setImageBitmap(bitmap);
                }
            }
        });
    }
}
