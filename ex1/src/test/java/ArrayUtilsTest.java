import com.example.FirstNumber.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArrayUtilsTest {
    @Test
    public void testIsSort(){
        Integer[] arr = {1, 2, 3, 4, 5};
        assertTrue(ArrayUtils.isSort(arr));
    }

    @Test
    public void testIsNotSort(){
        Integer[] arr = {5, 4, 3, 2, 1};
        assertFalse(ArrayUtils.isSort(arr));
    }
}
