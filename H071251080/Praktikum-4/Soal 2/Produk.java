class Produk {
    String brand;
    int seriesNumber;
    double price;

    Produk(String brand, int seriesNumber, double price) {
        this.brand        = brand;
        this.seriesNumber = seriesNumber;
        this.price        = price;
    }

    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Serial Number: " + seriesNumber);
        System.out.println("Price: Rp " + price);
    }
}

class Smartphone extends Produk {
    double screenSize;
    int storageCapacity;

    Smartphone(String brand, int seriesNumber, double price,
               double screenSize, int storageCapacity) {
        super(brand, seriesNumber, price);
        this.screenSize      = screenSize;
        this.storageCapacity = storageCapacity;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Screen Size: " + screenSize + " inches");
        System.out.println("Storage Capacity: " + storageCapacity + "GB");
    }
}

class Laptop extends Produk {
    int ramSize;
    String processorType;

    Laptop(String brand, int seriesNumber, double price,
           int ramSize, String processorType) {
        super(brand, seriesNumber, price);
        this.ramSize       = ramSize;
        this.processorType = processorType;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Processor Type: " + processorType);
        System.out.println("RAM Size: " + ramSize + "GB");
    }
}

class Camera extends Produk {
    int resolution;
    String lensType;

    Camera(String brand, int seriesNumber, double price,
           int resolution, String lensType) {
        super(brand, seriesNumber, price);
        this.resolution = resolution;
        this.lensType   = lensType;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Resolution: " + resolution + "MP");
        System.out.println("Lens Type: " + lensType);
    }
}
