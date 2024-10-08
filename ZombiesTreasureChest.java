import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ZombiesTreasureChest {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        String[] input;
        int capacity;
        int emeraldSize;
        int emeraldValue;
        int sapphireSize;
        int sapphireValue;

        long result;
        for (int i = 1; i <= t; i++)
        {
            input = reader.readLine().split(" ");
            capacity = Integer.parseInt(input[0]);
            emeraldSize = Integer.parseInt(input[1]);
            emeraldValue = Integer.parseInt(input[2]);
            sapphireSize = Integer.parseInt(input[3]);
            sapphireValue = Integer.parseInt(input[4]);

            result = makeTheWork(capacity, emeraldSize, emeraldValue, sapphireSize, sapphireValue);
            System.out.printf("Case #%d: %d", t, result);
        }
    }

    private static long makeTheWork(int capacity, int emeraldSize, int emeraldValue, int sapphireSize, int sapphireValue) {
        float eValue = (float) emeraldValue / emeraldSize;
        float sValue = (float) sapphireValue / sapphireSize;

        Product mostValuable, leastValuable;

        if (eValue > sValue)
        {
            mostValuable = new Product(eValue, emeraldSize, emeraldValue, 0);
            leastValuable = new Product(sValue, sapphireSize, sapphireValue, 1);
        } else {
            mostValuable = new Product(sValue, sapphireSize, sapphireValue, 1);
            leastValuable = new Product(eValue, emeraldSize, emeraldValue, 0);
        }

        int mVQuantity = capacity / mostValuable.size;
        int lVQuantity = (capacity - mVQuantity) / leastValuable.size;
        int remainder = capacity - mVQuantity - lVQuantity;

        if (((remainder + mostValuable.size) / leastValuable.size) * leastValuable.value > mostValuable.value)
        {
            mVQuantity--;
            lVQuantity = (capacity - mVQuantity) / leastValuable.size;
        }
        return (long) mVQuantity * mostValuable.value + (long) lVQuantity * mostValuable.value;
    }
}
class Product {
    float valuePound;
    int size;
    int value;
    int index;

    public Product(float valuePound, int size, int value, int index) {
        this.valuePound = valuePound;
        this.size = size;
        this.value = value;
        this.index = index;
    }
}
