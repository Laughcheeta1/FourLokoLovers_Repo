import java.util.List;

public class test {
    public static void main(String[] args) {
        double a = 0.3*3+0.1;
        double b = 1;
        if (Math.abs(a-b) < 1e-9) {
            System.out.println("Son iguales");
        }
    }
}
