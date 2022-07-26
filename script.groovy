def build() {
    echo "building the application..."
    sh 'mvn clean install'
} 

def BuildImageForDocker() {
    echo "building the docker image..."
     withCredentials([usernamePassword(credentialsId: 'Docker-login', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
              sh "docker rmi -f dsai83436/tomcatup"
              sh "docker build -t dsai83436/tomcatup -f gameoflife-web/Dockerfile ."
              sh "echo $PASS | docker login -u $USER --password-stdin"
              sh "docker push dsai83436/tomcatup"
         
} 

def deployApp() {
    
        sshPublisher(publishers: [sshPublisherDesc(configName: 'Docker', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '''cd //opt/tomcat/tomcat/bin/
                ./catalina.sh start''', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '//opt/tomcat/tomcat/webapps', remoteDirectorySDF: false, removePrefix: 'gameoflife-web/target', sourceFiles: 'gameoflife-web/target/gameoflife.war')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
   
} 

return this
