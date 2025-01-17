import java.util.Random;

abstract class Player {
    protected Monster monster;

    Monster getMonster() {
        return this.monster;
    }

    boolean hasLost() {
        return this.getMonster().getHP() <= 0;
    }


    abstract Move chooseMove();

    boolean isFasterThan(Player p) {
        return this.monster.getSpeed() > p.getMonster().getSpeed();
    }

    void attack(Player defender, Move move) {
        Move acc = move;
        Random rn = new Random();
        float i = rn.nextFloat();
        if (i > acc.getAccuracy() || i >= 1) {
            System.out.println("You missed your attack");
            return;
        }
        int damage = this.getMonster().getAttack() + acc.getPower() - defender.getMonster().getDefense();
        System.out.println("The damage from the attack was " + damage);
        defender.getMonster().setHP(defender.getMonster().getHP() - damage);
        return;
    }
}

class GameDriver {
    public static void main(String[] args) {
        // Human Player
        Move move1 = new Move("Vine Whip", "Grass", 45, 1.0f);
        Move move2 = new Move("Tackle", "Normal", 50, 1.0f);
        Move move3 = new Move("Take Down", "Normal", 90, 0.85f);
        Move move4 = new Move("Razor Leaf", "Grass", 55, 0.95f);
        Monster monster = new Monster("Bulbasaur", "Grass",
                240, 45, 49, 49,
                move1, move2, move3, move4);
        Player player = new HumanPlayer(monster);
        // CPU Player
        move1 = new Move("Scratch", "Normal", 40, 1.0f);
        move2 = new Move("Ember", "Fire", 40, 1.0f);
        move3 = new Move("Peck", "Flying", 35, 1.0f);
        move4 = new Move("Fire Spin", "Fire", 35, 0.85f);
        monster = new Monster("Torchic", "Fire", 240, 45, 60, 40,
                move1, move2, move3, move4);
        Player enemy = new CPUPlayer(monster);
        while ((!player.hasLost()) && (!enemy.hasLost())) {
// print both monsters' HP
            System.out.println("");
            System.out.printf("%s has %d HP\n",
                    player.getMonster().getName(),
                    player.getMonster().getHP());
            System.out.printf("%s has %d HP\n",
                    enemy.getMonster().getName(),
                    enemy.getMonster().getHP());
// decide the next move
            Move playerMove = player.chooseMove();
            Move enemyMove = enemy.chooseMove();
// execute the next move
            if (player.isFasterThan(enemy)) {
                player.attack(enemy, playerMove);
                if (!enemy.hasLost()) {
                    enemy.attack(player, enemyMove);
                }
            } else {
                enemy.attack(player, enemyMove);
                if (!player.hasLost()) {
                    player.attack(enemy, playerMove);
                }
            }
        }
        if (player.hasLost()) {
            System.out.printf("You and %s have lost the battle.\n",
                    player.getMonster().getName());
        } else {
            System.out.printf("You and %s are victorious!\n",
                    player.getMonster().getName());
        }
    }
}

