package org.devops

def clone(Map params){
    def branch_name = "feature"
    git branch: "${branch_name}", url: "https://github.com/JoseCorreaV/devops.git"
}

def install(){
    sh 'npm install' 
}
