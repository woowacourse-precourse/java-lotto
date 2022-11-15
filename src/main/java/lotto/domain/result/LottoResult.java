package lotto.domain.result;

import static lotto.constant.ErrorMessage.ERROR_MESSAGE_OF_CONSTRUCTOR;

import java.util.List;

public class LottoResult {

  public static final String LOTTO_STATUS_START = "[";
  public static final String LOTTO_STATUS_END = "]";
  public static final String LOTTO_NUMBER_DELIMETER = ", ";
  public static final String LINE_BREAK = "\n";
  public static final String STRING_SPLIT_DELIMETER = "";

  public static final String OUTPUT_MESSAGE_OF_LOTTERY_RESULT = "당첨 통계";
  public static final String OUTPUT_MESSAGE_OF_DIVIDING_LINE = "---";

  private LottoResult() {
    throw new UnsupportedOperationException( ERROR_MESSAGE_OF_CONSTRUCTOR );
  }

  private static String getRefinedStringList(String[] numbers) {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append( LOTTO_STATUS_START );
    stringBuilder.append( String.join( LOTTO_NUMBER_DELIMETER, numbers ) );
    stringBuilder.append( LOTTO_STATUS_END );
    stringBuilder.append( LINE_BREAK );

    return stringBuilder.toString();
  }

  private static String convertString(List<Integer> numberList) {
    return numberList.toString();
  }

  public static String makeStringResultOfEveryLottoList(List<List<Integer>> numbers) {
    StringBuilder stringBuilder = new StringBuilder();

    for ( List<Integer> lotto : numbers ) {
      String[] numberList = convertString( lotto ).split( STRING_SPLIT_DELIMETER );
      stringBuilder.append( getRefinedStringList( numberList ) );
    }

    return stringBuilder.toString();
  }
}
