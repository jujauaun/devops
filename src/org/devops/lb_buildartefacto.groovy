package org.devops

def clone(Map params){
    def branch_name = "${env.GIT_BRANCH}".split('/')[1]
    git branch: "${branch_name}", url: "https://github.com/JoseCorreaV/devops.git"
}

def install(){
    sh 'npm install' 
}
