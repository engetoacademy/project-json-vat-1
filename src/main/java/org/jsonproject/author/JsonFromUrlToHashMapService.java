package org.jsonproject.author;

import com.fasterxml.jackson.databind.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class JsonFromUrlToHashMapService {
    private Map<String , Double> countryStandardRateMap = new HashMap<>();

    public Map<String, Double> getCountryStandardRateMap() {
        return countryStandardRateMap;
    }

    private File myPathToFile = new File("JsonVat.json");

    public File getMyPathToFile() {
        return myPathToFile;
    }

    public void getRatesMap (File file) {
        if (file == null || !file.exists()) {
            return;
        }

        ObjectMapper jsonMapper = new ObjectMapper();

        try {
            JsonNode rootNode = jsonMapper.readTree(file);

            JsonNode countryNode = rootNode.path("rates");

            Iterator<JsonNode> namesAndStandardRateIterator = countryNode.elements();
            while(namesAndStandardRateIterator.hasNext()) {
                JsonNode standard = namesAndStandardRateIterator.next();

                countryStandardRateMap.put(standard.findValue("name").asText(), standard.findValue("standard").asDouble());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveJsonFromUrlToFile(String url) throws IOException {
        if (url == null || url.equals("")) {
            return;
        }
        InputStream in = new URL(url).openStream();
        Files.copy(in, Paths.get(String.valueOf(myPathToFile)), StandardCopyOption.REPLACE_EXISTING);
    }
}

