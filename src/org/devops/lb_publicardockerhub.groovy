package org.devops

def publicarImage(PROJECT){
    withDockerRegistry([ credentialsId: "josecorreav", url: "https://index.docker.io/v1/" ]) {
        sh "docker push ${PROJECT}"
        }
}
