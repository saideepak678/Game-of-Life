def gv

pipeline {
    agent any
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    //echo "building jar"
                    gv.buildJar()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    //echo "deploying"
                    gv.deployApp()
                }
            }
        }
    }   
}
