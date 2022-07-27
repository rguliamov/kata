package com.github.rguliamov.calc;

/**
 * @author Guliamov Rustam
 *
 * simple containter for two objects
 */
public class Tuple2<T1, T2> {
    private T1 _1;
    private T2 _2;

    public Tuple2(T1 _1, T2 _2) {
        this._1 = _1;
        this._2 = _2;
    }

    public T1 _1() {
        return _1;
    }

    public T2 _2() {
        return _2;
    }
}
