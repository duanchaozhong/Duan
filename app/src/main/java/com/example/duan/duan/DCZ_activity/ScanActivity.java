package com.example.duan.duan.DCZ_activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.example.duan.duan.DCZ_util.StatusBarUtil;
import com.example.duan.duan.R;
import com.example.duan.duan.zxing_code.camera.CameraManager;
import com.example.duan.duan.zxing_code.decoding.CaptureActivityHandler;
import com.example.duan.duan.zxing_code.decoding.InactivityTimer;
import com.example.duan.duan.zxing_code.view.ViewfinderView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

import java.io.IOException;
import java.util.Vector;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 *  扫码验证
 *
 * */
public class ScanActivity extends BaseActivity implements SurfaceHolder.Callback{
    public static CaptureActivityHandler handler;
    private ViewfinderView viewfinderView;
    private boolean hasSurface;
    private static Vector<BarcodeFormat> decodeFormats;
    private static String characterSet;
    private InactivityTimer inactivityTimer;
    private MediaPlayer mediaPlayer;
    private boolean playBeep;
    private static final float BEEP_VOLUME = 0.10f;
    private boolean vibrate;
    private static SurfaceView surfaceView;
    private static ScanActivity INSTANCE;
    public static Dialog dialog;

    @BindView(R.id.back)
    View back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        ButterKnife.bind(this);
        INSTANCE = this;
        CameraManager.init(INSTANCE);
        setViews();
        setListener();
    }


    /**
     *  数据初始化
     * */
    private void setViews() {
        viewfinderView = (ViewfinderView) findViewById(R.id.capture_viewfinder);
        hasSurface = false;
        inactivityTimer = new InactivityTimer(INSTANCE);
    }
    /**
     * 监听
     *
     * */
    private void setListener() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        surfaceView = (SurfaceView) findViewById(R.id.capture_preview);
        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        decodeFormats = null;
        characterSet = null;
        if (hasSurface) {
            initCamera(surfaceHolder);
        } else {
            surfaceHolder.addCallback(INSTANCE);
            surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        }
        playBeep = true;
        AudioManager audioService = (AudioManager) getSystemService(AUDIO_SERVICE);
        if (audioService.getRingerMode() != AudioManager.RINGER_MODE_NORMAL) {
            playBeep = false;
        }
        initBeepSound();
        vibrate = true;
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (handler != null) {
            handler.quitSynchronously();
            handler = null;
        }
        CameraManager.get().closeDriver();
    }

    @Override
    protected void onDestroy() {
        inactivityTimer.shutdown();
        super.onDestroy();
    }


    public void handleDecode(Result result, Bitmap barcode) {
        inactivityTimer.onActivity();
        String resultString = result.getText();
        getTicketInfo(resultString);
//        if (resultString.startsWith("meiyu://")) {
//            resultString = resultString.substring(8);
//            getTicketInfo(resultString);
//            initCamera(surfaceView.getHolder());
//            if (handler != null) {
//                handler.restartPreviewAndDecode();
//            }
//
//        } else {
//            Toast.makeText(INSTANCE, "非美寓有效二维码！", Toast.LENGTH_LONG).show();
//            SurfaceHolder surfaceHolder = surfaceView.getHolder();
//            initCamera(surfaceHolder);
//            if (handler != null)
//                handler.restartPreviewAndDecode();
//        }
    }

    private static void initCamera(SurfaceHolder surfaceHolder) {
        try {
            CameraManager.get().openDriver(surfaceHolder);
        } catch (IOException ioe) {
            return;
        } catch (RuntimeException e) {
            return;
        }
        if (handler == null) {
            handler = new CaptureActivityHandler(INSTANCE, decodeFormats,
                    characterSet);
        }
    }

    private void initBeepSound() {
        if (playBeep && mediaPlayer == null) {
            // The volume on STREAM_SYSTEM is not adjustable, and users found it
            // too loud,
            // so we now play on the music stream.
            setVolumeControlStream(AudioManager.STREAM_MUSIC);
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnCompletionListener(beepListener);

//            AssetFileDescriptor file = getResources().openRawResourceFd(
//                    R.raw.beep);
//            try {
//                mediaPlayer.setDataSource(file.getFileDescriptor(),
//                        file.getStartOffset(), file.getLength());
//                file.close();
//                mediaPlayer.setVolume(BEEP_VOLUME, BEEP_VOLUME);
//                mediaPlayer.prepare();
//            } catch (IOException e) {
//                mediaPlayer = null;
//            }
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.i("holder==null?", holder + "");
        if (!hasSurface) {
            hasSurface = true;
            initCamera(holder);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        hasSurface = false;
    }

    public ViewfinderView getViewfinderView() {
        return viewfinderView;
    }

    public Handler getHandler() {
        return handler;
    }

    public void drawViewfinder() {
        viewfinderView.drawViewfinder();

    }

    private static final long VIBRATE_DURATION = 200L;

    private void playBeepSoundAndVibrate() {
        if (playBeep && mediaPlayer != null) {
            mediaPlayer.start();
        }
        if (vibrate) {
            Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            vibrator.vibrate(VIBRATE_DURATION);
        }
    }

    /**
     * When the beep has finished playing, rewind to queue up another one.
     */
    private final MediaPlayer.OnCompletionListener beepListener = new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo(0);
        }
    };


    private enum State {
        PREVIEW,
        SUCCESS,
        DONE
    }

    private String serial;

    private void getTicketInfo(String serial) {
        this.serial = serial;
        Log.i("yc","扫二维码结果是："+serial);
        if(serial!=null){
            if(serial.contains("indoor")){
//                Intent intent=new Intent(INSTANCE,RoomCyclingActivity.class);
//                startActivity(intent);
                //室内骑行
                bindBike(serial.substring(serial.lastIndexOf(":")+1));

            }else if(serial.contains("outdoor")){
                //添加车辆
                addBike(serial);

            }else if (serial.contains("US")) {
                //添加好友s
                toUserInfo((Integer.parseInt(serial.substring(serial.lastIndexOf(":")+1))-100000));
            }else if(serial.contains("qz")) {
                //扫码充值
                String user_id = serial.substring(serial.lastIndexOf(":") + 1);

            }
        }

    }

    private void bindBike(String code){

    }

    private void addBike(String code){

    }


    private void toUserInfo(int code){

    }
}
