# 구현할 기능 목록

- [x] 구입 금액 입력 받기 - Game#insertMoney()
- [x] 구입 금액에 맞는 로또 개수 확인하기 - Game#buyLotto()
- [x] 로또 개수에 맞게 로또 새롭게 발행하기 - Game#createLotto()
- [x] 로또 발행 시 중복되지 않는 숫자 6개 뽑기 LottoAutoMachine#pickNumbers()
- [x] 새롭게 발행된 로또에 자동으로 지정된 6개 숫자 지정해주기 Lotto#Lotto()
- [] 발행한 로또 수량 및 번호 출력 (오름차순으로 정렬)
- [x] 로또 추첨을 위해 번호를 입력받기 LottoWin#
    - [x] 6개의 추첨 번호 입력 받기 LottoWin#createLuckyNumber()
    - [x] 1개의 보너스 번호 입력 받기 LottoWin#createBonusNumber()
- [] 로또 번호, 당첨 번호 비교하기 Game#
  - [] 비교한 값에 맞게 당첨 통계 출력 Game#printWinner
  - [] 구입금액과 당첨금을 통해 수익률 계산 및 출력 Game#printProfit
