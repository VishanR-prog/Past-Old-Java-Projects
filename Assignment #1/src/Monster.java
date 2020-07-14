public class Monster {
    private int hp;
    private String name;
    private int speed;
    private int attack;
    private int defense;
    private Move move1;
    private Move move2;
    private Move move3;
    private Move move4;
    private String type;

    public Monster(String name, String type, int speed, int attack, int defense, int hp, Move move1, Move move2, Move move3, Move move4) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.speed = speed;
        this.attack = attack;
        this.defense = defense;
        this.move1 = move1;
        this.move2 = move2;
        this.move3 = move3;
        this.move4 = move4;
    }


    public void setHP(int hp) {
        this.hp = hp;
        System.out.println("The HP of " + name + " is " + hp);
    }

    public int getHP() {

        return hp;
    }

    public int getSpeed() {
        return speed;
    }

    public Move getMove2() {
        return move2;
    }

    public Move getMove1() {
        return move1;
    }

    public Move getMove3() {
        return move3;
    }

    public Move getMove4() {
        return move4;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }
    public Object setName(String newName) {
        name = newName;
        return name;
    }

    public Object getName() {
        return name;
    }

    public Object setType(String newType) {
        type = newType;
        return type;
    }

    public Object getType() {
        return type;
    }




}
