package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    public enum uiMessage{
        correctLottoNumberIsThree(3,0,"3개 일치 (5,000원)"),
        correctLottoNumberIsFour(4,0,"4개 일치 (50,000원)"),
        correctLottoNumberIsFive(5,0,"5개 일치 (1,500,000원)"),
        correctLottoNumberIsFiveAndBonus(5,1,"5개 일치, 보너스 볼 일치 (30,000,000원)"),
        correctLottoNumberIsSix(6,0,"6개 일치 (2,000,000,000원)");
        private final String message;
        private final int number;
        private final int bonus;
        uiMessage(int number, int bonus, String message) {
            this.number = number;
            this.bonus = bonus;
            this.message = message;
        }
        public int getNumber() {
            return number;
        }
        public int getBonus() {
            return bonus;
        }
        public String getMessage() {
            return message;
        }

    }
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6자리여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현
    public static void lottoSystem(){
        System.out.println("구입금액을 입력해 주세요.");
        String payment = Console.readLine();
        Integer amountOfLotto = amountOfLotto(payment);
        System.out.println();
        System.out.println(amountOfLotto+"개를 구매했습니다.");
        ArrayList<List<Integer>> myLottoNumbers = getRandomLottoNumber(amountOfLotto);
        System.out.println("당첨  번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        System.out.println();
        List<Integer> getLottoNumber = getTypingWinningNumber(winningNumber);
        System.out.println("보너스 번호를 입력해 주세요");
        String bonusNumber = Console.readLine();

    }
    public static Integer amountOfLotto(String lottoPayment){
        try{
            Integer amount = 0;
            Integer payment = Integer.parseInt(lottoPayment);
            if(payment%1000 != 0){
                System.out.println("[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
                throw new IllegalArgumentException();
            }
            amount = payment/1000;
            return amount;
        } catch (NumberFormatException e){
            System.out.println("[ERROR] 구입 금액 입력은 숫자만 가능합니다.");
            throw new IllegalArgumentException();
        }
    }
    public static ArrayList<List<Integer>> getRandomLottoNumber(int amountOfLotto){
        ArrayList<List<Integer>> randomLottoNumber = new ArrayList<>();
        for(int amount=0;amount<amountOfLotto;amount++){
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers);
            randomLottoNumber.add(lottoNumbers);
        }
        return randomLottoNumber;
    }

    public static List<Integer> getTypingWinningNumber(String typing){
        try{
            String[] splitTypingNumber = typing.split(",");
            List<Integer> getWinningNumber = conversionArrayToList(splitTypingNumber);
            Lotto lotto = new Lotto(getWinningNumber);
            lotto.validate(getWinningNumber);
            System.out.println(getWinningNumber);
            return getWinningNumber;
        }
        catch (NumberFormatException e) {
            System.out.println("[ERROR] 당첨 번호 입력은 숫자와 ','만 가능합니다");
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> conversionArrayToList(String[] arr){
        List<Integer> getWinningNumber = new ArrayList<>();
        for(int arrayIndex=0;arrayIndex<arr.length;arrayIndex++){
            int number = Integer.parseInt(arr[arrayIndex]);
            if(number>45 || number<1){
                System.out.println("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            } else if (getWinningNumber.contains(number)) {
                System.out.println("[ERROR] 당첨 번호는 중복을 허용하지 않습니다.");
                throw new IllegalArgumentException();
            }
            getWinningNumber.add(number);
        }
        return getWinningNumber;
    }
}

