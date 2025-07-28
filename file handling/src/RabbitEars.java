public class RabbitEars {
    // Recursive method to calculate total ears
    public static int totalEars(int rabbits){
        // base case if there are no rabbits, return 0
        if (rabbits==0){
            return 0;
        }
        // Recursive case: each rabbit has 2 ears
        return 2+totalEars(rabbits-1);
    }
    public static void main(String[]args){
        int numberOfRabbits=5; // eg number of rabbits
        System.out.println("Total ears:"+totalEars(numberOfRabbits));
    }
}
