package org.devops

def clone(Map params){
    def BRANCH_NAME = "${env.GIT_BRANCH}".split('/')[1]
    git branch: "${BRANCH_NAME}", url: "${params.scmUrl}"
}

def install(){
    sh 'npm install' 
}
