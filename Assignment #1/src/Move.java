public class Move {
    private int power;
    private String name;
    private float accuracy;
    private String type;

    public Move(String name, String type, int power, float accuracy) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;

    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public int getPower() {
        return this.power;
    }

    public String setType(String newType) {
        type = newType;
        return type;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }
}
