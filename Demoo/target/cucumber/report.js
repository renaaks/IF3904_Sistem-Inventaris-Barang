$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/mycompany/demoo/test/DemooTest.feature");
formatter.feature({
  "comments": [
    {
      "line": 2,
      "value": "# language: id"
    }
  ],
  "line": 4,
  "name": "Mengelola User",
  "description": "     Mengelola data user",
  "id": "mengelola-user",
  "keyword": "Fitur"
});
formatter.scenario({
  "line": 8,
  "name": "Memasukan User Baru",
  "description": "",
  "id": "mengelola-user;memasukan-user-baru",
  "type": "scenario",
  "keyword": "Skenario",
  "tags": [
    {
      "line": 7,
      "name": "@Normal"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "Data user baru yang akan dimasukan tersedia dan tidak duplikasi",
  "keyword": "Dengan "
});
formatter.step({
  "line": 10,
  "name": "Memasukan data user",
  "keyword": "Ketika "
});
formatter.step({
  "line": 11,
  "name": "respon \"user sukses dimasukan\"",
  "keyword": "Maka "
});
formatter.match({
  "location": "DemoContext.data_user_baru_yang_akan_dimasukan_tersedia_dan_tidak_duplikasi()"
});
formatter.result({
  "duration": 101310420,
  "status": "passed"
});
formatter.match({
  "location": "DemoContext.memasukan_data_user()"
});
formatter.result({
  "duration": 28840,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "user sukses dimasukan",
      "offset": 8
    }
  ],
  "location": "DemoContext.respon(String)"
});
formatter.result({
  "duration": 3181037,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Memasukan User Baru",
  "description": "",
  "id": "mengelola-user;memasukan-user-baru",
  "type": "scenario",
  "keyword": "Skenario",
  "tags": [
    {
      "line": 13,
      "name": "@Duplikat"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "Data user baru yang akan dimasukan tersedia dan tidak duplikasi",
  "keyword": "Dengan "
});
formatter.step({
  "line": 16,
  "name": "Memasukan data user",
  "keyword": "Ketika "
});
formatter.step({
  "line": 17,
  "name": "respon gagal dengan pesan \"duplicate\"",
  "keyword": "Maka "
});
formatter.match({
  "location": "DemoContext.data_user_baru_yang_akan_dimasukan_tersedia_dan_tidak_duplikasi()"
});
formatter.result({
  "duration": 37925,
  "status": "passed"
});
formatter.match({
  "location": "DemoContext.memasukan_data_user()"
});
formatter.result({
  "duration": 28049,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "duplicate",
      "offset": 27
    }
  ],
  "location": "DemoContext.respon_gagal_dengan_pesan(String)"
});
formatter.result({
  "duration": 81382,
  "status": "passed"
});
formatter.uri("com/mycompany/demoo/test/Login.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# language : id"
    }
  ],
  "line": 3,
  "name": "Melakukan Login",
  "description": "     Memasukkan data username dan password",
  "id": "melakukan-login",
  "keyword": "Fitur"
});
formatter.scenario({
  "line": 7,
  "name": "Memasukan Informasi username dan password",
  "description": "",
  "id": "melakukan-login;memasukan-informasi-username-dan-password",
  "type": "scenario",
  "keyword": "Skenario",
  "tags": [
    {
      "line": 6,
      "name": "@Normal"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "Data username dan password akan dimasukan tersedia dan sesuai",
  "keyword": "Dengan "
});
formatter.step({
  "line": 9,
  "name": "Memasukan data username dan password",
  "keyword": "Ketika "
});
formatter.step({
  "line": 10,
  "name": "respon login \"anda telah berhasil login\"",
  "keyword": "Maka "
});
formatter.match({
  "location": "DemoContext.data_username_dan_password_akan_dimasukan_tersedia_dan_sesuai()"
});
formatter.result({
  "duration": 78222,
  "status": "passed"
});
formatter.match({
  "location": "DemoContext.memasukan_data_username_dan_password()"
});
formatter.result({
  "duration": 53334,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "anda telah berhasil login",
      "offset": 14
    }
  ],
  "location": "DemoContext.respon_login(String)"
});
formatter.result({
  "duration": 76642,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Memasukan Memasukan Informasi username dan password",
  "description": "",
  "id": "melakukan-login;memasukan-memasukan-informasi-username-dan-password",
  "type": "scenario",
  "keyword": "Skenario",
  "tags": [
    {
      "line": 12,
      "name": "@Gagal"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "Data username dan password yang akan dimasukan tidak tersedia",
  "keyword": "Dengan "
});
formatter.step({
  "line": 15,
  "name": "Memasukan data username dan password",
  "keyword": "Ketika "
});
formatter.step({
  "line": 16,
  "name": "respon login gagal dengan pesan \"username dan password tidak terdaftar\"",
  "keyword": "Maka "
});
formatter.match({
  "location": "DemoContext.data_username_dan_password_yang_akan_dimasukan_tidak_tersedia()"
});
formatter.result({
  "duration": 48988,
  "status": "passed"
});
formatter.match({
  "location": "DemoContext.memasukan_data_username_dan_password()"
});
formatter.result({
  "duration": 27259,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "username dan password tidak terdaftar",
      "offset": 33
    }
  ],
  "location": "DemoContext.respon_login_gagal_dengan_pesan(String)"
});
formatter.result({
  "duration": 84149,
  "status": "passed"
});
formatter.uri("com/mycompany/demoo/test/Mengelolabarang.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# language : id"
    }
  ],
  "line": 3,
  "name": "Mengelola barang",
  "description": "     Mengelola data barang",
  "id": "mengelola-barang",
  "keyword": "Fitur"
});
formatter.scenario({
  "line": 7,
  "name": "Mengelola Data Barang Baru",
  "description": "",
  "id": "mengelola-barang;mengelola-data-barang-baru",
  "type": "scenario",
  "keyword": "Skenario",
  "tags": [
    {
      "line": 6,
      "name": "@Normal"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "Data barang yang akan dimasukkan tersedia dan tidak duplikasi",
  "keyword": "Dengan "
});
formatter.step({
  "line": 9,
  "name": "Memasukkan data barang",
  "keyword": "Ketika "
});
formatter.step({
  "line": 10,
  "name": "respon menjadi \"data barang sukses dimasukan\"",
  "keyword": "Maka "
});
formatter.match({
  "location": "DemoContext.data_barang_yang_akan_dimasukkan_tersedia_dan_tidak_duplikasi()"
});
formatter.result({
  "duration": 56889,
  "status": "passed"
});
formatter.match({
  "location": "DemoContext.memasukkan_data_barang()"
});
formatter.result({
  "duration": 33186,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "data barang sukses dimasukan",
      "offset": 16
    }
  ],
  "location": "DemoContext.respon_menjadi(String)"
});
formatter.result({
  "duration": 95210,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Mengelola Data Barang Baru",
  "description": "",
  "id": "mengelola-barang;mengelola-data-barang-baru",
  "type": "scenario",
  "keyword": "Skenario",
  "tags": [
    {
      "line": 12,
      "name": "@Duplikat"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "Data barang baru yang akan dimasukkan tersedia dan tidak duplikasi",
  "keyword": "Dengan "
});
formatter.step({
  "line": 15,
  "name": "Memasukkan data barang",
  "keyword": "Ketika "
});
formatter.step({
  "line": 16,
  "name": "respon akan gagal dengan pesan \"duplikat\"",
  "keyword": "Maka "
});
formatter.match({
  "location": "DemoContext.data_barang_baru_yang_akan_dimasukkan_tersedia_dan_tidak_duplikasi()"
});
formatter.result({
  "duration": 87704,
  "status": "passed"
});
formatter.match({
  "location": "DemoContext.memasukkan_data_barang()"
});
formatter.result({
  "duration": 155259,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "duplikat",
      "offset": 32
    }
  ],
  "location": "DemoContext.respon_akan_gagal_dengan_pesan(String)"
});
formatter.result({
  "duration": 89679,
  "status": "passed"
});
});