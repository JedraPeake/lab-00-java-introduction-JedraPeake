package ca.uwo.eng.se2205b;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;
/**
 * Problem #2: Finds prime numbers and checks if they are palindromes.
 */
public class PalindromicPrime {
    /**
     * Creates an iterator that returns prime palindrome numbers
     * @return Non-{@code null} iterator to get palindrome prime numbers.
     */

    public Iterator<Integer> palindromeIterator() {
        return new PrimeIterator();
        //null changed
        //return null;
    }
    private static class PrimeIterator implements Iterator<Integer> {
        private int cursor;
        private int numberList=100000;
        private int end;
        private int index;

        public PrimeIterator(int start,int end){
            this.end =end;
            this.cursor =start;
            this.index = start;
        }

        public PrimeIterator() {
            populateArray();
            System.out.println("populate array");
        }

        private int[] myArray=new int[113];

        private void populateArray(){
            System.out.println("populate array");
            int n=0;
            for (int i = 2; i < numberList; ++i) {
                if(i==2){
                    myArray[n]=i;
                    n++;
                }
                else if ((isPrime(i))&&(isPalindrome(i))){
                    myArray[n]=i;
                    n++;
                }
            }
            for (int i = 0; i < myArray.length; ++i) {

                if(i%10==0){
                    System.out.println();
                }
                System.out.print(myArray[i]+"   ");
            }
        }

        private boolean isPalindrome(int number){
            String temp = new String(Integer.toString(number)).toString();
            String temp2 = new StringBuilder(Integer.toString(number)).reverse().toString();

            return temp.equals(temp2);
        }

        private boolean isPrime(int number){
            if (number == 1){return false;}
            else if (number == 2){return true;}
            else if (number%2==0){return false;}
            for(int i=3;i*i<=number;i+=2) {
                if(number%i==0){return false;}
            }
            return true;
        }

        @Override
        public boolean hasNext() {
            return  this.cursor < end ;
        }

        @Override
        public Integer next() {
            try{
                boolean pp=false;
                while(!pp){
                    if(isPrime(index)){
                        if (isPalindrome(index)){
                            pp = true;
                        }
                        else {index++;}
                    }
                    else {index++;}
                }
                int num = index;
                index++;
                cursor++;
                return num;
            }
            catch(NoSuchElementException e){
                throw new NoSuchElementException();
            }
        }
        @Override
        public void remove(){
            throw new UnsupportedOperationException("");
        }
    }

    public static void main(String[] args) {
        PrimeIterator i= new PrimeIterator(0,100);
        while(i.hasNext()){
            System.out.println(i.next()+" ");
        }
    }
}
