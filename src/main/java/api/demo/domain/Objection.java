package api.demo.domain;

public enum Objection {
    WAITING("대기"),
    YES("이의제기"),
    NONE("이의없음");

    private String value;

    Objection(String value){
        this.value = value;
    }

}
