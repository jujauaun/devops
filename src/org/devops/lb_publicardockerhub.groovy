package org.devops

def publicarImage (projectGitName) {
    withCredentials ([usernamePassword(credentialsId: "${env.TOKEN_ID}",
    passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
    sh "docker login -u ${env.DOCKERHUB_USERNAME} -p ${env.DOCKERHUB_PASSWORD}"
    sh "docker tag jujauaun/react-test jujauaun/react-test-jenkinsfile:latest"
    sh "docker push jujauaun/react-test-jenkinsfile:latest"
    }
}
