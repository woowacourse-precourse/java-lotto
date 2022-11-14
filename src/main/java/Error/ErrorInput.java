package Error;

public class ErrorInput {

  public static int isDigit(String number) {
    int res;

    for (int i = 0; i < number.length(); i++) {
      if (Character.isDigit(number.charAt(i)) == false) {
        throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
      }
    }
    res = Integer.parseInt(number);
    return res;
  }
}
