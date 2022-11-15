## 로또 기능 목록
- [X] User가 구입금액을 1000단위로 입력한다. User#buyLotto
- [X] Lotto가 구입금액을 1000으로 나눠 로또 갯수를 구하여 출력한다. Lotto#printLotto
- [X] Lotto가 로또 배열 하나에 1~45까지 중복되지 않은 6개의 숫자를 랜덤으로 뽑아 보여준다. Lotto#printRandomNumbers
  - [X] 로또 번호를 오름차순으로 정렬하여 보여준다.
- [X] User가 당첨 번호와 보너스 번호를 입력한다. User#userNumbers, User#userBonusNumber
- [X] LotteryMachine이 당첨 번호와 보너스 번호를 입력받아, 각 복권과 비교한다. LotteryMachine#countWinningNumber
- [X] LotteryMachine이 일치하는 숫자의 개수와 당첨 case를 매칭하여 당첨금을 계산한다. LotteryMachine#matchWinningCase
  - case1: 당첨 번호와 복권의 번호 중 3개가 일치하는 경우
  - case2: 당첨 번호와 복권의 번호 중 4개가 일치하는 경우
  - case3: 당첨 번호와 복권의 번호 중 5개가 일치하는 경우
    - [X] case3인 경우 보너스 번호와 일치하는 지 확인한다.
  - case4: case3 + 보너스 번호를 포함하여 일치하는 경우
  - case5: 당첨 번호와 복권의 번호 중 6개가 일치하는 경우
- [X] Lotto에서 당첨 통계를 보여준다. Lotto#winningStatistics
- [X] LotteryMachine이 수익금을 통해 수익률을 계산하여 보여준다. LotteryMachine#calculateRate


## 예외 케이스 추가
- [X] 구입 금액이 1000단위가 아니라면, "[ERROR]"로 시작하는 에러 문구를 출력한다.
- [X] 당첨 번호를 1~45 범위 밖의 숫자를 입력하면, "[ERROR]"로 시작하는 에러 문구를 출력한다.
    
