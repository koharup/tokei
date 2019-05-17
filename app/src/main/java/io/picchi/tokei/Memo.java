package io.picchi.tokei;

import io.realm.Realm;
import io.realm.RealmObject;

public class Memo extends RealmObject {
    //タイトル
    public String title;
    //日づけ
    public String updateDate;
    //内容
    public String content;

}
