package org.devops

def clone(){
    git branch: "${env.nameBranch}", url: "${env.scmUrl}"
}

def install(){
    sh 'npm install' 
}
