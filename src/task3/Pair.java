package task3;

public interface Pair {
    Pair add(Pair other);
    Pair subtract(Pair other);
    Pair multiply(int n);
    Pair divide(int n);
    double getFirst();
    double getSecond();
}