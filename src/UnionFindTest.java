
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class UnionFindTest {

    @Test
    public void example() {
        UnionFind uf = new UnionFind(10);
        Assertions.assertEquals(9, uf.find(9));
        Assertions.assertTrue(uf.union(1, 2));
        Assertions.assertTrue(uf.union(2, 3));
        Assertions.assertTrue(uf.union(0, 1));
        Assertions.assertTrue(uf.union(3, 4));
        // Test that joining any combination will have no effect, as they are already joined
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) Assertions.assertFalse(uf.union(i, j));
        // Test whether all first five entries have the same root
        for (int i = 0; i < 4; i++) Assertions.assertEquals(uf.find(i), uf.find(i + 1));
        // Test whether all last five entries have themselves as root
        for (int i = 5; i < 10; i++) Assertions.assertEquals(i, uf.find(i));
    }

    @Test
    public void UnionTwiceInARow() {
        UnionFind uf = new UnionFind(5);
        Assertions.assertTrue(uf.union(1, 2));
        Assertions.assertTrue(uf.union(1, 3));
        Assertions.assertFalse(uf.union(2, 3));
    }

    @Test
    public void rankNoUnionTest() {
        UnionFind uf = new UnionFind(10);
        // Test whether all entries have themselves as root
        for (int i = 0; i < 10; i++) Assertions.assertEquals(i, uf.find(i));
    }

    @Test
    public void findWithUnionTest() {
        UnionFind uf = new UnionFind(10);
        Assertions.assertTrue(uf.union(4, 2));
        Assertions.assertFalse(uf.union(2, 4));
        Assertions.assertEquals(uf.find(2), uf.find(4));
    }

    @Test
    @Timeout(1)
    public void fastEnough() {
        int n = 1_000_000;
        UnionFind uf = new UnionFind(n);
        Random rng = new Random(1234);
        for (int i = 0; i < n / 100; i++) {
            int a = rng.nextInt(n);
            int b = rng.nextInt(n);
            uf.union(a, b);
        }
    }
}
