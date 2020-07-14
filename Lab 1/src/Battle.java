/**
 *
 */

/**
 * @author visha
 *
 */
public class Battle {

    public static void main(String[] args) {
        float kroggAttack = 38.5f;
        float kroggDefense = 20.0f;
        float kroggHP = 200f;
        float bossAttack = 25f;
        float bossDefense = 12.5f;
        float bossHP = 200f;

        int round = 1;

        while (kroggHP > 0 && bossHP > 0) {

            // krogg attacks boss
            System.out.println("Round Number " + round);
            bossHP -= attack(kroggAttack, bossDefense);
            // boss attacks krogg
            kroggHP -= attack(bossAttack, kroggDefense);

            System.out.println("Krogg does " + attack(kroggAttack, bossDefense) +" to the Boss");
            System.out.println("Boss does " + attack(bossAttack, kroggDefense) +" to Krogg");
            System.out.println("Krogg HP is " + kroggHP);
            System.out.println("Boss HP is " + bossHP + '\n');

            if (kroggHP < 0) {
                System.out.println("Boss has won");
            }

            if (bossHP < 0) {
                System.out.println("Krogg has won, You are Victorious");
            }
            round ++;
        }
    }
    static float attack(float attack, float defense) {
        return attack - defense;
    }
}