package org.jsonproject.author;

import java.io.File;
import java.io.IOException;

public class App
{
    public static void main( String[] args ) throws IOException {
        JsonFromUrlToHashMapService myJsonFromUrl = new JsonFromUrlToHashMapService();
        myJsonFromUrl.saveJsonFromUrlToFile("http://jsonvat.com/");
        myJsonFromUrl.getRatesMap(new File("JsonVat.json"));

        MapCreatorService myMapCreatorService = new MapCreatorService();
        System.out.println("Three countries with lowest standard rates: " + myMapCreatorService.createBottomThreeMap(myJsonFromUrl));
        System.out.println("Three countries with highest standard rates: " + myMapCreatorService.createTopThreeMap(myJsonFromUrl));
    }
}