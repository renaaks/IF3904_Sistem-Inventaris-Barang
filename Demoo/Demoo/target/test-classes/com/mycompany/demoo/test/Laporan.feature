# language: id 

Fitur: Laporan barang 
       Mengelola laporan barang

        @Normal
	Skenario: Laporan 
            Dengan Data data barang user yang akan dilihat tersedia dan tidak duplikasi
            Ketika Akan melihat laporan
            Maka responnya adalah "Laporan akan dilampirkan"

	@Duplikat
	Skenario: Laporan
            Dengan Data data barang user yang akan dilihat tersedia dan tidak duplikasi
            Ketika Akan melihat laporan 
            Maka responnya adalah gagal dengan pesan "laporan duplicate"
