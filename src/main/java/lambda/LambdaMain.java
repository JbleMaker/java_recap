package lambda;

interface Add<T> {
    public T add(T a, T b);
}

public class LambdaMain {
    public static void main(String[] args) {
        Add<Integer> o = (a, b) -> a+b;

        int result = o.add(5,3);
        System.out.println(result);
    }
}
