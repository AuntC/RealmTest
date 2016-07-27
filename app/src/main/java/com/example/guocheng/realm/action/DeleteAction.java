package com.example.guocheng.realm.action;

import com.example.guocheng.realm.bean.Person;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by guocheng on 16-7-26.
 */
public class DeleteAction implements RealmAction {
    @Override
    public void action(Realm realm) {
        //删除方法 1 删除一张或者多张表
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //删除Person表
                realm.delete(Person.class);
                //删除全部表
                realm.deleteAll();
            }
        });

        //删除方法2 RealmResults/RealmObject查询结果中删除数据
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //RealmResults删除
                RealmResults<Person> realmResults = realm.where(Person.class).equalTo("age", 18).findAll();
                realmResults.deleteFirstFromRealm();
                realmResults.deleteLastFromRealm();
                realmResults.deleteAllFromRealm();
                realmResults.deleteFromRealm(1);
                //RealmObject删除
                realmResults.get(0).deleteFromRealm();
            }
        });
    }
}
