import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.List; 


class Library {
    private List<LibraryItem> items = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private LibraryLogger logger = new LibraryLogger();

    public void addItem(LibraryItem item) {
        items.add(item);
        System.out.println(item.title + " berhasil ditambahkan");
    }

    public void addMember(Member member) {
        members.add(member);
        System.out.println("Anggota " + member.name + " berhasil ditambahkan");
    }

    public LibraryItem findItemById(int itemId) {
    for (LibraryItem i : items) {
        if (i.itemId == itemId) {
            return i; 
        }
    }
    throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan.");
    }

    public Member findMemberById(String memberId) {
        for (Member m : members) {
            if (m.memberId == Integer.parseInt(memberId)) {
                return m; 
            }
        }
        throw new NoSuchElementException("Anggota dengan ID " + memberId + " tidak ditemukan.");
    }

    public void getLibraryStatus() {
        System.out.println("+-------+--------------+------------+");
        System.out.println("|  ID   |    Judul     |   Status   |");
        System.out.println("+-------+--------------+------------+");
        for (LibraryItem item : items) {
            String status = item.isBorrowed ? "Dipinjam" : "Tersedia";
            System.out.printf("| %-5d | %-12s | %-10s |%n", item.itemId, item.title, status);
        }
        System.out.println("+-------+--------------+------------+");
    }

    public void logAction(LibraryItem item, Member member, String action) {
        String type = (item instanceof Book) ? "Buku" : "DVD";
        logger.logActivity(type, item.title, member.name, action);
    }

    public void showAllLogs() {
        System.out.println(logger.getLogs());
    }
}

public class LibrarySystemCLI {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item\n2. Tambah Anggota\n3. Pinjam Item\n4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan\n6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item Anggota\n8. Keluar");
            System.out.print("Pilih: ");
            int choice = sc.nextInt(); sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Tipe (1.Buku / 2.DVD): ");
                        int type = sc.nextInt(); sc.nextLine();
                        System.out.print("Judul: "); String t = sc.nextLine();
                        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                        if (type == 1) {
                            System.out.print("Penulis: "); String a = sc.nextLine();
                            lib.addItem(new Book(t, id, a));
                        } else {
                            System.out.print("Durasi: "); int d = sc.nextInt();
                            lib.addItem(new DVD(t, id, d));
                        }
                        break;
                    case 2:
                        System.out.print("Nama: "); String name = sc.nextLine();
                        System.out.print("ID Member: "); String mid = sc.nextLine();
                        lib.addMember(new Member(name, Integer.parseInt(mid)));
                        break;
                    case 3:
                        System.out.print("ID Member: "); String m_id = sc.nextLine();
                        System.out.print("ID Item: "); int i_id = sc.nextInt();
                        System.out.print("Durasi Pinjam (hari): "); int days = sc.nextInt();
                        Member m = lib.findMemberById(m_id);
                        LibraryItem i = lib.findItemById(i_id);
                        System.out.println(m.borrow(i, days));
                        lib.logAction(i, m, "dipinjam");
                        break;
                    case 4:
                        System.out.print("ID Member: "); String rm_id = sc.nextLine();
                        System.out.print("ID Item: "); int ri_id = sc.nextInt();
                        System.out.print("Keterlambatan (hari): "); int late = sc.nextInt();
                        Member rm = lib.findMemberById(rm_id);
                        LibraryItem ri = lib.findItemById(ri_id);
                        System.out.println(rm.returnItem(ri, late));
                        lib.logAction(ri, rm, "dikembalikan");
                        break;
                    case 5: lib.getLibraryStatus(); break;
                    case 6: lib.showAllLogs(); break;
                    case 7:
                        System.out.print("ID Member: "); String sm_id = sc.nextLine();
                        lib.findMemberById(sm_id).getBorrowedItems();
                        break;
                    case 8: System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}