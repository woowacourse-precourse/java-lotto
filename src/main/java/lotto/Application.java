package lotto;

import java.util.*;
import java.text.NumberFormat;
import java.lang.IllegalArgumentException;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static int money;
    static int lottoNum;
    static final int lottoLength = 6; //로또 길이 상수
    static final int lottoMin = 1; //로또 번호 최소값
    static final int lottoMax = 45; //로또 번호 최대값
    static List<Lotto> lottoList;
    static List<Integer> hitNumber;
    static int bonus;

    static int castInt(String str){
        int num = 0;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException ex){
            throw new IllegalArgumentException(); //Error message 추후 수정
        }
        return num;
    }

    static int singleNumberInput(){
        int inputNum = castInt(Console.readLine());
        return inputNum;
    }

    static List<Integer> createLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(lottoMin, lottoMax, lottoLength);
        Collections.sort(numbers);
        return numbers;
    }

    static List<Lotto> createLottoList(int lottoNum){
        List<Lotto> lottoList = new ArrayList<>(lottoNum);
        for (int lottoIndex = 0; lottoIndex < lottoNum; lottoIndex++) {
            lottoList.add(new Lotto(createLotto()));
        }
        return lottoList;
    }
    static void printLottoList(List<Lotto> lottoList){
        for (Lotto lotto : lottoList)
            lotto.print();
    }

    static List<String> parsingStringInput(){
        String hitString = Console.readLine();
        List<String> hitStringParsed = Arrays.asList(hitString.split(","));
        return hitStringParsed;
    }

    static List<Integer> multiNumberInput(){
        List<String> stringParsed = parsingStringInput();
        List<Integer> multiNumberList = new ArrayList<>(lottoNum);
        for (int i = 0; i < lottoLength; i++) {
            multiNumberList.add(castInt(stringParsed.get(i)));
        }
        return multiNumberList;
    }

    public static void main(String[] args) {
        System.out.println("구매금액을 입력해주세요");
        money = singleNumberInput();

        lottoNum = money / 1000;
        System.out.println(lottoNum + "개를 구매했습니다.");

        lottoList = createLottoList(lottoNum);
        printLottoList(lottoList);

        System.out.println("당첨 번호를 입력해주세요.");
        hitNumber = multiNumberInput();

        System.out.println("보너스 번호를 입력해주세요.");
        bonus = singleNumberInput();
    }
}
