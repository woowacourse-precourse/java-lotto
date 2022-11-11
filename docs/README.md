#로또 게임
1. 구입금액 입력
2. 로또 번호 발행 및 출력
3. 당첨 번호 입력
4. 보너스 번호 입력
5. 당첨 번호와 로또 번호 비교 및 같은 개수가 몇개인지 저장
6. 
7. 당첨 통계 출력

##기능 목록
- [x] 1부터 45까지 서로 다른 수로 이루어진 6개의 로또번호 생성 - NumberGenerator#createLottoNumber
  - [x] 사이즈 확인 - Lotto#validate
  - [x] 중복 검사 - Lotto#checkOverlap
  - [x] 로또번호 출력 - Lotto#printLotto
- 1부터 45까지 서로 다른 수로 이루어진 6개의 번호와 1개의 서비스 번호를 입력한다.
  - [ ] 당첨 번호 입력 - NumberGenerator#createWinningNumber
    - [ ] 사이즈 확인
    - [ ] 중복 검사
    - [ ] 범위 확인
  - [x] 보너스 번호 입력 - NumberGenerator#createBonusNumber
    - [ ] 숫자인지 확인
    - [ ] 범위 확인
- [ ] 로또 번호(6자리)와 당첨 번호(6자리, 보너스 번호 1개)를 비교한다. - LottoManager#compare
  - [x] 당첨번호 중 몇개의 숫자가 같은지 알 수 있다. - Judgement#correctCount
    - [x] 보너스 번호가 있는지 알 수 있다.(당첨번호 5자리가 같은 경우만) - Judgement#hasWinningNumber
  - [ ] 당첨 내역 출력 - LottoManager#printWinningDetails
  - [ ] 수익률 출력 - LottoManager#printRateOfReturn
    - [ ] 당첨 금액 합산 - LottoManager#sumOfPrizeMoney