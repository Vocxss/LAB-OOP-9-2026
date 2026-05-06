import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
        if (isBorrowed) {
            isBorrowed = false;
            return "Item " + title + " dikembalikan";
        } else {
            return "Item " + title + " tidak sedang dipinjam";
        }
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
        return "Buku " + title + " oleh author " + author + " ID " + itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (days > 14) {
            throw new IllegalArgumentException("Item telah dipinjam namun belum dikembalikan");
        }
        isBorrowed = true ;
        return "Item " + title + " telah dipinjam selama " + days + " hari ";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 10000;
        } 
    }


class DVD extends LibraryItem {
    int duration;

    public DVD(String title, int itemId, int duration) {
        super(title, itemId);
        this.duration = duration;
    }

    @Override
    public String getDescription() {
        return "DVD " + title + " durasi " + duration + " menit ID " + itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (days > 7) {
            throw new IllegalArgumentException("Item telah dipinjam namun belum dikembalikan");
        }
        isBorrowed = true;
        return "Item " + title + "telah dipinjam selama " + days + " hari ";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 25000; 
    }
}
