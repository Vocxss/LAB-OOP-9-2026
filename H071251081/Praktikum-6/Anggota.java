import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class Member {
    protected String name;
    protected int memberId;
    protected List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) {
        String result = item.borrowItem(days);
        if (result.startsWith("Item")) {
            borrowedItems.add(item);
        }
        return result;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        double calcu = item.calculateFine(daysLate);
        item.returnItem();
        borrowedItems.remove(item);
        return "Item " + item.title + " berhasil dikembalikan dengan denda: Rp " + String.format("%.0f", calcu);
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam.");
            return;
        }
        
        System.out.println("+-------+--------------+");
        System.out.println("|  ID   |    Judul     |");
        System.out.println("+-------+--------------+");
        for (LibraryItem item : borrowedItems) {
            System.out.printf("| %-5d | %-12s |%n", item.itemId, item.title);
        }
        System.out.println("+-------+--------------+");
    }
}

class LibraryLogger {
    private List<String> logs = new ArrayList<>();
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void logActivity(String type, String title, String memberName, String action) {
        String timestamp = LocalDateTime.now().format(dtf);
        logs.add(String.format("%s [%s] %s oleh %s", timestamp, type, action, memberName));
    }

    public String getLogs() {
        if (logs.isEmpty()) return "Belum ada log.";
        return String.join("\n", logs);
    }

    public void clearLogs() {
        logs.clear();
    }
}



