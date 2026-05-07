package praktikum6;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainPerpus {
    public static void main(String[] args) {
        Library perpus = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) { // [cite: 82, 83, 91]
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print(">>> Pilih menu (1-8): ");
            int menu = sc.nextInt();

            try {
                switch (menu) {
                    case 1:
                        System.out.print("Tipe (1. Buku / 2. DVD): ");
                        int tipe = sc.nextInt(); sc.nextLine();
                        System.out.print("Judul: "); String jdl = sc.nextLine();
                        System.out.print("ID Item: "); int idI = sc.nextInt(); sc.nextLine();
                        if (tipe == 1) {
                            System.out.print("Penulis: "); String aut = sc.nextLine();
                            System.out.println(perpus.addItem(new Book(jdl, idI, aut)));
                        } else {
                            System.out.print("Durasi (menit): "); int dur = sc.nextInt();
                            System.out.println(perpus.addItem(new DVD(jdl, idI, dur)));
                        }
                        break;

                    case 2:
                        sc.nextLine();
                        System.out.print("Nama Anggota: "); String nm = sc.nextLine();
                        System.out.print("ID Anggota: "); int idM = sc.nextInt();
                        perpus.addMember(new Member(nm, idM));
                        System.out.println("Anggota " + nm + " berhasil ditambahkan.");
                        break;

                    case 3:
                        System.out.print("ID Anggota: "); int mId = sc.nextInt();
                        System.out.print("ID Item: "); int iId = sc.nextInt();
                        System.out.print("Lama Pinjam (hari): "); int days = sc.nextInt();
                        Member m = perpus.findMemberById(mId);
                        LibraryItem item = perpus.findItemById(iId);
                        System.out.println(m.borrow(item, days));
                        perpus.getLogger().logActivity(item.title + " dipinjam oleh " + m.name); 
                        break;

                    case 4:
                        System.out.print("ID Anggota: "); int mIdR = sc.nextInt();
                        System.out.print("ID Item: "); int iIdR = sc.nextInt();
                        System.out.print("Hari Terlambat: "); int late = sc.nextInt();
                        Member mR = perpus.findMemberById(mIdR);
                        LibraryItem itemR = perpus.findItemById(iIdR);
                        System.out.println(mR.returnItem(itemR, late));
                        perpus.getLogger().logActivity(itemR.title + " dikembalikan oleh " + mR.name);
                        break;

                    case 5:
                        System.out.println(perpus.getLibraryStatus());
                        break;

                    case 6:
                        System.out.println(perpus.getAllLogs());
                        break;

                    case 7:
                        System.out.print("ID Anggota: "); int mIdL = sc.nextInt();
                        perpus.findMemberById(mIdL).getBorrowedItems();
                        break;

                    case 8:
                        System.out.println("Terima kasih!");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                continue;
            }
        }
    }
}