package org.devops

def checkGit(Map param) {
    git url: param.scmUrl
}

def runCommand(String command) {
    sh command
}

def install() {
    runCommand('npm install')
}

def build() {
    runCommand('npm run build')
}

def test() {
    runCommand('npm test')
}