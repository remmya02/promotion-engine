package com.promotion.engine.promotions;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public interface Promotion {

    public static final Path configPath = Paths.get("./config.yml");
    Properties config = null;

    public default void loadConfig(){

    }

    public Integer apply(List<String> products);

}
