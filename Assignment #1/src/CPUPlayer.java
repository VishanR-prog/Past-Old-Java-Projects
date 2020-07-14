import java.util.Random;

public class CPUPlayer extends Player {
    public CPUPlayer(Monster monster) {
     this.monster = monster;
    }
    Move chooseMove() {
        Random rand = new Random();
        int choice = rand.nextInt(4);
        Move acc;
        switch (choice) {
            case 1:
                acc = this.getMonster().getMove1();
                break;
            case 2:
                acc = this.getMonster().getMove2();
                break;
            case 3:
                acc = this.getMonster().getMove3();
                break;
            case 4:
                acc = this.getMonster().getMove4();
                break;
            default:
                acc = this.getMonster().getMove1();
                break;

        }
        return acc;
    }
    }

