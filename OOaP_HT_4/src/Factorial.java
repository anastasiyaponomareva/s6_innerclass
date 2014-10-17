/**
 * Author: Ponomareva Anastasiya
 * Group: 201 SE-1
 * Task:  Factorial
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Factorial implements Iterable {
    //class fields
    private int lowerLimit; // lower limit in list
    private int upperLimit; //upper limit in list
    private ArrayList<Integer> factorials; //list itself

    /**
     * Constructor
     */
    public Factorial(int lowerLimit, int upperLimit) //robust constructor
            throws IllegalArgumentException {
        if ((lowerLimit < 0) || (upperLimit < 0) ||
                (lowerLimit >= upperLimit)) {
            throw new IllegalArgumentException("lower and upper " +
                    "limits should be positive," +
                    "lowerLimit should be less that upperLimit!");
        }
        //precondition checked
        factorials = new ArrayList<Integer>(); //list is initialized

        for (Integer i = lowerLimit; i <= upperLimit; i++) {
            //adding values to the list
            factorials.add(i);
        }


    }

    /**
     * Method to count factorial
     */
    private int factorial(int num) {
        int fact = 1;

        for (int i = 1; i <= num; i++) {
            fact *= i;
        }

        return fact;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public Iterator<Integer> iterator() {
        return new NumberIterator();
    }

    //inner private class to implement iterator
    private class NumberIterator implements Iterator<Integer> {
        private int position = 0;

        @Override
        public boolean hasNext() {
            return position < factorials.size();
        }

        public Integer next() {
            if (position < factorials.size()) {
                Integer current; //value to be returned
                if (position == 0) {
                    current = factorial(factorials.get(position));
                    ++position;
                } else {
                    current = factorial(factorials.get(position - 1))
                            * factorials.get(position);
                    ++position;
                }
                return current;
            } else throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Testing this class
     */
    public static void main(String[] args) {

        while (true) {
            Scanner in = new Scanner(System.in); //variable to read from the console
            Integer low; //variable for lower limit in the list
            Integer up; //variable for upper limit  in the list

            //try-catch in order to prevent failures
            try {

                //getting lower limit
                do {
                    System.out.println("Enter lower limit:");
                    low = TryParseInt(in.next());
                } while (low == null || low <= 0);

                //getting lower limit
                do {
                    System.out.println("Enter upper limit:");
                    up = TryParseInt(in.next());

                } while (up == null || up <= 0);

                //creating Factorial object
                Factorial fact = new Factorial(low, up);

                //printing results of using an iterator
                System.out.println("List of factorials: ");
                for (Iterator<Integer> it = fact.iterator(); it.hasNext(); ) {

                    System.out.println(it.next());
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            //Exit the program
            System.out.println("To exit press \" 1 + Enter\", " +
                    "any other key to continue!");

            if (in.next().equals("1")) {
                System.out.println("Exiting...");
                break;

            }

        }
    }

    /**
     * Imitating C#-like tryParse
     */
    public static Integer TryParseInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException ex) {
            return null;
        }
    }

}
