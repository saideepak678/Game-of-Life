def buildJar() {
    echo "building the application..."
    sh 'mvn clean install'
} 

def deployApp() {
    
       sshagent(['deploy-test']) {
 	sh "scp -o StrictHostKeyChecking=no gameoflife-web/target/gameoflife.war ubuntu@52.70.227.62:/opt/tomcat/tomcat/webapps"
 	sh "//opt/tomcat/tomcat/bin/startup.sh start"
 	}
} 

return this
