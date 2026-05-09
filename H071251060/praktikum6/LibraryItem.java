package praktikum6;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title; 
    protected int itemId;   
    protected boolean isBorrowed; 

    public LibraryItem(String title, int itemId) { 
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false;
    }

    public abstract String getDescription(); 
    public abstract String borrowItem(int days); 
    public abstract double calculateFine(int daysLate); 

    public String returnItem() { 
        this.isBorrowed = false;
        return title + " dikembalikan";
    }
}

class Book extends LibraryItem {
    private String author; 

    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    @Override
    public String getDescription() { 
        return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (days > 14) {
            throw new IllegalArgumentException("Pinjam buku maksimal 14 hari!");
        }
        if (this.isBorrowed) {
            throw new IllegalArgumentException("Item " + title + " telah dipinjam dan belum dikembalikan.");
        }
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) { 
        return daysLate * 10000;
    }
}

class DVD extends LibraryItem {
    private int duration; 

    public DVD(String title, int itemId, int duration) {
        super(title, itemId);
        this.duration = duration;
    }

    @Override
    public String getDescription() { 
        return "DVD: " + title + ", durasi " + duration + " menit, ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) { 
        if (days > 7) {
            throw new IllegalArgumentException("Pinjam DVD maksimal 7 hari!");
        }
        if (this.isBorrowed) {
            throw new IllegalStateException("Item " + title + " sedang tidak tersedia.");
        }
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) { 
        return daysLate * 25000;
    }
}

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
        if (item.isBorrowed) {
            throw new IllegalStateException("Item " + item.title + " tidak tersedia (sudah dipinjam).");
        }
        String message = item.borrowItem(days);
        item.isBorrowed = true;
        borrowedItems.add(item);
        return message;
    }

    public String returnItem(LibraryItem item, int daysLate) { 
        double fine = item.calculateFine(daysLate);
        item.returnItem();
        borrowedItems.remove(item);
        return "Item " + item.title + " berhasil dikembalikan dengan denda: Rp " + (int)fine;
    }

    public void getBorrowedItems() { 
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam.");
            return;
        }
        System.out.println("+-----+-----------------+");
        System.out.println("| ID  | Judul           |");
        System.out.println("+-----+-----------------+");
        for (LibraryItem item : borrowedItems) {
            System.out.printf("| %-3d | %-15s |\n", item.itemId, item.title);
        }
        System.out.println("+-----+-----------------+");
    }
}
