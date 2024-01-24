package org.devops


def analisisSonar(git_name){
    def scannerHome = tool 'sonar-scanner'
    if(scannerHome){
        withSonarQubeEnv('sonar-scanner'){
            sh "${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=${git_name} \
            -Dsonar.projectName=${PROJECT} \
            -Dsonar.sources=${env.source} \
            -Dsonar.tests=${env.UbTest} \
            -Dsonar.exclusions=${env.exclus} \
            -Dsonar.testExecutionReportPaths=${env.reportGenerate} \
            -Dsonar.javascript.lcov.reportPaths=${env.icov}"
            
        }
    } else{
        error 'SonarQube Scanner not found'
    }
}
