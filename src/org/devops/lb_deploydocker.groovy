package org.devops

def despliegueContenedor(projectGitName){
    sh "docker pull josecorreav/${projectGitName}"
    sh "docker run -p 5174:5174 --name ${projectGitName} -d ${projectGitName}"
}
