import java.util.ArrayList;

public class Member {
    String name;
    int memberId;
    ArrayList<LibraryItem> borrowedItems = new ArrayList<>();

    Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    String borrow(LibraryItem item, int days) {
        if (item.isBorrowed) {
            throw new IllegalStateException("Item " + item.title + " sedang dipinjam");
        }
        borrowedItems.add(item);
        LibraryLogger.logActivity("Item: " + item.title + " berhasil dipinjam selama " + days + " hari oleh " + name);
        return item.borrowItem(days);
    }

    String returnItem(LibraryItem item, int daysLate) {
        if (!item.isBorrowed) {
            throw new IllegalStateException("Item: " + item.title + " tidak sedang dipinjam");
        }
        item.returnItem();
        borrowedItems.remove(item);
        if (daysLate > 0) {
            LibraryLogger.logActivity("Item: " + item.title + " berhasil dikembalikan dengan denda Rp." + item.calculateFine(daysLate));
            return "Item: " + item.title + " berhasil dikembalikan dengan denda Rp." + item.calculateFine(daysLate);
        } else {
            LibraryLogger.logActivity("Item: " + item.title + " berhasil dikembalikan oleh " + name);
            return "Item: " + item.title + " berhasil dikembalikan oleh " + this.name;
        }
    }

    void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("No item :(");
        } else {
            System.out.println("=---------------------------------------=");
            System.out.printf("%-12s | %-20s%n", "Id", "Buku");
            System.out.println("=---------------------------------------=");
            for (LibraryItem libraryItem : borrowedItems) {
                System.out.printf("%-12s | %-20s%n", libraryItem.itemId, libraryItem.title);
            }
            System.out.println("=---------------------------------------=");
        }
    }
}