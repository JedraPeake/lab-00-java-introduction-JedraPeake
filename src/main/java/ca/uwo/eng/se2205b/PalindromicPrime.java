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
    private final int start;
    private final int end;

    public PalindromicPrime(int start,int end){
        this.end =end;
        this.start =start;
    }

    public Iterator<Integer> palindromeIterator() {
        return new PrimeIterator();
        //null changed
        //return null;
    }

    //took out static///
    private class PrimeIterator implements Iterator<Integer> {

        private int index;
        private int numberList=100000;
        private int populate=0;

        public PrimeIterator() {
            this.index = PalindromicPrime.this.start;
            System.out.println("index set");
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
            if (number%2==0){return false;}

            for(int i=3;i*i<=number;i+=2) {
                if(number%i==0){return false;}
            }
            return true;
        }

        @Override
        public boolean hasNext() {
            return index < PalindromicPrime.this.end;
        }

        @Override
        public Integer next() {
            if(populate==0){
                populateArray();
                populate++;
            }
            //current = first element
            int current =index;
            System.out.println("current:" + current);
            index++;
            return current;
            //throw new NoSuchElementException();
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException("");
        }
    }

    public static void main(String[] args) {

        PalindromicPrime x = new PalindromicPrime(1,100);
        Iterator<Integer> i=x.palindromeIterator();

        while(i.hasNext()){
            System.out.println(i.next()+" ");
        }

        //testing all in main...
        /*
        int z=1;
        while(index!=maxNumbers){
            int number=myArray[z];
            String temp = new String(Integer.toString(number)).toString();
            String temp2 = new StringBuilder(Integer.toString(number)).reverse().toString();
            if(temp.equals(temp2)){
                int prime=0;
                for(int i=2;i<number;i++) {
                    if(number%i==0)
                        prime=1;
                }
                if(prime ==1){
                    z++;
                }
                else{
                    z++;
                    index++;
                    if(index%10==0){
                        System.out.println();
                    }
                    System.out.print(number + "  ");
                }
            }
            else{
                z++;
            }
        }*/
    }

}
