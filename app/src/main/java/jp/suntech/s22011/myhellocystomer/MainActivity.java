package jp.suntech.s22011.myhellocystomer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタン・オブジェクトの用意
        Button btClick = findViewById(R.id.btClick);

        HelloListener listener = new HelloListener();

        btClick.setOnClickListener(listener);

        //クリアボタンであるbuttonオブジェクトを取得
        Button btNameClear = findViewById(R.id.btNameClear);
        btNameClear.setOnClickListener(listener);

        Button btAddressClear = findViewById(R.id.btAddressClear);
        btAddressClear.setOnClickListener(listener);
    }

    //ボタンをクリックしたときのリスナクラス
    private class HelloListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //名前入力欄であるEditTextオブジェクトを取得
            EditText input = findViewById(R.id.etName);
            EditText input2 = findViewById(R.id.etAddressName);
            //メッセージを表示するTextViewオブジェクトを取得
            TextView output = findViewById(R.id.tvOutput);
            TextView output2 = findViewById(R.id.tvOutput2);

            //タップされた画面部分のidのR値を取得
            int id = v.getId();
            //表示ボタンの場合
            if(id == R.id.btClick) {
                String inputStr = input.getText().toString();
                String inputStr2 = input2.getText().toString();
                output.setText(inputStr2 + "にお住いの" + inputStr + "さん、こんにちは！");
            }//クリアボタンの場合
            else if(id == R.id.btNameClear) {
                input.setText("");
                output.setText("");
            }
            else{
                input2.setText("");
                output2.setText("");
            }
        }
    }
}