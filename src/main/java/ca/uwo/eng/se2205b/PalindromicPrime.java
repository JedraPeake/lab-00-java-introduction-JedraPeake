package ca.uwo.eng.se2205b;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;
/**
 * Problem #2: Finds prime numbers and checks if they are palindromes.
 */
public class PalindromicPrime {
    /**
     * Creates an iterator that returns prime palindrome numbers
     * @return Non-{@code null} iterator to get palindrome prime numbers.
     */
    private final int end;

    public PalindromicPrime(int end){
        this.end =100;
    }

    public Iterator<Integer> palindromeIterator() {
        return null;
    }
    private static class PrimeIterator implements Iterator<Integer> {

        private int index=0;
        private int maxNumbers=6;
        private int numberList=100000;
        int end;

        private int[] myArray=new int[numberList];

        private void populateArray(){
            for (int i = 0; i < numberList; ++i) {
                myArray[i] = i+1;
            }
        }

        private boolean isPalindrome(int number){
            String temp = new String(Integer.toString(number)).toString();
            String temp2 = new StringBuilder(Integer.toString(number)).reverse().toString();

            return temp.equals(temp2);
        }

        private boolean isPrime(int number){
            if (number%2==0){return false;}

            for(int i=3;i*i<=number;i+=2) {
                if(number%i==0){return false;}
            }
            return true;
        }

        @Override
        public boolean hasNext() {
            return index < maxNumbers;
        }

        @Override
        public Integer next() {
            if(index==0){
                populateArray();
                index++;
            }
            int call=this.end;
            return myArray[call];
            //while(isPalindrome(myArray[current])&&isPrime(myArray[current])){
            //while(isPrime(myArray[current])){
            //}
            //index++;
            //return current;
            //throw new NoSuchElementException();
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException("");
        }
    }

    public static void main(String[] args) {

        PalindromicPrime x = new PalindromicPrime(100);
        Iterator<Integer> i=x.palindromeIterator();

        while(i.hasNext()){
            System.out.println(i.next()+" ");
        }
    }
}
