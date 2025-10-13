package task3;

public class Money implements Pair {
    private double first;
    private double second;

    public Money(double hryvnia, double kopeck) {
        this.first = hryvnia;
        this.second = kopeck;
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
            throw new IllegalArgumentException("Аргумент має бути типу Money");
        }
        Money m = (Money) other;
        return new Money(this.first + m.first, this.second + m.second);
    }

    @Override
    public Money subtract(Pair other) {
        if (!(other instanceof Money)) {
            throw new IllegalArgumentException("Аргумент має бути типу Money");
        }
        Money m = (Money) other;
        double totalThis = this.first * 100 + this.second;
        double totalOther = m.first * 100 + m.second;
        double diff = totalThis - totalOther;
        return new Money(0, diff);
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
    public double getFirst() { return first; }

    @Override
    public double getSecond() { return second; }

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