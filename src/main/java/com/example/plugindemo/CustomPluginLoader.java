package com.example.plugindemo;

import org.laxture.sbp.internal.SpringBootPluginClassLoader;
import org.pf4j.PluginClassLoader;
import org.pf4j.PluginDescriptor;
import org.pf4j.PluginLoader;
import org.pf4j.PluginManager;
import org.pf4j.util.FileUtils;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author <a href="https://github.com/hank-cp">Hank CP</a>
 */
public class CustomPluginLoader implements PluginLoader {

    protected PluginManager pluginManager;

    public CustomPluginLoader(PluginManager pluginManager) {
        this.pluginManager = pluginManager;
    }

    @Override
    public boolean isApplicable(Path pluginPath) {
        return Files.exists(pluginPath) && FileUtils.isJarFile(pluginPath);
    }

    @Override
    public ClassLoader loadPlugin(Path pluginPath, PluginDescriptor pluginDescriptor) {
        PluginClassLoader pluginClassLoader = new SpringBootPluginClassLoader(pluginManager, pluginDescriptor, getClass().getClassLoader());
        pluginClassLoader.addFile(pluginPath.toFile());
        // TODO add jarFile in jar
        return pluginClassLoader;
    }
}