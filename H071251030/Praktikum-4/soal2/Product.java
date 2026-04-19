class Product {
    private String brand;
    private int seriesNumber;
    private double price;
    private int stock;

    public Product(String brand, int seriesNumber, double price, int stock) {
        this.brand = brand;
        this.seriesNumber = seriesNumber;
        this.price = price;
        this.stock = stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public String getSeriesNumber() {
        return String.valueOf(seriesNumber);
    }

    public void getInfo() {
        System.out.println("Brand: " + this.brand);
        System.out.println("Series Number: " + this.seriesNumber);
        System.out.println("Price: $" + this.price);
        System.out.println("Stock: " + this.stock);
    }

}

class Phone extends Product {
    double screenSize;
    int memory;

    public Phone(String brand, int seriesNumber, double price, int stock, double screenSize, int memory) {
        super(brand, seriesNumber, price, stock);
        this.screenSize = screenSize;
        this.memory = memory;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Screen Size: " + this.screenSize + " inch");
        System.out.println("Memory: " + this.memory + " GB");
    }
}

class Camera extends Product {
    int resolution;
    String lensType;

    public Camera(String brand, int seriesNumber, double price, int stock, int resolution, String lensType) {
        super(brand, seriesNumber, price, stock);
        this.resolution = resolution;
        this.lensType = lensType;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Resolution: " + this.resolution + " MP");
        System.out.println("Lens Type: " + this.lensType);
    }
}

class Laptop extends Product {
    String processor;
    int ram;

    public Laptop(String brand, int seriesNumber, double price, int stock, String processor, int ram) {
        super(brand, seriesNumber, price, stock);
        this.processor = processor;
        this.ram = ram;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Processor: " + this.processor);
        System.out.println("Ram: " + this.ram + " GB");
    }
}
