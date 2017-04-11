package com.study.zxingdemo.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.study.zxingdemo.R;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CaptureFragment;
import com.uuzuche.lib_zxing.activity.CodeUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE = 0x111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_read = (Button) findViewById(R.id.btn_read);
        btn_read.setOnClickListener(this);
        Button btn_read_UI = (Button) findViewById(R.id.btn_read_UI);
        btn_read_UI.setOnClickListener(this);
        Button btn_create = (Button) findViewById(R.id.btn_create);
        btn_create.setOnClickListener(this);
        Button btn_create_logo = (Button) findViewById(R.id.btn_create_logo);
        btn_create_logo.setOnClickListener(this);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        /**
         * 处理二维码扫描结果
         */
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_read:
                //扫描操作
                Intent intentRead = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intentRead, REQUEST_CODE);
                break;
            case R.id.btn_read_UI:
                //扫描操作（自定义Ui）
                Intent intentReadUi = new Intent(MainActivity.this, MyUIActivity.class);
                startActivityForResult(intentReadUi, REQUEST_CODE);
                break;
            case R.id.btn_create:
                //生成不带logo的二维码
                Intent intentCreate = new Intent(MainActivity.this, CreateActivity.class);
                intentCreate.putExtra("type", 0);
                startActivity(intentCreate);

                break;
            case R.id.btn_create_logo:
                //生成带logo的二维码
                Intent intentCreateUn = new Intent(MainActivity.this, CreateActivity.class);
                intentCreateUn.putExtra("type", 1);
                startActivity(intentCreateUn);
                break;
        }
    }
}
