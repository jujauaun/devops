def call(Map param){
    pipeline{

        agent any

        tools{
            nodejs 'NodeJS'
        }
      /*  environment{
         nodeAppPath='http://host.docker.internal:3001/'
        } */
        stages{

            stage('Checkout'){
               steps{
                    script{
                      def repo = new org.devops.buildR()
                        repo.checkGit(scmUrl:param.scmUrl)
                       repo.install()
                        repo.build()
                     }
                 }
             }
             stage('Test react-test-jenkinsfile'){
                 steps{
                     script{
                         def repo = new org.devops.buildR()
                         repo.test()
                     }
                 }
             }
            stage('Sonar'){
                 steps{
                    script{
                       def ana = new org.devops.analisisSonarqube()
                        ana.analisisSonar()
                    }
                 }
           }
                   
        }
    }
}