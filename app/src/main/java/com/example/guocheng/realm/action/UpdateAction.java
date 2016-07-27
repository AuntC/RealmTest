package com.example.guocheng.realm.action;

import com.example.guocheng.realm.bean.Person;

import io.realm.Realm;

/**
 * Created by guocheng on 16-7-26.
 */
public class UpdateAction implements RealmAction {
    @Override
    public void action(Realm realm) {

        //对于Managed Object

        // Find the first person (no query conditions) and read a field
        final Person person = realm.where(Person.class).findFirst();
        // Update person in a transaction
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                person.setName("Senior Person");
                person.setAge(99);
            }
        });

        //对于unManaged Object
        Person unManagedPerson = new Person();
        unManagedPerson.setName("unManagedPerson");
        unManagedPerson.setAge(10);
        realm.copyToRealm(unManagedPerson);
        //必须要有主键
        realm.copyToRealmOrUpdate(unManagedPerson);
    }
}
