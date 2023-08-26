package me.joe.cesium.config;

import com.google.gson.Gson;
import me.joe.cesium.Cesium;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class Config {
    public static File STORAGE = null;//new File(Cesium.c.runDirectory,"istolethisfrom0x.jmod");
    private cfg    inner   = new cfg();
    public cfg getConfig() {
        return inner;
    }
    public void load() {
        try {
            loadInner();
        } catch (Exception e) {
            Cesium.LOGGER.error("Failed to load config file");
            e.printStackTrace();
        }
        if (inner == null) inner = new cfg();
    }
    private void loadInner() throws Exception {
        if (!STORAGE.isFile()) {
            STORAGE.delete();
        }
        if (!STORAGE.exists()) {
            STORAGE.createNewFile();
            return;
        }
        String t = FileUtils.readFileToString(STORAGE, StandardCharsets.UTF_8);
        Gson gson = new Gson();
        inner = gson.fromJson(t,cfg.class);
    }

    public void save() {
        try {
            saveInner();
        } catch (Exception e) {
            Cesium.LOGGER.error("Failed to save config file");
            e.printStackTrace();
        }
    }

    private void saveInner() throws Exception {
        Gson gson = new Gson();
        String c = gson.toJson(inner);
        FileUtils.writeStringToFile(STORAGE,c, StandardCharsets.UTF_8);
    }
}
