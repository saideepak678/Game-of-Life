def gv
pipeline {
    agent any
    stages {
  
        stage('init') {
            steps {
                script{
             gv=load "script.groovy"
                }
            }
        }
        
        stage('Build') {
            steps {
                script{
                    gv.BuildImageForDocker()
                }   
            }
        }
        
        stage('BuildImageForDocker ') {
            steps {
                script{
                    gv.BuildImageForDocker()
                }
              }
            }
        }
        
        stage('deployApp'){
            steps{
                script{
                    gv.deployApp()
                }
            }
        }

    }
