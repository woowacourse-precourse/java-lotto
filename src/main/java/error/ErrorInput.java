package error;

public class ErrorInput {

  public static boolean isDigit(String number) {
    for (int i = 0; i < number.length(); i++) {
      if (!Character.isDigit(number.charAt(i))) {
        return false;
      }
    }
    return true;
  }
}
