public class Main {
    public static void main(String[] args) {
        StandUser user1 = new StandUser("Dio");
        StandUser user2 = new StandUser("Jotaro");
        int cycle = 1;

        while (user1.hp > 0 && user2.hp > 0) {
            int targetActionValue = 100;
            String currentTurn;

            System.out.println("Cycle turn: " + cycle);
            cycle += 1;

            user1.displayStats();
            user2.displayStats();

            if (user1.stand.speed >= targetActionValue && user2.stand.speed >= targetActionValue && user1.stand.speed == user2.stand.speed) {
                System.out.println("Both has same speed! Identify randomly...");
                currentTurn = Math.random() <= 0.5 ? user1.name : user2.name;
            } else if (user1.stand.speed >= targetActionValue) {
                currentTurn = user1.name;
            } else if (user2.stand.speed >= targetActionValue) {
                currentTurn = user2.name;
            } else {
                user1.stand.speed = user1.stand.speed + 30;
                user2.stand.speed = user2.stand.speed + 30;
                System.out.println("Both no turns! skipped...");
                continue;
            }

            System.out.println("Turn: " + currentTurn);

            //Stand User 1
            if (currentTurn == user1.name) {
                user1.OraOraOra(user2);
                user1.stand.speed = user1.stand.speed - targetActionValue;
            } else {
                user1.stand.speed = user1.stand.speed + 30;
            }

            //Stand User 2
            if (currentTurn == user2.name) {
                user2.OraOraOra(user1);
                user2.stand.speed = user2.stand.speed - targetActionValue;
            } else {
                user2.stand.speed = user2.stand.speed + 30;
            }


        }

        if (user1.hp <= 0) {
            System.out.println(user2.name + " wins! 🏆");
        } else {
            System.out.println(user1.name + " wins! 🏆");
        }
    }
}