package WebServices;

import com.google.gson.Gson;
import javafx.geometry.Pos;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Assert;

import static com.sun.corba.se.impl.util.Version.asString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class TestWS {
    @Test
    public void testStatusOK()
            throws  IOException, URISyntaxException {
        HttpUriRequest request = new HttpGet("http://jsonplaceholder.typicode.com/posts/1");

        HttpResponse httpResponse = HttpClientBuilder
                .create()
                .build()
                .execute(request);

        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(200));
    }

    @Test
    public void testPageNotFoundCode()
            throws  IOException, URISyntaxException {
        HttpUriRequest request = new HttpGet("http://jsonplaceholder.typicode.com/posts/166");

        HttpResponse httpResponse = HttpClientBuilder
                .create()
                .build()
                .execute(request);

        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(404));
    }

    @Test
    public void testHeader()
            throws  IOException, URISyntaxException {
        HttpUriRequest request = new HttpGet("http://jsonplaceholder.typicode.com/posts/2");

        Header[] header = HttpClientBuilder
                .create()
                .build()
                .execute(request)
                .getHeaders("Server");

        String server = header[0].getValue();
        assertEquals("Cowboy",server);

    }

    @Test
    public void testContent()
            throws  IOException, URISyntaxException {
        HttpUriRequest request = new HttpGet("http://jsonplaceholder.typicode.com/posts/2");
        HttpResponse httpResponse = HttpClientBuilder
                .create()
                .build()
                .execute(request);

        String json = EntityUtils.toString(httpResponse.getEntity());

        Gson gson = new Gson();
        Posts post = gson.fromJson(json, Posts.class);
        assertEquals(2, post.getId());
    }



}
