package io.picchi.tokei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ChoiceActivity extends AppCompatActivity {

    public void LastActivity(View v) {
        Intent intent = new Intent(this, LastActivity.class);
        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        // ListViewに表示する項目を生成
        ArrayList<String> noodleList = new ArrayList<>();

        noodleList.add("そば");
        noodleList.add("うどん");
        noodleList.add("そうめん");
        noodleList.add("パスタ");
        noodleList.add("ラーメン");
        noodleList.add("ペンネ");

        /**
         * Adapterを生成
         * android.R.layout.simple_list_item_single_choice : 単一選択可能なレイアウト。今回はAndroid標準のレイアウトを使用。
         * noodleList : Adapterのコンストラクタの引数としてListViewに表示する項目のリストを渡す。
         */
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, noodleList);

        // idがlistのListViewを取得
        ListView listView = (ListView) findViewbyid(R.id.list);
        listView.setAdapter(arrayAdapter);

    }
}

