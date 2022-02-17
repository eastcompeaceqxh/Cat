package com.xinghai.kotlin.catio.data

/*
    "petID":1,
    "name":"埃及猫",
    "engName":"Egyptian Mau",
    "price":"",
    "coverURL":"http://img.boqiicdn.com/Data/BK/P/img99961410946559.jpg"
 */
data class Cat (
    var petID: String,
    var name: String,
    var engName: String,
    var price: String,
    var coverURL: String)