package lotto;

public class Prize {
  private static final int firstPlacePrizeMoney = 2000000000;
  private static final int secondPlacePrizeMoney = 30000000;
  private static final int thirdPlacePrizeMoney = 1500000;
  private static final int fourthPlacePrizeMoney = 50000;
  private static final int fifthPlacePrizeMoney = 5000;

  private int totalPrizeMoney;
  private int countOfFirstPlace;
  private int countOfSecondPlace;
  private int countOfThirdPlace;
  private int countOfFourthPlace;
  private int countOfFifthPlace;

  Prize(){
    countOfFirstPlace = 0;
    countOfSecondPlace = 0;
    countOfThirdPlace = 0;
    countOfFourthPlace = 0;
    countOfFifthPlace = 0;
    totalPrizeMoney = firstPlacePrizeMoney + secondPlacePrizeMoney
            + thirdPlacePrizeMoney + fourthPlacePrizeMoney + fifthPlacePrizeMoney;
  }

  public void renewRank(int getRightCount, boolean getBonnus){
    if(getRightCount == 6){
      countOfFirstPlace++;
    } else if((getRightCount == 5) && (getBonnus)){
      countOfSecondPlace++;
    } else if(getRightCount == 5){
      countOfThirdPlace++;
    } else if(getRightCount == 4){
      countOfFourthPlace++;
    } else if(getRightCount == 3){
      countOfFifthPlace++;
    }
  }

  public void showRank(int payment){
    System.out.println("당첨 통계");
    System.out.println("---");
    System.out.println("3개 일치 (5,000원) - " + countOfFifthPlace + "개");
    System.out.println("4개 일치 (50,000원) - " + countOfFourthPlace + "개");
    System.out.println("5개 일치 (1,500,000원) - " + countOfThirdPlace + "개");
    System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countOfSecondPlace + "개");
    System.out.println("6개 일치 (2,000,000,000원) - " + countOfFirstPlace + "개");

    double rateOfReturn = ((firstPlacePrizeMoney*countOfFirstPlace) +
            (secondPlacePrizeMoney*countOfSecondPlace) +
            (thirdPlacePrizeMoney*countOfThirdPlace) +
            (fourthPlacePrizeMoney*countOfFourthPlace) +
            (fifthPlacePrizeMoney*countOfFifthPlace)) / (double)payment;

    System.out.println("총 수익률은 " + (Math.round(rateOfReturn)/10.0) + "%입니다.");
  }
}
