pipeline {
    agent any 

    triggers {
        pollSCM('* * * * *')
    }

    stages {
        
        stage('Maven Compile') {
            steps {
                echo '----------------- Compile phase ----------'
                sh 'mvn clean compile'
            }
        }
        
         stage('Maven Test') {
            steps {
                echo '----------------- Test Phase ----------'
                sh 'mvn clean test'
            }
        }
        
        stage('Maven Build') {
             steps {
                echo '----------------- Build Phase ----------'
                sh 'mvn clean package -DskipTests'
            }
        }
    }
