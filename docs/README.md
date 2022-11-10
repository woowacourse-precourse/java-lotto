## 로또 프로그램 순서도

- - -
![로또 프로그램 순서도](https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=%E1%84%89%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%E1%84%83%E1%85%A9.png#R7VrRkps2FP0aPWYGEGB4RBhvZpp2OrMPmT51ZKMFGhm5sry28%2FWVQDJmYU2cZAtJeLI4EhY6R%2Bdyr2wA4%2B3pgeNd%2FjtLCQWOlZ4AXALHsV3Llx8KOdfIwoE1kPEi1YMa4LH4TDRoafRQpGTfGigYo6LYtcENK0uyES0Mc86O7WFPjLZn3eGMdIDHDaZd9GORirxGA2fR4O9JkeVmZtsP65413nzKODuUej7gwJW7spdJ3b3F5rv0Qvc5TtnxCoIJgDFnTNSt7SkmVHFraKvvW73Se3luTkrxJTf89nHx%2Bd%2B%2FLZZGnsftFXr3cC7f6VU%2BY3ogZhnVw4qzIYikki99ybjIWcZKTJMGRRUJRE1jyatmzAfGdhK0JfgPEeKsxccHwSSUiy3VvRSvCUUXPmNGGa8mN4xCtBecfSJXPYm1iDy5VvTESnGFwxDGni%2FxLj%2Basj078A25QYrZhphnRNwYp7lSBF1NoNl%2FIGxLBD%2FLAZxQLIrn9obDet9ml3GNdrKh5btDSrsrZbIEoQsCFyQIRDYIY5BEAC0AChQSJiAK5B0giUGAqt5YgaHd3QOUSj8qrY95IcjjDlcEHmVIaCv5VFB6LZ8Tx8Hq%2B8r3TLggp5uE617oa%2Bvp0OTqy2Pjc9sMya88HlhvJFEwu%2B1VFw26zZ2U25wet0lveSAyNgq8yluRclsQVKCnXFgbrh6gfGmByOtsA%2Fmy2KmmJBRTSijLON5KmneEF3IBhL%2Fs%2B7PpGPboiZgX8eQ9ezHoaKY1icrs2h43Dro2nJRr7R7bzlp%2BqZa2PSkx3Z4QLANrUIVgBJClkh8VYT0Vgr8%2BFvOcbdeH%2FQ%2Be%2FFwC5GiBNLxDL1d1RQugHsaqQKkdqhJaT2Wq%2FcL5VK4BrblsZap1RwIcOearIAjinyQB9ia3B%2By54LwRWIcjMJxUBLb7as5LFoyUgSPXGMxS1lU%2Bh8reNYj8ypNDWXDKNodtxeqQ%2Fdb1zviwnqQfuwXp6H6cS9IbNhv247SKUvPcLT8idbiDwspujnnhIdVWmdBSvYBVehQ33lS3uDpPCiJj4e4tcyF7h9c9Z3Sv%2B7PXX7fwsNe9SXndmY8lvknNiR1M3F%2FMfl08%2FjmKWX%2F0o3wTDeZqdrRqdvxNYELuHIP7Quvw76fTOk%2B0%2Bw6oerPnJQh8VeUq%2B0FlyLmala3F6D%2FVOH3nEb920HwpUjD6EaDTLVL%2FYB225fJEm9Y2fSUryQuuNYRpkZXyciNJq6pIRVaxwTTSHdsiTelrOraD8Vu%2Bzey2MLDnLMjr0cUkHt9fl25GM%2Bsis4yeqPb%2F6tIt2%2F8i%2B19PGBe%2BMMxibGG6v2XMwqg8AL6ZMPKy%2BcNk1Xf1r1SY%2FAc%3D "로도 프로그램 순서도")

1. 프로그램이 시작된다.
2. 구입금액을 입력받는다.
    * "구입금액을 입력해 주세요." 메시지를 출력한다.
    * 구입금액은 1,000원 단위로 입력받는다.
3. 올바른 금액을 입력 받았는지 확인한다.
    * 1000으로 나누어 떨어지지 않는 경우 예외 처리한다.
    * [ERROR] 메시지와 에러 내용을 출력한다.
4. 구매 정보를 출력한다.
    * "($갯수)개를 구매했습니다." 메시지를 출력한다.
    * 랜덤으로 뽑은 ($갯수)개의 리스트를 출력한다.
    * 로또 번호는 오름차순으로 정렬한다.
5. 당첨 번호와 보너스 번호를 입력받는다.
    * "당첨 번호를 입력해주세요." 메시지를 출력한다.
    * 당첨 번호를 ","를 기준으로 입력받는다.
    * "보너스 번호를 입력해 주세요." 메시지를 출력한다.
    * 보너스번호 1개를 입력받는다.
6. 당첨 번호와 보너스 번호를 올바르게 입력했는지 확인한다.
    * 올바르지 못한 입력이라면 예외 처리한다.
7. 당첨 통계를 출력한다.
    * 당첨 내용과 갯수, 수익률을 출력한다.

