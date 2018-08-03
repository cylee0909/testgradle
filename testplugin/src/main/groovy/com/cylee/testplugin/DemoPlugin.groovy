package com.cylee.testplugin

import org.gradle.api.Plugin
import org.gradle.api.Project


class DemoExtension {
    String config_test;
    int config_int;

}

class DemoPlugin implements Plugin<Project> {
    void apply(Project project) {
        DemoExtension extension = project.extensions.create('democonfig', DemoExtension);
        project.task('hello') {
            doLast {
                println("read config config_test = $extension.config_test, config_int = $extension.config_int")
                println "Hello World from the DemoPlugin"
            }
        }
    }
}