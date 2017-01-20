package ca.uwo.eng.se2205b;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Problem #2: Finds prime numbers and checks if they are palindromes.
 */
public class PalindromicPrime {
    /**
     * Creates an iterator that returns prime palindrome numbers
     * @return Non-{@code null} iterator to get palindrome prime numbers.
     */
    private int max;

    public Iterator<Integer> palindromeIterator() {
        return null;
    }
    private static class PrimeIterator implements Iterator<Integer> {

        private int index;
        private int max=100;

        @Override
        public boolean hasNext() {
            return index < max;
        }

        @Override
        public Integer next() {
            //returns next palindromeprime number
            int current=0;
            index++;
            return current;

            //throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("");
        }
    }

    public static void main(String[] args) {

        //PalindromicPrime x = new PalindromicPrime(0, 100);
        //Iterator<Integer> i = x.palindromeIterator();
        //Iterator<Integer> i = x.palindromeIterator();
        Iterator<Integer> i= new PrimeIterator();

        while(i.hasNext()){
            System.out.println(i.next()+" ");
        }
    }
}
