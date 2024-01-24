package org.devops

def clone(Map params){
    git branch: "${env.nameBranch}", url: "${env.scmUrl}"
}

def install(){
    sh 'npm install' 
}
