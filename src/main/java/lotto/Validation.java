package lotto;

import static lotto.response.Error.LOTTO_NUMBER_COUNT_ERROR;
import static lotto.response.Error.LOTTO_NUMBER_DUPLICATION_ERROR;
import static lotto.response.Error.LOTTO_NUMBER_OUT_OF_RANGE_ERROR;
import static lotto.response.Error.LOTTO_PURCHASE_MONETARY_UNIT_ERROR;
import static lotto.response.Error.LOTTO_PURCHASE_TYPE_ERROR;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validation {

  /**
   * Verify that the lotto number is formatted correctly.
   * @param numbers The number of lotto.
   */
  public static void validateLotto(List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR.toString());
    }
    if (!isDistinct(numbers)) {
      throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATION_ERROR.toString());
    }
    if (outOfRange(numbers)) {
      throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE_ERROR.toString());
    }
  }

  /**
   * Verify that the purchase amount is formatted correctly.
   * @param amount The number of purchase amount.
   */
  public static void validatePurchase(String amount) {
    if (!isNumeric(amount)) {
      throw new IllegalArgumentException(LOTTO_PURCHASE_TYPE_ERROR.toString());
    }
    if (Integer.parseInt(amount) % 1000 != 0) {
      throw new IllegalArgumentException(LOTTO_PURCHASE_MONETARY_UNIT_ERROR.toString());
    }
  }

  /**
   * Verify that the answer number is formatted correctly.
   * @param numbers The number of answer.
   */
  public static void validateAnswer(String[] numbers) {
    for(String number: numbers) {
      if (!isNumeric(number)) {
        throw new IllegalArgumentException(LOTTO_PURCHASE_TYPE_ERROR.toString());
      }
    }
    List<Integer> numberList = Arrays.stream(numbers)
        .map(Integer::parseInt).collect(Collectors.toList());
    validateLotto(numberList);
  }

  /**
   * Verify numbers contains number that have been used once.
   * @param numbers the list of integer to be checked.
   * @return true if no duplicate value exists.
   */
  private static boolean isDistinct(List<Integer> numbers) {
    return numbers.stream().distinct()
        .count() == numbers.size();
  }

  /**
   * Check if the Lotto number is out of range.
   * @param numbers the list of integer to be checked.
   * @return false if number is not in between 1 and 45.
   */
  private static boolean outOfRange(List<Integer> numbers) {
    return numbers.stream().anyMatch(num -> num<1 || num>45);
  }

  /**
   * Verify string is numeric.
   * @param string the string to be checked.
   * @return true if string is numeric.
   */
  private static boolean isNumeric(String string) {
    try {
      Double.parseDouble(string);
      return true;
    } catch(NumberFormatException e){
      return false;
    }
  }
}
