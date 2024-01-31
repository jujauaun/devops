package org.devops

def despliegueContenedor(projectGitName){
    sh "docker pull josecorreav/react-test-jenkinsfile"
    //sh "docker run --name ${PROJECT} -p 80${env.BUILD_ID}:3000 -d laurabecerra/${PROJECT}:${env.BUILD_ID}"
    sh "docker run -p 5174:5174 --name ${projectGitName} -d josecorreav/${projectGitName}"
}
