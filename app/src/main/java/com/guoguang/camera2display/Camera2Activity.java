package com.guoguang.camera2display;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;

public class Camera2Activity extends AppCompatActivity {
    private Camera2Helper camera2Helper;
    private File file;
    private AutoFitTextureView textureView;

    private static final String PHOTO_PATH= Environment.getExternalStorageDirectory().getPath();
    private static final String PHOTO_NAME="camera2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera2);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        camera2Helper.startCameraPreview();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        camera2Helper.onDestoryHelper();
    }

    private void init(){
        textureView=(AutoFitTextureView)findViewById(R.id.textureView);
        file=new File(PHOTO_PATH,PHOTO_NAME+".jpg");
        camera2Helper=Camera2Helper.getInstace(Camera2Activity.this,textureView,file,this);
    }

}
