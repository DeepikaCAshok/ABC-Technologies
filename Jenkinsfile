pipeline {

    agent any

    tools {
        maven 'Maven3'
    }

    environment {
        IMAGE_NAME = "student-app"
        CONTAINER_NAME = "student-container"
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'git@github.com:DeepikaCAshok/ABC-Technologies.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh '''
                    mvn sonar:sonar \
                    -Dsonar.projectKey=ABC-Technologies \
                    -Dsonar.projectName=ABC-Technologies
                    '''
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t student-app .'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                docker stop student-container || true
                docker rm student-container || true
                docker run -d --name student-container -p 8081:8080 student-app
                '''
            }
        }
    }

    post {
        success {
            echo 'Pipeline executed successfully!'
        }

        failure {
            echo 'Pipeline failed.'
        }

        always {
            echo 'Pipeline execution completed.'
        }
    }
}
