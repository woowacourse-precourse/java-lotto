# 기능 목록
1. 로또 구입 금액 입력
2. 당첨 번호 및 보너스 번호 입력
3. 입력 값 유효성 검사
4. 입력값(로또 구입 금액) => Lotto Instance 생성
5. Lotto Instance 유효성 검사
6. 생성된 Lotto Instance의 수량 및 번호 출력
7. 입력값(당첨번호, 보너스 번호) => winning Lotto Instance 생성
8. winning Lotto 유효성 검사
9. Lotto Instance와 winning Lotto 비교
10. (4) => 로또 수량 및 번호 출력
11. (8) => 당첨 내역 출력
12. 예외 처리

# 클래스 설계
#### 1. Lotto
기능 4,5
#### 2. WinningLotto (extends Lotto)
기능 7,8
#### 3. IOController (maybe static, maybe split to Input and Output Class)
기능 1,2,3,6,10,11
#### 4. LottoRepository
기능 9
#### 5. Enum?

# 기능 요구사항 - 로또
## 로또
1. 숫자 범위 1~45, 중복X
2. 발행시 : 6자리의 숫자
3. 추첨시 : 숫자 6개 + 보너스 번호 1개
## 발행 및 처리
1. 로또 1장 1000원
2. 구입 금액 입력 => 해당하는 만큼 로또 발행
3. 로또 번호(생성)과 당첨 번호(입력)를 비교 => 당첨 내역 및 수익률 출력
4. 잘못된 값 입력시 IllegalArgumentException 발생
## 입출력
###입력
1. 구입 금액은 천원 단위 => 아닐경우 예외처리
2. 당첨 번호 입력 => 번호는 쉼표를 기준으로 (ex 1,2,3,4,5,6)
3. 보너스 번호 입력
###출력
1. 로또 번호 및 수량 출력(오름차순)
2. 당첨 내역 출력
3. 수익률은 소수점 둘째 자리에서 반올림 (ex 62.5%)
4. 예외 발생시 => 에러메시지 출력

# 비기능적 요구사항
## 프로그래밍 요구사항
1. depth 최대 2
2. JUnit을 이용한 테스트 코드 작성, 도메인 로직에 단위 테스트 구현
3. 함수 최대 15라인
4. else 사용X
5. Java enum 사용
6. camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용
## 로또 클래스 요구사항
1. NoArgConstructor 금지
2. private numbers 유지
3. 필드 추가X
4. 패키지 변경은 가능


