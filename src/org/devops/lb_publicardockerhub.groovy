package org.devops

def publicarImage(PROJECT){
    withDockerRegistry([ credentialsId: "retofase2", url: "https://index.docker.io/v1/" ]) {
        sh "docker push ${PROJECT}"
        }
}
