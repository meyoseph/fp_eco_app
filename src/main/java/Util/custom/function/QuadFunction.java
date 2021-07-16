package Util.custom.function;

public interface QuadFunction<W, X, Y, Z, R> {
    R apply(W w, X x, Y y, Z z);
}
