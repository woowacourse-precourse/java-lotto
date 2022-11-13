package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoWin {

    private List<Integer> luckyNumbers;
    private final int luckyNumberSize = 7;

    
    // 로또 당첨, 보너스 번호 입력 확인 및 예외 처리
    private void validate(List<Integer> luckyNumbers) {
        if (luckyNumbers.size() != luckyNumberSize) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호가 부족합니다.");
        }
    }

    // 로또 당첨 번호 입력
    private void createLuckyNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        String[] number = numbers.split(",");
        for(int i=0; i<number.length; i++){

            luckyNumbers.add(Integer.parseInt(number[i]));
        }


    }

    // 로또 보너스 번호 입력
    private void createBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        luckyNumbers.add(bonusNumber);
    }
}
