package task3;

public class Complex implements Pair {
    private double first;
    private double second;

    public Complex(double real, double imag) {
        this.first = real;
        this.second = imag;
    }

    @Override
    public Complex add(Pair other) {
        if (!(other instanceof Complex)) {
            throw new IllegalArgumentException("Аргумент має бути типу Complex");
        }
        Complex c = (Complex) other;
        return new Complex(this.first + c.first, this.second + c.second);
    }

    @Override
    public Complex subtract(Pair other) {
        if (!(other instanceof Complex)) {
            throw new IllegalArgumentException("Аргумент має бути типу Complex");
        }
        Complex c = (Complex) other;
        return new Complex(this.first - c.first, this.second - c.second);
    }

    @Override
    public Complex multiply(int n) {
        return new Complex(this.first * n, this.second * n);
    }

    @Override
    public Complex divide(int n) {
        if (n == 0) {
            throw new IllegalArgumentException("Ділення на нуль");
        }
        return new Complex(this.first / n, this.second / n);
    }

    @Override
    public double getFirst() { return first; }

    @Override
    public double getSecond() { return second; }

    @Override
    public String toString() {
        String sign = second >= 0 ? " + " : " - ";
        return String.format("%.2f%s%.2fi", first, sign, Math.abs(second));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Complex)) return false;
        Complex c = (Complex) obj;
        return Math.abs(this.first - c.first) < 1e-10 &&
                Math.abs(this.second - c.second) < 1e-10;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(first) * 31 + Double.hashCode(second);
    }
}