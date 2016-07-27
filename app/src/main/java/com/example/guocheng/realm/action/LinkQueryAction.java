package com.example.guocheng.realm.action;

import com.example.guocheng.realm.bean.Person;

import io.realm.Realm;

/**
 * Created by guocheng on 16-7-26.
 * 最简单的多表查询
 */
public class LinkQueryAction implements RealmAction {
    @Override
    public void action(Realm realm) {
        realm.where(Person.class).equalTo("dog.name", "Lucky").findFirst();
    }
}
