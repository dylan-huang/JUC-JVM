package pers.dylan.drools;

public class Result {

    private String code;

    private String info;

    public Result(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public Result() {
    }

    public static Result buildResult(String code, String info) {
        return new Result(code, info);
    }

    public void setResult(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(code);
        sb.append("|").append(info);
        return sb.toString();
    }
}
