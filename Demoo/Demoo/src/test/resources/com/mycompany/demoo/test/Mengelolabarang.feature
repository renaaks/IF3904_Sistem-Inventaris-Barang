# language : id

    Fitur: Mengelola barang
           Mengelola data barang

            @Normal
            Skenario: Mengelola Data Barang Baru
		Dengan Data barang yang akan dimasukkan tersedia dan tidak duplikasi
		Ketika Memasukkan data barang
		Maka respon menjadi "data barang sukses dimasukan"

            @Duplikat
            Skenario: Mengelola Data Barang Baru
		Dengan Data barang baru yang akan dimasukkan tersedia dan tidak duplikasi
		Ketika Memasukkan data barang
		Maka respon akan gagal dengan pesan "duplikat"
