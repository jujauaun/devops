package org.devops

def despliegueContenedor(projectGitName){
    sh "docker pull josecorreav/${projectGitName}"
    sh "docker run -p 9000:9000 --network=${env.JOB_NAME} --name ${projectGitName} -d ${projectGitName}"
}
