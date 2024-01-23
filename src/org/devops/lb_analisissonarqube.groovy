package org.devops

def analisisSonar(){
    def scannerHome = tool 'sonnar'
    if(scannerHome){
        withSonarQubeEnv('sonnar'){
            sh "${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=react-test-jenkinsfile \
            -Dsonar.projectName=react-test-jenkinsfile \
            -Dsonar.sources=src \
            -Dsonar.tests=src/__test__ \
            -Dsonar.exclusions='**/*.test.js' \
            -Dsonar.testExecutionReportPaths=./test-report.xml \
            -Dsonar.javascript.lcov.reportPaths=coverage/lcov.info
            "
        }
    } else{
        error 'SonarQube Scanner not found'
    }
}