package task2;

abstract class Pair {
    protected double first;
    protected double second;

    public Pair(double first, double second) {
        this.first = first;
        this.second = second;
    }

    public abstract Pair add(Pair other);
    public abstract Pair subtract(Pair other);
    public abstract Pair multiply(int n);
    public abstract Pair divide(int n);

    public double getFirst() { return first; }
    public double getSecond() { return second; }
}

class Money extends Pair {

    public Money(double hryvnia, double kopeck) {
        super(hryvnia, kopeck);
        normalize();
    }

    private void normalize() {
        if (second >= 100 || second < 0) {
            int extraHryvnia = (int)(second / 100);
            first += extraHryvnia;
            second = second % 100;

            if (second < 0) {
                first -= 1;
                second += 100;
            }
        }
    }

    @Override
    public Money add(Pair other) {
        if (!(other instanceof Money)) {
            throw new IllegalArgumentException("Аргумент має бути типу task2.Money");
        }
        Money m = (Money) other;
        return new Money(this.first + m.first, this.second + m.second);
    }

    @Override
    public Money subtract(Pair other) {
        if (!(other instanceof Money)) {
            throw new IllegalArgumentException("Аргумент має бути типу task2.Money");
        }
        Money m = (Money) other;
        double totalThis = this.first * 100 + this.second;
        double totalOther = m.first * 100 + m.second;
        double diff = totalThis - totalOther;
        return new Money(0, diff); // Конструктор сам нормалізує
    }

    @Override
    public Money multiply(int n) {
        if (n == 0) {
            return new Money(0, 0);
        }
        double total = (this.first * 100 + this.second) * n;
        return new Money(0, total);
    }

    @Override
    public Money divide(int n) {
        if (n == 0) {
            throw new IllegalArgumentException("Ділення на нуль");
        }
        double total = (this.first * 100 + this.second) / n;
        return new Money(0, total);
    }

    @Override
    public String toString() {
        return String.format("%.0f грн %.0f коп", first, second);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Money)) return false;
        Money m = (Money) obj;
        return Math.abs(this.first - m.first) < 0.01 &&
                Math.abs(this.second - m.second) < 0.01;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(first) * 31 + Double.hashCode(second);
    }
}

class Complex extends Pair {

    public Complex(double real, double imag) {
        super(real, imag);
    }

    @Override
    public Complex add(Pair other) {
        if (!(other instanceof Complex)) {
            throw new IllegalArgumentException("Аргумент має бути типу task2.Complex");
        }
        Complex c = (Complex) other;
        return new Complex(this.first + c.first, this.second + c.second);
    }

    @Override
    public Complex subtract(Pair other) {
        if (!(other instanceof Complex)) {
            throw new IllegalArgumentException("Аргумент має бути типу task2.Complex");
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
