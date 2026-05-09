import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.NoSuchElementException;

class LibraryLogger {
    static ArrayList<String> logs = new ArrayList<>();

    static void logActivity(String activity) {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatTime = time.format(format);
        logs.add(formatTime + " - " + activity);
    }

    void clearLogs() {
        logs.clear();
    }
}

public class Library {
    ArrayList<LibraryItem> items = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();

    String addItem(LibraryItem item) {
        for (LibraryItem existingItem : items) {
            if (existingItem.itemId == item.itemId) {
                throw new IllegalArgumentException("Item dengan ID " + item.itemId + " sudah ada!");
            }
        }
        items.add(item);
        LibraryLogger.logActivity("Item: " + item.title + " berhasil ditambahkan");
        return "Item: " + item.title + " - berhasil ditambahkan";
    }

    String addMember(Member member) {
        for (Member existingMember : members) {
            if (existingMember.memberId == member.memberId) {
                throw new IllegalArgumentException("Member dengan ID " + member.memberId + " sudah ada!");
            }
        }
        members.add(member);
        LibraryLogger.logActivity("Member: " + member.name + " berhasil ditambahkan");
        return "Member: " + member.name + " - berhasil ditambahkan";
    }

    LibraryItem findItemById(int itemId) {
        boolean isFind = false;
        LibraryItem itemFinded = null;
        for (LibraryItem item : items) {
            if (itemId == item.itemId) {
                isFind = true;
                itemFinded = item;
            }
        }

        if (!isFind) {
            throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan!");
        } else {
            return itemFinded;
        }
    }

    Member findMemberById(int mId) {
        boolean isFind = false;
        Member itemFinded = null;
        for (Member member : members) {
            if (mId == member.memberId) {
                isFind = true;
                itemFinded = member;
            }
        }

        if (!isFind) {
            throw new NoSuchElementException("Member dengan ID " + mId + " tidak ditemukan!");
        } else {
            return itemFinded;
        }
    }

    String getLibraryStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("+=================================================+================+\n");
        sb.append(String.format("| %-47s | %-14s |\n", "Deskripsi Item", "Status"));
        sb.append("+=================================================+================+\n");

        if (items.isEmpty()) {
            sb.append("| Tidak ada item di perpustakaan                  |                |\n");
        } else {
            for (LibraryItem item : items) {
                String status = item.isBorrowed ? "Dipinjam" : "Tersedia";
                String description = item.getDescription();
                if (description.length() > 47) {
                    description = description.substring(0, 44) + "...";
                }
                sb.append(String.format("| %-47s | %-14s |\n", description, status));
            }
        }
        sb.append("+=================================================+================+");

        return sb.toString();
    }

    String getAllLogs() {
        StringBuilder sb = new StringBuilder();
        sb.append("+=========================+=========================================================+\n");
        sb.append(String.format("| %-23s | %-55s |\n", "Timestamp", "Activity"));
        sb.append("+=========================+=========================================================+\n");

        if (LibraryLogger.logs.isEmpty()) {
            sb.append("| Tidak ada log           | -                                                       |\n");
        } else {
            for (String log : LibraryLogger.logs) {
                String[] parts = log.split(" - ", 2);
                String timestamp = parts[0];
                String activity = parts.length > 1 ? parts[1] : "-";
                
                if (activity.length() > 55) {
                    activity = activity.substring(0, 52) + "...";
                }
                sb.append(String.format("| %-23s | %-55s |\n", timestamp, activity));
            }
        }
        sb.append("+=========================+=========================================================+");

        return sb.toString();
    }
}
