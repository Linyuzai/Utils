package com.linyuzai.util.tts;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;

import com.linyuzai.util.App;

import java.util.HashMap;
import java.util.Locale;

/**
 * you need install xunfei+ before
 * Created by Administrator on 2016/6/19 0019.
 */
@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
public class XSpeaker extends UtteranceProgressListener implements
        TextToSpeech.OnInitListener {

    public static final String TAG = "XSpeaker";
    public static final String ENGINE = "com.iflytek.speechcloud";
    private TextToSpeech speech;
    private HashMap<String, String> map = new HashMap<>();
    private OnSpeakListener listener;

    /**
     * you need App.bind() before
     */
    public XSpeaker() {
        this(App.checkNull(App.getContext()));
    }

    public XSpeaker(Context context) {
        // TODO Auto-generated constructor stub
        speech = new TextToSpeech(context, this, ENGINE);
        speech.setOnUtteranceProgressListener(this);
    }

    public void setOnSpeakListener(
            OnSpeakListener listener) {
        this.listener = listener;
    }

    public int speak(String text) {
        return speech.speak(text, TextToSpeech.QUEUE_FLUSH, map);
    }

    public void release() {
        speech.shutdown();
    }

    @Override
    public void onInit(int status) {
        // TODO Auto-generated method stub
        if (status == TextToSpeech.SUCCESS) {
            // 设置朗读语言
            int supported = speech.setLanguage(Locale.CHINA);
            map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "UniqueID");
            if ((supported != TextToSpeech.LANG_AVAILABLE)
                    && (supported != TextToSpeech.LANG_COUNTRY_AVAILABLE)) {
                Log.w(TAG, "chinese is not supported");
            }
        }
    }

    @Override
    public void onStart(String utteranceId) {
        // TODO Auto-generated method stub
        if (listener != null)
            listener.onStart();
    }

    @Override
    public void onDone(String utteranceId) {
        // TODO Auto-generated method stub
        if (listener != null)
            listener.onFinish();
    }

    @Override
    public void onError(String utteranceId) {
        // TODO Auto-generated method stub
        if (listener != null)
            listener.onError();
    }

    public interface OnSpeakListener {
        void onStart();

        void onFinish();

        void onError();
    }
}
