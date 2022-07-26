def buildJar() {
    echo "building the application..."
    sh 'mvn clean install'
} 

def deployApp() {
    
        sshPublisher(publishers: [sshPublisherDesc(configName: 'Docker', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '''cd //opt/tomcat/tomcat/bin/
                ./catalina.sh start''', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '//opt/tomcat/tomcat/webapps', remoteDirectorySDF: false, removePrefix: 'gameoflife-web/target', sourceFiles: 'gameoflife-web/target/gameoflife.war')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
   
} 

return this
