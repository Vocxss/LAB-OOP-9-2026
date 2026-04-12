public class Stand {
    String standName;
    String standType;
    int power;
    int speed;
    int durability_armor;
    String[] typeList = {"close-range", "long-distance"};


    void setStats(String type) {
        switch (type) {
            case "close-range":
                this.power = 9 + (int)(Math.random()*2);
                this.speed = 95 + (int)(Math.random()*6);
                this.durability_armor = (int)(Math.random()*10);
                break;
            case "long-distance":
                this.power = 10 + (int)(Math.random()*5);
                this.speed = 100 + (int)(Math.random()*6);
                this.durability_armor = (int)(Math.random()*10);
                break;
        }
    }
    
    public Stand() {
        int randomInt = (int)(Math.random()*2);
        this.standName = "NPC";
        this.standType = typeList[randomInt];
        setStats(this.standType);
    }

    public Stand(String standUser) {
        switch (standUser) {
            case "Dio":
                this.standName = "The World";
                this.standType = "close-range";
                this.power = 10;
                this.speed = 105;
                this.durability_armor = 10; 
                break;
            case "Jotaro":
                this.standName = "Star Platinum";
                this.standType = "close-range";
                this.power = 11;
                this.speed = 100;
                this.durability_armor = 10;
                break;
            case "Kakyoin":
                this.standName = "Hierophant Green";
                this.standType = "long-distance";
                this.power = 13;
                this.speed = 115;
                this.durability_armor = 7;
                break;
            case "Avdol":
                this.standName = "Magician's Red";
                this.standType = "long-distance";
                this.power = 12;
                this.speed = 110;
                this.durability_armor = 8;
                break;
            case "Polnareff":
                this.standName = "Silver Chariot";
                this.standType = "close-range";
                this.power = 10;
                this.speed = 102;
                this.durability_armor = 8;
                break;
        }
    }
}