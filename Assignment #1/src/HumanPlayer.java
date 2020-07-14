import java.util.Scanner;

class HumanPlayer extends Player {
        public static final Scanner Game = new Scanner(System.in);
    public HumanPlayer(Monster monster) {
        this.monster = monster;
    }

    // get move by asking user
        Move chooseMove() {
            //do {
            System.out.print("Select a Move: ");
            int move = Integer.parseInt(Game.next());
            Game.nextLine();
            Move acc;
            switch (move) {
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
            System.out.println("Good Choice");
            //} while (true);
            return acc;
        }

    }
