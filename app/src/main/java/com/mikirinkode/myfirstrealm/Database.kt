package com.mikirinkode.myfirstrealm

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

object Database {


    fun getDatabase(): Realm {
        val config = RealmConfiguration.create(schema = setOf(User::class))
        val realm: Realm = Realm.open(config)

        return realm
    }
}