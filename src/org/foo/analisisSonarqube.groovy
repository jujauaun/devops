package org.devops

def call(gitName) {
    def scannerHome = tool 'sonarqube' 
    withSonarQubeEnv('sonarqube') { 
        sh "${scannerHome}/bin/sonar-scanner " +
           "-Dsonar.projectKey=${gitName} " +
           "-Dsonar.projectName=${PROJECT} " +
           "-Dsonar.sources=${env.WORKSPACE}"
    }  
}
