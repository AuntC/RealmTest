package com.example.guocheng.realm.action;

import com.example.guocheng.realm.bean.Person;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import io.realm.Realm;

/**
 * Created by guocheng on 16-7-26.
 */
public class CreateAction implements RealmAction {

    @Override
    public void action(Realm realm) {
        //增方法 1 createObject
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //通过该方法创建的person处于unmanaged状态
                Person person = realm.createObject(Person.class);
                person.setName("A");
                person.setAge(8);
            }
        });

        //增方法 2 copyToRealm
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //person处于unmanaged状态
                Person person = new Person();
                person.setName("B");
                person.setAge(18);
                Person realmPerson = realm.copyToRealm(person);
                //realmPerson处于managed状态
            }
        });

        //增方法 3 createObjectFromJson/createAllFromJson
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                String jsonString = "";
                InputStream is = null;
                JSONObject jsonObject = null;
                JSONArray jsonArray = null;

                /*************  createObjectFromJson  ****************/
                realm.createObjectFromJson(Person.class, jsonString);
                try {
                    realm.createObjectFromJson(Person.class, is);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                realm.createObjectFromJson(Person.class, jsonObject);

                /*************  createAllFromJson  ****************/
                realm.createAllFromJson(Person.class, jsonString);
                try {
                    realm.createAllFromJson(Person.class, is);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                realm.createAllFromJson(Person.class, jsonArray);
            }
        });
    }
}
