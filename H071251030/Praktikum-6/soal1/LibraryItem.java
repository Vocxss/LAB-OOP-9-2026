abstract class LibraryItem {
    String title;
    int itemId;
    boolean isBorrowed;

    LibraryItem(String title,
            int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false;
    }

    abstract String getDescription();

    abstract String borrowItem(int days);

    abstract double calculateFine(int daysLate);

    String returnItem() {
        this.isBorrowed = false;
        return this.title + "dikembalikan";
    }
}

class Book extends LibraryItem {
    String author;

    Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    @Override
    String borrowItem(int days) {
            if (days >= 14) {
                throw new IllegalArgumentException("Peminjaman maksimal 14 hari!");
            } else {
                this.isBorrowed = true;
                return "Buku " + this.title + " dipinjamkan!";
            }
    }

    @Override
    String getDescription() {
        return "Buku: " + this.title + " - dibuat oleh " + this.author + " - ID: " + this.itemId;
    }

    @Override
    double calculateFine(int daysLate) {
        return 10000 * daysLate;
    }
}

class DVD extends LibraryItem {
    int duration;

    DVD(String title, int itemId, int duration) {
        super(title, itemId);
        this.duration = duration;
    }

    @Override
    String borrowItem(int days) {
            if (days >= 7) {
                throw new IllegalArgumentException("Peminjaman maksimal 7 hari!");
            } else {
                this.isBorrowed = true;
                return "DVD " + this.title + " dipinjamkan!";
            }
    }

    @Override
    String getDescription() {
        return "DVD: " + this.title + "- durasi: " + this.duration + " menit - ID: " + this.itemId;
    }

    @Override
    double calculateFine(int daysLate) {
        return 25000 * daysLate;
    }
}
