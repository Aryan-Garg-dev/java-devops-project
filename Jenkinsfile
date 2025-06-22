pipeline {
    agent any

    tools {
        maven 'Maven 3.9.10'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build & Test') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t java-maven-app .'
            }
        }
        stage('Docker Run') {
            steps {
                sh 'docker run --rm java-maven-app'
            }
        }
    }
}
