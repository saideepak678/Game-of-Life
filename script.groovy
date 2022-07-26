def build() {
    echo "building the application..."
    sh 'mvn package'
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
    echo 'deploying the application...'
} 

return this
