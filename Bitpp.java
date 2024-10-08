import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Bitpp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());
        int x = 0;

        String s;
        for (int i = 0; i < t; i++)
        {
            s = reader.readLine();
            if ((s.charAt(0) == '-' && s.charAt(1) == '-') || (s.charAt(1) == '-' && s.charAt(2) == '-'))
                x--;
            else
                x++;
        }

        System.out.println(x);
    }
}