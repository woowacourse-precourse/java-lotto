## 📝 구현 기능 목록
- [X] 로또 구입 금액 입력
  - [X] [예외 처리] 1000원으로 나누어 떨어지지 않는 경우
  - [X] [예외 처리] 문자열이 입력된 경우
- [X] 발행 로또 수량 출력
- [X] 로또 발행
  - [X] 랜던 번호 생성
    - [X] [예외 처리] 생성한 숫자가 6개가 아닌 경우
    - [X] [예외 처리] 중복되는 숫자가 있는 경우
  - [X] 오름차순 정리
  - [X] 발행한 로또 번호 출력
- [X] 당첨 번호 입력
  - [X] [예외 처리] 당첨 번호가 범위(1~45)를 벗어나는 경우
  - [X] [예외 처리] 문자가 입력되는 경우
  - [X] [예외 처리] 중복되는 숫자가 있는 경우
  - [X] [예외 처리] 당첨 번호가 쉼표(,)로 구분되지 않은 경우
- [ ] 보너스 번호 입력
  - [ ] [예외 처리] 보너스 번호가 범위(1~45)를 벗어나는 경우
  - [ ] [예외 처리] 당첨 번호와 중복되는 경우
- [ ] 당첨 결과 확인
  - [ ] 당첨 숫자와 비교
  - [ ] 보너스 숫자와 비교
- [ ] 당첨 내역 출력
- [ ] 수익률 계산 및 출력
- [ ] 프로그램 종료


## Commit log
- 2022.11.13
  - docs: add feature list and commit log

- 2022.11.14
  - feat: add game class
  - feat: add print class and print money input string
  - feat: add user's purchase amount
  - refactor: modify exception
  - test: string to int money test
  - feat: add output class and print the number of lottos
  - style: change variable name

- 2022.11.15
  - feat: issue lottos
  - refactor: relocate output methods to print class
  - refactor: issue lottos
  - feat: check random lotto numbers validation
  - refactor: refactoring issue lottos exception validate
  - feat: sort in ascending order
  - refactor: add lotto issue method
  - feat: add print lottos
  - test: issue lotto test
  - refactor: modify exception string
  - feat: print winnging number message
  - feat: input winning lotto number
  - refactor: return winning number to lotto
  - feat: add winning number validation
  - refactor: separate createWinningLotto method
  - test: test winning number validation