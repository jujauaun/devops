package org.devops

def AnalisisOwasp(projectGitName){
      //  sh "docker network create ${env.JOB_NAME}"
      //  sh "docker network connect ${env.JOB_NAME} ${projectGitName}"
        sh """docker run  --rm -v reportOwasp:/zap/wrk/:rw /
        --name owasp /
        --user root --network=${env.NameNetwork} /
        -t owasp/zap2docker-stable /
        zap-full-scan.py /
        -t ${env.dominio} /
        -r reportOwasp.html -I
            """
}
