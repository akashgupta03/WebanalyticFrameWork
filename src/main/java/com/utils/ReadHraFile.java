package com.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.sstoehr.harreader.HarReader;
import de.sstoehr.harreader.HarReaderException;
import de.sstoehr.harreader.model.HarEntry;

import java.io.*;
import java.util.List;

public class ReadHraFile
{
    public  void ConvertHatToJson(String fileName) throws HarReaderException, IOException {
        String pathToFile = "./ProxyHarFile/"+fileName+".har";

        HarReader harReader = new HarReader();
        List<HarEntry> harEntryList = harReader.readFromFile(new File(pathToFile)).getLog().getEntries();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("./JsonFile"+fileName), "utf-8")))
        {
            writer.write(gson.toJson(harEntryList));
        }
    }



}
