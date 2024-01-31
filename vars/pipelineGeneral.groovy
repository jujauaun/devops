def call(){

    pipeline{

        agent any

        tools{
            nodejs 'NodeJS'
        }
        
        environment{
            projectName = "${env.UrlGitHub}".replaceAll('.+/(.+)\\.git', '$1')toLowerCase()
        }

        stages{
            stage('Fase 2: Construcción de imagen en Docker Desktop') {
                steps {
                    script {
                        def buildimage = new org.devops.lb_buildimagen()
                        buildimage.buildImageDocker("${projectName}")
                    }
                }
            }
            stage('Fase 2: publicar imagen a docker hub') {
                steps {
                    script {
                        def publicImage = new org.devops.lb_publicardockerhub()
                        publicImage.publicarImage("${projectName}")
                    }
                    
                } 
            }

            /*stage('Fase 1: Proceso de construcción') {
                steps {
                    script {
                        def cloneapp = new org.devops.lb_buildartefacto()
                        cloneapp.clone()
                        def buildapp = new org.devops.lb_buildartefacto()
                        buildapp.install()
                    }
                }
            }

            stage('Fase 1: Análisis de Sonarqube'){
                steps{
                    script{
                        def test = new org.devops.lb_analisissonarqube()
                        test.runTest()
                        def analisysSonarqube = new org.devops.lb_analisissonarqube()
                        analisysSonarqube.analisys("${projectName}")
                    }
                }
            }
 stage('Push Imagen') {
                steps {
                    script {
                        def pushimage = new org.devops.push()
                        pushimage("${PROJECT}")
                    }
                    
                } 
            }

            stage('Deploy Imagen') {
                steps {
                    script{
                        DOCKER_EXIST = sh(returnStdout: true, script: 'echo "$(docker ps -q --filter name=${PROJECT})"').trim()
                        
                        if (DOCKER_EXIST != '') {  
                            sh "docker start ${PROJECT}"
                        } else {
                            def deployimage = new org.devops.deploy()
                            deployimage("${PROJECT}")
                        }
                    }    
                }                                        
            }

            stage('Escaneo de la aplicación') {
                steps {
                    script{
                         def owaspscan = new org.devops.owasp()
                        owaspscan("${PROJECT}")
                    }
                }
            }*/
        }
    }
}
