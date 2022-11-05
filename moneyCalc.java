import java.util.Scanner;

public class moneyCalc {

    public static void main(String[] args) {


        final float curPay = (float) 15.5;
        final float overTMult = (float) 1.5;

        int salary, i, j;
        int[] possibleHours = new int[] {32, 35, 40, 45, 48, 50, 56};
        float[][] revenueCollector = new float[2][7]; 

        Scanner myScnr = new Scanner(System.in);

        char answer = 'y';

        while (answer == 'y') {
            System.out.println("Please enter your big money $$$: ");
            salary = myScnr.nextInt();

            for(i=0; i < 7; ++i) {
                if(possibleHours[i] > 40) 
                    revenueCollector[0][i] = 52*(curPay*40 + overTMult*curPay*(possibleHours[i] - 40));
            
                else
                    revenueCollector[0][i] = 52*(curPay*possibleHours[i]);
            }

            for(i=0; i < 7; ++i) {
                revenueCollector[1][i] = (float)((salary / 52)/possibleHours[i]); 
            }

            for (i = 0; i < 2; ++i) {
                for (j = 0; j < 7; ++j) {

                    if (i == 1 && j == 0)
                        System.out.println("----------------------------------------------------------------------------");
                    System.out.println("Hours " + possibleHours[j] + "Pay: " +revenueCollector[i][j]);
                }
            }

            System.out.println("Enter a new value? y or n?: ");
            answer = myScnr.next().charAt(0);
            myScnr.nextLine(); // consume new line char from buffer

        }
        System.out.println("Thank you! Good luck!");
    }
}