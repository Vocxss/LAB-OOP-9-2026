package praktikum6;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

class LibraryLogger {
    private List<String> logs = new ArrayList<>();

    public String logActivity(String activity) { 
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);
        String entry = timestamp + " | " + activity;
        logs.add(entry);
        return entry;
    }

    public String getLogs() { 
        if (logs.isEmpty()) return "Belum ada log aktivitas.";
        return String.join("\n", logs);
    }

    public void clearLogs() {
        logs.clear();
    }
}

class Library {
    private List<LibraryItem> items = new ArrayList<>(); 
    private List<Member> members = new ArrayList<>();
    private LibraryLogger logger = new LibraryLogger(); 

    public String addItem(LibraryItem item) { 
        items.add(item);
        return item.title + " berhasil ditambahkan";
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public LibraryItem findItemById(int itemId) { // 
        for (LibraryItem item : items) {
            if (item.itemId == itemId) return item;
        }
        throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan.");
    }

    public Member findMemberById(int memberId) {
        for (Member m : members) {
            if (m.memberId == memberId) return m;
        }
        throw new NoSuchElementException("Anggota dengan ID " + memberId + " tidak ditemukan.");
    }

    public String getLibraryStatus() { 
        StringBuilder sb = new StringBuilder();
        sb.append("+-----+-----------------+-----------+\n");
        sb.append("| ID  | Judul           | Status    |\n");
        sb.append("+-----+-----------------+-----------+\n");
        for (LibraryItem item : items) {
            String status = item.isBorrowed ? "Dipinjam" : "Tersedia";
            sb.append(String.format("| %-3d | %-15s | %-9s |\n", item.itemId, item.title, status));
        }
        sb.append("+-----+-----------------+-----------+");
        return sb.toString();
    }

    public String getAllLogs() { 
        return logger.getLogs();
    }

    public LibraryLogger getLogger() {
        return logger;
    }
}