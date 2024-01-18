package org.devops

def clone(Map params) {
    git branch: env.GIT_BRANCH?.tokenize('/')?.last() ?: 'master',
    url: params.scmUrl
}

def install() {
    sh 'npm install'
}