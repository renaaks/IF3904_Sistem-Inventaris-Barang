# language : id

    Fitur: Mengelola Permohonan Barang
           Mengelola data permohonan barang

           @Normal
           Skenario: Mengelola data permohonan barang
                   Dengan Data permohonan barang yang akan dimasukkan tersedia dan tidak duplikasi		
                   Ketika Memasukkan data permohonan barang
                   Maka respon permohonan "permohonan barang sukses dimasukan"

           @Duplikat
           Skenario: Memasukkan data permohonan barang
                    Dengan Data permohonan barang yang akan dimasukkan tersedia dan tidak duplikasi
                    Ketika Memasukkan data barang
                    Maka respon permohonan gagal dengan pesan "permohonan barang sudah ada"
