package io.picchi.tokei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import io.realm.Realm;

public class CreateActivity extends AppCompatActivity {

    //Realm型の変数を宣言
    public Realm realm;


    //EditText型の変数を宣言
    public EditText titleEditText;
    public EditText contentEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        //realmを開く
        realm = Realm.getDefaultInstance();

        //関連付け
        titleEditText = (EditText) findViewById(R.id.titleEditText);
        contentEditText = (EditText) findViewById(R.id.contentEditText);

    }

    //データをRealmに保存
    public void save(final String title, final String updateDate, final String content){

        //メモを保存する
        realm.executeTransaction(new Realm.Transaction(){
            @Override
            public void execute(Realm beRealm){
                Memo memo = realm.createObject(Memo.class);
                memo.title = title;
                memo.updateDate = updateDate;
                memo.content = content;

            }
        });

    }

    //EditTextに入力されたデータをもとにMemoをを作る
    public void create(View view) {
        //タイトルを取得
        String title = titleEditText.getText().toString();

        //日ずけを取得
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss", Locale.JAPANESE);
        String updateDate = sdf.format(date);

        //内容を取得
        String content = contentEditText.getText().toString();

        //出力して見る
        check(title, updateDate, content);

        //保存する
        save(title,updateDate,content);

        //画面を終了
        finish();

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        //realmを閉じる
        realm.close();
    }

    private void check(String title, String updateDate, String content) {

        //Memoクラスにインスタンスを生成する
        Memo memo = new Memo();

        //それぞれの要素を代入する
        memo.title = title;
        memo.updateDate = updateDate;
        memo.content = content;

        //ログに出して見る
        Log.d("Memo", memo.title);
        Log.d("Memo", memo.updateDate);
        Log.d("Memo", memo.content);


    }

    @Deprecated
    protected void onResume() {
        super.onResume();
    }




}
