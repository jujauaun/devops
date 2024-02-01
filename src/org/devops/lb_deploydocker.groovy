package org.devops

def despliegueContenedor(projectGitName){
    sh "docker pull josecorreav/${projectGitName}"
    sh "docker run -p 443:443 --network=${env.JOB_NAME} --name ${projectGitName} -d ${projectGitName}"
}
