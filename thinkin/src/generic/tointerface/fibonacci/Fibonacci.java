package generic.tointerface.fibonacci;

import generic.tointerface.coffee.Generator;

/**
 * Created by KaiLin.Guo on 2018-02-28.
 */
public class Fibonacci implements Generator<Integer> {
    private int count = 0;

    @Override
    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < 12; i++)
            System.out.print(gen.next() + " ");
    }
}
