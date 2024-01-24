package org.devops

def clone(Map params){
    def branch_name = "${env.GIT_BRANCH}".split('/')[1]
    def scmUrl = "https://github.com/JoseCorreaV/devops.git"
    git branch: "${branch_name}", url: "${params.scmUrl}"
}

def install(){
    sh 'npm install' 
}
