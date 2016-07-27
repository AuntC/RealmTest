package com.example.guocheng.realm.action;

import com.example.guocheng.realm.bean.Person;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by guocheng on 16-7-26.
 */
public class QueryAction implements RealmAction {

    @Override
    public void action(Realm realm) {
        RealmResults<Person> realmResults = realm.where(Person.class).equalTo("age", 18).findAll();

        //1.查询通过RealmQuery来生成结果
        //2.RealmQuery支持链式操作

        //初始化生成RealmQuery的方式有:
        realm.where(Person.class);//该方法与RealmQuery.createQuery()本质是一样的

        RealmQuery.createQuery(realm, Person.class);
        RealmQuery.createDynamicQuery(null, "Person");
        RealmQuery.createQueryFromResult(realmResults);
        RealmQuery.createQueryFromList(null);

        RealmQuery realmQuery = realm.where(Person.class);

        //RealmQuery支持的链式操作有
        realmQuery
                .equalTo("age", 18).notEqualTo("age", 18)
                .greaterThan("age", 18).greaterThanOrEqualTo("age", 18)
                .lessThan("age", 18).lessThanOrEqualTo("age", 18)
                .contains("name", "a")
                .or().not()
                .beginsWith("name", "a").endsWith("name", "a")
                .beginGroup().endGroup()
                .between("age", 10, 12)
                .isNull("name").isNotNull("name").isEmpty("name").isNotEmpty("name");

        //RealmQuery支持的结果操作
        realmQuery.findAll();
        realmQuery.findAllAsync();
        realmQuery.distinct("name");
        realmQuery.distinctAsync("name");
        realmQuery.findAllSorted("name");
        realmQuery.findAllSortedAsync("name");
        realmQuery.findFirst();
        realmQuery.findFirstAsync();
    }
}
