package org.devops


def testCoverage(){
    sh 'npm test' 
}

def analisisSonar(gitName){
    def scannerHome = tool 'sonar-scanner'
    if(scannerHome){
        withSonarQubeEnv('sonar-scanner'){
            sh "${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=${gitName} \
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
