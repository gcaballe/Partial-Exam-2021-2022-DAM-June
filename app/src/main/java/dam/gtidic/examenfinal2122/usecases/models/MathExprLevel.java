package dam.gtidic.examenfinal2122.usecases.models;

public class MathExprLevel implements Level{

    private double solution;
    private MathExpr expression;

    public MathExprLevel() {
    }

    public MathExprLevel(double solution, MathExpr expression) {
        this.solution = solution;
        this.expression = expression;
    }

    public double getSolution() {
        return solution;
    }

    public void setSolution(double solution) {
        this.solution = solution;
    }

    public MathExpr getExpression() {
        return expression;
    }

    public void setExpression(MathExpr expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "MathExprLevel{" +
                "solution=" + solution +
                ", expression=" + expression +
                '}';
    }
}
