import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n=== MENU PERPUSTAKAAN ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Member");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Logs");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.println("----------------------------------------");
            System.out.print("Pilih: ");

            int pilihan = input.nextInt();
            input.nextLine();

            try {
                switch (pilihan) {
                    case 1 -> {
                        System.out.println("1. Book");
                        System.out.println("2. DVD");
                        System.out.println("----------------------------------------");
                        System.out.print("Pilih tipe: ");

                        int jenis = input.nextInt();
                        input.nextLine();

                        System.out.print("Title: ");
                        String title = input.nextLine();

                        System.out.print("ID: ");
                        int id = input.nextInt();
                        input.nextLine();

                        if (jenis == 1) {
                            System.out.print("Author: ");
                            String author = input.nextLine();
                            Book book = new Book(title, id, author);
                            System.out.println(library.addItem(book));
                        } else {
                            System.out.print("Durasi (menit): ");
                            int durasi = input.nextInt();
                            input.nextLine();
                            DVD dvd = new DVD(title, id, durasi);
                            System.out.println(library.addItem(dvd));
                        }
                    }

                    case 2 -> {
                        System.out.print("Nama: ");
                        String name = input.nextLine();

                        System.out.print("Member ID: ");
                        int memberId = input.nextInt();
                        input.nextLine();

                        Member member = new Member(name, memberId);
                        System.out.println(library.addMember(member));
                    }

                    case 3 -> {
                        // Pinjam
                        System.out.print("ID Member: ");
                        int mId = input.nextInt();

                        System.out.print("ID Item: ");
                        int itemId = input.nextInt();

                        System.out.print("Jumlah hari: ");
                        int days = input.nextInt();
                        input.nextLine();

                        Member m = library.findMemberById(mId);
                        LibraryItem item = library.findItemById(itemId);

                        System.out.println(m.borrow(item, days));
                    }

                    case 4 -> {
                        System.out.print("ID Member: ");
                        int rmId = input.nextInt();

                        System.out.print("ID Item: ");
                        int rItemId = input.nextInt();

                        System.out.print("Hari keterlambatan: ");
                        int late = input.nextInt();
                        input.nextLine();

                        Member rm = library.findMemberById(rmId);
                        LibraryItem rItem = library.findItemById(rItemId);

                        System.out.println(rm.returnItem(rItem, late));
                    }

                    case 5 -> System.out.println(library.getLibraryStatus());

                    case 6 -> System.out.println(library.getAllLogs());

                    case 7 -> {
                        System.out.print("ID Member: ");
                        int mIdToFind = input.nextInt();
                        library.findMemberById(mIdToFind).getBorrowedItems();
                    }
                    case 8 -> {
                        System.out.println("Keluar...");
                        return;
                    }

                    default -> System.out.println("Pilihan tidak valid");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

}