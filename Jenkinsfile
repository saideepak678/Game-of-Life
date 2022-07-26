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
                    gv.build()
                }   
            }
        }
        
        stage('Build Image For Docker ') {
            steps {
                script{
                    gv.BuildImageForDocker()
                }
              }
            }
        
        stage('deploy App'){
            steps{
                script{
                    gv.deployApp()
                }
            }
        }

    }
}
