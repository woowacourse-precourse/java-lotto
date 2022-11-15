# 미션 - 로또

## 🚀 기능 설명

### Lotto.java
Lotto class의 경우, 보너스 번호를 제외한 입력받은 당첨번호 6개에 대해 예외처리를 할 수 있도록 하였다.

- validateDuplicatedNumber
    - 입력된 당첨번호 6개 중 중복된 번호가 있을 경우, `IllegalArgumentException`을 발생시킨다.
    

- validateNumberInRange
    - 입력된 당첨번호 6개 중 하나라도 1~45의 범위를 벗어나면 `IllegalArgumentException`을 발생시킨다.



### Application.java
Application class의 경우, 자동 로또번호 생성, 당첨 통계 출력 등 로또 기능 구현에 필요한 전반적인 기능을 다루도록 하였다.

- createAutoNumbers
    - 구매 금액을 입력받으면 그에 따른 로또 번호를 출력할 수 있는 기능
    - 이후에 있을 당첨통계를 위해 List<HashSet<Integer>>를 return 하도록 하였다.


- createLottoNumber
    - 입력받은 당첨번호를 List<Integer>로 바꾸도록 하는 기능

- createBonusNumber
    - 보너스 번호를 입력받으며 보너스 번호가 1~45 안에 있는 숫자인지, 입력받은 6개의 당첨번호와 중복되지는 않는지 확인하는 기능

- prize
    - enum으로, createBonusNumber와 createLottoNumber, crateWinningNumber를 통해 순위, 금액을 return 받을 수 있도록 한 기능
    - findRankByMatch
      - 당첨숫자 중 맞춘 개수(int)와 보너스 여부(boolean)로 순위를 return 받는 기능
    - findTextByRank
      - 당첨통계 출력 시 사용하는 기능으로 순위에 따라 해당되는 텍스트를 출력한다.
    - findPrizeByRank
      - 당첨통계 출력 시 사용하는 기능으로 순위에 따라 해당되는 상금을 출력한다.

- createLottoStatistics
  - 구매한 로또들에 대한 당첨 통계를 나타낸 기능
  - enum의 findRankByMatch를 통해 통계를 내도록 하였다.

- printLottoStatistics
    - 앞서 LottoStatistics을 통해 얻은 통계를 출력하는 기능
    - findTextByRank와 findPrizeByRank를 통해 출력하도록 하였다.