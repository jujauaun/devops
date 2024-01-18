// pipelineGeneral.groovy

pipeline {
    agent any

    environment {
        // Define variables si es necesario
    }

    stages {
        stage('Checkout') {
            steps {
                // Puedes agregar pasos para realizar la verificación del código fuente
                // Por ejemplo: git 'https://tu-repositorio.git'
            }
        }

        stage('Build') {
            steps {
                // Llama a la función de la biblioteca compartida para la etapa de construcción
                libraryUtils.buildStep()
            }
        }

        stage('Test') {
            steps {
                // Llama a la función de la biblioteca compartida para la etapa de pruebas
                libraryUtils.testStep()
            }
        }

        stage('Deploy') {
            steps {
                // Llama a la función de la biblioteca compartida para la etapa de implementación
                libraryUtils.deployStep()
            }
        }
    }

    post {
        success {
            // Puedes agregar acciones que se ejecuten después de que el Pipeline sea exitoso
        }
        failure {
            // Puedes agregar acciones que se ejecuten después de que el Pipeline falle
        }
    }
}
