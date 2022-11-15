package lotto;

import java.util.List;

public class Validation {

  /**
   * Verify numbers contains number that have been used once.
   * @param numbers the list of integer to be checked.
   * @return true if no duplicate value exists.
   */
  public static boolean isDistinct(List<Integer> numbers) {
    return numbers.stream().distinct()
        .count() == numbers.size();
  }

  /**
   * Check if the Lotto number is out of range.
   * @param numbers the list of integer to be checked.
   * @return false if number is not in between 1 and 45.
   */
  public static boolean outOfRange(List<Integer> numbers) {
    return numbers.stream().anyMatch(num -> num<1 || num>45);
  }

  /**
   * Verify string is numeric.
   * @param string the string to be checked.
   * @return true if string is numeric.
   */
  public static boolean isNumeric(String string) {
    try {
      Double.parseDouble(string);
      return true;
    } catch(NumberFormatException e){
      return false;
    }
  }
}
