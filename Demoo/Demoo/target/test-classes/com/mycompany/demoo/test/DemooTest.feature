
# language: id

Fitur: Mengelola User
       Mengelola data user

       @Normal
       Skenario: Memasukan User Baru
                Dengan Data user baru yang akan dimasukan tersedia dan tidak duplikasi
                Ketika Memasukan data user
                Maka respon "user sukses dimasukan"

        @Duplikat
        Skenario: Memasukan User Baru
                Dengan Data user baru yang akan dimasukan tersedia dan tidak duplikasi
                Ketika Memasukan data user
                Maka respon gagal dengan pesan "duplicate"
