public class Mahasiswa20 {
    String nim, nama, kelas;
    double ipk;

    public Mahasiswa20(String nm, String name, String kls, double ip) {
        this.nim = nm;
        this.nama = name;
        this.kelas = kls;
        this.ipk = ip;
    }

    public void tampilInformasi() {
        System.out.println(nama + " " + nim + " " + kelas + " " + ipk);
    }
}