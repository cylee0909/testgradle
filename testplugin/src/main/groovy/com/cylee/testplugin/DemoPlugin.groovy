package com.cylee.testplugin

import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project

class Person {
    String name
    int age
}

class DemoExtension {
    final Person greeter
    String config_test;
    int config_int;

    DemoExtension() {
        greeter = new Person()
    }

    void greeter(Action<? super Person> action) {
        action.execute(greeter)
    }
}

class DemoPlugin implements Plugin<Project> {
    void apply(Project project) {
        DemoExtension extension = project.extensions.create('democonfig', DemoExtension);
        project.task('hello') {
            doLast {
                println("read config config_test = $extension.config_test, config_int = $extension.config_int, name = $extension.greeter.name, age = $extension.greeter.age")
                println "Hello World from the DemoPlugin"
            }
        }
    }
}