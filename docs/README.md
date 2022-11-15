# 구현할 기능 목록

- [x] 구입 금액 입력 받기 - LottoMachine#insertMoney()
    - [x] 구입 금액 입력 방식 확인 - LottoMachine#validateMoney()
    - [x] 구입 금액에 맞는 로또 개수 확인하기 - LottoMachine#checkLottoCount()
- [x] 로또 개수에 맞게 로또 새롭게 발행하기 - LottoMachine#createLotto()
- [x] 로또 발행 시 중복되지 않는 숫자 6개 뽑기 NumberAutoMachine#pickNumbers()
    -[x] 로또 번호 오름차순 정렬하기 NumberAutoMachine#sortNumbers()
- [x] 새롭게 발행된 로또에 자동으로 지정된 6개 숫자 지정해주기 Lotto#Lotto()
    - [x] 발행 된 로또 번호 개수 및 중복 확인 Lotto#validate()
- [x] 발행한 로또 수량 및 번호 출력 LottoMachine#printLottoBought()
- [x] 로또 추첨을 위해 번호를 입력받기
    - [x] 6개의 추첨 번호 입력 받기 WinningNumber#createLuckyNumber()
    - [x] 1개의 보너스 번호 입력 받기 WinningNumber#createBonusNumber()
- [x] 로또 번호, 당첨 번호, 보너스 번호 비교하기 LottoMachine#compareLotto()
    - [x] 로또 번호와 당첨 번호와 비교 LottoMachine#compareLuckyNumber()
    - [x] 로또 번호와 보너스 번호와 비교 LottoMachine#compareBonusNumber()
    - [x] 로또 결과에 따라 당첨자 추가 WinningResult#plusWinningResult()
    - [x] 구입금액과 당첨금을 통해 수익률 계산 LottoMachine#getProfit()
- [x] 비교한 값에 맞게 당첨 통계 출력 LottoMachine#printResult()
  
