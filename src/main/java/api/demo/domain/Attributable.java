package api.demo.domain;

public enum Attributable {
    CARRIER("운송사"),
    DRIVER("기사");

    private String value;

    Attributable(String value){
        this.value = value;
    }

}
