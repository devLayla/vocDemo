package api.demo.domain;

public enum VocStatus {
    Question("문의"),
    Claim("클레임"),
    Compensation("배상청구"),
    Penalty_Issued("패널티발급"),
    Driver_check("기사님확인"),
    Complete("처리완료");

    private String value;

    VocStatus(String value){
        this.value = value;
    }

}
