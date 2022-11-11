package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Computer {

    public List<List<Integer>> issuedLotto(int amount) {
        List<List<Integer>> lottoList = new ArrayList<>();
        printAmount(amount);
        generateLotto(amount, lottoList);
        sortLotto(lottoList);
        printLottoList(lottoList);
        return lottoList;
    }

    public void printAmount(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void generateLotto(int amount, List<List<Integer>> lottoList) {
        List lotto = new ArrayList();
        for (int idx = 0; idx < amount; idx++) {
            lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(lotto);
        }
    }

    public void sortLotto(List<List<Integer>> lottoList) {
        for (List lotto : lottoList) {
            Collections.sort(lotto);
        }
    }

    public void printLottoList(List<List<Integer>> lottoList) {
        for (List lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public List inputWinningNumber () {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winnigNumberList = new ArrayList<>();
        String number = inputNumber();
        winnigNumberList = convertToList(splitNumber(number));
        return winnigNumberList;
    }

    public String inputNumber() {
        String number = Console.readLine();
        return number;
    }

    public int[] splitNumber(String number) {
        String[] numberArray = number.split(",");
        int[] intArray = isValid(numberArray);
        return intArray;
    }

    public int[] isValid(String[] numberArray) {
        isNum(numberArray);
        int[] intArray = isCorrectRange(numberArray);
        isCorrectSize(intArray);
        return intArray;
    }

    public void isNum(String[] numberArray) {
        for(String number : numberArray){
            findText(number);
        }
    }

    public void findText(String number) {
        for(char item : number.toCharArray()) {
            if(!Character.isDigit(item)) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
            }
        }
    }

    public int[] isCorrectRange(String[] numberArray){
        int[] intArray = Arrays.stream(numberArray).mapToInt(Integer::parseInt).toArray();
        for(int number : intArray){
            if(!(number >= 1 && number <= 45)){
                throw new IllegalArgumentException("[ERROR] 1부터 45까지의 숫자만 입력할 수 있습니다.");
            }
        }
        return intArray;
    }

    public void isCorrectSize(int[] intArray) {
        Set sizeAndDupCheck = new HashSet<>();
        for(int number : intArray){
            sizeAndDupCheck.add(number);
        }
        if(sizeAndDupCheck.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자를 입력할 수 없고, 6개의 숫자만 입력할 수 있습니다.");
        }
    }

    public List convertToList(int[] numberArray) {
        List<Integer> numberList = new ArrayList<>();
        for(int number : numberArray){
            numberList.add(number);
        }
        return numberList;
    }
}