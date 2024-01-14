import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Kalkulator Perjalanan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton buttonHitungKecepatan = createStyledButton("Hitung Kecepatan");
        JButton buttonHitungJarak = createStyledButton("Hitung Jarak Tempuh");
        JButton buttonHitungWaktu = createStyledButton("Hitung Waktu Tempuh");
        JButton buttonExit = createStyledButton("Keluar");

        panel.add(buttonHitungKecepatan);
        panel.add(buttonHitungJarak);
        panel.add(buttonHitungWaktu);
        panel.add(buttonExit);

        frame.add(panel);

        buttonHitungKecepatan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Menampilkan input dialog untuk mengambil nilai dari pengguna
                String jarakInput = JOptionPane.showInputDialog(frame, "Masukkan jarak tempuh (km):");
                String waktuInput = JOptionPane.showInputDialog(frame, "Masukkan waktu tempuh (jam):");

                // Menghitung kecepatan
                try {
                    double jarak = Double.parseDouble(jarakInput);
                    double waktu = Double.parseDouble(waktuInput);

                    double kecepatan = jarak / waktu;

                    // Menampilkan output
                    JOptionPane.showMessageDialog(frame, "Kecepatan Anda adalah " + kecepatan + " km/jam", "Hasil Perhitungan", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Masukan tidak valid. Harap masukkan angka.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonHitungJarak.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Menampilkan input dialog untuk mengambil nilai dari pengguna
                String kecepatanInput = JOptionPane.showInputDialog(frame, "Masukkan kecepatan (km/jam):");
                String waktuInput = JOptionPane.showInputDialog(frame, "Masukkan waktu tempuh (jam):");

                // Menghitung jarak tempuh
                try {
                    double kecepatan = Double.parseDouble(kecepatanInput);
                    double waktu = Double.parseDouble(waktuInput);

                    double jarakTempuh = kecepatan * waktu;

                    // Menampilkan output
                    JOptionPane.showMessageDialog(frame, "Jarak tempuh Anda adalah " + jarakTempuh + " km", "Hasil Perhitungan", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Masukan tidak valid. Harap masukkan angka.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonHitungWaktu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Menampilkan input dialog untuk mengambil nilai dari pengguna
                String jarakInput = JOptionPane.showInputDialog(frame, "Masukkan jarak tempuh (km):");
                String kecepatanInput = JOptionPane.showInputDialog(frame, "Masukkan kecepatan (km/jam):");

                // Menghitung waktu tempuh
                try {
                    double jarak = Double.parseDouble(jarakInput);
                    double kecepatan = Double.parseDouble(kecepatanInput);

                    double waktuTempuh = jarak / kecepatan;

                    // Mengonversi waktu tempuh menjadi jam dan menit
                    int jam = (int) waktuTempuh;
                    int menit = (int) ((waktuTempuh - jam) * 60);

                    // Menampilkan output
                    JOptionPane.showMessageDialog(frame, "Waktu tempuh Anda adalah " + jam + " jam " + menit + " menit", "Hasil Perhitungan", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Masukan tidak valid. Harap masukkan angka.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmExit = JOptionPane.showConfirmDialog(frame, "Apakah Anda yakin ingin keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION);
                if (confirmExit == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(frame, "Terima kasih telah menggunakan Kalkulator Perjalanan. Sampai Jumpa!", "Keluar", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }
        });

        frame.setVisible(true);
    }

    private static JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(95, 158, 160));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        return button;
    }
}