# Responsi-1-Pemob
Nama : Muhammad Fadhel Fusta --
NIM  : H1D023113 --
Shift : E ->F --



https://github.com/user-attachments/assets/b941454c-77fc-4bab-8de1-23c749bc97af

Data pemain diambil dari API menggunakan Retrofit melalui ApiService yang memanggil endpoint teams/{id} dan mengembalikan objek TeamResponse.
Hasilnya dikirim ke TeamRepository, lalu diteruskan ke TeamViewModel yang menyimpan data dalam bentuk LiveData.
Fragment mengamati LiveData ini dan, setelah data diterima, mengirim daftar pemain (squad) ke PlayersAdapter untuk ditampilkan di RecyclerView.
Adapter kemudian menampilkan nama dan posisi pemain dalam bentuk kartu dengan warna berbeda untuk tiap posisi.

Dengan pola MVVM, alur ini membuat data dari API dapat ditampilkan di layar secara efisien dan terstruktur.
