package dam.gtidic.examenfinal2122.usecases.models;

import androidx.annotation.NonNull;

public enum Operations {
    ADD {
        public double apply(double a, double b) {
            return a + b;
        }
    },
    SUBTRACT {
        public double apply(double a, double b) {
            return a - b;
        }
    },
    MULTIPLY {
        public double apply(double a, double b) {
            return a * b;
        }
    },
    DIVIDE {
        public double apply(double a, double b) {
            return a / b;
        }
    };

    public abstract double apply(double a, double b);

    @NonNull
    @Override
    public String toString() {
        switch (this){
            case ADD:
                return "+";
            case DIVIDE:
                return "/";
            case MULTIPLY:
                return "*";
            case SUBTRACT:
                return "-";
            default:
                return "";
        }
    }
}
