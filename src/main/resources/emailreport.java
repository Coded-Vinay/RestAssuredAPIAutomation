import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class EmailReport {

    //To make it pass
    @Test
    public void passTest(){
        Assert.assertTrue(true);
    }

    //To make it fail
    @Test
    public void failTest(){
        Assert.assertTrue(false);
    }

    //To make it skip
    @Test
    public void skipTest(){
        throw new SkipException("Skipping -This method is skipped testing ");
    }
}