package com.example.plugindemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example", "org.laxture.sbp.spring.boot", "org.laxture.sbp.spring.boot.*"})
public class PluginDemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(PluginDemoApplication.class, args);
	}

//	@Bean
//	public SpringBootPluginManager pluginManager() {
//		return new SpringBootPluginManager();
//	}
//
//	@Bean
//	@ConditionalOnMissingBean
//	public SpringBootPluginManager pluginManager(SbpProperties properties) {
//		// Setup RuntimeMode
//		System.setProperty("pf4j.mode", properties.getRuntimeMode().toString());
//
//		// Setup Plugin folder
//		String pluginsRoot = StringUtils.hasText(properties.getPluginsRoot()) ? properties.getPluginsRoot() : "plugins";
//		System.setProperty("pf4j.pluginsDir", pluginsRoot);
//		String appHome = System.getProperty("app.home");
//		if (RuntimeMode.DEPLOYMENT == properties.getRuntimeMode()
//				&& StringUtils.hasText(appHome)) {
//			System.setProperty("pf4j.pluginsDir", appHome + File.separator + pluginsRoot);
//		}
//
//		SpringBootPluginManager pluginManager = new SpringBootPluginManager(
//				new File(pluginsRoot).toPath()) {
//			@Override
//			protected PluginLoader createPluginLoader() {
//				if (properties.getCustomPluginLoader() != null) {
//					Class<PluginLoader> clazz = properties.getCustomPluginLoader();
//					try {
//						Constructor<?> constructor = clazz.getConstructor(PluginManager.class);
//						return (PluginLoader) constructor.newInstance(this);
//					} catch (Exception ex) {
//						throw new IllegalArgumentException(String.format("Create custom PluginLoader %s failed. Make sure" +
//								"there is a constructor with one argument that accepts PluginLoader", clazz.getName()));
//					}
//				} else {
//					return new CompoundPluginLoader()
//							.add(new DefaultPluginLoader(this) {
//								@Override
//								protected PluginClassLoader createPluginClassLoader(Path pluginPath,
//																					PluginDescriptor pluginDescriptor) {
//									if (properties.getClassesDirectories() != null && properties.getClassesDirectories().size() > 0) {
//										for (String classesDirectory : properties.getClassesDirectories()) {
//											pluginClasspath.addClassesDirectories(classesDirectory);
//										}
//									}
//									if (properties.getLibDirectories() != null && properties.getLibDirectories().size() > 0) {
//										for (String libDirectory : properties.getLibDirectories()) {
//											pluginClasspath.addJarsDirectories(libDirectory);
//										}
//									}
//									return new SpringBootPluginClassLoader(pluginManager,
//											pluginDescriptor, getClass().getClassLoader());
//								}
//							}, this::isDevelopment)
//							.add(new JarPluginLoader(this) {
//								@Override
//								public ClassLoader loadPlugin(Path pluginPath, PluginDescriptor pluginDescriptor) {
//									PluginClassLoader pluginClassLoader = new SpringBootPluginClassLoader(pluginManager, pluginDescriptor, getClass().getClassLoader());
//									pluginClassLoader.addFile(pluginPath.toFile());
//									return pluginClassLoader;
//								}
//							}, this::isNotDevelopment);
//				}
//			}
//
//			@Override
//			protected PluginStatusProvider createPluginStatusProvider() {
//				if (PropertyPluginStatusProvider.isPropertySet(properties)) {
//					return new PropertyPluginStatusProvider(properties);
//				}
//				return super.createPluginStatusProvider();
//			}
//		};
//
//		Set<String> profiles = new HashSet<>(Arrays.asList(properties.getPluginProfiles()));
//		profiles.add("plugin"); // set default profile
//		pluginManager.setProfiles(profiles.toArray(new String[] {}));
//		pluginManager.setAutoStartPlugin(properties.isAutoStartPlugin());
//		pluginManager.presetProperties(flatProperties(properties.getPluginProperties()));
//		pluginManager.setExactVersionAllowed(properties.isExactVersionAllowed());
//		pluginManager.setSystemVersion(properties.getSystemVersion());
//
//		return pluginManager;
//	}
//	private Map<String, Object> flatProperties(Map<String, Object> propertiesMap) {
//		Stack<String> pathStack = new Stack<>();
//		Map<String, Object> flatMap = new HashMap<>();
//		propertiesMap.entrySet().forEach(mapEntry -> {
//			recurse(mapEntry, entry -> {
//				pathStack.push(entry.getKey());
//				if (entry.getValue() instanceof Map) return;
//				flatMap.put(String.join(".", pathStack), entry.getValue());
//
//			}, entry -> {
//				pathStack.pop();
//			});
//		});
//		return flatMap;
//	}
//
//	private void recurse(Map.Entry<String, Object> entry,
//						 Consumer<Map.Entry<String, Object>> preConsumer,
//						 Consumer<Map.Entry<String, Object>> postConsumer) {
//		preConsumer.accept(entry);
//
//		if (entry.getValue() instanceof Map) {
//			Map<String, Object> entryMap = (Map<String, Object>) entry.getValue();
//			for (Map.Entry<String, Object> subEntry : entryMap.entrySet()) {
//				recurse(subEntry, preConsumer, postConsumer);
//			}
//		}
//
//		postConsumer.accept(entry);
//	}

}
