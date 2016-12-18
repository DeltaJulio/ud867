/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package io.github.deltajulio.jokebackend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import io.github.deltajulio.JokeClass;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "jokebackend.deltajulio.github.io",
                ownerName = "jokebackend.deltajulio.github.io",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "jokeEndpoint")
    public MyJoke getJoke()
    {
        MyJoke joke = new MyJoke();
        joke.setData(JokeClass.getJoke());
        return joke;
    }

}
