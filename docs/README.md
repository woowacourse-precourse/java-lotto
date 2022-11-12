#로또 게임
1. 구입금액 입력(예외 : 1000원 단위 아닐 경우)
2. 로또 번호 발행 및 출력
3. 당첨 번호 입력(예외 : 중복되는 숫자 입력시, 숫자가 아닌 문자 입력시, 범위 밖의 숫자 입력시)
4. 보너스 번호 입력(예외 : 당첨번호에 포함되는 숫자 입력시, 숫자가 아닌 문자 입력시, 범위 밖의 숫자 입력시)
5. 당첨 번호와 로또 번호 비교
6. 당첨 통계 출력
7. 수익률 출력

##기능 목록
- [ ] 로또 개수 입력 - LottoManager # inputLottoCount
  - [ ] 숫자인지 확인
  - [ ] 1000 원  위 확인
- [x] 1부터 45까지 서로 다른 수로 이루어진 6개의 로또번호 생성 - NumberGenerator#createLottoNumber
  - [x] 사이즈 확인 - Lotto#validate
  - [x] 중복 검사 - Lotto#checkOverlap
  - [x] 로또번호 출력 - LottoManager#printLottoNumbers
- 1부터 45까지 서로 다른 수로 이루어진 6개의 번호와 1개의 서비스 번호를 입력한다.
  - [ ] 당첨 번호 입력 - LottoManager #inputWinningNumbers
    - [ ] 사이즈 확인 - WinningNumbers #validate
    - [ ] 중복 검사 - WinningNumbers #checkOverlap
    - [ ] 범위 확인 - WinningNumbers #checkScope
  - [x] 보너스 번호 입력 - LottoManager# inputBonusNumber
    - [ ] 숫자인지 확인
    - [ ] 범위 확인 - WinningNumbers #checkScope
  - [ ] 당첨번호가 보너스 번호를 포함하는지 확인 - WinningNumbers #checkInclusion
- [ ] 로또 번호(6자리)와 당첨 번호(6자리, 보너스 번호 1개)를 비교한다. - LottoManager#compare
  - [x] 당첨번호 중 몇개의 숫자가 같은지 알 수 있다. - Judgement#correctCount
    - [x] 보너스 번호가 있는지 알 수 있다.(당첨번호 5자리가 같은 경우만) - Judgement#hasWinningNumber
  - [ ] 수익률 계산 - LottoCalculator#sumOfPrizeMoney
  - [ ] 당첨 내역 출력 - LottoManager#printWinningDetails
  - [ ] 수익률 출력 - LottoManager#printRateOfReturn
    