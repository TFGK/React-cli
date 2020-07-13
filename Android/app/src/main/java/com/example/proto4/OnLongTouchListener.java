package com.example.proto4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class OnLongTouchListener implements View.OnLongClickListener{
    Intent intent;
    SpeechRecognizer mRecognizer;
    String resultStr;
    boolean isListening;

    public OnLongTouchListener (Context ctx) {
        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        //음성 인식을위한 음성 인식기의 의도에 사용되는 여분의 키입니다.
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,ctx.getPackageName());
        //음성을 번역할 언어를 설정합니다.
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"ko-KR");

        mRecognizer= SpeechRecognizer.createSpeechRecognizer(ctx);
    }

    @Override
    public boolean onLongClick(View v) {
        Log.e("@@@@@@@","롱클릭");
        mRecognizer.setRecognitionListener(listener);
        mRecognizer.startListening(intent);
        isListening = true;
        return true;
    }

    private RecognitionListener listener = new RecognitionListener() {
        @Override
        public void onReadyForSpeech(Bundle params) {
            Log.e("------","onReadyForSpeech");
        }

        @Override
        public void onBeginningOfSpeech() {
            Log.e("------","onBeginningOfSpeech");
        }

        @Override
        public void onRmsChanged(float rmsdB) {

        }

        @Override
        public void onBufferReceived(byte[] buffer) {

        }

        @Override
        public void onEndOfSpeech() {
            Log.e("------","onEndOfSpeech");
        }

        @Override
        public void onError(int error) {
            String message;

            switch (error) {
                case SpeechRecognizer.ERROR_AUDIO:
                    message = "오디오 에러";
                    break;
                case SpeechRecognizer.ERROR_CLIENT:
                    message = "클라이언트 에러";
                    break;
                case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                    message = "퍼미션 없음";
                    break;
                case SpeechRecognizer.ERROR_NETWORK:
                    message = "네트워크 에러";
                    break;
                case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                    message = "네트웍 타임아웃";
                    break;
                case SpeechRecognizer.ERROR_NO_MATCH:
                    message = "찾을 수 없음";
                    break;
                case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                    message = "RECOGNIZER가 바쁨";
                    break;
                case SpeechRecognizer.ERROR_SERVER:
                    message = "서버가 이상함";
                    break;
                case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                    message = "말하는 시간초과";
                    break;
                default:
                    message = "알 수 없는 오류임";
                    break;
            }
            Log.e("------", "error: "+message);
        }

        @Override
        public void onResults(Bundle results) {
            if(isListening){
                Log.e("------","onResults");
                // 아래 코드는 음성인식된 결과를 ArrayList로 모아옵니다.
                ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

                // 이후 for문으로 textView에 setText로 음성인식된 결과를 수정해줍니다.
                for(int i = 0; i < matches.size() ; i++){
                    Log.e("------", matches.get(i));
                }

                resultStr = matches.get(0).trim();
                speeched();
                isListening = false;
            }
        }

        @Override
        public void onPartialResults(Bundle partialResults) {

        }

        @Override
        public void onEvent(int eventType, Bundle params) {

        }
    };

    public void speeched(){}
}
