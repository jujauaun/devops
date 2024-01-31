package org.devops

def publicarImage(projectGitName){
    withDockerRegistry([ credentialsId: "josecorreav", url: "https://hub.docker.com/repository/docker/josecorreav/react-test-jenkinsfile" ]) {
        sh "docker push josecorreav/${projectGitName}"
        }
}
