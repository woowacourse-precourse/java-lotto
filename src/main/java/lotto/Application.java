package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
enum MatchCount {
    THREE(3,"5,000원"),FOUR(4,"50,000원"),
    FIVE(5,"1,500,000원"),FIVE_BONUS(5,"30,000,000원"),
    SIX(6,"2,000,000,000원");
    private final int value;
    private final String prize;
    MatchCount(int value,String prize) {
        this.value=value;
        this.prize=prize;
    }
    public int getValue() {
        return value;
    }
    public String getPrize() {
        return prize;
    }
}

public class Application {
    private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_ANSWER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String PRICE_MESSAGE = "값이 1000으로 나누어지지 않습니다.";
    private static final String ANSWER_MESSAGE = "번호가 6개가 아닙니다";
    private static final String LUCKY_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String OUT_OF_RANGE_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다";
    private static final String SHOP_RESULT = "개를 구매했습니다.";
    private static final String IS_DUPLICATED_MESSAGE = "숫자가 중복되었습니다.";
    private static final String LOTTO_RESULT = "당첨 통계";
    private static final String LOTTO_RESULT_LINE="---";
    private static final String MATCH="개 일치 ";
    private static final String COUNT="개";

    public static void main(String[] args) {
        int myPrice = priceInput();
        int lottoCount=howManyLottos(myPrice);
        System.out.println(lottoCount+SHOP_RESULT);

        List<List<Integer>> myLottos=getMyLottos(lottoCount);
        for(List<Integer> myLotto:myLottos){
            System.out.println(myLotto);
        }

        List<Integer> lottoNumbers = lottoNumAnswerInput();
        Lotto lottoAnswer = new Lotto(lottoNumbers);
        int luckyNumber = getLuckyNumber();

        lottoResult(lottoAnswer,luckyNumber,myLottos);
    }
    public static void lottoResult(Lotto answer, int luckyNum, List<List<Integer>> lottos){
        System.out.println(LOTTO_RESULT);
        System.out.println(LOTTO_RESULT_LINE);
//        System.out.println(matchNum + MATCH + price + count + COUNT);
    }

    public static List<List<Integer>> getMyLottos(int count){
        List<List<Integer>> totalLottos=new ArrayList<>();
        List<Integer> numbers;
        for (int loop=0;loop<count;loop++){
            numbers=Randoms.pickUniqueNumbersInRange(1, 45, 6);
            isValidateNumbers(numbers);
            isDuplicated(numbers);
            Collections.sort(numbers);
            totalLottos.add(numbers);
        }
        return totalLottos;

    }
    public static int howManyLottos(int price){
        return price/1000;
    }

    public static void validatePrice(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + PRICE_MESSAGE);
        }
    }

    public static int priceInput() {
        System.out.println(INPUT_MESSAGE);
        String getPrice = Console.readLine();
        int price = Integer.valueOf(getPrice);
        validatePrice(price);
        return price;
    }

    public static void validateInputForm(String input) {
        int count = 0;
        for (int charIndex = 0; charIndex < input.length(); charIndex++) {
            if (input.charAt(charIndex) == ',') {
                count++;
            }
        }
        if (count != 5) {
            throw new IllegalArgumentException(ANSWER_MESSAGE);
        }

    }

    public static List<Integer> lottoNumAnswerInput() {
        List<Integer> lottoNumbers = new ArrayList<>();
        System.out.println(LOTTO_ANSWER_INPUT_MESSAGE);
        String lottoInput = Console.readLine();
        validateInputForm(lottoInput);
        String[] tempInput = lottoInput.split(",");

        for (String num : tempInput) {
            lottoNumbers.add(Integer.valueOf(num));
        }
        return lottoNumbers;
    }

    public static int getLuckyNumber() {
        System.out.println(LUCKY_NUMBER_INPUT_MESSAGE);
        String getLuckyNum = Console.readLine();
        int luckyNum = Integer.valueOf(getLuckyNum);
        isValidateNumber(luckyNum);
        return luckyNum;
    }
    public static void isDuplicated(List<Integer> numbers){
        for(Integer num : numbers){
            if(Collections.frequency(numbers,num)!=1){
                throw new IllegalArgumentException(ERROR_MESSAGE + IS_DUPLICATED_MESSAGE);
            }
        }
    }
    public static void isValidateNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE + OUT_OF_RANGE_MESSAGE);
        }
    }
    public static void isValidateNumbers(List<Integer> numbers){
        for(Integer num : numbers){
            if(num<1||num>45){
                throw new IllegalArgumentException(ERROR_MESSAGE + OUT_OF_RANGE_MESSAGE);
            }
        }
    }
}
