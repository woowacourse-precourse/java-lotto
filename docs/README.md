## 로또 기능 목록
- [ ] User가 구입금액을 1000단위로 입력한다. User#buyLotto
- [ ] Lotto가 구입금액을 1000으로 나눠 로또 갯수를 구하여 출력한다. Lotto#printLotto
- [ ] Lotto가 로또 배열 하나에 1~45까지 중복되지 않은 6개의 숫자를 랜덤으로 뽑아 보여준다. Lotto#putRandomNumbers
- [ ] User가 당첨 번호와 보너스 번호를 입력한다. User#userNumbers, User#userBonusNumber
- [ ] LotteryMachine이 당첨 번호와 보너스 번호를 입력받아, 각 복권과 비교한다. LotteryMachine#countWinningNumber
- [ ] LotteryMachine이 일치하는 숫자의 개수와 당첨 case를 매칭한다. LotteryMachine#matchWinningCase
  - case1: 당첨 번호와 복권의 번호 중 3개가 일치하는 경우
  - case2: 당첨 번호와 복권의 번호 중 4개가 일치하는 경우
  - case3: 당첨 번호와 복권의 번호 중 5개가 일치하는 경우
  - case4: case3 + 보너스 번호를 포함하여 일치하는 경우
  - case5: 당첨 번호와 복권의 번호 중 6개가 일치하는 경우
- [ ] Calculator가 당첨 case별로 발생한 수익금을 계산한다. Calculator#calculateRevenue
- [ ] Calculator가 수익금을 통해 수익률을 계산하여 보여준다. Calculator#calculateRate

## 예외 케이스 추가(예정)
- [ ] 구입 금액이 1000단위가 아니라면 IllegalArgumentException을 발생시킨다.
    
