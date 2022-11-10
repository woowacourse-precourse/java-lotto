package lotto.view;

import java.util.List;

public class Printer {

    void printInputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    void printNumberOfPurchasedLotto(int lottoNumber){
        System.out.println(lottoNumber +"개를 구매했습니다.");
    }

    void printPurchasedLotto(List<List<Integer>> purchasedLotto){
        for(List<Integer> lotto : purchasedLotto){
            String message = "[";
            for(int lottoNumber : lotto){
                message += (lottoNumber + ", ");
            }
            message = message.substring(0, message.length() - 1); // 마지막 공백 제거
            message += "]";
            System.out.println(message);
        }
    }

    void printInputWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    void printInputWinningBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
