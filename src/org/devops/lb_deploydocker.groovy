package org.devops

def despliegueContenedor(projectGitName){
    sh "docker pull josecorreav/react-test-jenkinsfile"
    sh "docker run -d --name ${projectGitName} --network=${env.NameNetwork} -p 8081:5174 --user root josecorreav/${projectGitName}"
}
