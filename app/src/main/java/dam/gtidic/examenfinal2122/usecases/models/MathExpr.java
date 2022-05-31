package dam.gtidic.examenfinal2122.usecases.models;

public class MathExpr {

    private String operator1;
    private Operations operation;
    private String operator2;
    private String result;

    public MathExpr(String operator1, Operations operation, String operator2, String result) {
        this.operator1 = operator1;
        this.operation = operation;
        this.operator2 = operator2;
        this.result = result;
    }

    public String getOperator1() {
        return operator1;
    }

    public void setOperator1(String operator1) {
        this.operator1 = operator1;
    }

    public Operations getOperation() {
        return operation;
    }

    public void setOperation(Operations operation) {
        this.operation = operation;
    }

    public String getOperator2() {
        return operator2;
    }

    public void setOperator2(String operator2) {
        this.operator2 = operator2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "MathExpr{" +
                "operator1=" + operator1 +
                ", operation=" + operation +
                ", operator2=" + operator2 +
                ", result=" + result +
                '}';
    }
}
