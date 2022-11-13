package lotto;

public class Sample {


    public static int stringToInt(String line){ // Lotto-valid-001
        try{
            int number = Integer.parseInt(line);
            if (number % 1000 != 0)
                throw new IllegalArgumentException();
            return number;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
