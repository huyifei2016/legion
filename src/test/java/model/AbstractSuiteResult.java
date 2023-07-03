package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractSuiteResult {
    private String suitName;

    public String getSuitName() {
        return suitName;
    }

    public void setSuitName(String suitName) {
        this.suitName = suitName;
    }
}
