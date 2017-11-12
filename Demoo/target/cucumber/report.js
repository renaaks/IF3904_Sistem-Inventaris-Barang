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
  "duration": 99339062,
  "status": "passed"
});
formatter.match({
  "location": "DemoContext.memasukan_data_user()"
});
formatter.result({
  "duration": 27260,
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
  "duration": 3200395,
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
  "duration": 40692,
  "status": "passed"
});
formatter.match({
  "location": "DemoContext.memasukan_data_user()"
});
formatter.result({
  "duration": 25679,
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
  "duration": 76642,
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
  "duration": 62024,
  "status": "passed"
});
formatter.match({
  "location": "DemoContext.memasukan_data_username_dan_password()"
});
formatter.result({
  "duration": 32000,
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
  "duration": 105877,
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
  "duration": 51753,
  "status": "passed"
});
formatter.match({
  "location": "DemoContext.memasukan_data_username_dan_password()"
});
formatter.result({
  "duration": 28049,
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
  "duration": 59655,
  "status": "passed"
});
});