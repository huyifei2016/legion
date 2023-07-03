package model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Log {
    private String suitName;
    private String testClass;
    private String method;
    private long time;
    private int status;
    private String result;
    private String exceptionInfo;




    @Override
    public String toString() {
        return "Log{" +
                "suitName='" + suitName + '\'' +
                ", testClass='" + testClass + '\'' +
                ", method='" + method + '\'' +
                ", time=" + time +
                ", status=" + status +
                ", result='" + result + '\'' +
                ", exceptionInfo='" + exceptionInfo + '\'' +
                '}';
    }

    public String getSuitName() {
        return suitName;
    }

    public void setSuitName(String suitName) {
        this.suitName = suitName;
    }

    public String getTestClass() {
        return testClass;
    }

    public void setTestClass(String testClass) {
        this.testClass = testClass;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }
}
