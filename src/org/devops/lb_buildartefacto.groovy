package org.devops

def clone(Map params){
    def BRANCH_NAME = "feature"
    git branch: "${BRANCH_NAME}", url: "https://github.com/JoseCorreaV/devops.git"
}

def install(){
    sh 'npm install' 
}
