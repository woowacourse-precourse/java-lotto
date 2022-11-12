package lotto;

abstract public class Exception extends Throwable {
    public static long checkNumeric(String input){
        long number;
        try{
            number = Long.parseLong(input);
        }
        catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    public void checkDivisible(long dividend, long divisor){
        long remainder = dividend % divisor;
        if(remainder!=0) throw new IllegalArgumentException();
    }
}
