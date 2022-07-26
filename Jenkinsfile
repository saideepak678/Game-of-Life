CODE_CHANGES = getGitChanges()
pipeline {
    
  agent any

    stages {
          
      stage('Build') {
            steps {
              echo 'building the application'
            }
        }
    
      stage('test') {
          when {
              expression {
                  BRANCH_NAME== 'master' ||BRANCH_NAME == 'dev'
              }
              
          }
            steps {
              echo 'testing the application'
            }
        }
      
      stage('deploy') {
            steps {
               echo 'deploy the application'
            }
        }
    
    }
    post {
        always{
            echo 'always send the mail kind things'
        }
        failure {
            echo 'failure the command'
        }
        success{
            echo 'success'
        } 
    }
}
