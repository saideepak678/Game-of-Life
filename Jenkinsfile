#!/usr/bin/env groovy
def gv
pipeline {
    agent any
    stages {
  
        stage('init') {
            steps {
                script{
             gv = load "script.groovy"
                }
            }
        }
        stage('Build') {
            steps {
                script{
                    gv.build()
                }   
            }
        }   
        stage('deploy App') {
            steps{
                script{
                    gv.deployApp()
                }
            }
        }

    }
}
