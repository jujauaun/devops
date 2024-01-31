package org.devops

def AnalisisOwasp(projectGitName){
        sh "docker network connect ${env.NameNetwork} ${projectGitName}"
        sh "docker run -d --name owasp --user root --network=${env.NameNetwork} -v owasp_data:/zap/reports -t owasp/zap2docker-stable /bin/bash"
        sh 'docker exec owasp mkdir /zap/wrk'
        sh "docker exec owasp zap-full-scan.py -t ${env.dominio} / -r reportapp.html -I"
        sh 'docker cp owasp:/zap/wrk/reportapp.html reportapp.html'
        sh "docker cp reportapp.html jenkins:/var/jenkins_home/workspace/${env.NameNetwork}/" 
}
