package org.devops

def clone(Map params){
    def branch_name = 'feature'
    git branch: "${branch_name}", url: "${params.scmUrl}"
}

def install(){
    sh 'npm install' 
}
