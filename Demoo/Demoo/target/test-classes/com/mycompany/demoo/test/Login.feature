# language : id

    Fitur: Melakukan Login
           Memasukkan data username dan password

            @Normal
            Skenario: Memasukan Informasi username dan password
                    Dengan Data username dan password akan dimasukan tersedia dan sesuai
                    Ketika Memasukan data username dan password
                    Maka respon login "anda telah berhasil login"

            @Gagal 
            Skenario: Memasukan Memasukan Informasi username dan password
                    Dengan Data username dan password yang akan dimasukan tidak tersedia
                    Ketika Memasukan data username dan password
                    Maka respon login gagal dengan pesan "username dan password tidak terdaftar"
