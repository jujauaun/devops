package org.devops

def clone(Map params){
    def branchName = env.GIT_BRANCH.replaceAll("/", "-") // Reemplaza '/' con '-' en el nombre de la rama
    checkout scm: [
        $class: 'GitSCM',
        branches: [[name: "*/${env.BRANCH_NAME}"]],
        userRemoteConfigs: [[url: params.scmUrl]]
    ]
}

def install(){
    sh 'npm install' 
}