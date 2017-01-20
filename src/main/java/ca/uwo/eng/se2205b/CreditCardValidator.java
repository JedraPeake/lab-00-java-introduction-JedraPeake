package ca.uwo.eng.se2205b;
import java.util.Scanner;
/**
 * Problem #3: Validates a Credit Card
 */
public class CreditCardValidator {

    /**
     * Compute if the number is a valid Credit Card Number.
     * @param number Credit Card number to validate.
     * @return Non-{@code null} enum of the type of credit card.
     */

    public static void validate(long number) {
        int i = 15;
        int numberList [] = new int[16];
        //reversing the long and storing in array
        while(number > 0) {
            numberList[i] = (int)(number%10);
            number /= 10;
            i--;
        }

        //Checking Validation
        int sum = 0;
        for(i = 0; i < 16; i++) {
            if(i%2 == 0) {
                numberList[i] *= 2;
                if(numberList[i] >= 10) {
                    numberList[i] = numberList[i]%10 + 1;
                }
            }
            sum += numberList[i];
        }

        //printing
        int z=15;
        System.out.print("Your ");
        while(numberList[z]==0) {
            z--;
        }
        if(numberList[z] == 4) {System.out.print(CreditCard.Visa);}
        else if(numberList[z] == 5) {System.out.print(CreditCard.MasterCard);}
        else if(numberList[z] == 6) {System.out.print(CreditCard.Discover);}
        else {System.out.print(CreditCard.AMEX);}

        if(sum%10 == 0) {
            System.out.println(" CreditCard is valid");
        }
        else {
            System.out.println(" CreditCard is invalid");
        }
    }

    public enum CreditCard{
        Visa, MasterCard, AMEX, Discover
    }

    //driver 1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a credit card number: ");
        long creditcardNumber = sc.nextLong();
        validate(creditcardNumber);
    }
}
