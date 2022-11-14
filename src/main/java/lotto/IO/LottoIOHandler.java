package lotto.IO;

import lotto.Domain.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LottoIOHandler extends IOHandler {
    // 로또 당첨 번호를 입력한다.
    public List<Integer> getLottoAnswer(){
        System.out.println("당첨 번호를 입력해 주세요.");
        validateInput(getUserInput());
        return convertStringToIntList(input);
    }

    // "~,~" 형식의 문자열을 리스트로 변환한다.
    public List<Integer> convertStringToIntList(String input){
        List<Integer> numbers = new ArrayList<>();
        String[] num = input.split(",");
        for (String s : num) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }

    // 사용자가 ","구분자 없이 입력한 경우:
    // 4[0-6]or[1-3][0-9]or[0-9]가 5번 반복 이후 4[0-6]or[1-3][0-9]or[0-9] 오는지 확인
    @Override
    public void validateInput(String input) {
        Pattern pass = Pattern.compile("^(?:4[0-5][,]|[1-3][0-9][,]|[1-9][,]){5}(?:[4][0-6]|[1-3][0-9]|[1-9])$");
        Matcher matcher = pass.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException("[ERROR] , 구분자를 통해 1~45사이의 수 6개를 입력해주세요");
        }
    }

    // 수익률 측정
    public String printStatistics(List<Rank> ranks,int purchaseAmount){
        double yield=0;
        for(Rank rank:ranks){
            yield+=rank.getPrizeMoney();
        }
        return String.format("%.1f",(yield/purchaseAmount)*100);
    }

    // 당첨 결과 반환
    public int[] getResult(List<Rank> ranks){
        int[] rankCount = new int[5];
        for(Rank rank:ranks){
            if(rank.getRank()!=6)
                rankCount[rank.getRank()-1]++;
        }
        return rankCount;
    }

    // 사용자에게 로또 당첨 통계 출력
    public void printResult(List<Rank> ranks,int purchaseAmount){
        int[] rankCount = getResult(ranks);
        System.out.println("3개 일치 (5,000원) - "+rankCount[4]+"개\n"+
                "4개 일치 (50,000원) - "+rankCount[3]+"개\n"+
                "5개 일치 (1,500,000원) - "+rankCount[2]+"개\n"+
                "5개 일치, 보너스 볼 일치 (30,000,000원) - "+rankCount[1]+"개\n"+
                "6개 일치 (2,000,000,000원) - "+rankCount[0]+"개\n"+
                "총 수익률은 "
                +printStatistics(ranks,purchaseAmount)
                +"%입니다.");
    }
}
