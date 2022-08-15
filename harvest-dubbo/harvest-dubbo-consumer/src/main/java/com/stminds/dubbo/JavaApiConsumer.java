package com.stminds.dubbo;

import com.stminds.dubbo.api.DubboTest;
import org.apache.dubbo.common.config.configcenter.DynamicConfiguration;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.model.FrameworkModel;

import java.util.HashMap;

import static org.apache.dubbo.registry.client.migration.MigrationRuleHandler.DUBBO_SERVICEDISCOVERY_MIGRATION;

public class JavaApiConsumer {

    public static void main(String[] args) {
//        method1();
                method2();

    }

    private static void method2() {
        ApplicationModel applicationModel;
        applicationModel = FrameworkModel.defaultModel().newApplication();
        ApplicationConfig applicationConfig = new ApplicationConfig(applicationModel);
        applicationConfig.setName("dubbo-servicediscovery-migration-consumer");

        RegistryConfig registryConfig = new RegistryConfig(applicationModel);
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("192.168.3.123:2181");
        //        registryConfig.setAddress("127.0.0.1:2181");

        applicationModel.getApplicationConfigManager().setApplication(applicationConfig);
        applicationModel.getApplicationConfigManager().addRegistry(registryConfig);
        applicationModel.getDeployer().start();
        //        String RULE_KEY = applicationModel.getApplicationName() + ".migration";
        //        DynamicConfiguration configuration = applicationModel.getModelEnvironment().getDynamicConfiguration().get();
        //        configuration.publishConfig(RULE_KEY, DUBBO_SERVICEDISCOVERY_MIGRATION, "");
        ReferenceConfig<DubboTest> referenceConfig = new ReferenceConfig<>(applicationModel.newModule());
        referenceConfig.setInterface(DubboTest.class);
        referenceConfig.setCheck(false);
        referenceConfig.setGroup("dev");

        //        referenceConfig.setParameters(new HashMap<>());
        //        referenceConfig.getParameters().put("migration.step", "APPLICATION_FIRST");
        DubboTest dubboTest = referenceConfig.get();
        System.out.println(dubboTest.sayHi());
    }

    private static void method1() {
        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("cdp-consumer");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setProtocol("zookeeper");

        registry.setAddress("192.168.3.123:2181");

        registry.setTimeout(600000);
        ConsumerConfig consumerConfig = new ConsumerConfig();

        consumerConfig.setGroup("dev");

        // 引用远程服务
        ReferenceConfig<DubboTest> reference = new ReferenceConfig<>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        reference.setApplication(application);
        reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
        reference.setConsumer(consumerConfig);
        reference.setInterface(DubboTest.class);
        reference.setParameters(new HashMap<>());
        reference.getParameters().put("migration.step", "APPLICATION_FIRST");

        DubboTest shortMessageRpc = reference.get();
        System.out.println(shortMessageRpc.sayHi());
    }

}
