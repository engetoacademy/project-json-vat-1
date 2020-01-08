package org.jsonproject.author;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class JsonTest {
    private JsonFromUrlToHashMapService myJsonFromUrl;
    private MapCreatorService myMapCreatorService;

    @Before
    public void setUp () {
        myJsonFromUrl = new JsonFromUrlToHashMapService();
        myMapCreatorService = new MapCreatorService();
        myJsonFromUrl.getRatesMap(new File("test.json"));
    }

    @Test
    public void testingSizeOfStandardRateMap(){
        Assert.assertEquals(3,myJsonFromUrl.getCountryStandardRateMap().size());
    }

    @Test
    public void testingSizeOfCreateBottomThreeMap(){
        Assert.assertEquals(3,myMapCreatorService.createBottomThreeMap(myJsonFromUrl).size());
    }

    @Test
    public void testingSizeOfCreateTopThreeMap(){
        Assert.assertEquals(3,myMapCreatorService.createTopThreeMap(myJsonFromUrl).size());
    }

    @Test
    public void testingCurrentValueOfLuxembourgStandardRate() {
        Assert.assertEquals(17.0, myMapCreatorService.createBottomThreeMap(myJsonFromUrl).values().toArray()[0]);
        Assert.assertEquals("Luxembourg", myMapCreatorService.createBottomThreeMap(myJsonFromUrl).keySet().toArray()[0]);
    }

    @Test
    public void testingLowestStandardRateIsLuxembourg() {
        Assert.assertEquals("Luxembourg", myMapCreatorService.createBottomThreeMap(myJsonFromUrl).keySet().toArray()[0]);
    }

    @Test
    public void testingHighestStandardRateIsSpain() {
        Assert.assertEquals("Spain", myMapCreatorService.createTopThreeMap(myJsonFromUrl).keySet().toArray()[0]);
    }

    @Test
    public void testingStandardRateForSpain() {
        Assert.assertEquals(21.0, myMapCreatorService.createTopThreeMap(myJsonFromUrl).values().toArray()[0]);
    }
}