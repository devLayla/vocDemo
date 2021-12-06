package api.demo.domain;

public enum CheckDriver {
    WAITING("대기"),
    OK("확인완료");

    private String value;

    CheckDriver(String value){
        this.value = value;
    }

}
