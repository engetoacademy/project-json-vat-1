package org.jsonproject.author;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class JsonFromUrlToHashMapServiceTest {
    private JsonFromUrlToHashMapService myJsonFromUrl;

    @Before
    public void setUp () {
        myJsonFromUrl = new JsonFromUrlToHashMapService();
    }

    @Test
    public void nullInUrl () throws IOException {
        myJsonFromUrl.saveJsonFromUrlToFile(null);
        Assert.assertTrue(myJsonFromUrl.getCountryStandardRateMap().isEmpty());
    }

    @Test
    public void emptyStringInUrl () throws IOException {
        myJsonFromUrl.saveJsonFromUrlToFile("");
        Assert.assertTrue(myJsonFromUrl.getCountryStandardRateMap().isEmpty());
    }

    @Test
    public void savesFileNormally () throws IOException {
        myJsonFromUrl.saveJsonFromUrlToFile("http://jsonvat.com/");
        Assert.assertTrue(myJsonFromUrl.getMyPathToFile().exists());
    }
}