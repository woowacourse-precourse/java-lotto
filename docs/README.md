#로또 게임

##기능 목록
- 1부터 45까지 서로 다른 수로 이루어진 6개의 로또번호 생성 - NumberGenerator#createLottoNumber
  - 사이즈 확인 - Lotto#validate
  - 중복 검사 - Lotto#duplicate
- 1부터 45까지 서로 다른 수로 이루어진 6개의 번호와 1개의 서비스 번호를 입력한다.
  - 당첨 번호 입력 - NumberGenerator#makeWinningNumber
  - 보너스 번호 입력 - NumberGenerator#makeBonusNumber
- 로또 번호(6자리)와 당첨 번호(6자리, 보너스 번호 1개)를 비교한다. - Machine#compare
  - 당첨번호 중 몇개의 숫자가 같은지 알 수 있다. - Judgement#correctCount
    - 보너스 번호가 있는지 알 수 있다.(당첨번호 5자리가 같은 경우만) - Judgement#hasWinningNumber
  - 당첨 내역 출력 - Machine#printWinningDetails
  - 수익률 출력 - Machine#printRateOfReturn
    - 당첨 금액 합산 - Machine#sumOfPrizeMoney