package ca.uwo.eng.se2205b;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Problem #2: Finds prime numbers and checks if they are palindromes.
 */
public class PalindromicPrime {
    /**
     * Creates an iterator that returns prime palindrome numbers.
     *
     * @return Non-{@code null} iterator to get palindrome prime numbers.
     */
    public Iterator<Integer> palindromeIterator() {

        return null;
    }

    private static class PrimeIterator implements Iterator<Integer> {

        int i = 2;

        @Override
        public boolean hasNext() {return true;}

        @Override
        public Integer next() {
            //returns next palindrome
            int current=0;
            return current;

            //throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("");
        }
    }
    //needed to run class...
    public static void main(String[] args) {
        Iterator<Integer> i = new PrimeIterator();
        while(i.hasNext()){
            System.out.println(i.next()+" ");
        }
    }
}
