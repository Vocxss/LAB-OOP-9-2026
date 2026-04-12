public class StandUser {
    String name;
    Stand stand = new Stand();
    int hp = 100;

    public StandUser() {
        this.name = "NPC";
    }

    public StandUser(String name) {
        this.name = name;
        this.stand = new Stand(this.name);
    }

    int takeDamage(StandUser target, double damage) {
        int damageTaken;
        if (target.stand.durability_armor >= 1) {
            damageTaken = (int) (damage - (damage * 0.2));
        } else {
            damageTaken = (int) damage;
        }
        target.stand.durability_armor = target.stand.durability_armor <= 0 ? 0 : target.stand.durability_armor - 1;
        return damageTaken;
    }

    void OraOraOra(StandUser target) {
        boolean isCrit = Math.random() <= 0.5;
        System.err.println(isCrit ? "HOWWLYY SHIT! IT'S CRITICAL HIT!" : "");
        System.out.println(this.name + " attacks " + target.name);
        int calculatedHp = target.hp - (isCrit ? takeDamage(target, this.stand.power) * 2: takeDamage(target, this.stand.power));
        target.hp = calculatedHp <= 0 ? 0 : calculatedHp;
        System.out.println(target.name + " current HP: " + target.hp);
    }

    void displayStats() {
        String line = "=".repeat(20);
        System.out.println(line);
        System.out.println(this.name + "'s stat: ");
        System.out.println("HP: " + this.hp);
        System.out.println("Stand Name: " + this.stand.standName + " (" + this.stand.standType + ")");
        System.out.println("Power: " + this.stand.power);
        System.out.println("Speed: " + this.stand.speed);
        System.out.println("Durability_armor: " + this.stand.durability_armor);
        System.out.println(line);
    }
}