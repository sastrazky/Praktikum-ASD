class TransaksiPengisian_20 {
    Kendaraan_20 kendaraan;
    BBM_20 bbm;
    double liter;
    double totalBayar;

    TransaksiPengisian_20(Kendaraan_20 kendaraan, BBM_20 bbm, double liter) {
        this.kendaraan = kendaraan;
        this.bbm = bbm;
        this.liter = liter;
        this.totalBayar = liter * bbm.hargaPerLiter;
    }
}