package org.devops

def AnalisisOwasp(projectGitName){
      //  sh "docker network connect ${env.NameNetwork} ${projectGitName}"
        sh "docker run -dt --name owasp owasp/zap2docker-stable /bin/bash"
        sh 'docker exec owasp mkdir /zap/wrk'
        sh "docker exec owasp zap-full-scan.py -t https://example.com/ -r reportOwasp.html -I"
        sh 'docker cp owasp:/zap/wrk/reportOwasp.html ${WORKSPACE}/reportOwasp.html'" 
}
