package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import io.github.deltajulio.androidjokelib.DisplayActivity;
import io.github.deltajulio.jokebackend.myApi.MyApi;

/**
 * Created by bryan on 12/16/16.
 */

public class JokeAsyncTask extends AsyncTask<Context, Void, String>
{
    private static MyApi jokeApiService = null;
    private JokeInterface callback;

    public JokeAsyncTask(JokeInterface callback)
    {
        this.callback = callback;
    }

    @Override
    protected String  doInBackground(Context... params)
    {
        if (jokeApiService == null)
        {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // local server settings
                    .setRootUrl("http://10.0.2.2:8080/_ah/api")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            jokeApiService = builder.build();
        }

        try
        {
            return jokeApiService.jokeEndpoint().execute().getData();
        } catch (IOException e)
        {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result)
    {
        callback.onJokeReceived(result);
    }
}
