package ca.uwo.eng.se2205b;

/**
 * Created by PeakeAndSons on 2017-01-20.
 */
public class CreditCardValidatorDriver2 {
    public static void main(String[] args) {

        long numberList [] = {54321, 4388576018402626l, 4111111111111111l, 5500000000000004l, 340000000000009l};
        for(int i=0;i<numberList.length;i++)
        {
            CreditCardValidator.validate(numberList[i]);
        }
    }
}
