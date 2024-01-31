package org.devops

def publicarImage(projectGitName){
    withDockerRegistry([ credentialsId: "josecorreav", url: "https://index.docker.io/v1/" ]) {
        sh "docker push ${projectGitName}"
        }
}
