package org.devops

def AnalisisOwasp(projectGitName){
      //  sh "docker network create ${env.JOB_NAME}"
      //  sh "docker network connect ${env.JOB_NAME} ${projectGitName}"
sh "docker run --rm -v fullscan_react-test_OWASP:/zap/wrk/:rw --user root --network=${env.NET_NAME} -t owasp/zap2docker-stable zap-full-scan.py -t http://${env.IPHOST}:8081/ -r fullscan_react-test_OWASP.html -I"
}
