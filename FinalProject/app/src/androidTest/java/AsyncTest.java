import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.JokeAsyncTask;
import com.udacity.gradle.builditbigger.JokeInterface;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by bryan on 12/19/16.
 */

@RunWith(AndroidJUnit4.class)
public class AsyncTest implements JokeInterface
{
    @Test
    public void testVerifyJokeAsyncTask()
    {
        JokeAsyncTask jokeAsyncTask = new JokeAsyncTask(this);
        jokeAsyncTask.execute();
        String joke = null;

        try
        {
            joke = jokeAsyncTask.get();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        assertNotNull(joke);
    }

    public void onJokeReceived(String joke)
    {
        // intentionally left blank
    }
}
