package com.cylee.testplugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class DemoPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.task('hello') {
            doLast {
                println "Hello World from the DemoPlugin"
            }
        }
    }
}